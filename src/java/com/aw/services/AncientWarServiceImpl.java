/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.services;

import com.aw.app.action.BattleAction;
import com.aw.app.action.BuildingAction;
import com.aw.app.action.StrategyAction;
import com.aw.app.action.TroopsAction;
import com.aw.app.action.UserAction;
import com.aw.model.objects.Buildings;
import com.aw.model.objects.User;
import com.aw.model.objects.UserDevices;
import com.aw.model.objects.UserTroopsDetails;
import com.aw.util.MongoDbUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.WriteResult;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author iftikhar
 */
public class AncientWarServiceImpl implements AncientWarService{
   private static AncientWarService service;
   /**
    * 
    */
   private AncientWarServiceImpl(){
       
   }
   /**
    * 
    * @return 
    */
   public static AncientWarService getInstance(){
        if (service == null) {
            service = new AncientWarServiceImpl();
            return service;
        }
        else {
            return service;
        }
   }
   /**
    * 
    * @param userId
    * @return
    * @throws JSONException 
    */
    @Override
    public JSONObject browseUserVillage(Long userId) throws JSONException {
        DBCollection coll = MongoDbUtil.getCollection("ancient_war", "aw_user");
        DBObject query = QueryBuilder.start("uid").is(userId).get();
        DBCursor cursor = coll.find(query);
        JSONObject status = new JSONObject();
        while(cursor.hasNext()) {
            DBObject user = cursor.next();
            if(user != null) {
                Long uid = (Long)user.get("uid");
                JSONObject userVillage =  getUserVillage(uid,"visit");
                return userVillage;
            }
            else {
                    status.put("status", false);
                    status.put("message", "No Village found");
                    return status;
            }
        }
        return status;
    }
    /**
     * 
     * @param userId
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject getUserVillage(Long userId) throws JSONException{
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JSONObject village = new JSONObject();
        village.put("village", "my village");
        return village;
    }
    /**
     * 
     * @param userId
     * @param action
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject getUserVillage(Long userId, String action) throws JSONException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("userId "+userId+" action "+action);
        Map villageInfo = new UserAction().getUserVillage(userId, action);
        if(villageInfo != null) {
            JSONObject village = new JSONObject(villageInfo);
            return village;
        }
        else {
            return new JSONObject();
        }

    }
    /**
     * 
     * @param key
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject getSystemSettingByKey(String key) throws JSONException{
        DBCollection collection = MongoDbUtil.getCollection("ancient_war", "aw_system_settings");
        DBObject dbObject = new BasicDBObject();
        dbObject.put("key", key);
        DBObject filteredObject = collection.findOne(dbObject);
        JSONObject json = new JSONObject();
        if (filteredObject != null) {
            json.put("status", filteredObject.get("value").toString());    
        }
        else {
            json.put("status",""); 
        }
        return json;
    }
    /**
     * 
     * @param deviceId
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject login(String deviceId) throws JSONException {
        JSONObject response = new JSONObject();
        if(deviceId != null && !deviceId.equals("")) {
            DBCollection users = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user");
            BasicDBObject filter = new BasicDBObject("selected_market_id",deviceId);
            BasicDBObject user = (BasicDBObject) users.findOne(filter);
        
            DBCollection devices = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_devices");
            BasicDBObject deviceQuery = new BasicDBObject("device_id",deviceId);
            BasicDBObject device = (BasicDBObject)devices.findOne(deviceQuery);
           /// System.out.println("Device Id: "+device.get("device_id"));
            long uid = 0;
            if(device != null && device.containsField("uid") && device.get("uid") != null) {      
                    uid = (Long) device.get("uid");
                    user = (BasicDBObject) users.findOne(new User("uid",uid));
                    
                    DBCollection troopsDetailsCollection = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_troops_details");
                    UserTroopsDetails userTroopsDetails;
                    userTroopsDetails = new UserTroopsDetails("uid",user.get("uid"));
                    BasicDBObject details = (BasicDBObject)troopsDetailsCollection.findOne(userTroopsDetails);
                    if(details == null) {
                        details = new UserTroopsDetails();
                        details.put("uid", user.get("uid"));
                        details.put("titan_level", 1);
                        MongoDbUtil.saveCollection(MongoDbUtil.defaultDBName, "aw_user_troops_details", details);
                    }
                    user.put("last_visited", new Date().getTime());
                    // update user
                    BasicDBObject query = new BasicDBObject().append("uid", user.get("uid"));
                    BasicDBObject updateUser = new BasicDBObject();
                    updateUser.append("$set", new BasicDBObject("last_visited",user.get("last_visited")));
                    MongoDbUtil.updateCollection("aw_user", query, updateUser);
                    new StrategyAction().bootStrapAction((Long)user.get("uid"));
                    return getUserVillage(uid,"login");                                   
            }
            else {
                    JSONObject json = new JSONObject();
                    json.put("device_id", deviceId);
                    User createdUser = this.createUser(json);
                    if(createdUser !=  null) {
                        return this.getUserVillage((Long)createdUser.get("uid"),"login");
                    }
                    else {
                        response.put("status", false);
                        response.put("message", "User is not found and unable to create the user.");
                        return response;
                    }
                }               
    } else if(deviceId == null || deviceId.equals("")) {
                response.put("status", false);
                response.put("message", "Device id is required.");
                return response;
     }  
     else {
                response.put("status", false);
                response.put("message", "No input information provided.");
                return response;
        }
    }
    /**
     * 
     * @param data
     * @return
     * @throws JSONException 
     */
    @Override
    public User createUser(JSONObject data) throws JSONException {
        String deviceId = data.getString("device_id");
        if(deviceId != null && !deviceId.equals("")) {
            User user = new User();
            long currentTime = new Date().getTime();
            if(data.has("name")) {
                user.put("name", data.get("name"));
            }
            long maxValueInDb = (Long) MongoDbUtil.findMaxValueForKey("aw_user", "uid");
            user.put("uid", maxValueInDb + 1);
            user.put("trophies", 0);
            user.put("experience", 0);
            user.put("game_level", 1);
            user.put("spens", 1000);
            user.put("last_visited", currentTime);
            user.put("purchased_gold", 0);
            user.put("deducted_gold", 0);
            user.put("has_completed_tutorial", 0);
            user.put("current_tutorial_step", 1);
            user.put("selected_market_id", deviceId);
            WriteResult result = MongoDbUtil.saveCollection(MongoDbUtil.defaultDBName, "aw_user", user);
            if(result.getLastError().ok()){
                /************ Maintain User Device Table *************/
                Map deviceData = new HashMap();
                deviceData.put("device_id", data.get("device_id"));
                deviceData.put("is_created", new Date().getTime());
                deviceData.put("uid", user.get("uid"));
                UserDevices device = new UserDevices(deviceData);
                MongoDbUtil.saveCollection(MongoDbUtil.defaultDBName, "aw_user_devices", device);
                
                /************ Maintain User Troops Detail Table *************/
                Map troopsData = new HashMap();
                troopsData.put("uid", user.get("uid"));
                UserTroopsDetails details = new UserTroopsDetails(troopsData);
                MongoDbUtil.saveCollection(MongoDbUtil.defaultDBName, "aw_user_troops", details);
                
                /************* Add Town Hall for User Profile *********/
                JSONObject buildingData = new JSONObject();
                buildingData.put("uid", user.get("uid"));
                buildingData.put("tid", Buildings.housingTid);
                buildingData.put("level", 1);
                buildingData.put("construction_start_time", currentTime - 1000);
                buildingData.put("is_constructing", true);
                buildingData.put("position_x", 10);
                buildingData.put("position_y", 20);
                Map success = BuildingAction.addBuilding(buildingData,true);
                if(success.containsKey("status") && Boolean.parseBoolean((String)success.get("status"))) {
                    user.append("error-message", "Building Configuration not found. Please check the tid and level and confirm it in the database.");
                }
                /************* Add Default Barrack for User Profile *********/
                JSONObject barrackData = new JSONObject();
                barrackData.put("uid", user.get("uid"));
                barrackData.put("tid", "TID_BUILDING_BARRACK");
                barrackData.put("level", 1);
                barrackData.put("construction_start_time", currentTime - 1000);
                barrackData.put("is_constructing", true);
                barrackData.put("position_x", 10);
                barrackData.put("position_y", 20);
                success = BuildingAction.addBuilding(barrackData,true);
                if(success.containsKey("status") && Boolean.parseBoolean((String)success.get("status"))) {
                    user.append("error-message", "Building Configuration not found. Please check the tid and level and confirm it in the database.");
                }
                return user;
            }
            else {
                return null;
            }
                  
        }
        else {
            return null;
        }
    }
    /**
     * 
     * @param data
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject updateUserName(JSONObject data) throws JSONException {
        JSONObject response = new JSONObject();
        long uid = data.getLong("uid");
        String name = data.getString("name");
        Map status = new UserAction().updateUserName(uid, name);
        if(status.containsKey("errorMessage")) {
            response.put("status", false);
            response.put("message", status.get("errorMessage"));
            return response;
        }
        response.put("status", true);
        response.put("message", "");
        return response;
    }
    /**
     * 
     * @param data
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject addBattleInfo(JSONObject data) throws JSONException {
         //To change body of generated methods, choose Tools | Templates.
        JSONObject response = new JSONObject();
        Map result = new BattleAction().addBattleDetail(data);
        if(result.containsKey("errorMessage")) {
            response.put("status", false);
            response.put("errorMessage", result.get("errorMessage"));
            return response;
        }
        else {
            response.put("status", true);
            response.put("message", "");
            return response;
        }
        
    }
    /**
     * 
     * @param userId
     * @param type
     * @return 
     */
    @Override
    public JSONObject getUserBattleLogs(long userId, String type) {
        Map data = new UserAction().getUserBattleLogs(userId, type);
        if(data.containsKey("errorMessage")) {
            try {
                JSONObject response = new JSONObject();
                response.put("status", false);
                response.put("message", data.get("errorMessage"));
                return response;
            } catch (JSONException ex) {
                Logger.getLogger(AncientWarServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                return new JSONObject();
            }
        }
        else {              
              return new JSONObject(data);
        }
    }
    /**
     * 
     * @param data
     * @return 
     */
    @Override
    public JSONObject addBuilding(JSONObject data) {        
        try {
            Map result = BuildingAction.addBuilding(data, false);
            if(result.containsKey("errorMessage")) {
                JSONObject response = new JSONObject();
                response.put("status", result.get("status"));
                response.put("message", result.get("errorMessage"));
                return response;
            }
            else {
                return new JSONObject(result);
            }    
        }
        catch(JSONException e) { return null;}
    }
    /**
     * 
     * @param data
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject updateBuilding(JSONObject data) throws JSONException {
        JSONObject response = new JSONObject();
         Map status = null;
        if(data.get("action").equals("update_position")) {
            long uid = data.getLong("uid");
            long buildingId = data.getLong("building_id");
            long positionX = data.getLong("position_x");
            long positionY = data.getLong("position_y");
            status = new BuildingAction().updateBuildingPosition(uid, buildingId, positionX, positionY);
        }
        else if(data.getString("action").equals("update_collection")) {
            long uid = data.getLong("uid");
            long buildingId = data.getLong("building_id");
            long time = new Date().getTime();
            status = new BuildingAction().updateBuildingCollection(uid, buildingId, time);
        }
        else if(data.getString("action").equalsIgnoreCase("upgrade_building")) {
            long uid = data.getLong("uid");
            long buildingId = data.getLong("building_id");
            long time = new Date().getTime();
            status = new BuildingAction().upgradeBuilding(uid, buildingId, time);
        }
            
        if(status != null && status.containsKey("errorMessage")) {
                response.put("status", false);
                response.put("message", status.get("errorMessage"));
                return response;
        }
        else {
                // error Message Unknow action
        }
        response = new JSONObject(status);        
     return response;
    }
    /**
     * 
     * @param data
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject trainTroops(JSONObject data) throws JSONException {
        Map inputData = new HashMap();
        inputData.put("uid", data.get("uid"));
        inputData.put("tid", data.get("tid"));
        inputData.put("level", data.get("level"));
        inputData.put("building_id", data.get("building_id"));
        inputData.put("is_first_in_queue", data.get("is_first_in_queue"));
        String action = data.getString("action");
        Map result = null;
        if(action.equals("train")) {
          result = new TroopsAction().trainTroops(inputData);  
        }
        else {
            result = new TroopsAction().removeFromBarracks(inputData);
        }
        if(result.containsKey("errorMessage")) {
            JSONObject response = new JSONObject();
            response.put("status", false);
            response.put("message", result.get("errorMessage"));
            return response;
        }
        else {
            return new JSONObject(result);
        }       
    }
    /**
     * 
     * @param data
     * @return
     * @throws JSONException 
     */
    @Override
    public JSONObject upgradeTroops(JSONObject data) throws JSONException {
        Map inputData = new HashMap();
        inputData.put("uid", data.get("uid"));
        inputData.put("tid", data.get("tid"));     
        Map result = new TroopsAction().upgradeTroops(inputData);
        if(result.containsKey("errorMessage")) {
            JSONObject response = new JSONObject();
            response.put("status", false);
            response.put("message", result.get("errorMessage"));
            return response;
        }
        else {
            return new JSONObject(result);
        }        
    }
    
}

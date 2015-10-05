/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.app.action;

import com.aw.model.objects.BuildingBase;
import com.aw.model.objects.BuildingResource;
import com.aw.model.objects.BuildingTownhall;
import com.aw.model.objects.ClanUsers;
import com.aw.model.objects.UserTroopsDetails;
import com.aw.util.MongoDbUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author iftikhar
 */
public class UserAction {
    /**
     * 
     * @param uid
     * @param infoType
     * @return 
     */
    public Map getUserVillage(long uid, String infoType) {
        Map villageInfo = new HashMap();
        Map data = new HashMap();
        DBObject user = getUserDetail(uid);
        if(user != null) {
          List userBuildings =   new BuildingAction().getUserBuildings(uid);
          List troops = new TroopsAction().getUserTroopsData(uid, "other");
          List troopsOwn = null;
          if("login".equalsIgnoreCase(infoType)) {
              troopsOwn = new TroopsAction().getUserTroopsData(uid, "self");
          }
          if(troopsOwn != null) {
              troops.addAll(troopsOwn);
          }
          List buildingData = null;
          if(userBuildings != null) {
              if("login".equalsIgnoreCase(infoType)){
                  buildingData = new BuildingAction().getBuildInfoForOwner(userBuildings);
              }
              else {
                  buildingData = new BuildingAction().getBuildInfoForAttack(userBuildings);
              }
          }
          if(buildingData == null)
              buildingData = new ArrayList();
          if(user.containsField("clanUsers")) {
              List<ClanUsers> clanUsers = (List<ClanUsers>)user.get("clanUsers");
              ClanUsers clanUser = clanUsers.get(0);
              villageInfo.put("clan_name", clanUser.get("name"));
              villageInfo.put("clan_flag", clanUser.get("flag"));
              villageInfo.put("clan_id", clanUser.get("clan_id"));   
          }
          /// Access Token
          DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_token");
          BasicDBObject query = new BasicDBObject("uid",user.get("uid"));
          DBObject token = table.findOne(query);
          String userToken = "";
          if(token != null) {
              userToken = (String) token.get("access_token");
          }
          else {
              userToken = createUserAccessToken((Long)user.get("uid"));
          }
          villageInfo.put("uid", user.get("uid"));
          villageInfo.put("name", user.get("name"));
          villageInfo.put("trophies", user.get("trophies"));
          villageInfo.put("level",(int) user.get("game_level"));
          villageInfo.put("troops", troops);
          villageInfo.put("buildings", buildingData);
          villageInfo.put("access_token", userToken);
          if("login".equalsIgnoreCase(infoType)) {
              villageInfo.put("spens", user.get("spens"));
          }
          
          data.put("status", true);
          data.put("message", "");
          data.put("data_set", villageInfo);
          return data;
        }
        else {
            data.put("status", false);
            data.put("message", "Village Not Found");
            return data;
        }
    }
    /**
     * 
     * @param uid
     * @return 
     */
    public DBObject getUserDetail(long uid) {
       DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user");
       BasicDBObject query = new BasicDBObject("uid",uid);
       DBObject user = table.findOne(query);
       if(user != null) 
           return user;
       else
        return null; 
    }
    /**
     * 
     * @param uid
     * @return 
     */
    public String createUserAccessToken(long uid) {
        BasicDBObject userToken = new BasicDBObject();
        userToken.put("uid", uid);
        userToken.put("is_login", 1);
        String token = new AuthAction().createToken();
        userToken.put("access_token", token);
        MongoDbUtil.saveCollection("aw_user_token", userToken);
        return token;
    }
    /**
     * 
     * @param token
     * @return 
     */
    public int checkAccess(String token) {
        DBCollection collection = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_token");
        BasicDBObject filter = new BasicDBObject();
        filter.put("access_token", token);
        DBObject record = collection.findOne(filter);
        if(record !=null){
            boolean login = (Boolean)record.get("is_login");
            if(login) {
                return 1;
            }
            else {
                return 2;
            }
        }
        else {
             return 3;
        }
    }
    /**
     * 
     * @param token
     * @return 
     */
    public long getLoginUserId(String token) {
        DBCollection collection = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_token");
        BasicDBObject filter = new BasicDBObject();
        filter.put("access_token", token);
        filter.put("is_login", true);
        DBObject record = collection.findOne(filter);
        if(record != null)
            return (Long)record.get("uid");
        else
            return -1;
    }
    /**
     * 
     * @param uid
     * @param buildCost
     * @param type
     * @param action
     * @return 
     */
    public boolean updateUserResource(Object uid,Object buildCost,String type,String action) {
        boolean state = false;
        boolean townHallPass = false;
        DBObject user = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user")
                        .findOne(new BasicDBObject("uid",uid));
        String tid = BuildingAction.resourceStorage[0];
        String maxField = "";
        String townHallStorageField = "";
        long amount = 0;
        if(user != null) {
            type = type.toLowerCase();
            if("spens".equalsIgnoreCase(type)) {
                if("increase".equalsIgnoreCase(action)) {
                    long spens = (Long)user.get("spens");
                    long cost = (Long) buildCost;
                    spens+=cost;
                    BasicDBObject update = new BasicDBObject("$set",new BasicDBObject("spens",spens));
                    WriteResult result = MongoDbUtil.updateCollection("aw_user", new BasicDBObject("uid",uid), update);
                    return result.getLastError().ok();
                }
                else {
                     long spens = (Long)user.get("spens");
                    long cost = (Long) buildCost;
                    spens-=cost;
                    BasicDBObject update = new BasicDBObject("$set",new BasicDBObject("spens",spens));
                    WriteResult result = MongoDbUtil.updateCollection("aw_user", new BasicDBObject("uid",uid), update);
                    return result.getLastError().ok();
                }      
            }
            else if("gold".equalsIgnoreCase(type)) {
                tid = BuildingAction.resourceStorage[0];
                maxField = "max_stored_gold";
                townHallStorageField = "gold_stored";
                
            }
            else if("mithril".equalsIgnoreCase(type)) {
                tid = BuildingAction.resourceStorage[1];
                maxField = "max_stored_mithril";
                townHallStorageField = "mithril_stored";
            }
            else if("dark mithril".equalsIgnoreCase(type)) {
                tid = BuildingAction.resourceStorage[2];
                maxField = "max_stored_dark_mithril";
                townHallStorageField = "dark_mithril_stored";
            }
           
            DBCursor buildings = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").find(
                                 new BasicDBObject().append("uid", uid).append("tid", tid));
            if("increase".equalsIgnoreCase(action)) {
                DBObject townHallBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                                 new BasicDBObject().append("uid", uid).append("tid", TownHallAction.townHallTid));
                BuildingBase buildingBase = new BuildingBase(townHallBase.toMap());
                if(buildingBase.containsField("buildingTownhalls")) {
                    BuildingTownhall townHall =  buildingBase.getBuildingTownhalls().get(0);
                    if(townHall.getLong("townHallStorageField") < townHall.getLong("maxField")) {
                        amount = (Long) buildCost;
                        long temp = amount;
                        long total = townHall.getLong("townHallStorageField") + amount;
                        if(total > townHall.getLong("maxField")) {
                            amount = amount - townHall.getLong("maxField") - townHall.getLong("townHallStorageField");
                            total = townHall.getLong("maxField");
                        }
                        else {
                            amount = 0;
                        }
                        townHall.put("townHallStorageField", total);
                        // update
                        BasicDBObject query = new BasicDBObject().append("uid", uid).append("tid", TownHallAction.townHallTid);
                        BasicDBObject update = new BasicDBObject("$set",new BasicDBObject("buildingTownhalls",buildingBase.getBuildingTownhalls()));
                        WriteResult result = MongoDbUtil.updateCollection("aw_building_base", query, update);
                        townHallPass = result.getLastError().ok();
                        if(!result.getLastError().ok())
                            amount = temp;
                    }     
                }
            }
            long subAmount = amount;
            int resourceCount = 0;
            if(buildings != null) {
                while(buildings.hasNext()) {
                    DBObject building = buildings.next();
                    BuildingBase bb = new BuildingBase(building.toMap());
                    List<BuildingResource> resources = (List<BuildingResource>) bb.get("buildingResources");
                    BuildingResource resource = new BuildingResource(resources.get(0).toMap());
                    if("decrease".equalsIgnoreCase(action)) {
                        if(resource.getLong("resource_stored") > 0 & resource.getLong("resource_stored") <= subAmount) {
                            subAmount-= resource.getLong("resource_stored");
                            resource.put("resource_stored", 0);
                            // Update here...
                            resourceCount++;
                        }
                        else if(resource.getLong("resource_stored") > 0 & resource.getLong("resource_stored") > subAmount){
                            resource.put("resource_stored", resource.getLong("resource_stored") - subAmount);
                            subAmount = 0;
                            // Update here
                            resourceCount++;
                        }
                    }
                    else if("increase".equalsIgnoreCase(action)) {
                        if(subAmount > 0) {
                            long total = resource.getLong("resource_stored") + subAmount;
                            if(resource.getLong("$maxField") == total) {
                                resource.put("resource_stored", total);
                                // update here
                                subAmount = 0;
                                state = true;
                            }
                            else if(total > resource.getLong("$maxField") && resource.getLong("$maxField") > resource.getLong("resource_stored")) {
                                long difference = resource.getLong("$maxField") - resource.getLong("resource_stored");
                                subAmount-=difference;
                                resource.put("resource_stored", resource.getLong("$maxField"));
                                resourceCount++;
                                // update resouce
                            }
                        }
                    }
                }
            }
            /**** First Fill the Town Hall for increase resource action ***/
            if(subAmount > 0 && "decrease".equalsIgnoreCase(action)) {
                DBObject townHallBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                                        new BasicDBObject().append("uid", uid).append("tid", TownHallAction.townHallTid));
             List<BuildingTownhall> townHallList = (List<BuildingTownhall>)townHallBase.get("buildingTownhalls");
             if(townHallList != null) {
                 BuildingTownhall townhall = townHallList.get(0);
                 townhall.put("townHallStorageField", townhall.getLong("townHallStorageField") - subAmount);
                 if(townhall.getLong("townHallStorageField") < 0) {
                     state = false;
                 }
                 else {
                     // update town hall
                     townHallPass = true;
                     state = true;
                 }
             }
          }
        }
        if(townHallPass && !state)
            state = townHallPass;
        
     return state;
    }
    /**
     * 
     * @param uid
     * @param level 
     */
    public void unlockUserTroops(Object uid, Object level) {
        Map tidLevel = new TroopsAction().getTroopsTidLevelForBarrack(level);
        DBObject userTroopsDetail = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_troops_details").findOne(
                                    new BasicDBObject().append("uid", uid));
        if(userTroopsDetail == null) {
         userTroopsDetail =  this.createUserTroopDetail(uid);
        }
        if(tidLevel != null && !tidLevel.isEmpty()) {
            Set keys = tidLevel.keySet();
            Iterator keyIterator = keys.iterator();
            while(keyIterator.hasNext()) {
                String key = (String)keyIterator.next();
                long value = (Long)tidLevel.get(key);
                String fieldName = key.replace("TID_", "").concat("_level").toLowerCase();
                long utdValue = (Long) userTroopsDetail.get(fieldName);
                if(value > utdValue)
                    userTroopsDetail.put(fieldName, value);
                BasicDBObject updateUser = new BasicDBObject("$set",new BasicDBObject(fieldName,userTroopsDetail.get(fieldName)));
                BasicDBObject query = new BasicDBObject().append("uid", uid);
                WriteResult result = MongoDbUtil.updateCollection("aw_user_troops_details", query, updateUser);    
            }    
        }
    }
    /**
     * 
     * @param uid
     * @param name
     * @return 
     */
    public Map updateUserName(long uid, String name) {
        Map state = new HashMap();
        DBObject user = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user").findOne(
                        new BasicDBObject().append("uid", uid));
        if(user != null) {
            DBCursor cursor = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user").find(
                        new BasicDBObject().append("name", name));
            boolean nameInUse = false;
            while(cursor.hasNext()) {
                DBObject nextUser = cursor.next();
                long nextUserId = (Long) nextUser.get("uid");
                if(nextUserId != uid) {
                    nameInUse = true;
                    break;
                }
            }
            if(!nameInUse) {
                BasicDBObject update = new BasicDBObject("$set",new BasicDBObject("name",name));
                BasicDBObject query = new BasicDBObject("uid",uid);
                WriteResult  result = MongoDbUtil.updateCollection("aw_user", query, update);
                if(!result.getLastError().ok()) {
                    state.put("errorMessage", "User update error.");
                }
            }
            else {
                state.put("errorMessage", "Name is already in use.");
            }
        }
        return state;
    }
    /**
     * 
     * @param uid
     * @param type
     * @return 
     */
    public Map getUserBattleLogs(long uid,String type) {
        Map  result = new HashMap();
        result.put("status", false);
        result.put("message", "");
        int count = 5;
        BasicDBObject query = new BasicDBObject();
        if(uid > 0) {
            if("attack".equalsIgnoreCase(type)) {
                query.put("attacker_id", uid);
                query.put("count", BattleAction.attackLogCount);
            }
            else if("defense".equalsIgnoreCase(type)) {
                query.put("defender_id", uid);
                query.put("count", BattleAction.defenseLogCount);
            }
            else {
                query.put("attacker_id", uid);
                query.put("count", BattleAction.attackLogCount);
            }
            DBCursor cursor = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_battle").find(
                              query.append("limit", count));
            List battles = new ArrayList();
            while(cursor.hasNext()) {
                DBObject battle = cursor.next();
                Map detail = new BattleAction().getBattleDetail((Long)battle.get("battled_id"));
                battles.add(detail);
            }
            result.put("dataset", battles);
            result.put("status", true);
        }
        else {
            result.put("errorMessage", "uid is missing.");
        }
        return result;
    }
    /**
     * 
     * @param uid
     * @return 
     */
    public DBObject createUserTroopDetail(Object uid) {
        UserTroopsDetails detail = new UserTroopsDetails();
        detail.setUserId(uid.toString());
        Map detailMap = detail.toMap();
        WriteResult result = MongoDbUtil.saveCollection("aw_user_troops_details", new BasicDBObject(detailMap));
        if(result.getLastError().ok()) {
            return MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_troops_details").findOne(
                   new BasicDBObject("uid",uid));
        }
        else {
            return null;
        }
        
    }
    /**
     * 
     * @param uid
     * @param type
     * @return 
     */
    public long getUserResource(Object uid, String type) {
        DBObject user = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user").findOne(
                        new BasicDBObject().append("uid", uid));
        long amount = 0;
        if(user != null) {
            String tid = "";
            String maxField = "";
            String townHallStorageField = "";
            
            if("spens".equalsIgnoreCase(type)) {
                return (Long)user.get("spens");
            }
            else if("gold".equalsIgnoreCase(type)) {
                tid = BuildingAction.resourceStorage[0];
                maxField = "max_stored_gold";
                townHallStorageField = "gold_stored";
                
            }
            else if("mithril".equalsIgnoreCase(type)) {
                tid = BuildingAction.resourceStorage[1];
                maxField = "max_stored_mithril";
                townHallStorageField = "mithril_stored";
            }
            else if("dark mithril".equalsIgnoreCase(type)) {
                tid = BuildingAction.resourceStorage[2];
                maxField = "max_stored_dark_mithril";
                townHallStorageField = "dark_mithril_stored";
            }
            
            DBCursor cursor = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").find(
                              new BasicDBObject().append("uid", uid).append("tid", tid));
            DBObject townHallBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                              new BasicDBObject().append("uid", uid).append("tid", TownHallAction.townHallTid));
            BuildingTownhall townHall = ((List<BuildingTownhall>) townHallBase.get("buildingTownhalls")).get(0);
            amount = townHall.getLong(townHallStorageField);
            while(cursor.hasNext()) {
                DBObject building = cursor.next();
                BuildingResource resource = ((List<BuildingResource>) building.get("buildingResources")).get(0);
                amount+= resource.getLong("resource_stored");
            }
        }
        return amount;
    }
}

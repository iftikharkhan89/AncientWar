/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.app.action;

import com.aw.model.objects.BarrackTroops;
import com.aw.model.objects.BuildingArmy;
import com.aw.model.objects.UserTroopsDetails;
import com.aw.util.MongoDbUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author iftikhar
 */
public class TroopsAction {
    /**
     * 
     * @param uid
     * @param building 
     */
    public void checkToopsUpgrades(Long uid, DBObject building) {
        boolean success = false;
        Long time = new Date().getTime();
        DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_troops_details");
        BasicDBObject query = new BasicDBObject("uid",uid);
        DBObject userTroopsDetail = table.findOne(query);
        if(userTroopsDetail != null) {
            
        }
        // In complete method code.....
    }
    /**
     * 
     * @param uid
     * @param buildingId
     * @return 
     */
    public boolean checkToopsInBarrack(Long uid, long buildingId) {
        boolean state = false;
        Long time = new Date().getTime();
        DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_barrack_troops");
        
        BasicDBObject query = new BasicDBObject("uid",uid);
        query.put("building_id", buildingId);
        DBCursor barrackTroops = table.find(query);
        long nextTroopsTrainingTime = 0;
        if(barrackTroops != null && barrackTroops.size() > 0) {
            while (barrackTroops.hasNext()) {
                DBObject barrackTroop = barrackTroops.next();
                if(nextTroopsTrainingTime > 0 && state) {
                    BasicDBObject updateQuery = new BasicDBObject();
                    updateQuery.put("bc_id", barrackTroop.get("bc_id"));
                    BasicDBObject updateBt = new BasicDBObject();
                    Map data = new HashMap();
                    data.put("is_first_in_queue", 1);
                    data.put("training_start_time", nextTroopsTrainingTime);
                    BasicDBObject object = new BasicDBObject(data);
                    updateBt.put("$set",object );
                    MongoDbUtil.updateCollection("aw_barrack_troops", updateQuery, updateBt);        
                }
                Map result = processTroopTraining(barrackTroop, time);
                boolean breakState = (boolean)result.get("breakState");
                state = (boolean)result.get("status");
                long nextTrainingTime = (long)result.get("nextTrainingTime");
                if(breakState) {
                    // Error Condition
                }
                else if (state && result.containsKey("nextTrainingTime") && nextTrainingTime > 0){
                    nextTroopsTrainingTime = nextTrainingTime;
                }
                else {
                    nextTroopsTrainingTime = 0;
                }
            } 
        }
        return state;
    }
    /**
     * 
     * @param troopSet
     * @param time
     * @return 
     */
    public Map processTroopTraining(DBObject troopSet, Long time) {
        Map result = new HashMap();
        DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_troops_configuration");
        BasicDBObject query = new BasicDBObject();
        query.put("tid", troopSet.get("tid"));
        query.put("level", troopSet.get("level"));
        DBCursor resultSet = table.find(query);
        while(resultSet.hasNext()) {
            DBObject config = resultSet.next();
            long remainingSpace = this.getRemainingTroopSpace((Long)troopSet.get("uid")); // Get from Method Later.
            if(config != null) {
                long trainingTime = (Long)config.get("training_time");
                long count = (Long)troopSet.get("count");
                long totalElapseTimeRequired = trainingTime * count;
                long trainingStartTime = (Long) troopSet.get("training_start_time");
                long endTime = trainingStartTime + totalElapseTimeRequired;
                long housingSpace = (Long)config.get("housing_space");
                long spaceRequired = count * housingSpace;
                if(endTime < new Date().getTime()) {
                    if(remainingSpace >= spaceRequired) {
                        boolean isAdded = addTroopOfUsers((Long)config.get("troop_id"), (Long)troopSet.get("uid"),(String)config.get("tid"),(Long)troopSet.get("count"));
                        if(isAdded) {
                            BasicDBObject deleteQuery = new BasicDBObject();
                            deleteQuery.put("bc_id", troopSet.get("bc_id"));
                            MongoDbUtil.removeCollection("aw_barrack_troops", deleteQuery);
                            result.put("status", true);
                            result.put("nextTrainingTime", endTime);
                        }
                    } else if (remainingSpace == 0) {
                        BasicDBObject queryObject = new BasicDBObject("bc_id",troopSet.get("bc_id"));
                        BasicDBObject updateData = new BasicDBObject("training_start_time",new Date().getTime());
                        BasicDBObject updateQuery = new BasicDBObject("$set",updateData);
                        MongoDbUtil.updateCollection(MongoDbUtil.defaultDBName, queryObject, updateQuery);
                        
                        result.put("status", false);
                        result.put("breakStatus", true);
                        result.put("reason", "Training Fields are full.");
                    }
                    else {
                        long troopCount = (long)Math.floor(remainingSpace / housingSpace);
                        this.addTroopOfUsers((Long)config.get("troop_id"), (Long)troopSet.get("uid"),(String)config.get("tid"),troopCount);
                        long intialCount = (Long) troopSet.get("count");
                        long resultCount = intialCount - count;
                        
                        Map queryMap = new HashMap();
                        queryMap.put("bc_id", troopSet.get("bc_id"));
                        Map updateData = new HashMap();
                        updateData.put("count", resultCount);
                        updateData.put("training_start_time", trainingStartTime + (trainingTime * troopCount));
                        Map dataMap = new HashMap();
                        dataMap.put("query", queryMap);
                        dataMap.put("update", updateData);
                        MongoDbUtil.updateCollection("aw_barrack_troops", updateData);
                        result.put("status", true);
                        result.put("breakStatus", true);
                        result.put("reason", "Training Fields are full.");
                    }
                }
            }
            else {
                result.put("reason", "Configuration not found");
            }
        }
        return result;
    }
    /**
     * 
     * @param uid
     * @return 
     */
    public long getRemainingTroopSpace(long uid) {
        long totalSpace = new BuildingAction().getTotalHousingSpace(uid);
        long consumedSpace = 0;
        long remainingSpace = totalSpace;
        DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_troops");
        BasicDBObject query = new BasicDBObject("uid",uid);
        DBCursor cursor = table.find(query);
        Map troopMap = new HashMap();
        while(cursor.hasNext()) {
            DBObject userTroop = cursor.next();
            long troopId = (Long)userTroop.get("troop_id");
            
            if(troopMap.containsKey(troopId)) {
                long value = (Long) troopMap.get(troopId);
                ++value;
                troopMap.put(troopId, value);
            }
            else {
                troopMap.put(troopId, 1);
            }          
        }
        Iterator entries = troopMap.entrySet().iterator();
        while(entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            long key = (Long) entry.getKey();
            long value = (Long) entry.getValue();
            DBCollection configTable = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_troops_configuration");
            DBCursor configCursor = configTable.find(new BasicDBObject("troop_id",key));
            while(configCursor.hasNext()) {
                DBObject config = configCursor.next();
                long configHousingSpace = (Long)config.get("housing_space");
                consumedSpace = consumedSpace + (configHousingSpace * value);
            }
        }
        remainingSpace = remainingSpace - consumedSpace;
        if(remainingSpace < 0)
            remainingSpace = 0;
        return remainingSpace;
    }
    
    public boolean addTroopOfUsers(Long troopId, Long uid, String tid, Long count) {
        boolean state = false;
        if(uid > 0 && !"".equals(tid) && count > 0) {
            for(int i=1; i <= count; i++) {
               BasicDBObject userTroops = new BasicDBObject();
               userTroops.put("troop_id", troopId);
               userTroops.put("uid", uid);
               userTroops.put("tid", tid);
               userTroops.put("is_created", new Date().getTime());
               userTroops.put("is_owner", 1);
               MongoDbUtil.saveCollection("aw_barrack_troops", userTroops);
               state = true;
            }
        }
        return state;
    }
    /**
     * 
     * @param uid
     * @param action
     * @return 
     */
    public List getUserTroopsData(long uid, String action) {
        List troopsData = new ArrayList();
        String owner = "";
        if("self".equalsIgnoreCase(action))
            owner = "1";
        if("".equalsIgnoreCase(action))
            owner = "0";
            
        DBCursor userTroopsResult = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_troops").find(
                                    new BasicDBObject("uid",uid).append("owner", owner));
        while(userTroopsResult.hasNext()) {
            DBObject userTroop = userTroopsResult.next();
            troopsData.add(userTroop);
        }     
     return troopsData;  
    }
    /**
     * 
     * @param level
     * @return 
     */
    public Map getTroopsTidLevelForBarrack(Object level) {
        DBCursor cursor = this.getTroopsForBarrackLevel(level);
        Map data = new HashMap();
        while(cursor.hasNext()) {
            DBObject object = cursor.next();
            data.put(object.get("tid"), object.get("level"));
        }
     return data;
    }
    /**
     * 
     * @param level
     * @return 
     */
    public DBCursor getTroopsForBarrackLevel(Object level) {
        return MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_troops_configuration").find(
                                new BasicDBObject().append("barrack_level", level).append("level", 1));
    }
    /**
     * 
     * @param data
     * @return 
     */
    public Map trainTroops(Map data) {
        Map state = new HashMap();
        DBObject troopsConfig = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_troops_configuration").findOne(
                                new BasicDBObject().append("tid", data.get("tid")).append("level", data.get("level")));
        DBObject buildingInfo = BuildingAction.getBuildingDetails(data.get("building_id"));
        if(troopsConfig == null) {
            state.put("errorMessage", "Troop Configuration is not available.");
            return state;
        }
        if(buildingInfo == null) {
            state.put("errorMessage", "Building/Barrack not found.");
            return state;
        }
        long userResource = new UserAction().getUserResource(data.get("uid"), troopsConfig.get("training_resource").toString());
        long trainingCost = (Long) troopsConfig.get("training_cost");
        long barrakLevel = (Long)troopsConfig.get("barrack_level");
        long level = (Long)buildingInfo.get("level");
        if(barrakLevel == level && userResource == trainingCost) {
           this.checkToopsInBarrack((Long)data.get("uid"), (Long)data.get("building_id"));
           DBObject barrack = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_barrack_troops").findOne(
                              new BasicDBObject().append("uid", data.get("uid")).append("building_id", 
                              data.get("building_id")).append("tid", data.get("tid")).append("level", 
                              data.get("level")));
           DBObject firstInQueue = this.getFirstInQueue(data);
           if(barrack == null && firstInQueue == null) {
               BasicDBObject barrackTroops = new BarrackTroops(data);
               barrackTroops.put("training_start_time", new Date().getTime());
               barrackTroops.put("count", 1);
               new UserAction().updateUserResource(data.get("uid"), trainingCost, (String)troopsConfig.get("training_resource"), "decrease");
               WriteResult result = MongoDbUtil.saveCollection("aw_barrack_troops", barrackTroops);
               if(!result.getLastError().ok()) {
                 new UserAction().updateUserResource(data.get("uid"), trainingCost, (String)troopsConfig.get("training_resource"), "increase");
                 state.put("status", false);
                 state.put("errorMessage", "Unable to add troops in barrack.");
               }
           }
           else if(barrack == null && firstInQueue != null) {
               // Copied from existing code. However no difference seen in code 
               // comparing to if block above.
               BasicDBObject barrackTroops = new BarrackTroops(data);
               barrackTroops.put("training_start_time", new Date().getTime());
               barrackTroops.put("count", 1);
               new UserAction().updateUserResource(data.get("uid"), trainingCost, (String)troopsConfig.get("training_resource"), "decrease");
               WriteResult result = MongoDbUtil.saveCollection("aw_barrack_troops", barrackTroops);
               if(!result.getLastError().ok()) {
                 new UserAction().updateUserResource(data.get("uid"), trainingCost, (String)troopsConfig.get("training_resource"), "increase");
                 state.put("status", false);
                 state.put("errorMessage", "Unable to add troops in barrack.");
               }
           }
           else {
               int barrackCount = (Integer) barrack.get("count");
               ++barrackCount;
               new UserAction().updateUserResource(data.get("uid"), trainingCost, (String)troopsConfig.get("training_resource"), "decrease");
               BasicDBObject updateObject = new BasicDBObject("$set",new BasicDBObject("count",barrackCount));
               WriteResult wResult = MongoDbUtil.updateCollection("aw_barrack_troops", barrack, updateObject);
               if(!wResult.getLastError().ok()) {
                   new UserAction().updateUserResource(data.get("uid"), trainingCost, (String)troopsConfig.get("training_resource"), "increase");
                   state.put("errorMessage", "Unable to update troops in barrack.");
               }
           }
           
        }
        else if(userResource < trainingCost) {
            String errorMessage = "Training resource "+troopsConfig.get("training_resource").toString()+" is not enough in the storage.";
            state.put("errorMessage", errorMessage);
        }
        else {
            int bLevel = (Integer)troopsConfig.get("barrack_level");
            String errorMessage = "You cannot train this troop in this barrack, it requires level '"+bLevel+"' barrack.";
            state.put("errorMessage", errorMessage);
        }
     return state;
    }
    /**
     * 
     * @param data
     * @return 
     */
    public DBObject getFirstInQueue(Map data) {
        return MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_barrack_troops").findOne(
               new BasicDBObject().append("building_id", data.get("building_id")).append("is_first_in_queue", 1));
    }
    /**
     * 
     * @param data
     * @return 
     */
    public Map upgradeTroops(Map data) {
        Map state = new HashMap();
        long time = new Date().getTime();
        DBObject userTroopsDetail = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_troops_details").findOne(
                                    new BasicDBObject("uid",data.get("uid")));
        if(userTroopsDetail == null) {
            userTroopsDetail = new UserTroopsDetails(data);
            userTroopsDetail.put("titan_level", 1);
            MongoDbUtil.saveCollection("aw_user_troops_details", userTroopsDetail);   
        }
        String tid = data.get("tid").toString();
        String fildName = tid.replace("TID_", "");
        long level = (Long)userTroopsDetail.get(fildName) + 1;
        DBObject troopsConfig = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_troops_configuration").findOne(
                                new BasicDBObject("level",level).append("tid", data.get("tid")));
        if(troopsConfig != null) {
          long userResource =  new UserAction().getUserResource(data.get("uid"), troopsConfig.get("upgrade_resource").toString());
          long upgradeCost = (Long)troopsConfig.get("upgrade_cost");
          DBObject userLabBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                                 new BasicDBObject("uid",data.get("uid")).append("tid", "TID_BUILDING_TAVERN"));
          BuildingArmy userLab = null;
          if(userLabBase == null || !userLabBase.containsField("buildingArmies")) {
              state.put("errorMessage", "You need research laboratary to upgrade any troop.");
              return state;
          }
          else {
              List<BuildingArmy> buildingArmies = (List<BuildingArmy>) userLabBase.get("buildingArmies");
              userLab = buildingArmies.get(0);
          }
          long labLevel = (Long)troopsConfig.get("laboratory_level");
          long baseLevel = (Long)userLabBase.get("level");
          if(userLab != null && userLab.containsField("upgrading_character_tid") && !"".equals(userLab.getString("upgrading_character_tid"))
             && userLab.getLong("research_start_time") > 0) {
              state.put("errorMessage", "Already another troop/spell is on the research.");
          }
          else if (labLevel > baseLevel) {
              String errorMessage = "This troop can be upgraded in research lab, Research Lab of lv-'"+labLevel+"\" is required.";
              state.put("errorMessage", errorMessage);
          }
          else if(userResource >= upgradeCost) {
              userLab.put("upgrading_character_tid", data.get("tid"));
              userLab.put("research_start_time", time);
              //update userLab here
          }
          else if(userResource < upgradeCost) {
              String errorMessage = "Upgrade resource('"+troopsConfig.get("upgrade_resource")+"') is not enough in the storage.";
              state.put("errorMessage", errorMessage);
          }
        }
        else {
            state.put("errorMessage", "Troop Configuration is not available.");
        }
      return state;
    }
    /**
     * 
     * @param data
     * @return 
     */
    public Map removeFromBarracks(Map data) {
        Map state = new HashMap();
        DBObject configuration = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_troops_configuration").findOne(
                                 new BasicDBObject("level",data.get("level")).append("tid", data.get("tid")));
        DBObject buildingInfo = BuildingAction.getBuildingDetails(data.get("building_id"));
        if(configuration != null) {
            if(buildingInfo != null) {
                DBObject barrack = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_barrack_troops").findOne(
                                   new BasicDBObject("uid",data.get("uid")).append("building_id", data.get("building_id"))
                                   .append("tid", data.get("tid")).append("level", data.get("level")));
                long trainingCost = (Long) configuration.get("training_cost");
                UserAction action = new UserAction();

                if(barrack != null && (Integer)barrack.get("count") > 0) {
                    int barrackCount = (Integer)barrack.get("count");
                    switch (barrackCount) {
                        case 1:
                           WriteResult deleteResult = MongoDbUtil.removeCollection("aw_barrack_troops", barrack);
                            if(deleteResult.getLastError().ok()) {
                                action.updateUserResource(data.get("uid"), trainingCost, configuration.get("training_resource").toString(), "increase");
                            }
                            state.put("status", true);
                        DBObject nextBarrackTroop = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_barrack_troops").findOne(
                                                    new BasicDBObject("uid",data.get("uid")).append("building_id", data.get("building_id")));
                            if(nextBarrackTroop != null) {
                                BasicDBObject updateObject = new BasicDBObject("$set",new BasicDBObject()
                                                                 .append("training_start_time", new Date().getTime()));
                                MongoDbUtil.updateCollection("aw_barrack_troops", barrack, updateObject);
                                
                            }
                        break;
                        default:
                            BasicDBObject updateObject = new BasicDBObject("$set",new BasicDBObject("count",barrackCount - 1).append("training_start_time", new Date().getTime()));
                            DBObject query = new BasicDBObject("uid",data.get("uid")).append("building_id", data.get("building_id"))
                                   .append("tid", data.get("tid")).append("level", data.get("level"));
                            WriteResult updateResult = MongoDbUtil.updateCollection("aw_barrack_troops", query, updateObject);
                            //barrack.put("count", barrackCount - 1);
                            //barrack.put("training_start_time", new Date().getTime());
                            if(updateResult.getLastError().ok())
                                state.put("status", true);
                    }
                    
                    boolean status = (Boolean)state.get("status");
                    if(!status) {
                        state.put("errorMessage", "");
                    }
                    else {
                        action.updateUserResource(data.get("uid"), trainingCost, configuration.get("training_resource").toString(), "increase");
                    }
                }
                else {
                    state.put("errorMessage", "Troops not found in barrack.");
                }
            }
            else {
                state.put("errorMessage", "Building/Barrack not found.");
            }
        }
        else {
            state.put("errorMessage", "Troop Configuration is not available.");
        }
        return state;
    }
}

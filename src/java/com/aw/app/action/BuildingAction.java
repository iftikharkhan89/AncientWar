/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.app.action;

import com.aw.model.objects.BuildingArmy;
import com.aw.model.objects.BuildingBase;
import com.aw.model.objects.BuildingConfiguration;
import com.aw.model.objects.BuildingDefense;
import com.aw.model.objects.BuildingResource;
import com.aw.model.objects.BuildingTownhall;
import com.aw.util.AWUtil;
import com.aw.util.MongoDbUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author iftikhar
 */
public class BuildingAction {
    
   public static final String HOUSING_TID = "TID_BUILDING_HOUSING";
   public static String []resourceStorage = {"TID_BUILDING_GOLD_STORAGE","TID_BUILDING_MITHRIL_STORAGE","TID_BUILDING_DARK_MITHRIL_STORAGE"};
   public static String []collectionResource = { "TID_BUILDING_MITHRIL_COLLECTOR" , "TID_BUILDING_GOLD_COLLECTOR"};
   /**
    * 
    * @param uid
    * @return 
    */
   public List getUserBuildings(long uid) {
       List buildings = new ArrayList();
       DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base");
       BasicDBObject query = new BasicDBObject("uid",uid);
       DBCursor cursor = table.find(query);
       while(cursor.hasNext()) {
           DBObject object = cursor.next();
           buildings.add(object);
       }
       return buildings;
   }
   /**
    * 
    * @param buildings
    * @return 
    */
   public List getBuildInfoForOwner(List buildings) {
       List buildingData = new ArrayList();
       for(Object building : buildings) {
           Map data = new HashMap();
           DBObject buildingObject = (DBObject) building;
           boolean checkStatus = checkBuildingUpgrade(buildingObject.get("uid"),buildingObject.get("building_id"),new Date().getTime());
           if(checkStatus) {
               DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base");
               buildingObject = table.findOne(new BasicDBObject("building_id",buildingObject.get("building_id")));
           }
           data.put("building_id", buildingObject.get("building_id"));
           data.put("tid", buildingObject.get("tid"));
           data.put("position_x", buildingObject.get("position_x"));
           data.put("position_y", buildingObject.get("position_y"));
           data.put("level", buildingObject.get("level"));
           data.put("is_constructing", buildingObject.get("is_constructing"));
           data.put("construction_start_time", buildingObject.get("construction_start_time"));
           data.put("is_upgrading", buildingObject.get("is_upgrading"));
           data.put("upgrade_start_time", buildingObject.get("upgrade_start_time"));
           data.put("building_class", buildingObject.get("building_class"));
           data.put("resource_available", 0);
           data.put("last_collection_time", 0);
           data.put("", building);

           if(buildingObject.containsField("building_resource")) {
               // add  additional fields to buildingData object.
               // last_collection_time
               // resource_available
           }
           if(buildingObject.containsField("building_townhalls")) {
                // add  additional fields to buildingData object.
               // gold_stored
               // mithril_stored
               // remove resource_available
               // remove last_collection_time
           }
        buildingData.add(data);
       }     
     return buildingData;
   }
   /**
    * 
    * @param buildings
    * @return 
    */
   public List getBuildInfoForAttack(List buildings) {
       List buildingData = new ArrayList();
       Map data = new HashMap();
       for(Object building : buildings) {
           DBObject buildingObject = (DBObject) building;
           boolean checkStatus = checkBuildingUpgrade(buildingObject.get("uid"),buildingObject.get("building_id"),new Date().getTime());
           if(checkStatus) {
               DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base");
               buildingObject = table.findOne(new BasicDBObject("building_id",buildingObject.get("building_id")));
           }
           data.put("building_id", buildingObject.get("building_id"));
           data.put("tid", buildingObject.get("tid"));
           data.put("position_x", buildingObject.get("position_x"));
           data.put("position_y", buildingObject.get("position_y"));
           data.put("level", buildingObject.get("level"));
           data.put("is_constructing", buildingObject.get("is_constructing"));
           data.put("construction_start_time", buildingObject.get("construction_start_time"));
           data.put("is_upgrading", buildingObject.get("is_upgrading"));
          // data.put("upgrade_start_time", buildingObject.get("upgrade_start_time"));
           data.put("building_class", buildingObject.get("building_class"));
           data.put("resource_available", 0);
          // data.put("last_collection_time", 0);

           if(buildingObject.containsField("building_resource")) {
               // add  additional fields to buildingData object.
               // resource_available
           }
           if(buildingObject.containsField("building_townhalls")) {
                // add  additional fields to buildingData object.
               // gold_stored
               // mithril_stored
               // remove resource_available
           }
           buildingData.add(data);
       }     
    return buildingData;
   }
   /**
    * 
    * @param data
    * @param flag
    * @return
    * @throws JSONException 
    */
   public static Map addBuilding(JSONObject data,boolean flag) throws JSONException {
       Map statusData = new HashMap();
       if(data != null && (data.has("uid") & data.has("tid") & data.has("level"))){
          DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_configuration");
          BuildingConfiguration bc = new BuildingConfiguration();
          bc.put("level", data.get("level"));
          bc.put("tid", data.get("tid"));
          DBObject buildingConfiguration = table.findOne(bc);
          if(buildingConfiguration != null) {
              statusData = addBuildingFromConfiguration(buildingConfiguration,data,flag);
          }
          else {
              statusData.put("errorMessage", "Building Configuration not found. Please check the tid and level and confirm it in the database.");
          }
       }
       else {
           statusData.put("errorMessage", "Data is missing. Please Check uid, building_id, Position X & Y.");
       }
       return statusData;
   }
   /**
    * 
    * @param buildingConfiguration
    * @param data
    * @param isRegister
    * @return
    * @throws JSONException 
    */
   public static Map addBuildingFromConfiguration(DBObject buildingConfiguration,JSONObject data,boolean isRegister) throws JSONException {
       Map statusData = new HashMap();
       if(buildingConfiguration != null && data != null) {
           BasicDBObject buildingBase = new BasicDBObject();
           long time = new Date().getTime();
           if(data.has("position_x")) {
               buildingBase.put("position_x", data.get("position_x"));
           if(data.has("position_y")) 
               buildingBase.put("position_y", data.get("position_y"));
           
           buildingBase.put("created", time);
           String tid = (String)buildingConfiguration.get("tid");
           if(!tid.equals("TID_BUILDING_TOWN_HALL")){
               buildingBase.put("construction_start_time", time);
               buildingBase.put("is_constructing", 1);
           }
           long lastCollectionTime = time + ApplicationSettings.convertToTimeStamp(buildingConfiguration);
           buildingBase.put("uid", data.get("uid"));
           buildingBase.put("attributes", buildingConfiguration.get("attributes"));
           boolean price = false;
           if(!isRegister) {
               UserAction userAction = new UserAction();
               if(!TownHallAction.isAllowedBuilding(buildingConfiguration.get("tid"),data.get("uid"),buildingConfiguration.get("level"))) {
                   statusData.put("status", false);
               }
               else if(!isBuildAddAllow(data.get("uid"),buildingConfiguration.get("build_resource"),buildingConfiguration.get("build_cost"))) {
                   statusData.put("status", false);
                   statusData.put("errorMessage", "Not enough resource available in storage.");
               }
               long buildCost = (Long)buildingConfiguration.get("build_cost");
               if(buildCost > 0) {
                   price = userAction.updateUserResource(data.get("uid"),buildingConfiguration.get("build_cost"),(String)buildingConfiguration.get("build_resource"),"decrease");
               }
               else {
                   price = true;
               }         
           }
           else {
               price = true;
           }
           if(!price) {
               statusData.put("errorMessage", "Not enough resource available in storage.");
               statusData.put("status", false);
           }
           WriteResult result = MongoDbUtil.saveCollection("aw_building_base", buildingBase);
           if(result.getLastError().ok()) {
               String collectionName = "aw_building_base";
               BasicDBObject buildingObject = null;
               String buildingClass = (String) buildingConfiguration.get("building_class");
               if("Defense".equalsIgnoreCase(buildingClass)) {
                   collectionName = "aw_building_defense";
                   buildingObject = new BuildingDefense();
                   buildingObject.put("attributes", buildingConfiguration.get("attributes"));
               }
               else if("Resource".equalsIgnoreCase(buildingClass)) {
                   collectionName = "aw_building_resource";
                   buildingObject = new BuildingResource();
                   buildingObject.put("attributes", buildingConfiguration.get("attributes"));
                   if(containString(collectionResource, buildingConfiguration.get(tid).toString())) {
                       buildingObject.put("last_collection_time", lastCollectionTime);
                       
                   }
                   else 
                       buildingObject.put("last_collection_time", 0);
                   buildingObject.put("resource_stored", 0);
               }
               else if("Army".equalsIgnoreCase(buildingClass)) {
                   collectionName = "aw_building_army";
                   buildingObject = new BuildingArmy();
                   buildingObject.put("attributes", buildingConfiguration.get("attributes"));
               }
               else if("Town Hall".equalsIgnoreCase(buildingClass)) {
                   collectionName = "aw_building_townhall";
                   buildingObject = new BuildingTownhall();
                   buildingObject.put("attributes", buildingConfiguration.get("attributes"));
                   buildingObject.put("gold_stored",buildingConfiguration.get("gold_stored"));
                   buildingObject.put("mithril_stored", buildingConfiguration.get("mithril_stored"));
               }
               else {
                   statusData.put("status", true);
                   statusData.put("building_id", buildingBase.get("building_id"));
               }             
               if(buildingObject != null) {
                  buildingObject.put("building_id", buildingBase.get("building_id"));
                  WriteResult r = MongoDbUtil.saveCollection(collectionName, buildingObject);
                  if(r.getLastError().ok()) {
                      String buildingConfigTid = (String)buildingConfiguration.get("tid");
                      if(buildingConfigTid.equalsIgnoreCase("TID_BUILDING_BARRACK")) {
                          new UserAction().unlockUserTroops(data.get("uid"), buildingConfiguration.get("level"));
                      }
                      statusData.put("status", true);
                  }
                   
               }
           }
           else {
               price = new UserAction().updateUserResource(data.get("uid"), buildingConfiguration.get("build_cost"), (String)buildingConfiguration.get("build_resource"), "increase");
           }
         }
       }
    return statusData;
   }
   /**
    * 
    * @param uid
    * @param buildResource
    * @param buildCost
    * @return 
    */
   public static boolean isBuildAddAllow(Object uid,Object buildResource,Object buildCost) {
       long userResource = new UserAction().getUserResource(uid, (String)buildResource);
       long amount = (Long)buildCost;
       return userResource >= amount;
   }
   /**
    * 
    * @param uid
    * @return 
    */
   public long getTotalHousingSpace(long uid) {
       long campSpace = 0;
       DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base");
       BasicDBObject query = new BasicDBObject();
       query.put("tid", HOUSING_TID);
       query.put("uid", uid);
       DBCursor cursor = table.find(query);
       while(cursor.hasNext()){
           DBObject building = cursor.next();
           if(building.containsField("buildingArmies")) {
               /// In complete Code
           }
       }      
    return campSpace;
   }
   /**
    * 
    * @param array
    * @param value
    * @return 
    */
   private static boolean containString(String [] array, String value) {
       boolean contains = false;
       for(String s:array) {
           if(value.equalsIgnoreCase(s))
               contains = true;
       }
    return contains;         
   }
   /**
    * 
    * @param uid
    * @param buildingId
    * @param time
    * @return 
    */
   public boolean checkBuildingUpgrade(Object uid, Object buildingId, long time){
       boolean state = false;
       DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base");
       BasicDBObject query = new BasicDBObject();
       query.put("uid", uid);
       query.put("building_id", buildingId);
       DBCursor cursor = table.find(query); {
       while(cursor.hasNext()) {
           DBObject buildingBase = cursor.next();
           if(time == 0)
               time = new Date().getTime();     
           boolean isConstructing = (Boolean)buildingBase.get("is_constructing");
           if(isConstructing) {
               long startTime = (Long) buildingBase.get("construction_start_time");
               long endTime = startTime + ApplicationSettings.convertToTimeStamp(buildingBase);
               if(time > endTime) {
                   BasicDBObject queryUpdate = new BasicDBObject();
                   queryUpdate.put("uid", buildingBase.get("uid"));
                   queryUpdate.put("building_id", buildingBase.get("building_id"));
                   BasicDBObject toUpdate = new BasicDBObject();
                   toUpdate.put("is_constructing", 0);
                   toUpdate.put("construction_start_time", 0);
                   BasicDBObject update = new BasicDBObject("$set",toUpdate);
                   MongoDbUtil.updateCollection("aw_building_base", queryUpdate,update);
                   return true;
               }       
           }
           boolean upgrading = (Boolean)buildingBase.get("is_upgrading");
           if(upgrading) {
               long startTime = (Long)buildingBase.get("upgrade_start_time");
               DBObject nextLevelConfig = this.getBuildingConfiguration(buildingBase.get("tid"),((Long)buildingBase.get("level") + 1));
               long endTime = startTime + ApplicationSettings.convertToTimeStamp(nextLevelConfig);
               if(time > endTime) {
                   buildingBase.put("is_upgrading", 0);
                   buildingBase.put("upgrade_start_time", 0);
                   buildingBase.put("level", (Long)buildingBase.get("level") + 1);
                   state = this.updateBuildingFromConfiguration(buildingBase);
               }       
           }
        }
     }
    return state;
   }
   /**
    * 
    * @param tid
    * @param level
    * @return 
    */
   public DBObject getBuildingConfiguration(Object tid, Object level){
       DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_configuration");
       return table.findOne(new BasicDBObject().append("tid", tid).append("level", level));
   }
   /**
    * 
    * @param building
    * @return 
    */
   public boolean updateBuildingFromConfiguration(DBObject building) {
       boolean state = false;
       if(building != null) {
           DBObject buildingConfig = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_configuration").findOne(
           new BasicDBObject().append("tid", building.get("tid")).append("level", building.get("level")));
           if(buildingConfig != null){
               building.put("attributes", buildingConfig.get("attributes"));
               BasicDBObject params = new BasicDBObject()
                                            .append("is_upgrading", building.get("is_upgrading"))
                                            .append("upgrade_start_time", building.get("upgrade_start_time"))
                                            .append("level", building.get("level"))
                                            .append("attributes", building.get("attributes"));
             WriteResult result =  MongoDbUtil.updateCollection("aw_building_base", new BasicDBObject("building_id",building.get("building_id")), new BasicDBObject("$set",params));
             if(result.getLastError().ok()) {
                 String buildingClass = (String) buildingConfig.get("building_class");
                 DBObject specialBuildObject = null;
                 String collectionName = "aw_building_base";
                 if("Defense".equalsIgnoreCase(buildingClass)) {
                     collectionName = "aw_building_defense";
                 }
                 else if("Resource".equalsIgnoreCase(buildingClass)) {
                     collectionName = "aw_building_resource";
                 }
                 else if("Army".equalsIgnoreCase(buildingClass)) {
                     collectionName = "aw_building_army";
                 }
                 else if("Town Hall".equalsIgnoreCase(buildingClass)) {
                     collectionName = "aw_building_townhall";
                 }
                 
                 if(specialBuildObject != null) {
                     
                 }
             }
           }
       }
    return false;
   }
   /**
    * 
    * @param uid
    * @param townGoldLoot
    * @param townMithrilLoot
    * @param isDestroyed 
    */
   public void updateBattleTownHall(long uid,long townGoldLoot,long townMithrilLoot,boolean isDestroyed) {
       DBObject buildingBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                               new BasicDBObject().append("uid", uid).append("tid", TownHallAction.townHallTid)
                                .append("building_class", "Town Hall"));
       if(buildingBase != null) {
           if(buildingBase.containsField("buildingTownhalls")) {
               List<BuildingTownhall> townhalls = (List<BuildingTownhall>)buildingBase.get("buildingTownhalls");
               BuildingTownhall townHall = townhalls.get(0);
               if(townGoldLoot > 0) {
                   townHall.put("gold_stored", townHall.getLong("gold_stored") - townGoldLoot);                 
               }
               if(townGoldLoot < 0) {
                   townHall.put("gold_stored", 0);                 
               }
               if(townMithrilLoot > 0) {
                   townHall.put("mithril_stored", townHall.getLong("mithril_stored") - townMithrilLoot); 
               }
               if(townMithrilLoot < 0) {
                   townHall.put("mithril_stored", 0); 
               }
               // update townhall....
               BasicDBObject townhallUpdate = new BasicDBObject("$set",new BasicDBObject().append("gold_stored", townHall.get("gold_stored"))
                                              .append("mithril_stored", townHall.get("mithril_stored"))
                                              .append("mithril_stored", townHall.get("mithril_stored")));
               BasicDBObject townhallQuery =  new BasicDBObject("building_townhall_id",townHall.get("building_townhall_id"));
               MongoDbUtil.updateCollection("aw_building_townhall", townhallQuery, townhallUpdate);
               
               if(isDestroyed) {
                   buildingBase.put("is_destroyed", 1);
               }
               buildingBase.put("buildingTownhalls", townhalls);
               BasicDBObject updateObject = new BasicDBObject("$set",new BasicDBObject().append("is_destroyed", buildingBase.get("buildingBase"))
                                                .append("buildingTownhalls", buildingBase.get("buildingTownhalls")));
               BasicDBObject query = new BasicDBObject().append("uid", uid).append("tid", TownHallAction.townHallTid)
                                .append("building_class", "Town Hall");
               MongoDbUtil.updateCollection("aw_building_base", query, updateObject);
           }
       }
   }
   /**
    * 
    * @param uid
    * @param buildingId
    * @param positionX
    * @param positionY
    * @return 
    */
   public Map updateBuildingPosition(long uid, long buildingId, long positionX, long positionY) {
       Map status = new HashMap();
       DBObject buildingBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                               new BasicDBObject().append("uid", uid).append("building_id", buildingId));
       if(buildingBase != null) {
           BasicDBObject update = new BasicDBObject("$set",new BasicDBObject("position_x",positionX).append("position_y", positionY));
           BasicDBObject query = new BasicDBObject().append("uid", uid).append("building_id", buildingId);
           WriteResult result = MongoDbUtil.updateCollection("aw_building_base", query, update);
           status.put("status", result.getLastError().ok());
       }
       else {
           status.put("status", false);
           status.put("errorMessage", "Building Not Found.");
       }
       return status;
   }
   /**
    * 
    * @param uid
    * @param buildingId
    * @param time
    * @return 
    */
   public Map updateBuildingCollection(long uid, long buildingId, long time) {
       Map status = new HashMap();
       DBObject buildingBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                               new BasicDBObject().append("uid", uid).append("building_id", buildingId));
       if(buildingBase != null) {
           if(buildingBase.containsField("building_class") && buildingBase.get("building_class").toString().equalsIgnoreCase("Resource") && this.isCollectionBuilding(buildingBase.get("tid"))) {
               if(buildingBase.containsField("buildingResources")) {
                  List<BuildingResource> buildingResources = (List<BuildingResource>)buildingBase.get("buildingResources");
                  BuildingResource resource = buildingResources.get(0);
                  if(resource != null) {
                      status = updateBuildingStorageResource(resource, buildingBase.get("tid"), new Date().getTime());
                  }
                  else {
                      status.put("status", false);
                      status.put("errorMessage", "Resource not found.");
                  }
               }
           }
           else {
               status.put("errorMessage", "Building is not a resource collector.");
           }      
       }
       else {
           status.put("errorMessage", "Building Not Found.");
       }
    return status;
   }
   /**
    * 
    * @param uid
    * @param buildingId
    * @param time
    * @return 
    */
   public Map instantFinishBuilding(long uid, long buildingId, long time) {
       Map status = new HashMap();
       DBObject buildingBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                               new BasicDBObject().append("uid", uid).append("building_id", buildingId));
       if(buildingBase != null) {
           int updating = (Integer)buildingBase.get("is_upgrading");
           int constructing = (Integer) buildingBase.get("is_constructing");
           if(updating == 1 || constructing == 1) {
              DBObject nextLevelConfig = this.getBuildingConfiguration(buildingBase.get("tid"), (Long)buildingBase.get("level") + 1);
              if(updating == 1 && nextLevelConfig == null) {
                  status.put("errorMessage", "Next level of building is not present.");
                  return status;
              }
              long spenAmount = this.calculateInstantFinishAmount(buildingId, time);
              long userSpens = new UserAction().getUserResource(uid, "spens");
              if(userSpens >= spenAmount) {
                  UserAction action = new UserAction();
                 if(action.updateUserResource(uid, spenAmount, "spens", "decrease")) {
                     buildingBase.put("is_upgrading", 0);
                     buildingBase.put("upgrade_start_time", 0);
                     buildingBase.put("level", (Long)buildingBase.get("level") + 1);
                     if(AWUtil.isInArray(collectionResource, buildingBase.get("tid").toString())) {
                         long lastCollectionTime = time;
                         List<BuildingResource> resources = (List<BuildingResource>) buildingBase.get("buildingResources");
                         BuildingResource resource = resources.get(0);
                         if(resource != null) {
                             resource.put("last_collection_time", lastCollectionTime);
                             // update resource here...
                         }
                     }
                     // update building base here....
                 }
              }
              else {
                    status.put("errorMessage", "Not enough resources in the storage to finish this building upgrade.");
              }
              
           }
           else {
               status.put("errorMessage", "Building is not upgrading, you have made bad request.");
           }
       }
       else {
             status.put("errorMessage", "Building Not Found.");
       }
    return status;
   }
   /**
    * 
    * @param tid
    * @return 
    */
   private boolean isCollectionBuilding(Object tid) {
       if(tid.toString().equalsIgnoreCase("TID_BUILDING_MITHRIL_COLLECTOR") || tid.toString().equalsIgnoreCase("TID_BUILDING_GOLD_COLLECTOR"))
           return true;
       else
        return false;
   }
   /**
    * 
    * @param resource
    * @param tid
    * @param time
    * @return 
    */
   public Map updateBuildingStorageResource(BuildingResource resource, Object tid, long time) {
       Map status = new HashMap();
       BuildingBase buildingBase = (BuildingBase) resource.get("building");
       if(buildingBase != null) {
           long lastCollectionTime = resource.getLong("last_collection_time");
           long perHour = resource.getLong("resource_per_hour");
           long timeDiff = time - lastCollectionTime;
           if(timeDiff < 0)
               timeDiff = 0;
           if(timeDiff > 0) {
               resource.put("last_collection_time", time);
               long generatedResource = calculateGeneratedResource(timeDiff, perHour);
               /** Check for Collector Maximum Limit if that exceeds it should be set to resource_max of collector ***/
               if(generatedResource > resource.getLong("resource_max") && resource.getLong("resource_max") > 0) {
                   generatedResource = resource.getLong("resource_max");
                   String produceResource = resource.getString("produces_resource");
                   long uid = buildingBase.getLong("uid");
                   /********* First Target the Town Hall for Collection ******/
                   
                   
                   /********* Target Storage Resource (Mithril Storage or Gold Storage) ******/
                   if(generatedResource > 0) {
                      boolean success  = new UserAction().updateUserResource(uid, generatedResource, produceResource, "increase");
                      status.put("status", success);
                      if(success) {
                          // update resource object
                      }
                   }
               }            
           }
           else {
               status.put("errorMessage", "No changes in timestamp.");
           }
       }
    return status;
   }
   /**
    * 
    * @param difference
    * @param perHour
    * @return 
    */
   private long calculateGeneratedResource(long difference, long perHour) {
       long perUnit = perHour/3600;      
       return (long)Math.floor(perUnit * difference);
   }
   /**
    * 
    * @param uid
    * @param buildingId
    * @param time
    * @return 
    */
   public Map upgradeBuilding(long uid, long buildingId, long time) {
       Map status = new HashMap();
       DBObject buildingBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                               new BasicDBObject().append("uid", uid).append("building_id", buildingId));
       if(buildingBase != null) {
           int upgrading = (Integer) buildingBase.get("");
           if(upgrading == 1) {
              status.put("errorMessage", "Building is already upgrading.");
              return status;
           }
           int constructing = (Integer) buildingBase.get("");
           if(constructing == 1) {
               status.put("errorMessage", "Building is under construction.");
               return status;
           }
           DBObject nextLevelConfig = this.getBuildingConfiguration(buildingBase.get("tid"), (Long)buildingBase.get("level") + 1);
           boolean isAllowed = TownHallAction.isAllowedBuilding(buildingBase.get("tid"), uid, (Long)buildingBase.get("level") + 1);
           if(isAllowed)
               status.put("status", true);
           if(nextLevelConfig == null) {
               status.put("errorMessage", "Next level of building is not present.");
           }
           
           buildingBase.put("is_upgrading", 1);
           buildingBase.put("upgrade_start_time", time);
           if(new UserAction().updateUserResource(uid, nextLevelConfig.get("build_cost"), (String)nextLevelConfig.get("build_resource"), "decrease")) {
               if(buildingBase.get("tid").toString().equals(collectionResource[0]) || 
                  buildingBase.get("tid").toString().equals(collectionResource[1])) {
                  long lastCollectionTime = time + ApplicationSettings.convertToTimeStamp(nextLevelConfig);
                  if(buildingBase.containsField("buildingResources")) {
                      List<BuildingResource> buildingResources = (List<BuildingResource>) buildingBase.get("buildingResources");
                      if(buildingResources != null && buildingResources.size() > 0) {
                          BuildingResource resource = buildingResources.get(0);
                          resource.put("last_collection_time", lastCollectionTime);
                          // update resource object here.
                      }
                  }
               }
               // update building base here
           }
           else {
               status.put("errorMessage", "Building Not Found.");
           }
           
       }
    return status;
   }
   /**
    * 
    * @param buildingId
    * @param time
    * @return 
    */
   private long calculateInstantFinishAmount(long buildingId, long time) {
       DBObject buildingBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                               new BasicDBObject().append("building_id", buildingId));
       if(buildingBase != null) {
           int upgrading = (Integer) buildingBase.get("is_upgrading");
           DBObject configObject = null;
           long startTime =0;
           if(upgrading == 1) {
             configObject =  this.getBuildingConfiguration(buildingBase.get("tid"), (Long)buildingBase.get("level") + 1);
             startTime = (Long)buildingBase.get("upgrade_start_time");
           }
           else {
             configObject =  this.getBuildingConfiguration(buildingBase.get("tid"), buildingBase.get("level"));
             startTime = (Long)buildingBase.get("construction_start_time");
           }
           if(configObject != null) {
               long endTime = startTime + ApplicationSettings.convertToTimeStamp(configObject);
               long diff = endTime - time;
               if(diff > 0) {
                   long spenConsumed = StrategyAction.getInstantFinishValue("building", diff);
                   return spenConsumed;
               }
           }
       }
    return 0;
   }
   /**
    * 
    * @param buildingId
    * @return 
    */
   public static DBObject getBuildingDetails(Object buildingId) {      
       return MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
              new BasicDBObject("building_id", buildingId));
   }
}

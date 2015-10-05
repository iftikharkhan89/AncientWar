/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.app.action;

import com.aw.model.objects.Battle;
import com.aw.model.objects.BattleBuilding;
import com.aw.model.objects.BattleTroops;
import com.aw.model.objects.BuildingBase;
import com.aw.model.objects.BuildingResource;
import com.aw.util.AWUtil;
import com.aw.util.MongoDbUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author iftikhar
 */
public class BattleAction {
   public static int attackLogCount = 5;
   public static int defenseLogCount = 5;
    /**
     * 
     * @param data
     * @return
     * @throws JSONException 
     */
    public Map addBattleDetail(JSONObject data) throws JSONException {
        Map status = new HashMap();
        Map attackerResources = new HashMap();
        attackerResources.put("gold", 0);
        attackerResources.put("mithril", 0);
        attackerResources.put("dark mithril", 0);       
        if(data != null & data.length() > 0) {
            if(data.has("attacker_id") && data.has("defender_id") && data.has("total_damage")) {
                Battle battle = new Battle(AWUtil.jsonToMap(data));
                // populate battle fields from battle Map
                //
                battle.put("is_created", new Date().getTime());
                WriteResult saveBattle = MongoDbUtil.saveCollection("aw_battle",battle );
                if(saveBattle.getLastError().ok()) {
                    // state = true
                    this.processBattleTroops(data, battle);
                    this.updateBattleTrophy(battle);
                    boolean townIsDestroy = false;
                    if(data.has("townhall_destroyed") && data.getBoolean("townhall_destroyed")) {
                        townIsDestroy = true;
                    }
                    new BuildingAction().updateBattleTownHall(data.getLong("defender_id"), data.getLong("town_gold_loot"), data.getLong("town_mithril_loot"), townIsDestroy);
                   
                    /*** Process Battle Building ***/
                    if(data.has("buildings") && data.getJSONArray("buildings").length() > 0 ) {
                        JSONArray buildingsArray = data.getJSONArray("buildings");
                        for(int i =0; i < buildingsArray.length(); i++) {
                            JSONObject building = buildingsArray.getJSONObject(i);
                            BattleBuilding battleBuilding = new BattleBuilding(AWUtil.jsonToMap(building));
                            battleBuilding.put("battle_id", battle.get("battled_id"));
                            battleBuilding.put("is_created", new Date().getTime());
                            WriteResult saveBattleBuilding = MongoDbUtil.saveCollection("aw_battle_buildings", battleBuilding);
                            if(saveBattleBuilding.getLastError().ok()) {
                                if(battleBuilding.containsField("buildingBase")) {
                                  Map buildingBaseMap = (Map) battleBuilding.get("buildingBase");
                                  BuildingBase buildingBase =  new BuildingBase(buildingBaseMap);
                                  if(building.getBoolean("is_destroyed")) {
                                      buildingBase.put("is_destroyed", 1);
                                  }
                                  if(building.getLong("resource_lost") > 0 && buildingBase.getString("building_class").equalsIgnoreCase("Resource")) {
                                      if(buildingBase.containsField("buildingResources")) {
                                          BuildingResource bResource = ((List<BuildingResource>)buildingBase.get("buildingResources")).get(0);
                                          if(bResource.getLong("resource_stored") > 0) {
                                              String resourceType = "";
                                             if(bResource.containsField("produces_resource"))
                                                      resourceType = bResource.getString("produces_resource").toLowerCase();
                                             else if(bResource.getLong("max_stored_gold") > 0)
                                                 resourceType = "gold";
                                             else if(bResource.getLong("max_stored_mithril") > 0)
                                                 resourceType = "mithril";
                                             else if(bResource.getLong("max_stored_dark_mithril") > 0) 
                                                 resourceType = "dark_mithril";
                                             
                                             long attackResource = (Long)attackerResources.get(resourceType);
                                             attackResource+= building.getLong("resource_lost");
                                             attackerResources.put(resourceType, attackResource);
                                             bResource.put("resource_stored", bResource.getLong("resource_stored") - building.getLong("resource_lost") );
                                             // update Building Resource bResource
                                             
                                          }
                                          
                                      }
                                  }
                                  // update building base here
                                }
                            }
                        }
                        /********* Update Attacker Resources *******/
                        Set keySet = attackerResources.keySet();
                        Iterator iterator = keySet.iterator();
                        while(iterator.hasNext()) {
                            String key = (String)iterator.next();
                            long value = (Long) attackerResources.get(key);
                            if(value > 0) {
                                new UserAction().updateUserResource(data.get("attacker_id"), value, key, "increase");
                            }
                        }
                    }   
                    
                }
                else {
                    status.put("errorMessage", "Insertion failed.");
                }
            }
            else {
                status.put("errorMessage", "Data is missing please check attacker_id , defender_id, total_damage.");
            }
        }
        else {
               status.put("errorMessage", "No input information is provided.");
        }
        return status;
    }
    /**
     * 
     * @param data
     * @param battle
     * @throws JSONException 
     */
    public void processBattleTroops(JSONObject data, Battle battle) throws JSONException {
        if(data.has("troops") && data.getJSONArray("troops").length() > 0) {
            JSONArray array = data.getJSONArray("troops");
            JSONObject troopObj = null;
            for(int i =0 ; i < array.length(); i++) {
                troopObj = array.getJSONObject(i);
                BasicDBObject troop = new BasicDBObject();
                troop.put("battle_id", battle.get("battle_id"));
                troop.put("is_created", new Date().getTime());
                troop.put("tid", troopObj.getString("tid"));
                troop.put("level", troopObj.get("level"));
                troop.put("count", troopObj.getLong("count"));
                WriteResult result = MongoDbUtil.saveCollection("aw_battle_troops", troop);
                if(result.getLastError().ok()) {
                    long count = troopObj.getLong("count");
                    for(int j = 1; j <= count; j++) {
                        DBObject troopConfig = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_troops_configuration").findOne(
                                               new BasicDBObject().append("tid", troopObj.getString("tid")).append("level", troopObj.get("level")));
                        if(troopConfig != null) {
                            DBObject userTroops = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user_troops").findOne(
                                                  new BasicDBObject().append("troop_id", troopConfig.get("troop_id")).append("uid", data.get("attacker_id")));
                            if(userTroops != null) {
                                // delete userTroops
                                MongoDbUtil.removeCollection("aw_user_troops", userTroops);
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * 
     * @param battle 
     */
    public void updateBattleTrophy(Battle battle) {
        Map battleMap = battle.toMap();
        if(battleMap.containsKey("attacker_id") && battle.getLong("attacker_id") > 0) {
            DBObject user = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user")
                            .findOne(new BasicDBObject("uid",battle.get("attacker_id")));
            if(user != null && battle.getLong("attacker_trophies") > 0) {
                if(battle.getLong("attacker_won") == 1) {
                    long userTrophies = (Long) user.get("trophies");
                    userTrophies+= battle.getLong("attacker_trophies");
                    user.put("trophies", userTrophies);
                }
                else {
                    long userTrophies = (Long) user.get("trophies");
                    userTrophies-= battle.getLong("attacker_trophies");
                    if(userTrophies < 0) userTrophies = 0;
                    user.put("trophies", userTrophies);
                }
                // Update User here
                BasicDBObject updateUser = new BasicDBObject("$set",new BasicDBObject("trophies",user.get("trophies")));
                BasicDBObject query = new BasicDBObject("uid",battle.get("attacker_id"));
                MongoDbUtil.updateCollection("aw_user", query, updateUser);
            }
        }
        if(battleMap.containsKey("defender_id") && battle.getDefenderId() > 0) {
            DBObject user = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_user")
                            .findOne(new BasicDBObject("uid",battle.get("defender_id")));
            if(user != null && battle.getLong("defender_trophies") > 0) {
                if(battle.getAttackerWon() == 1) {
                    long userTrophies = (Long) user.get("trophies");
                    userTrophies+= battle.getLong("defender_trophies");
                    user.put("trophies", userTrophies);
                }
                else {
                    long userTrophies = (Long) user.get("trophies");
                    userTrophies-= battle.getLong("defender_trophies");
                    if(userTrophies < 0) userTrophies = 0;
                    user.put("trophies", userTrophies);
                }
                // Update User here
                BasicDBObject updateUser = new BasicDBObject("$set",new BasicDBObject("trophies",user.get("trophies")));
                BasicDBObject query = new BasicDBObject("uid",battle.get("defender_id"));
                MongoDbUtil.updateCollection("aw_user", query, updateUser);
            }
        }
    }
    /**
     * 
     * @param battleId
     * @return 
     */
    public Map getBattleDetail(long battleId) {
        Map data = new HashMap();     
        DBObject battle = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_battle").findOne(
                          new BasicDBObject().append("battle_id", battleId));
        if(battle != null) {
            if(battle.containsField("battleBuildings")) {
                List<BattleBuilding> battleBuildings = (List<BattleBuilding>) battle.get("battleBuildings");
                List battles = new ArrayList();
                for(BattleBuilding bb: battleBuildings) {
                    Map bbData = new HashMap();
                    bbData.put("building_id", bb.get("building_id"));
                    bbData.put("is_destroyed", bb.get("is_destroyed"));
                    bbData.put("resource_lost", bb.get("resource_lost"));
                    battles.add(bbData);
                }
                data.put("buildings", battles);
            }
            if(battle.containsField("battleTroops")) {
                List<BattleTroops> battleTroops = (List<BattleTroops>) battle.get("battleTroops");
                List troops = new ArrayList();
                for(BattleTroops bt : battleTroops) {
                    Map tData = new HashMap();
                    tData.put("tid", bt.get("tid"));
                    tData.put("count", bt.get("count"));
                    tData.put("level", bt.get("level"));
                    troops.add(tData);
                }
                data.put("troops", troops);
            }
        }
        return data;
    }
}

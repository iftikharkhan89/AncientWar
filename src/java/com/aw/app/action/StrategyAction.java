/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.app.action;

import com.aw.util.MongoDbUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 *
 * @author iftikhar
 */
public class StrategyAction {
    /**
     * 
     * @param type
     * @param time 
     */
    public void getInstantFinishValue(String type, Long time) {
        
    }
    /**
     * 
     * @param uid 
     */
    public void bootStrapAction(Long uid) {
        /********** Perform User Building Checking ***************/
        DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base");
        BasicDBObject query = new BasicDBObject("uid",uid);
        DBCursor userBuildings = table.find(query);
        int count = 0;
        while(userBuildings.hasNext()) {           
            DBObject building = userBuildings.next();
            if(building.containsField("tid")) {
                String tid = (String)building.get("tid");
                TroopsAction troopsAction = new TroopsAction();
                if(tid != null && tid.equalsIgnoreCase("TID_BUILDING_TAVERN")) {                   
                    troopsAction.checkToopsUpgrades(uid, building);
                    count++;
                }
                else if (tid != null && tid.equalsIgnoreCase("TID_BUILDING_BARRACK")) {
                    int buildingId = (Integer)building.get("building_id");
                    troopsAction.checkToopsInBarrack(uid, buildingId);
                    count++;
                }
                
            }
        }
    }
    /**
     * 
     * @param type
     * @param time
     * @return 
     */
    public static long getInstantFinishValue(String type, long time) {
        long minutes = 0;
        if("building".equalsIgnoreCase(type)) {
            return (long)Math.ceil(time/60);
        }
        else if("army_camp".equalsIgnoreCase(type)) {
            return (long)Math.ceil(time/60);
        }
     return minutes;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.app.action;

import com.aw.model.objects.BuildingBase;
import com.aw.model.objects.BuildingTownhall;
import com.aw.util.MongoDbUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.util.List;

/**
 *
 * @author iftikhar
 */
public class TownHallAction {
    
    public static final String townHallTid = "TID_BUILDING_TOWN_HALL";
    /**
     * 
     * @param tid
     * @param uid
     * @param level
     * @return 
     */
    public static boolean isAllowedBuilding(Object tid,Object uid,Object level){
        boolean isAllowed = false;
        if(tid != null && tid.toString().equalsIgnoreCase(townHallTid)) { /**** If Town Hall comes for upgrade ***/
            isAllowed = true;
            return isAllowed;
        }
        DBCollection table = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base");
        BasicDBObject query = new BasicDBObject();
        query.put("tid", tid);
        query.put("uid", uid);
        BuildingBase buildingBase = (BuildingBase)table.findOne(query);
        if(buildingBase != null) {
            Object townHallLevel = buildingBase.get("level");
            
        }
        return isAllowed;
    }
    /**
     * 
     * @param uid
     * @return 
     */
    public BasicDBObject getTownHallOfUser(Object uid) {
       DBObject buildingBase = MongoDbUtil.getCollection(MongoDbUtil.defaultDBName, "aw_building_base").findOne(
                               new BasicDBObject("uid",uid).append("tid", townHallTid));
       if(buildingBase != null) {
           if(buildingBase.containsField("buildingTownhalls")) {
                List<BuildingTownhall> townHallBuildings = (List<BuildingTownhall>)buildingBase.get("buildingTownhalls");
                return townHallBuildings.get(0);
           }
       }
       return null;
    }
}

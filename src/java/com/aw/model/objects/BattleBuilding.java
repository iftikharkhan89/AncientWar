/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.model.objects;

import com.mongodb.BasicDBObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author iftikhar
 */
public class BattleBuilding extends BasicDBObject {
 private long battleBuildingId;
 private long battleId;
 private int buildingId;
 private boolean isDestroyed;
 private long resourceLost;
 private long isCreated;
 private BuildingBase buildingBase;
 private Battle battle;

    public BattleBuilding(long battleBuildingId, long battleId, int buildingId, boolean isDestroyed, long resourceLost, long isCreated) {
        this.battleBuildingId = battleBuildingId;
        this.battleId = battleId;
        this.buildingId = buildingId;
        this.isDestroyed = isDestroyed;
        this.resourceLost = resourceLost;
        this.isCreated = isCreated;
    }

    public BattleBuilding() {
    }

    public BattleBuilding(Map m) {
        super(m);
    }

    public long getBattleBuildingId() {
        return battleBuildingId;
    }

    public void setBattleBuildingId(long battleBuildingId) {
        this.battleBuildingId = battleBuildingId;
    }

    public long getBattleId() {
        return battleId;
    }

    public void setBattleId(long battleId) {
        this.battleId = battleId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public boolean isIsDestroyed() {
        return isDestroyed;
    }

    public void setIsDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    public long getResourceLost() {
        return resourceLost;
    }

    public void setResourceLost(long resourceLost) {
        this.resourceLost = resourceLost;
    }

    public long getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(long isCreated) {
        this.isCreated = isCreated;
    }

    public BuildingBase getBuildingBase() {
        return buildingBase;
    }

    public void setBuildingBase(BuildingBase buildingBase) {
        this.buildingBase = buildingBase;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    @Override
    public Map toMap() {
        Map<String,Object> battleBuilding = new HashMap<>();
        battleBuilding.put("battle_building_id", this.getBattleBuildingId());
        battleBuilding.put("battle_id", this.getBattleId());
        battleBuilding.put("building_id", this.getBuildingId());
        battleBuilding.put("is_destroyed", this.isIsDestroyed());
        battleBuilding.put("resource_lost", this.getResourceLost());
        battleBuilding.put("is_created", this.getIsCreated());
        if(this.getBuildingBase() != null)
            battleBuilding.put("buildingBase", this.getBuildingBase().toMap());
        else 
            battleBuilding.put("buildingBase", this.getBuildingBase());
        if(this.getBattle() != null)
            battleBuilding.put("battle", this.getBattle().toMap());
        else 
           battleBuilding.put("battle", this.getBattle());  
        
        return battleBuilding; 
    }
    
}

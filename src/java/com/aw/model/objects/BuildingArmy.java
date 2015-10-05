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
public class BuildingArmy extends BasicDBObject{
  private long building_army_id;
  private long building_id;
  private long bunker;
  private long housing_space;
  private long unit_production;
  private long upgrades_units;
  private long last_trained_character_time;
  private long is_tavern;
  private String upgrading_character_tid;
  private String research_start_time;
  private BuildingBase building;

    public BuildingArmy(Map m) {
        super(m);
    }

    public BuildingArmy() {
    }

    public long getBuilding_army_id() {
        return building_army_id;
    }

    public void setBuilding_army_id(long building_army_id) {
        this.building_army_id = building_army_id;
    }

    public long getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(long building_id) {
        this.building_id = building_id;
    }

    public long getBunker() {
        return bunker;
    }

    public void setBunker(long bunker) {
        this.bunker = bunker;
    }

    public long getHousing_space() {
        return housing_space;
    }

    public void setHousing_space(long housing_space) {
        this.housing_space = housing_space;
    }

    public long getUnit_production() {
        return unit_production;
    }

    public void setUnit_production(long unit_production) {
        this.unit_production = unit_production;
    }

    public long getUpgrades_units() {
        return upgrades_units;
    }

    public void setUpgrades_units(long upgrades_units) {
        this.upgrades_units = upgrades_units;
    }

    public long getLast_trained_character_time() {
        return last_trained_character_time;
    }

    public void setLast_trained_character_time(long last_trained_character_time) {
        this.last_trained_character_time = last_trained_character_time;
    }

    public long getIs_tavern() {
        return is_tavern;
    }

    public void setIs_tavern(long is_tavern) {
        this.is_tavern = is_tavern;
    }

    public String getUpgrading_character_tid() {
        return upgrading_character_tid;
    }

    public void setUpgrading_character_tid(String upgrading_character_tid) {
        this.upgrading_character_tid = upgrading_character_tid;
    }

    public String getResearch_start_time() {
        return research_start_time;
    }

    public void setResearch_start_time(String research_start_time) {
        this.research_start_time = research_start_time;
    }

    public BuildingBase getBuilding() {
        return building;
    }

    public void setBuilding(BuildingBase building) {
        this.building = building;
    }

    @Override
    public Map toMap() {
        Map<String,Object> buildingArmy = new HashMap<>();
        buildingArmy.put("building_army_id", this.getBuilding_army_id());
        buildingArmy.put("building_id", this.getBuilding_id());
        buildingArmy.put("bunker", this.getBunker());
        buildingArmy.put("housing_space", this.getHousing_space());
        buildingArmy.put("unit_production", this.getUnit_production());
        buildingArmy.put("upgrades_units", this.getUpgrades_units());
        buildingArmy.put("last_trained_character_time", this.getLast_trained_character_time());
        buildingArmy.put("is_tavern", this.getIs_tavern());
        buildingArmy.put("upgrading_character_tid", this.getUpgrading_character_tid());
        buildingArmy.put("research_start_time", this.getResearch_start_time());
        if(this.getBuilding() != null)
            buildingArmy.put("building", this.getBuilding().toMap());
        else
            buildingArmy.put("building", this.getBuilding());
        return buildingArmy; //To change body of generated methods, choose Tools | Templates.
    }
  
}

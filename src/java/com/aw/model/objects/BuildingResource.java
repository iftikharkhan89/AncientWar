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
public class BuildingResource extends BasicDBObject {
 private long buildingResourceId;
 private long buildingId;
 private long maxStoredGold;
 private long maxStoredMithril;
 private String producesResource;
 private int resourcePerHour;
 private int resourceMax;
 private int resourceStored;
 private String lastCollectionTime;
 private long maxStoredDarkMithril;
 private BuildingBase building;

    public BuildingResource(long buildingResourceId, long buildingId) {
        this.buildingResourceId = buildingResourceId;
        this.buildingId = buildingId;
    }

    public BuildingResource(Map m) {
        super(m);
    }

    public BuildingResource() {
    }

    public long getBuildingResourceId() {
        return buildingResourceId;
    }

    public void setBuildingResourceId(long buildingResourceId) {
        this.buildingResourceId = buildingResourceId;
    }

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    public long getMaxStoredGold() {
        return maxStoredGold;
    }

    public void setMaxStoredGold(long maxStoredGold) {
        this.maxStoredGold = maxStoredGold;
    }

    public long getMaxStoredMithril() {
        return maxStoredMithril;
    }

    public void setMaxStoredMithril(long maxStoredMithril) {
        this.maxStoredMithril = maxStoredMithril;
    }

    public String getProducesResource() {
        return producesResource;
    }

    public void setProducesResource(String producesResource) {
        this.producesResource = producesResource;
    }

    public int getResourcePerHour() {
        return resourcePerHour;
    }

    public void setResourcePerHour(int resourcePerHour) {
        this.resourcePerHour = resourcePerHour;
    }

    public int getResourceMax() {
        return resourceMax;
    }

    public void setResourceMax(int resourceMax) {
        this.resourceMax = resourceMax;
    }

    public int getResourceStored() {
        return resourceStored;
    }

    public void setResourceStored(int resourceStored) {
        this.resourceStored = resourceStored;
    }

    public String getLastCollectionTime() {
        return lastCollectionTime;
    }

    public void setLastCollectionTime(String lastCollectionTime) {
        this.lastCollectionTime = lastCollectionTime;
    }

    public long getMaxStoredDarkMithril() {
        return maxStoredDarkMithril;
    }

    public void setMaxStoredDarkMithril(long maxStoredDarkMithril) {
        this.maxStoredDarkMithril = maxStoredDarkMithril;
    }

    public BuildingBase getBuilding() {
        return building;
    }

    public void setBuilding(BuildingBase building) {
        this.building = building;
    }

    @Override
    public Map toMap() {
        Map<String,Object> buildingRes = new HashMap<>();
        buildingRes.put("building_resource_id", this.getBuildingResourceId());
        buildingRes.put("building_id", this.getBuildingId());
        buildingRes.put("max_stored_gold", this.getMaxStoredGold());
        buildingRes.put("max_stored_mithril", this.getMaxStoredMithril());
        buildingRes.put("produces_resource", this.getProducesResource());
        buildingRes.put("resource_per_hour", this.getResourcePerHour());
        buildingRes.put("resource_max", this.getResourceMax());
        buildingRes.put("resource_stored", this.getResourceStored());
        buildingRes.put("last_collection_time", this.getLastCollectionTime());
        buildingRes.put("max_stored_dark_mithril", this.getMaxStoredDarkMithril());
        if(this.getBuilding() != null)
            buildingRes.put("building", this.getBuilding().toMap());
        
        return buildingRes; //To change body of generated methods, choose Tools | Templates.
    }

   
    
}

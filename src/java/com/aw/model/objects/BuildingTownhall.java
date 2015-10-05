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
public class BuildingTownhall extends BasicDBObject {
 private long buildingTownhallId;
 private long buildingId;
 private long maxStoredGold;
 private long maxStoredMithril;
 private String exportNameNPC;
 private long goldStored;
 private long mithrilStored;

    public BuildingTownhall(long buildingTownhallId, long buildingId) {
        this.buildingTownhallId = buildingTownhallId;
        this.buildingId = buildingId;
    }

    public BuildingTownhall(Map m) {
        super(m);
    }

    public BuildingTownhall() {
    }

    public long getBuildingTownhallId() {
        return buildingTownhallId;
    }

    public void setBuildingTownhallId(long buildingTownhallId) {
        this.buildingTownhallId = buildingTownhallId;
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

    public String getExportNameNPC() {
        return exportNameNPC;
    }

    public void setExportNameNPC(String exportNameNPC) {
        this.exportNameNPC = exportNameNPC;
    }

    public long getGoldStored() {
        return goldStored;
    }

    public void setGoldStored(long goldStored) {
        this.goldStored = goldStored;
    }

    public long getMithrilStored() {
        return mithrilStored;
    }

    public void setMithrilStored(long mithrilStored) {
        this.mithrilStored = mithrilStored;
    }

    @Override
    public Map toMap() {
        Map<String,Object> buildingTownhalls = new HashMap<>();
        buildingTownhalls.put("building_townhall_id", this.getBuildingTownhallId());
        buildingTownhalls.put("building_id", this.getBuildingId());
        buildingTownhalls.put("max_stored_gold", this.getMaxStoredGold());
        buildingTownhalls.put("max_stored_mithril", this.getMaxStoredMithril());
        buildingTownhalls.put("export_name_npc", this.getExportNameNPC());
        buildingTownhalls.put("gold_stored", this.getGoldStored());
        buildingTownhalls.put("mithril_stored", this.getMithrilStored());
        
        return buildingTownhalls; //To change body of generated methods, choose Tools | Templates.
    }

    
 
}

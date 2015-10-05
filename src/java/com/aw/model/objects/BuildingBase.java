/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.model.objects;

import com.mongodb.BasicDBObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author iftikhar
 */
public class BuildingBase extends BasicDBObject  {
 private long buildingId;
 private String uid;
 private String name;
 private String tid;
 private String infoTid;
 private int level;
 private String buildingClass;
 private String swf;
 private String exportName;
 private String exportNameNPC;
 private String exportNameConstruction;
 private String buildTimeD;
 private String buildTimeH;
 private String buildTimeM;
 private String buildResource;
 private int buildCost;
 private int townHallLevel;
 private int width;
 private int height;
 private String icon;
 private String exportNameBuildAnim;
 private int hitPoints;
 private String regenerationTime;
 private String destroyEffect;
 private String exportNameDamageAnim;
 private String exportNameDamaged;
 private int buildingWidth;
 private int buildingHeight;
 private String exportNameBase;
 private String pickupEffect;
 private String placingEffect;
 private int cannotSellLast;
 private int destructionXp;
 private int locked;
 private String exportNameBaseNPC;
 private int position_x;
 private int position_y;
 private String created;
 private boolean isConstructing;
 private String constructionStartTime;
 private boolean isUpgrading;
 private String upgradeStartTime;
 private boolean isSynced;
 private boolean isTownhall;
 private boolean isDestroyed;
 private List<BattleBuilding> battleBuildings;
 private List<BuildingArmy> buildingArmies;
 private User u;
 private List<BuildingDefense> buildingDefenses;
 private List<BuildingResource> buildingResources;
 private List<BuildingTownhall> buildingTownhalls;

    public BuildingBase() {
    }

    public BuildingBase(Map m) {
        super(m);
    }

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getInfoTid() {
        return infoTid;
    }

    public void setInfoTid(String infoTid) {
        this.infoTid = infoTid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBuildingClass() {
        return buildingClass;
    }

    public void setBuildingClass(String buildingClass) {
        this.buildingClass = buildingClass;
    }

    public String getSwf() {
        return swf;
    }

    public void setSwf(String swf) {
        this.swf = swf;
    }

    public String getExportName() {
        return exportName;
    }

    public void setExportName(String exportName) {
        this.exportName = exportName;
    }

    public String getExportNameNPC() {
        return exportNameNPC;
    }

    public void setExportNameNPC(String exportNameNPC) {
        this.exportNameNPC = exportNameNPC;
    }

    public String getExportNameConstruction() {
        return exportNameConstruction;
    }

    public void setExportNameConstruction(String exportNameConstruction) {
        this.exportNameConstruction = exportNameConstruction;
    }

    public String getBuildTimeD() {
        return buildTimeD;
    }

    public void setBuildTimeD(String buildTimeD) {
        this.buildTimeD = buildTimeD;
    }

    public String getBuildTimeH() {
        return buildTimeH;
    }

    public void setBuildTimeH(String buildTimeH) {
        this.buildTimeH = buildTimeH;
    }

    public String getBuildTimeM() {
        return buildTimeM;
    }

    public void setBuildTimeM(String buildTimeM) {
        this.buildTimeM = buildTimeM;
    }

    public String getBuildResource() {
        return buildResource;
    }

    public void setBuildResource(String buildResource) {
        this.buildResource = buildResource;
    }

    public int getBuildCost() {
        return buildCost;
    }

    public void setBuildCost(int buildCost) {
        this.buildCost = buildCost;
    }

    public int getTownHallLevel() {
        return townHallLevel;
    }

    public void setTownHallLevel(int townHallLevel) {
        this.townHallLevel = townHallLevel;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExportNameBuildAnim() {
        return exportNameBuildAnim;
    }

    public void setExportNameBuildAnim(String exportNameBuildAnim) {
        this.exportNameBuildAnim = exportNameBuildAnim;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getRegenerationTime() {
        return regenerationTime;
    }

    public void setRegenerationTime(String regenerationTime) {
        this.regenerationTime = regenerationTime;
    }

    public String getDestroyEffect() {
        return destroyEffect;
    }

    public void setDestroyEffect(String destroyEffect) {
        this.destroyEffect = destroyEffect;
    }

    public String getExportNameDamageAnim() {
        return exportNameDamageAnim;
    }

    public void setExportNameDamageAnim(String exportNameDamageAnim) {
        this.exportNameDamageAnim = exportNameDamageAnim;
    }

    public String getExportNameDamaged() {
        return exportNameDamaged;
    }

    public void setExportNameDamaged(String exportNameDamaged) {
        this.exportNameDamaged = exportNameDamaged;
    }

    public int getBuildingWidth() {
        return buildingWidth;
    }

    public void setBuildingWidth(int buildingWidth) {
        this.buildingWidth = buildingWidth;
    }

    public int getBuildingHeight() {
        return buildingHeight;
    }

    public void setBuildingHeight(int buildingHeight) {
        this.buildingHeight = buildingHeight;
    }

    public String getExportNameBase() {
        return exportNameBase;
    }

    public void setExportNameBase(String exportNameBase) {
        this.exportNameBase = exportNameBase;
    }

    public String getPickupEffect() {
        return pickupEffect;
    }

    public void setPickupEffect(String pickupEffect) {
        this.pickupEffect = pickupEffect;
    }

    public String getPlacingEffect() {
        return placingEffect;
    }

    public void setPlacingEffect(String placingEffect) {
        this.placingEffect = placingEffect;
    }

    public int getCannotSellLast() {
        return cannotSellLast;
    }

    public void setCannotSellLast(int cannotSellLast) {
        this.cannotSellLast = cannotSellLast;
    }

    public int getDestructionXp() {
        return destructionXp;
    }

    public void setDestructionXp(int destructionXp) {
        this.destructionXp = destructionXp;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public String getExportNameBaseNPC() {
        return exportNameBaseNPC;
    }

    public void setExportNameBaseNPC(String exportNameBaseNPC) {
        this.exportNameBaseNPC = exportNameBaseNPC;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public boolean isIsConstructing() {
        return isConstructing;
    }

    public void setIsConstructing(boolean isConstructing) {
        this.isConstructing = isConstructing;
    }

    public String getConstructionStartTime() {
        return constructionStartTime;
    }

    public void setConstructionStartTime(String constructionStartTime) {
        this.constructionStartTime = constructionStartTime;
    }

    public boolean isIsUpgrading() {
        return isUpgrading;
    }

    public void setIsUpgrading(boolean isUpgrading) {
        this.isUpgrading = isUpgrading;
    }

    public String getUpgradeStartTime() {
        return upgradeStartTime;
    }

    public void setUpgradeStartTime(String upgradeStartTime) {
        this.upgradeStartTime = upgradeStartTime;
    }

    public boolean isIsSynced() {
        return isSynced;
    }

    public void setIsSynced(boolean isSynced) {
        this.isSynced = isSynced;
    }

    public boolean isIsTownhall() {
        return isTownhall;
    }

    public void setIsTownhall(boolean isTownhall) {
        this.isTownhall = isTownhall;
    }

    public boolean isIsDestroyed() {
        return isDestroyed;
    }

    public void setIsDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    public List<BattleBuilding> getBattleBuildings() {
        return battleBuildings;
    }

    public void setBattleBuildings(List<BattleBuilding> battleBuildings) {
        this.battleBuildings = battleBuildings;
    }

    public List<BuildingArmy> getBuildingArmies() {
        return buildingArmies;
    }

    public void setBuildingArmies(List<BuildingArmy> buildingArmies) {
        this.buildingArmies = buildingArmies;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public List<BuildingDefense> getBuildingDefenses() {
        return buildingDefenses;
    }

    public void setBuildingDefenses(List<BuildingDefense> buildingDefenses) {
        this.buildingDefenses = buildingDefenses;
    }

    public List<BuildingResource> getBuildingResources() {
        return buildingResources;
    }

    public void setBuildingResources(List<BuildingResource> buildingResources) {
        this.buildingResources = buildingResources;
    }

    public List<BuildingTownhall> getBuildingTownhalls() {
        return buildingTownhalls;
    }

    public void setBuildingTownhalls(List<BuildingTownhall> buildingTownhalls) {
        this.buildingTownhalls = buildingTownhalls;
    }

    @Override
    public Map toMap() {
        Map<String,Object> buildingBase = new HashMap();
        buildingBase.put("building_id", this.getBuildingId());
        buildingBase.put("uid", this.getUid());
        buildingBase.put("name", this.getName());
        buildingBase.put("tid", this.getTid());
        buildingBase.put("info_tid", this.getInfoTid());
        buildingBase.put("level", this.getLevel());
        buildingBase.put("building_class", this.getBuildingClass());
        buildingBase.put("swf", this.getSwf());
        buildingBase.put("export_name", this.getExportName());
        buildingBase.put("export_name_npc", this.getExportNameBaseNPC());
        buildingBase.put("export_name_construction", this.getExportNameConstruction());
        buildingBase.put("build_time_d", this.getBuildTimeD());
        buildingBase.put("build_time_h", this.getBuildTimeH());
        buildingBase.put("build_time_m", this.getBuildTimeM());
        buildingBase.put("build_resource", this.getBuildResource());
        buildingBase.put("build_cost", this.getBuildCost());
        buildingBase.put("town_hall_level", this.getTownHallLevel());
        buildingBase.put("width", this.getWidth());
        buildingBase.put("height", this.getHeight());
        buildingBase.put("icon", this.getIcon());
        buildingBase.put("export_name_build_anim", this.getExportNameBuildAnim());
        buildingBase.put("hit_points", this.getHitPoints());
        buildingBase.put("regeneration_time", this.getRegenerationTime());
        buildingBase.put("destroy_effect", this.getDestroyEffect());
        buildingBase.put("export_name_damage_anim", this.getExportNameDamageAnim());
        buildingBase.put("export_name_damaged", this.getExportNameDamaged());
        buildingBase.put("building_width", this.getBuildingWidth());
        buildingBase.put("building_height", this.getBuildingHeight());
        buildingBase.put("export_name_base", this.getExportNameBase());
        buildingBase.put("pickup_effect", this.getPickupEffect());
        buildingBase.put("placing_effect", this.getPlacingEffect());
        buildingBase.put("cannot_sell_last", this.getCannotSellLast());
        buildingBase.put("destruction_xp", this.getDestructionXp());
        buildingBase.put("locked", this.getLocked());
        buildingBase.put("export_name_base_npc", this.getExportNameBaseNPC());
        buildingBase.put("position_x", this.getPosition_x());
        buildingBase.put("position_y", this.getPosition_y());
        buildingBase.put("created", this.getCreated());
        buildingBase.put("is_constructing", this.isIsConstructing());
        buildingBase.put("construction_start_time", this.getConstructionStartTime());
        buildingBase.put("is_upgrading", this.isIsUpgrading());
        buildingBase.put("upgrade_start_time", this.getUpgradeStartTime());
        buildingBase.put("is_synced", this.isIsSynced());
        buildingBase.put("is_townhall", this.isIsTownhall());
        buildingBase.put("is_destroyed", this.isIsDestroyed());
        if(this.getBattleBuildings() != null)
            buildingBase.put("battleBuildings", this.getBattleBuildings());
        if(this.getBuildingArmies() != null)
            buildingBase.put("buildingArmies", this.getBuildingArmies());
        
        if(this.getBuildingDefenses() != null)
            buildingBase.put("buildingDefense", this.getBuildingDefenses());
        if(this.getBuildingResources() != null)
            buildingBase.put("buildingResource", this.getBuildingResources());
        if(this.getBuildingTownhalls() != null)
            buildingBase.put("buildingTownhalls", this.getBuildingTownhalls()); 
        return buildingBase; //To change body of generated methods, choose Tools | Templates.
    }
    
}

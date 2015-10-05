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
public class Buildings extends BasicDBObject  {
 public static String housingTid = "TID_BUILDING_HOUSING";   
 private long buildingId;
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
 private long maxStoredGold;
 private long maxStoredMithril;
 private int bunker;
 private int housingSpace;
 private String producesResource;
 private int resourcePerHour;
 private int resourceMax;
 private int unitProduction;
 private int upgradesUnits;
 private long hitPoints;
 private long regenTime;
 private long attackRange;
 private long attackSpeed;
 private long damage;
 private String destroyEffect;
 private String attackEffect;
 private String hitEffect;
 private String projectile;
 private String exportNameDamageAnim;
 private String exportNameDamaged;
 private long buildingW;
 private long buildingH;
 private String exportNameBase;
 private String exportNameBaseNPC;
 private long airTargets;
 private long groundTargets;
 private long minAttackRange;
 private long damageRadius;
 private long pushBack;
 private String pickupEffect;
 private String placingEffect;
 private long cannotSellLast;
 private String defenderCharacter;
 private long defenderCount;
 private long defenderZ;
 private long destructionXp;
 private long locked;

    public Buildings(long buildingId, String name) {
        this.buildingId = buildingId;
        this.name = name;
    }

    public Buildings() {
    }

    public Buildings(Map m) {
        super(m);
    }

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
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

    public int getBunker() {
        return bunker;
    }

    public void setBunker(int bunker) {
        this.bunker = bunker;
    }

    public int getHousingSpace() {
        return housingSpace;
    }

    public void setHousingSpace(int housingSpace) {
        this.housingSpace = housingSpace;
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

    public int getUnitProduction() {
        return unitProduction;
    }

    public void setUnitProduction(int unitProduction) {
        this.unitProduction = unitProduction;
    }

    public int getUpgradesUnits() {
        return upgradesUnits;
    }

    public void setUpgradesUnits(int upgradesUnits) {
        this.upgradesUnits = upgradesUnits;
    }

    public long getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(long hitPoints) {
        this.hitPoints = hitPoints;
    }

    public long getRegenTime() {
        return regenTime;
    }

    public void setRegenTime(long regenTime) {
        this.regenTime = regenTime;
    }

    public long getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(long attackRange) {
        this.attackRange = attackRange;
    }

    public long getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(long attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long damage) {
        this.damage = damage;
    }

    public String getDestroyEffect() {
        return destroyEffect;
    }

    public void setDestroyEffect(String destroyEffect) {
        this.destroyEffect = destroyEffect;
    }

    public String getAttackEffect() {
        return attackEffect;
    }

    public void setAttackEffect(String attackEffect) {
        this.attackEffect = attackEffect;
    }

    public String getHitEffect() {
        return hitEffect;
    }

    public void setHitEffect(String hitEffect) {
        this.hitEffect = hitEffect;
    }

    public String getProjectile() {
        return projectile;
    }

    public void setProjectile(String projectile) {
        this.projectile = projectile;
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

    public long getBuildingW() {
        return buildingW;
    }

    public void setBuildingW(long buildingW) {
        this.buildingW = buildingW;
    }

    public long getBuildingH() {
        return buildingH;
    }

    public void setBuildingH(long buildingH) {
        this.buildingH = buildingH;
    }

    public String getExportNameBase() {
        return exportNameBase;
    }

    public void setExportNameBase(String exportNameBase) {
        this.exportNameBase = exportNameBase;
    }

    public String getExportNameBaseNPC() {
        return exportNameBaseNPC;
    }

    public void setExportNameBaseNPC(String exportNameBaseNPC) {
        this.exportNameBaseNPC = exportNameBaseNPC;
    }

    public long getAirTargets() {
        return airTargets;
    }

    public void setAirTargets(long airTargets) {
        this.airTargets = airTargets;
    }

    public long getGroundTargets() {
        return groundTargets;
    }

    public void setGroundTargets(long groundTargets) {
        this.groundTargets = groundTargets;
    }

    public long getMinAttackRange() {
        return minAttackRange;
    }

    public void setMinAttackRange(long minAttackRange) {
        this.minAttackRange = minAttackRange;
    }

    public long getDamageRadius() {
        return damageRadius;
    }

    public void setDamageRadius(long damageRadius) {
        this.damageRadius = damageRadius;
    }

    public long getPushBack() {
        return pushBack;
    }

    public void setPushBack(long pushBack) {
        this.pushBack = pushBack;
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

    public long getCannotSellLast() {
        return cannotSellLast;
    }

    public void setCannotSellLast(long cannotSellLast) {
        this.cannotSellLast = cannotSellLast;
    }

    public String getDefenderCharacter() {
        return defenderCharacter;
    }

    public void setDefenderCharacter(String defenderCharacter) {
        this.defenderCharacter = defenderCharacter;
    }

    public long getDefenderCount() {
        return defenderCount;
    }

    public void setDefenderCount(long defenderCount) {
        this.defenderCount = defenderCount;
    }

    public long getDefenderZ() {
        return defenderZ;
    }

    public void setDefenderZ(long defenderZ) {
        this.defenderZ = defenderZ;
    }

    public long getDestructionXp() {
        return destructionXp;
    }

    public void setDestructionXp(long destructionXp) {
        this.destructionXp = destructionXp;
    }

    public long getLocked() {
        return locked;
    }

    public void setLocked(long locked) {
        this.locked = locked;
    }

    @Override
    public Map toMap() {
        Map<String,Object> building = new HashMap<>();
        building.put("building_id", this.getBuildingId());
        building.put("name", this.getName());
        building.put("tid", this.getTid());
        building.put("infotid", this.getInfoTid());
        building.put("level", this.getLevel());
        building.put("buildingclass", this.getBuildingClass());
        building.put("swf", this.getSwf());
        building.put("exportname", this.getExportName());
        building.put("exportnamenpc", this.getExportNameBaseNPC());
        building.put("exportnameconstruction", this.getExportNameConstruction());
        building.put("buildtimed", this.getBuildTimeD());
        building.put("buildtimeh", this.getBuildTimeH());
        building.put("buildtimem", this.getBuildTimeM());
        building.put("buildresource", this.getBuildResource());
        building.put("buildcost", this.getBuildCost());
        building.put("townhalllevel", this.getTownHallLevel());
        building.put("width", this.getWidth());
        building.put("height", this.getHeight());
        building.put("icon", this.getIcon());
        building.put("exportnamebuildanim", this.getExportNameBuildAnim());
        building.put("maxstoredgold", this.getMaxStoredGold());
        building.put("maxstoredmithril", this.getMaxStoredMithril());
        building.put("bunker", this.getBunker());
        building.put("housingspace", this.getHousingSpace());
        building.put("producesresource", this.getProducesResource());
        building.put("resourceperhour", this.getResourcePerHour());
        building.put("resourcemax", this.getResourceMax());
        building.put("unitproduction", this.getUnitProduction());
        building.put("upgradesunits", this.getUpgradesUnits());
        building.put("hitpoints", this.getHitPoints());
        building.put("regentime", this.getRegenTime());
        building.put("attackrange", this.getAttackRange());
        building.put("attackspeed", this.getAttackSpeed());
        building.put("damage", this.getDamage());
        building.put("destroyeffect", this.getDestroyEffect());
        building.put("attackeffect", this.getAttackEffect());
        building.put("hiteffect", this.getHitEffect());
        building.put("projectile", this.getProjectile());
        building.put("exportnamedamageanim", this.getExportNameDamageAnim());
        building.put("exportnamedamaged", this.getExportNameDamaged());
        building.put("buildingw", this.getBuildingW());
        building.put("buildingh", this.getBuildingH());
        building.put("exportnamebase", this.getExportNameBase());
        building.put("exportnamebasenpc", this.getExportNameBaseNPC());
        building.put("airtargets", this.getAirTargets());
        building.put("groundtargets", this.getGroundTargets());
        building.put("minattackrange", this.getMinAttackRange());
        building.put("damageradius", this.getDamageRadius());
        building.put("pushback", this.getPushBack());
        building.put("pickupeffect", this.getPickupEffect());
        building.put("placingeffect", this.getPlacingEffect());
        building.put("cannotselllast", this.getCannotSellLast());
        building.put("defendercharacter", this.getDefenderCharacter());
        building.put("defendercount", this.getDefenderCount());
        building.put("defenderz", this.getDefenderZ());
        building.put("destructionxp", this.getDestructionXp());
        building.put("locked", this.getLocked());
        return building; //To change body of generated methods, choose Tools | Templates.
    }

   

}

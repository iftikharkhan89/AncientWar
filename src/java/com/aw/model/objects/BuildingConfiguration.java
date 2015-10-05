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
public class BuildingConfiguration extends BasicDBObject {
 private long buildingConfigId;
 private String name;
 private String tid;
 private String infoTid;
 private int level;
 private String buildingClass;
 private String swf;
 private String exportName;
 private String exportNameNPC;
 private String exportNameConstruction;
 private int buildTimeD;
 private int buildTimeH;
 private int buildTimeM;
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
 private String isCreated;
 private int housingSpace;
 private int bunker;
 private int unitProduction;
 private int upgradesUnits;
 private int attackRange;
 private int minAttackRange;
 private int attackSpeed;
 private String defenderCharacter;
 private int defenderCount;
 private int defenderZ;
 private int damage;
 private String attackEffect;
 private String hitEffect;
 private String projectile;
 private int airTargets;
 private int groundTargets;
 private int damageRadius;
 private int pushBack;
 private int maxStoredGold;
 private int maxStoredMithril;
 private int maxStoredDarkMithril;
 private String producesResource;
 private int resourcePerHour;
 private int resourceMax;

    public BuildingConfiguration(long buildingConfigId) {
        this.buildingConfigId = buildingConfigId;
    }

    public BuildingConfiguration(Map m) {
        super(m);
    }

    public BuildingConfiguration() {
    }

    public long getBuildingConfigId() {
        return buildingConfigId;
    }

    public void setBuildingConfigId(long buildingConfigId) {
        this.buildingConfigId = buildingConfigId;
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

    public int getBuildTimeD() {
        return buildTimeD;
    }

    public void setBuildTimeD(int buildTimeD) {
        this.buildTimeD = buildTimeD;
    }

    public int getBuildTimeH() {
        return buildTimeH;
    }

    public void setBuildTimeH(int buildTimeH) {
        this.buildTimeH = buildTimeH;
    }

    public int getBuildTimeM() {
        return buildTimeM;
    }

    public void setBuildTimeM(int buildTimeM) {
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

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    public int getHousingSpace() {
        return housingSpace;
    }

    public void setHousingSpace(int housingSpace) {
        this.housingSpace = housingSpace;
    }

    public int getBunker() {
        return bunker;
    }

    public void setBunker(int bunker) {
        this.bunker = bunker;
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

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getMinAttackRange() {
        return minAttackRange;
    }

    public void setMinAttackRange(int minAttackRange) {
        this.minAttackRange = minAttackRange;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public String getDefenderCharacter() {
        return defenderCharacter;
    }

    public void setDefenderCharacter(String defenderCharacter) {
        this.defenderCharacter = defenderCharacter;
    }

    public int getDefenderCount() {
        return defenderCount;
    }

    public void setDefenderCount(int defenderCount) {
        this.defenderCount = defenderCount;
    }

    public int getDefenderZ() {
        return defenderZ;
    }

    public void setDefenderZ(int defenderZ) {
        this.defenderZ = defenderZ;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public int getAirTargets() {
        return airTargets;
    }

    public void setAirTargets(int airTargets) {
        this.airTargets = airTargets;
    }

    public int getGroundTargets() {
        return groundTargets;
    }

    public void setGroundTargets(int groundTargets) {
        this.groundTargets = groundTargets;
    }

    public int getDamageRadius() {
        return damageRadius;
    }

    public void setDamageRadius(int damageRadius) {
        this.damageRadius = damageRadius;
    }

    public int getPushBack() {
        return pushBack;
    }

    public void setPushBack(int pushBack) {
        this.pushBack = pushBack;
    }

    public int getMaxStoredGold() {
        return maxStoredGold;
    }

    public void setMaxStoredGold(int maxStoredGold) {
        this.maxStoredGold = maxStoredGold;
    }

    public int getMaxStoredMithril() {
        return maxStoredMithril;
    }

    public void setMaxStoredMithril(int maxStoredMithril) {
        this.maxStoredMithril = maxStoredMithril;
    }

    public int getMaxStoredDarkMithril() {
        return maxStoredDarkMithril;
    }

    public void setMaxStoredDarkMithril(int maxStoredDarkMithril) {
        this.maxStoredDarkMithril = maxStoredDarkMithril;
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

    @Override
    public Map toMap() {
        Map<String,Object> buildingConfig = new HashMap<>();
        buildingConfig.put("building_config_id", this.getBuildingConfigId());
        buildingConfig.put("name", this.getName());
        buildingConfig.put("tid", this.getTid());
        buildingConfig.put("info_tid", this.getInfoTid());
        buildingConfig.put("level", this.getLevel());
        buildingConfig.put("building_class", this.getBuildingClass());
        buildingConfig.put("swf", this.getSwf());
        buildingConfig.put("export_name", this.getExportName());
        buildingConfig.put("export_name_npc", this.getExportNameBaseNPC());
        buildingConfig.put("export_name_construction", this.getExportNameConstruction());
        buildingConfig.put("build_time_d", this.getBuildTimeD());
        buildingConfig.put("build_time_h", this.getBuildTimeH());
        buildingConfig.put("build_time_m", this.getBuildTimeM());
        buildingConfig.put("build_resource", this.getBuildResource());
        buildingConfig.put("build_cost", this.getBuildCost());
        buildingConfig.put("town_hall_level", this.getTownHallLevel());
        buildingConfig.put("width", this.getWidth());
        buildingConfig.put("height", this.getHeight());
        buildingConfig.put("icon", this.getIcon());
        buildingConfig.put("export_name_build_anim", this.getExportNameBuildAnim());
        buildingConfig.put("hit_points", this.getHitPoints());
        buildingConfig.put("regeneration_time", this.getRegenerationTime());
        buildingConfig.put("destroy_effect", this.getDestroyEffect());
        buildingConfig.put("export_name_damage_anim", this.getExportNameDamageAnim());
        buildingConfig.put("export_name_damaged", this.getExportNameDamaged());
        buildingConfig.put("building_width", this.getBuildingWidth());
        buildingConfig.put("building_height", this.getBuildingHeight());
        buildingConfig.put("export_name_base", this.getExportNameBase());
        buildingConfig.put("pickup_effect", this.getPickupEffect());
        buildingConfig.put("placing_effect", this.getPlacingEffect());
        buildingConfig.put("cannot_sell_last", this.getCannotSellLast());
        buildingConfig.put("destruction_xp", this.getDestructionXp());
        buildingConfig.put("locked", this.getLocked());
        buildingConfig.put("export_name_base_npc", this.getExportNameBaseNPC());
        buildingConfig.put("is_created", this.getIsCreated());
        buildingConfig.put("housing_space", this.getHousingSpace());
        buildingConfig.put("bunker", this.getBunker());
        buildingConfig.put("unit_production", this.getUnitProduction());
        buildingConfig.put("upgrades_units", this.getUpgradesUnits());
        buildingConfig.put("attack_range", this.getAttackRange());
        buildingConfig.put("min_attack_range", this.getMinAttackRange());
        buildingConfig.put("attack_speed", this.getAttackSpeed());
        buildingConfig.put("defender_character", this.getDefenderCharacter());
        buildingConfig.put("defender_count", this.getDefenderCount());
        buildingConfig.put("defender_z", this.getDefenderZ());
        buildingConfig.put("damage", this.getDamage());
        buildingConfig.put("attack_effect", this.getAttackEffect());
        buildingConfig.put("hit_effect", this.getHitEffect());
        buildingConfig.put("projectile", this.getProjectile());
        buildingConfig.put("air_targets", this.getAirTargets());
        buildingConfig.put("ground_targets", this.getGroundTargets());
        buildingConfig.put("damage_radius", this.getDamageRadius());
        buildingConfig.put("push_back", this.getPushBack());
        buildingConfig.put("max_stored_gold", this.getMaxStoredGold());
        buildingConfig.put("max_stored_mithril", this.getMaxStoredMithril());
        buildingConfig.put("max_stored_dark_mithril", this.getMaxStoredDarkMithril());
        buildingConfig.put("produces_resource", this.getProducesResource());
        buildingConfig.put("resource_per_hour", this.getResourcePerHour());
        buildingConfig.put("resource_max", this.getResourceMax());       
        return buildingConfig; //To change body of generated methods, choose Tools | Templates.
    }

}

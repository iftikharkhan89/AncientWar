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
public class TroopsConfiguration extends BasicDBObject {
 private String troopId;
 private String name;
 private String tid;
 private String infoTid;
 private int level;
 private long damageRadius;
 private String swf;
 private String iconSWF;
 private long upgradeTimeH;
 private long movementOffsetSpeed;
 private long upgradeCost;
 private long barrackLevel;
 private long attackSpeed;
 private long isFlying;
 private String dieEffect;
 private String animation;
 private long unitType;
 private long hitPoints;
 private String tombStone;
 private long airTargets;
 private String preferedTargetBuildingClass;
 private long housingSpace;
 private String attackEffect;
 private long preferedTargetDamageMod;
 private long groundTargets;
 private String projectile;
 private long attackCount;
 private String upgradeResource;
 private String preferedTargetBuilding;
 private long movementOffsetAmount;
 private String trainingResource;
 private String exportName;
 private String iconExportName;
 private long isJumper;
 private long attackRange;
 private long speed;
 private long trainingTime;
 private String bigPicture;
 private long damage;
 private String hitEffect;
 private long laboratoryLevel;
 private long trainingCost;
 private String isCreated;
 private List<UserTroops> userTroops;

    public TroopsConfiguration(String troopId, String name) {
        this.troopId = troopId;
        this.name = name;
    }

    public TroopsConfiguration(Map m) {
        super(m);
    }

    public TroopsConfiguration() {
    }

    public String getTroopId() {
        return troopId;
    }

    public void setTroopId(String troopId) {
        this.troopId = troopId;
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

    public long getDamageRadius() {
        return damageRadius;
    }

    public void setDamageRadius(long damageRadius) {
        this.damageRadius = damageRadius;
    }

    public String getSwf() {
        return swf;
    }

    public void setSwf(String swf) {
        this.swf = swf;
    }

    public String getIconSWF() {
        return iconSWF;
    }

    public void setIconSWF(String iconSWF) {
        this.iconSWF = iconSWF;
    }

    public long getUpgradeTimeH() {
        return upgradeTimeH;
    }

    public void setUpgradeTimeH(long upgradeTimeH) {
        this.upgradeTimeH = upgradeTimeH;
    }

    public long getMovementOffsetSpeed() {
        return movementOffsetSpeed;
    }

    public void setMovementOffsetSpeed(long movementOffsetSpeed) {
        this.movementOffsetSpeed = movementOffsetSpeed;
    }

    public long getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(long upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public long getBarrackLevel() {
        return barrackLevel;
    }

    public void setBarrackLevel(long barrackLevel) {
        this.barrackLevel = barrackLevel;
    }

    public long getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(long attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public long getIsFlying() {
        return isFlying;
    }

    public void setIsFlying(long isFlying) {
        this.isFlying = isFlying;
    }

    public String getDieEffect() {
        return dieEffect;
    }

    public void setDieEffect(String dieEffect) {
        this.dieEffect = dieEffect;
    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public long getUnitType() {
        return unitType;
    }

    public void setUnitType(long unitType) {
        this.unitType = unitType;
    }

    public long getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(long hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getTombStone() {
        return tombStone;
    }

    public void setTombStone(String tombStone) {
        this.tombStone = tombStone;
    }

    public long getAirTargets() {
        return airTargets;
    }

    public void setAirTargets(long airTargets) {
        this.airTargets = airTargets;
    }

    public String getPreferedTargetBuildingClass() {
        return preferedTargetBuildingClass;
    }

    public void setPreferedTargetBuildingClass(String preferedTargetBuildingClass) {
        this.preferedTargetBuildingClass = preferedTargetBuildingClass;
    }

    public long getHousingSpace() {
        return housingSpace;
    }

    public void setHousingSpace(long housingSpace) {
        this.housingSpace = housingSpace;
    }

    public String getAttackEffect() {
        return attackEffect;
    }

    public void setAttackEffect(String attackEffect) {
        this.attackEffect = attackEffect;
    }

    public long getPreferedTargetDamageMod() {
        return preferedTargetDamageMod;
    }

    public void setPreferedTargetDamageMod(long preferedTargetDamageMod) {
        this.preferedTargetDamageMod = preferedTargetDamageMod;
    }

    public long getGroundTargets() {
        return groundTargets;
    }

    public void setGroundTargets(long groundTargets) {
        this.groundTargets = groundTargets;
    }

    public String getProjectile() {
        return projectile;
    }

    public void setProjectile(String projectile) {
        this.projectile = projectile;
    }

    public long getAttackCount() {
        return attackCount;
    }

    public void setAttackCount(long attackCount) {
        this.attackCount = attackCount;
    }

    public String getUpgradeResource() {
        return upgradeResource;
    }

    public void setUpgradeResource(String upgradeResource) {
        this.upgradeResource = upgradeResource;
    }

    public String getPreferedTargetBuilding() {
        return preferedTargetBuilding;
    }

    public void setPreferedTargetBuilding(String preferedTargetBuilding) {
        this.preferedTargetBuilding = preferedTargetBuilding;
    }

    public long getMovementOffsetAmount() {
        return movementOffsetAmount;
    }

    public void setMovementOffsetAmount(long movementOffsetAmount) {
        this.movementOffsetAmount = movementOffsetAmount;
    }

    public String getTrainingResource() {
        return trainingResource;
    }

    public void setTrainingResource(String trainingResource) {
        this.trainingResource = trainingResource;
    }

    public String getExportName() {
        return exportName;
    }

    public void setExportName(String exportName) {
        this.exportName = exportName;
    }

    public String getIconExportName() {
        return iconExportName;
    }

    public void setIconExportName(String iconExportName) {
        this.iconExportName = iconExportName;
    }

    public long getIsJumper() {
        return isJumper;
    }

    public void setIsJumper(long isJumper) {
        this.isJumper = isJumper;
    }

    public long getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(long attackRange) {
        this.attackRange = attackRange;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public long getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(long trainingTime) {
        this.trainingTime = trainingTime;
    }

    public String getBigPicture() {
        return bigPicture;
    }

    public void setBigPicture(String bigPicture) {
        this.bigPicture = bigPicture;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long damage) {
        this.damage = damage;
    }

    public String getHitEffect() {
        return hitEffect;
    }

    public void setHitEffect(String hitEffect) {
        this.hitEffect = hitEffect;
    }

    public long getLaboratoryLevel() {
        return laboratoryLevel;
    }

    public void setLaboratoryLevel(long laboratoryLevel) {
        this.laboratoryLevel = laboratoryLevel;
    }

    public long getTrainingCost() {
        return trainingCost;
    }

    public void setTrainingCost(long trainingCost) {
        this.trainingCost = trainingCost;
    }

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    public List<UserTroops> getUserTroops() {
        return userTroops;
    }

    public void setUserTroops(List<UserTroops> userTroops) {
        this.userTroops = userTroops;
    }

    @Override
    public Map toMap() {
        Map<String,Object> troopsConfig = new HashMap<>();
        troopsConfig.put("troop_id", this.getTroopId());
        troopsConfig.put("name", this.getName());
        troopsConfig.put("tid", this.getTid());
        troopsConfig.put("info_tid", this.getInfoTid());
        troopsConfig.put("level", this.getLevel());
        troopsConfig.put("damage_radius", this.getDamageRadius());
        troopsConfig.put("swf", this.getSwf());
        troopsConfig.put("icon_swf", this.getIconSWF());
        troopsConfig.put("upgrade_timeH", this.getUpgradeTimeH());
        troopsConfig.put("movementOffsetSpeed", this.getMovementOffsetSpeed());
        troopsConfig.put("upgrade_cost", this.getUpgradeCost());
        troopsConfig.put("barrack_level", this.getBarrackLevel());
        troopsConfig.put("attack_speed", this.getAttackSpeed());
        troopsConfig.put("is_flying", this.getIsFlying());
        troopsConfig.put("die_effect", this.getDieEffect());
        troopsConfig.put("animation", this.getAnimation());
        troopsConfig.put("unit_type", this.getUnitType());
        troopsConfig.put("hit_points", this.getHitPoints());
        troopsConfig.put("tomb_stone", this.getTombStone());
        troopsConfig.put("air_targets", this.getAirTargets());
        troopsConfig.put("preferedTargetBuildingClass", this.getPreferedTargetBuildingClass());
        troopsConfig.put("housing_space", this.getHousingSpace());
        troopsConfig.put("attack_effect", this.getAttackEffect());
        troopsConfig.put("preferedTargetDamageMod", this.getPreferedTargetDamageMod());
        troopsConfig.put("ground_targets", this.getGroundTargets());
        troopsConfig.put("projectile", this.getProjectile());
        troopsConfig.put("attack_count", this.getAttackCount());
        troopsConfig.put("upgrade_resource", this.getUpgradeResource());
        troopsConfig.put("preferedTargetBuilding", this.getPreferedTargetBuilding());
        troopsConfig.put("movementOffsetAmount", this.getMovementOffsetAmount());
        troopsConfig.put("training_resource", this.getTrainingResource());
        troopsConfig.put("export_name", this.getExportName());
        troopsConfig.put("icon_export_name", this.getIconExportName());
        troopsConfig.put("is_jumper", this.getIsJumper());
        troopsConfig.put("attack_range", this.getAttackRange());
        troopsConfig.put("speed", this.getSpeed());
        troopsConfig.put("training_time", this.getTrainingTime());
        troopsConfig.put("big_picture", this.getBigPicture());
        troopsConfig.put("damage", this.getDamage());
        troopsConfig.put("hit_effect", this.getHitEffect());
        troopsConfig.put("laboratory_level", this.getLaboratoryLevel());
        troopsConfig.put("training_cost", this.getTrainingCost());
        troopsConfig.put("is_created", this.getIsCreated());
        if(this.getUserTroops() != null)
            troopsConfig.put("userTroops", this.getUserTroops());
        return troopsConfig; //To change body of generated methods, choose Tools | Templates.
    }
}

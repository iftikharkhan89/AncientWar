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
public class Troops extends BasicDBObject {
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
 private int unitOfType;
 private long hitpoints;
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
 private int isJumper;
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

    public Troops(String troopId, String name) {
        this.troopId = troopId;
        this.name = name;
    }

    public Troops(Map m) {
        super(m);
    }

    public Troops() {
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

    public int getUnitOfType() {
        return unitOfType;
    }

    public void setUnitOfType(int unitOfType) {
        this.unitOfType = unitOfType;
    }

    public long getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(long hitpoints) {
        this.hitpoints = hitpoints;
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

    public int getIsJumper() {
        return isJumper;
    }

    public void setIsJumper(int isJumper) {
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
        Map<String,Object> troops = new HashMap<>();
        troops.put("troop_id", this.getTroopId());
        troops.put("name", this.getName());
        troops.put("tid", this.getTid());
        troops.put("info_tid", this.getInfoTid());
        troops.put("level", this.getLevel());
        troops.put("damageRadius", this.getDamageRadius());
        troops.put("swf", this.getSwf());
        troops.put("iconSWF", this.getIconSWF());
        troops.put("upgradeTimeH", this.getUpgradeTimeH());
        troops.put("movementOffsetSpeed", this.getMovementOffsetSpeed());
        troops.put("upgradeCost", this.getUpgradeCost());
        troops.put("barrackLevel", this.getBarrackLevel());
        troops.put("attackSpeed", this.getAttackSpeed());
        troops.put("isFlying", this.getIsFlying());
        troops.put("dieEffect", this.getDieEffect());
        troops.put("animation", this.getAnimation());
        troops.put("unitOfType", this.getUnitOfType());
        troops.put("hitpoints", this.getHitpoints());
        troops.put("tombStone", this.getTombStone());
        troops.put("airTargets", this.getAirTargets());
        troops.put("preferedTargetBuildingClass", this.getPreferedTargetBuildingClass());
        troops.put("housingSpace", this.getHousingSpace());
        troops.put("attackEffect", this.getAttackEffect());
        troops.put("preferedTargetDamageMod", this.getPreferedTargetDamageMod());
        troops.put("groundTargets", this.getGroundTargets());
        troops.put("projectile", this.getProjectile());
        troops.put("attackCount", this.getAttackCount());
        troops.put("upgradeResource", this.getUpgradeResource());
        troops.put("preferedTargetBuilding", this.getPreferedTargetBuilding());
        troops.put("movementOffsetAmount", this.getMovementOffsetAmount());
        troops.put("trainingResource", this.getTrainingResource());
        troops.put("exportName", this.getExportName());
        troops.put("iconExportName", this.getIconExportName());
        troops.put("isJumper", this.isJumper);
        troops.put("attackRange", this.getAttackRange());
        troops.put("speed", this.getSpeed());
        troops.put("trainingTime", this.trainingTime);
        troops.put("bigPicture", this.getBigPicture());
        troops.put("damage", this.getDamage());
        troops.put("hitEffect", this.getHitEffect());
        troops.put("laboratoryLevel", this.getLaboratoryLevel());
        troops.put("trainingCost", this.trainingCost);
        troops.put("is_created", this.getIsCreated());
        return troops; //To change body of generated methods, choose Tools | Templates.
    }

   

}

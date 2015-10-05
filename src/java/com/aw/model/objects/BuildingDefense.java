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
public class BuildingDefense extends BasicDBObject {
 private long buildingDefenseId;
 private long buildingId;
 private int attackRange;
 private int attackSpeed;
 private int damage;
 private String attackEffect;
 private String hitEffect;
 private String projectile;
 private int airTargets;
 private int groundTargets;
 private int minAttackRange;
 private int damageRadius;
 private int pushBack;
 private String defenderCharacter;
 private int defenderCount;
 private int defenderZ;

    public BuildingDefense(long buildingDefenseId, long buildingId) {
        this.buildingDefenseId = buildingDefenseId;
        this.buildingId = buildingId;
    }

    public BuildingDefense(Map m) {
        super(m);
    }

    public BuildingDefense() {
    }

    public long getBuildingDefenseId() {
        return buildingDefenseId;
    }

    public void setBuildingDefenseId(long buildingDefenseId) {
        this.buildingDefenseId = buildingDefenseId;
    }

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
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

    public int getMinAttackRange() {
        return minAttackRange;
    }

    public void setMinAttackRange(int minAttackRange) {
        this.minAttackRange = minAttackRange;
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

    @Override
    public Map toMap() {
        Map<String,Object> buildingDefense = new HashMap<>();
        buildingDefense.put("building_defense_id", this.getBuildingDefenseId());
        buildingDefense.put("building_id", this.getBuildingId());
        buildingDefense.put("attack_range", this.getAttackRange());
        buildingDefense.put("attack_speed", this.getAttackSpeed());
        buildingDefense.put("damage", this.getDamage());
        buildingDefense.put("attack_effect", this.getAttackEffect());
        buildingDefense.put("hit_effect", this.getHitEffect());
        buildingDefense.put("projectile", this.getProjectile());
        buildingDefense.put("air_targets", this.getAirTargets());
        buildingDefense.put("ground_targets", this.getGroundTargets());
        buildingDefense.put("min_attack_range", this.getMinAttackRange());
        buildingDefense.put("damage_radius", this.getDamageRadius());
        buildingDefense.put("push_back", this.getPushBack());
        buildingDefense.put("defender_character", this.getDefenderCharacter());
        buildingDefense.put("defender_count", this.getDefenderCount());
        buildingDefense.put("defender_z", this.getDefenderZ());
        
        return buildingDefense; //To change body of generated methods, choose Tools | Templates.
    }

 
}

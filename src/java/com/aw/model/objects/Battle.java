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
public class Battle extends BasicDBObject {
 private long battledId;
 private long attackerId;
 private long defenderId;
 private int attackerWon;
 private long goldLoot;
 private long mithrilLoot;
 private long darkMithril_loot;
 private long goldAvailable;
 private long mithrilAvailable;
 private long darkMithrilAvailable;
 private int attackerTrophies;
 private int defenderTrophies;
 private int totalDamage;
 private boolean townhallDestroyed;
 private long clanId;
 private long iscreated;
 private List<BattleBuilding> battleBuildings;
 private List<BattleTroops> battleTroops;

    public Battle() {
    }

    public Battle(long battledId, long attackerId, long defenderId, int attackerWon, long goldLoot, long mithrilLoot, long darkMithril_loot, long goldAvailable, long mithrilAvailable, long darkMithrilAvailable, int attackerTrophies, int defenderTrophies, int totalDamage, boolean townhallDestroyed, long clanId, long iscreated) {
        this.battledId = battledId;
        this.attackerId = attackerId;
        this.defenderId = defenderId;
        this.attackerWon = attackerWon;
        this.goldLoot = goldLoot;
        this.mithrilLoot = mithrilLoot;
        this.darkMithril_loot = darkMithril_loot;
        this.goldAvailable = goldAvailable;
        this.mithrilAvailable = mithrilAvailable;
        this.darkMithrilAvailable = darkMithrilAvailable;
        this.attackerTrophies = attackerTrophies;
        this.defenderTrophies = defenderTrophies;
        this.totalDamage = totalDamage;
        this.townhallDestroyed = townhallDestroyed;
        this.clanId = clanId;
        this.iscreated = iscreated;
    }

    public Battle(Map m) {
        super(m);
    }

    public Battle(long battledId, long attackerId, long defenderId) {
        this.battledId = battledId;
        this.attackerId = attackerId;
        this.defenderId = defenderId;
    }

    public long getBattledId() {
        return battledId;
    }

    public void setBattledId(long battledId) {
        this.battledId = battledId;
    }

    public long getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(long attackerId) {
        this.attackerId = attackerId;
    }

    public long getDefenderId() {
        return defenderId;
    }

    public void setDefenderId(long defenderId) {
        this.defenderId = defenderId;
    }

    public int getAttackerWon() {
        return attackerWon;
    }

    public void setAttackerWon(int attackerWon) {
        this.attackerWon = attackerWon;
    }

    public long getGoldLoot() {
        return goldLoot;
    }

    public void setGoldLoot(long goldLoot) {
        this.goldLoot = goldLoot;
    }

    public long getMithrilLoot() {
        return mithrilLoot;
    }

    public void setMithrilLoot(long mithrilLoot) {
        this.mithrilLoot = mithrilLoot;
    }

    public long getDarkMithril_loot() {
        return darkMithril_loot;
    }

    public void setDarkMithril_loot(long darkMithril_loot) {
        this.darkMithril_loot = darkMithril_loot;
    }

    public long getGoldAvailable() {
        return goldAvailable;
    }

    public void setGoldAvailable(long goldAvailable) {
        this.goldAvailable = goldAvailable;
    }

    public long getMithrilAvailable() {
        return mithrilAvailable;
    }

    public void setMithrilAvailable(long mithrilAvailable) {
        this.mithrilAvailable = mithrilAvailable;
    }

    public long getDarkMithrilAvailable() {
        return darkMithrilAvailable;
    }

    public void setDarkMithrilAvailable(long darkMithrilAvailable) {
        this.darkMithrilAvailable = darkMithrilAvailable;
    }

    public int getAttackerTrophies() {
        return attackerTrophies;
    }

    public void setAttackerTrophies(int attackerTrophies) {
        this.attackerTrophies = attackerTrophies;
    }

    public int getDefenderTrophies() {
        return defenderTrophies;
    }

    public void setDefenderTrophies(int defenderTrophies) {
        this.defenderTrophies = defenderTrophies;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = totalDamage;
    }

    public boolean isTownhallDestroyed() {
        return townhallDestroyed;
    }

    public void setTownhallDestroyed(boolean townhallDestroyed) {
        this.townhallDestroyed = townhallDestroyed;
    }

    public long getClanId() {
        return clanId;
    }

    public void setClanId(long clanId) {
        this.clanId = clanId;
    }

    public long getIscreated() {
        return iscreated;
    }

    public void setIscreated(long iscreated) {
        this.iscreated = iscreated;
    }

    public List<BattleBuilding> getBattleBuildings() {
        return battleBuildings;
    }

    public void setBattleBuildings(List<BattleBuilding> battleBuildings) {
        this.battleBuildings = battleBuildings;
    }

    public List<BattleTroops> getBattleTroops() {
        return battleTroops;
    }

    public void setBattleTroops(List<BattleTroops> battleTroops) {
        this.battleTroops = battleTroops;
    }

    @Override
    public Map toMap() {
        Map<String,Object> battle = new HashMap<>();
        battle.put("battled_id", this.getBattledId());
        battle.put("attacker_id", this.getAttackerId());
        battle.put("defender_id", this.getDefenderId());
        battle.put("attacker_won", this.getAttackerWon());
        battle.put("gold_loot", this.getGoldLoot());
        battle.put("mithril_loot", this.getMithrilLoot());
        battle.put("dark_mithril_loot", this.getDarkMithril_loot());
        battle.put("gold_available", this.getGoldAvailable());
        battle.put("mithril_available", this.getMithrilAvailable());
        battle.put("darkMithril_available", this.getDarkMithrilAvailable());
        battle.put("attacker_trophies", this.getAttackerTrophies());
        battle.put("defender_trophies", this.getDefenderTrophies());
        battle.put("total_damage", this.getTotalDamage());
        battle.put("townhall_destroyed", this.isTownhallDestroyed());
        battle.put("clan_id", this.getClanId());
        battle.put("is_created", this.getIscreated());
        if(this.getBattleBuildings() != null)
        battle.put("battleBuildings", this.getBattleBuildings());
        battle.put("battleTroops", this.getBattleTroops());       
        return battle; 
    }

   
}

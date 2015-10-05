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
public class TownhallLevels extends BasicDBObject {

    private long townhallLevelId;
    private long level;
    private long attackCost;
    private long buildingHousing;
    private long buildingMithrilStorage;
    private long buildingGoldStorage;
    private long buildingMithrilCollector;
    private long buildingGoldCollector;
    private long buildingBarrack;
    private long buildingHokuCannon;
    private long buildingWall;
    private long buildingArcherTower;
    private long buildingWizardTower;
    private long buildingMagicalSpikeEye;
    private long buildingTitanGuardian;
    private long buildingAirKillerDefense;
    private long buildingGroundBomber;
    private long buildingGuildHall;
    private long buildingJumpingJackTrap;
    private long buildingSuperBomb;
    private long buildingBomb;
    private long buildingWorkerHut;
    private long buildingTavern;
    private long buildingHeroAltar;
    private long buildingTeslaTower;
    private long buildingspellForge;
    private long buildingBow;
    private long buildingHalloweenBomb;
    private long buildingsLowBomb;
    private long heroAltarBarbarianKing;
    private long buildingDarkMithrilCollector;
    private long buildingDarkMithrilStorage;
    private long heroAltarArcherQueen;
    private long buildingAirtrap;
    private long buildingMegaAirTrap;
    private long darkMithrilBarrack;

    public TownhallLevels(long townhallLevelId) {
        this.townhallLevelId = townhallLevelId;
    }

    public TownhallLevels(Map m) {
        super(m);
    }

    public TownhallLevels() {
    }

    public long getTownhallLevelId() {
        return townhallLevelId;
    }

    public void setTownhallLevelId(long townhallLevelId) {
        this.townhallLevelId = townhallLevelId;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getAttackCost() {
        return attackCost;
    }

    public void setAttackCost(long attackCost) {
        this.attackCost = attackCost;
    }

    public long getBuildingHousing() {
        return buildingHousing;
    }

    public void setBuildingHousing(long buildingHousing) {
        this.buildingHousing = buildingHousing;
    }

    public long getBuildingMithrilStorage() {
        return buildingMithrilStorage;
    }

    public void setBuildingMithrilStorage(long buildingMithrilStorage) {
        this.buildingMithrilStorage = buildingMithrilStorage;
    }

    public long getBuildingGoldStorage() {
        return buildingGoldStorage;
    }

    public void setBuildingGoldStorage(long buildingGoldStorage) {
        this.buildingGoldStorage = buildingGoldStorage;
    }

    public long getBuildingMithrilCollector() {
        return buildingMithrilCollector;
    }

    public void setBuildingMithrilCollector(long buildingMithrilCollector) {
        this.buildingMithrilCollector = buildingMithrilCollector;
    }

    public long getBuildingGoldCollector() {
        return buildingGoldCollector;
    }

    public void setBuildingGoldCollector(long buildingGoldCollector) {
        this.buildingGoldCollector = buildingGoldCollector;
    }

    public long getBuildingBarrack() {
        return buildingBarrack;
    }

    public void setBuildingBarrack(long buildingBarrack) {
        this.buildingBarrack = buildingBarrack;
    }

    public long getBuildingHokuCannon() {
        return buildingHokuCannon;
    }

    public void setBuildingHokuCannon(long buildingHokuCannon) {
        this.buildingHokuCannon = buildingHokuCannon;
    }

    public long getBuildingWall() {
        return buildingWall;
    }

    public void setBuildingWall(long buildingWall) {
        this.buildingWall = buildingWall;
    }

    public long getBuildingArcherTower() {
        return buildingArcherTower;
    }

    public void setBuildingArcherTower(long buildingArcherTower) {
        this.buildingArcherTower = buildingArcherTower;
    }

    public long getBuildingWizardTower() {
        return buildingWizardTower;
    }

    public void setBuildingWizardTower(long buildingWizardTower) {
        this.buildingWizardTower = buildingWizardTower;
    }

    public long getBuildingMagicalSpikeEye() {
        return buildingMagicalSpikeEye;
    }

    public void setBuildingMagicalSpikeEye(long buildingMagicalSpikeEye) {
        this.buildingMagicalSpikeEye = buildingMagicalSpikeEye;
    }

    public long getBuildingTitanGuardian() {
        return buildingTitanGuardian;
    }

    public void setBuildingTitanGuardian(long buildingTitanGuardian) {
        this.buildingTitanGuardian = buildingTitanGuardian;
    }

    public long getBuildingAirKillerDefense() {
        return buildingAirKillerDefense;
    }

    public void setBuildingAirKillerDefense(long buildingAirKillerDefense) {
        this.buildingAirKillerDefense = buildingAirKillerDefense;
    }

    public long getBuildingGroundBomber() {
        return buildingGroundBomber;
    }

    public void setBuildingGroundBomber(long buildingGroundBomber) {
        this.buildingGroundBomber = buildingGroundBomber;
    }

    public long getBuildingGuildHall() {
        return buildingGuildHall;
    }

    public void setBuildingGuildHall(long buildingGuildHall) {
        this.buildingGuildHall = buildingGuildHall;
    }

    public long getBuildingJumpingJackTrap() {
        return buildingJumpingJackTrap;
    }

    public void setBuildingJumpingJackTrap(long buildingJumpingJackTrap) {
        this.buildingJumpingJackTrap = buildingJumpingJackTrap;
    }

    public long getBuildingSuperBomb() {
        return buildingSuperBomb;
    }

    public void setBuildingSuperBomb(long buildingSuperBomb) {
        this.buildingSuperBomb = buildingSuperBomb;
    }

    public long getBuildingBomb() {
        return buildingBomb;
    }

    public void setBuildingBomb(long buildingBomb) {
        this.buildingBomb = buildingBomb;
    }

    public long getBuildingWorkerHut() {
        return buildingWorkerHut;
    }

    public void setBuildingWorkerHut(long buildingWorkerHut) {
        this.buildingWorkerHut = buildingWorkerHut;
    }

    public long getBuildingTavern() {
        return buildingTavern;
    }

    public void setBuildingTavern(long buildingTavern) {
        this.buildingTavern = buildingTavern;
    }

    public long getBuildingHeroAltar() {
        return buildingHeroAltar;
    }

    public void setBuildingHeroAltar(long buildingHeroAltar) {
        this.buildingHeroAltar = buildingHeroAltar;
    }

    public long getBuildingTeslaTower() {
        return buildingTeslaTower;
    }

    public void setBuildingTeslaTower(long buildingTeslaTower) {
        this.buildingTeslaTower = buildingTeslaTower;
    }

    public long getBuildingspellForge() {
        return buildingspellForge;
    }

    public void setBuildingspellForge(long buildingspellForge) {
        this.buildingspellForge = buildingspellForge;
    }

    public long getBuildingBow() {
        return buildingBow;
    }

    public void setBuildingBow(long buildingBow) {
        this.buildingBow = buildingBow;
    }

    public long getBuildingHalloweenBomb() {
        return buildingHalloweenBomb;
    }

    public void setBuildingHalloweenBomb(long buildingHalloweenBomb) {
        this.buildingHalloweenBomb = buildingHalloweenBomb;
    }

    public long getBuildingsLowBomb() {
        return buildingsLowBomb;
    }

    public void setBuildingsLowBomb(long buildingsLowBomb) {
        this.buildingsLowBomb = buildingsLowBomb;
    }

    public long getHeroAltarBarbarianKing() {
        return heroAltarBarbarianKing;
    }

    public void setHeroAltarBarbarianKing(long heroAltarBarbarianKing) {
        this.heroAltarBarbarianKing = heroAltarBarbarianKing;
    }

    public long getBuildingDarkMithrilCollector() {
        return buildingDarkMithrilCollector;
    }

    public void setBuildingDarkMithrilCollector(long buildingDarkMithrilCollector) {
        this.buildingDarkMithrilCollector = buildingDarkMithrilCollector;
    }

    public long getBuildingDarkMithrilStorage() {
        return buildingDarkMithrilStorage;
    }

    public void setBuildingDarkMithrilStorage(long buildingDarkMithrilStorage) {
        this.buildingDarkMithrilStorage = buildingDarkMithrilStorage;
    }

    public long getHeroAltarArcherQueen() {
        return heroAltarArcherQueen;
    }

    public void setHeroAltarArcherQueen(long heroAltarArcherQueen) {
        this.heroAltarArcherQueen = heroAltarArcherQueen;
    }

    public long getBuildingAirtrap() {
        return buildingAirtrap;
    }

    public void setBuildingAirtrap(long buildingAirtrap) {
        this.buildingAirtrap = buildingAirtrap;
    }

    public long getBuildingMegaAirTrap() {
        return buildingMegaAirTrap;
    }

    public void setBuildingMegaAirTrap(long buildingMegaAirTrap) {
        this.buildingMegaAirTrap = buildingMegaAirTrap;
    }

    public long getDarkMithrilBarrack() {
        return darkMithrilBarrack;
    }

    public void setDarkMithrilBarrack(long darkMithrilBarrack) {
        this.darkMithrilBarrack = darkMithrilBarrack;
    }

    @Override
    public Map toMap() {
        Map townHallLevels = new HashMap();
        townHallLevels.put("townhall_level_id", this.getTownhallLevelId());
        townHallLevels.put("level", this.getLevel());
        townHallLevels.put("attack_cost", this.getAttackCost());
        townHallLevels.put("building_housing", this.getBuildingHousing());
        townHallLevels.put("building_mithril_storage", this.getBuildingMithrilStorage());
        townHallLevels.put("building_gold_storage", this.getBuildingGoldStorage());
        townHallLevels.put("building_mithril_collector", this.getBuildingMithrilCollector());
        townHallLevels.put("building_gold_collector", this.getBuildingGoldCollector());
        townHallLevels.put("building_barrack", this.getBuildingBarrack());
        townHallLevels.put("building_hoku_cannon", this.getBuildingHokuCannon());
        townHallLevels.put("building_wall", this.getBuildingWall());
        townHallLevels.put("building_archer_tower", this.getBuildingArcherTower());
        townHallLevels.put("building_wizard_tower", this.getBuildingWizardTower());
        townHallLevels.put("building_magical_spike_eye", this.getBuildingMagicalSpikeEye());
        townHallLevels.put("building_titan_guardian", this.getBuildingTitanGuardian());
        townHallLevels.put("building_air_killer_defense", this.getBuildingAirKillerDefense());
        townHallLevels.put("building_ground_bomber", this.getBuildingGroundBomber());
        townHallLevels.put("building_guild_hall", this.getBuildingGuildHall());
        townHallLevels.put("building_jumping_jack_trap", this.getBuildingJumpingJackTrap());
        townHallLevels.put("building_superbomb", this.getBuildingSuperBomb());
        townHallLevels.put("building_bomb", this.getBuildingBomb());
        townHallLevels.put("building_worker_hut", this.getBuildingWorkerHut());
        townHallLevels.put("building_tavern", this.buildingTavern);
        townHallLevels.put("building_hero_altar", this.getBuildingHeroAltar());
        townHallLevels.put("building_tesla_tower", this.getBuildingTeslaTower());
        townHallLevels.put("buildingspell_forge", this.getBuildingspellForge());
        townHallLevels.put("building_bow", this.getBuildingBow());
        townHallLevels.put("building_halloween_bomb", this.getBuildingHalloweenBomb());
        townHallLevels.put("buildingslowbomb", this.getBuildingsLowBomb());
        townHallLevels.put("hero_altar_barbarian_king", this.getHeroAltarBarbarianKing());
        townHallLevels.put("building_dark_mithril_collector", this.getBuildingDarkMithrilCollector());
        townHallLevels.put("building_dark_mithril_storage", this.getBuildingDarkMithrilStorage());
        townHallLevels.put("hero_altar_archer_queen", this.getHeroAltarArcherQueen());
        townHallLevels.put("building_airtrap", this.getBuildingAirtrap());
        townHallLevels.put("building_megaairtrap", this.getBuildingMegaAirTrap());
        townHallLevels.put("dark_mithril_barrack", this.getDarkMithrilBarrack());
        return townHallLevels;
    }

}

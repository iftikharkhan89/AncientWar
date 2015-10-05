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
public class User extends BasicDBObject {
 
private String uid;
 private String name;
 private long gold;
 private long spens;
 private long mithril;
 private long dark_mithril;
 private String race;
 private long experience;
private String selected_market_id;
 private long game_level;
 private long offer_gold;
 private long offer_spens;
 private long offer_mithril;
 private long last_visited;
 private long purchased_gold;
 private long deducted_gold;
 private long deducted_spens;
 private long deducted_mithril;
 private long deducted_dark_mithril;
 private String db_version;
 private long inventory_limit;
 private String user_email;
 private long has_completed_tutorial;
 private long current_tutorial_step;
 private String trophies;
 
 private List<BuildingBase> buildingBases;
 private List<ClanUsers> clanUsers;
 private List<UserDevices> userDevices;
 private List<UserShields> userShields;
 private List<UserToken> userTokens;
         
    public User(String key, Object value) {
        super(key, value);
    }

    public User() {
    }

    public User(Map m) {
        super(m);
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

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public long getSpens() {
        return spens;
    }

    public void setSpens(long spens) {
        this.spens = spens;
    }

    public long getMithril() {
        return mithril;
    }

    public void setMithril(long mithril) {
        this.mithril = mithril;
    }

    public long getDark_mithril() {
        return dark_mithril;
    }

    public void setDark_mithril(long dark_mithril) {
        this.dark_mithril = dark_mithril;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public String getSelected_market_id() {
        return selected_market_id;
    }

    public void setSelected_market_id(String selected_market_id) {
        this.selected_market_id = selected_market_id;
    }

    public long getGame_level() {
        return game_level;
    }

    public void setGame_level(long game_level) {
        this.game_level = game_level;
    }

    public long getOffer_gold() {
        return offer_gold;
    }

    public void setOffer_gold(long offer_gold) {
        this.offer_gold = offer_gold;
    }

    public long getOffer_spens() {
        return offer_spens;
    }

    public void setOffer_spens(long offer_spens) {
        this.offer_spens = offer_spens;
    }

    public long getOffer_mithril() {
        return offer_mithril;
    }

    public void setOffer_mithril(long offer_mithril) {
        this.offer_mithril = offer_mithril;
    }

    public long getLast_visited() {
        return last_visited;
    }

    public void setLast_visited(long last_visited) {
        this.last_visited = last_visited;
    }

    public long getPurchased_gold() {
        return purchased_gold;
    }

    public void setPurchased_gold(long purchased_gold) {
        this.purchased_gold = purchased_gold;
    }

    public long getDeducted_gold() {
        return deducted_gold;
    }

    public void setDeducted_gold(long deducted_gold) {
        this.deducted_gold = deducted_gold;
    }

    public long getDeducted_spens() {
        return deducted_spens;
    }

    public void setDeducted_spens(long deducted_spens) {
        this.deducted_spens = deducted_spens;
    }

    public long getDeducted_mithril() {
        return deducted_mithril;
    }

    public void setDeducted_mithril(long deducted_mithril) {
        this.deducted_mithril = deducted_mithril;
    }

    public long getDeducted_dark_mithril() {
        return deducted_dark_mithril;
    }

    public void setDeducted_dark_mithril(long deducted_dark_mithril) {
        this.deducted_dark_mithril = deducted_dark_mithril;
    }

    public String getDb_version() {
        return db_version;
    }

    public void setDb_version(String db_version) {
        this.db_version = db_version;
    }

    public long getInventory_limit() {
        return inventory_limit;
    }

    public void setInventory_limit(long inventory_limit) {
        this.inventory_limit = inventory_limit;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public long getHas_completed_tutorial() {
        return has_completed_tutorial;
    }

    public void setHas_completed_tutorial(long has_completed_tutorial) {
        this.has_completed_tutorial = has_completed_tutorial;
    }

    public long getCurrent_tutorial_step() {
        return current_tutorial_step;
    }

    public void setCurrent_tutorial_step(long current_tutorial_step) {
        this.current_tutorial_step = current_tutorial_step;
    }

    public String getTrophies() {
        return trophies;
    }

    public void setTrophies(String trophies) {
        this.trophies = trophies;
    }

    public List<BuildingBase> getBuildingBases() {
        return buildingBases;
    }

    public void setBuildingBases(List<BuildingBase> buildingBases) {
        this.buildingBases = buildingBases;
    }

    public List<ClanUsers> getClanUsers() {
        return clanUsers;
    }

    public void setClanUsers(List<ClanUsers> clanUsers) {
        this.clanUsers = clanUsers;
    }

    public List<UserDevices> getUserDevices() {
        return userDevices;
    }

    public void setUserDevices(List<UserDevices> userDevices) {
        this.userDevices = userDevices;
    }

    public List<UserShields> getUserShields() {
        return userShields;
    }

    public void setUserShields(List<UserShields> userShields) {
        this.userShields = userShields;
    }

    public List<UserToken> getUserTokens() {
        return userTokens;
    }

    public void setUserTokens(List<UserToken> userTokens) {
        this.userTokens = userTokens;
    }

    @Override
    public Map toMap() {
        Map<String,Object> user = new HashMap<>();
        user.put("uid", this.getUid());
        user.put("name", this.getName());
        user.put("spens", this.getSpens());
        user.put("gold", this.getGold());
        user.put("mithril", this.getMithril());
        user.put("dark_mithril", this.getDark_mithril());
        user.put("race", this.getRace());
        user.put("experience", this.getExperience());
        user.put("selected_market_id", this.getSelected_market_id());
        user.put("game_level", this.getGame_level());
        user.put("offer_gold", this.getOffer_gold());
        user.put("offer_spens", this.getOffer_spens());
        user.put("offer_mithril", this.getOffer_mithril());
        user.put("last_visited", this.getLast_visited());
        user.put("purchased_gold", this.getPurchased_gold());
        user.put("deducted_gold", this.getDeducted_gold());
        user.put("deducted_spens", this.getDeducted_spens());
        user.put("deducted_mithril", this.getDeducted_mithril());
        user.put("deducted_dark_mithril", this.getDeducted_dark_mithril());
        user.put("db_version", this.getDb_version());
        user.put("inventory_limit", this.getInventory_limit());
        user.put("user_email", this.getUser_email());
        user.put("has_completed_tutorial", this.getHas_completed_tutorial());
        user.put("current_tutorial_step", this.getCurrent_tutorial_step());
        user.put("trophies", this.getTrophies());
        
        if(this.getBuildingBases() != null)
            user.put("buildingBase", this.getBuildingBases());
        if(this.getClanUsers() != null)
            user.put("clanUsers", this.getClanUsers());
        if(this.getUserDevices() != null)
            user.put("userDevices", this.getUserDevices());
        if(this.getUserShields() != null) 
            user.put("userShields", this.getUserShields());
        if(this.getUserTokens() != null)
            user.put("userTokens", this.getUserTokens());
        
        return user; //To change body of generated methods, choose Tools | Templates.
    }
    
}

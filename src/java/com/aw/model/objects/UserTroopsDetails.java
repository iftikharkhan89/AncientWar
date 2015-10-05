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
public class UserTroopsDetails extends BasicDBObject {
 private String userTroopsDetails;
 private String userId;
 private long soldierLevel;
 private long elfArcherLevel;
 private long gnomeThiefLevel;
 private long titanLevel;
 private long explosiveSpiritLevel;
 private long balloonBomberLevel;
 private long wizardLevel;
 private long sacredElfLevel;
 private long behemothLevel;
 private long titanKnightLevel;
 private long cyclopsLevel;
 private User user;
 
    public UserTroopsDetails() {
        super();
    }

    public UserTroopsDetails(String key, Object value) {
        super(key, value);
    }

    public UserTroopsDetails(Map m) {
        super(m);
    }

    public String getUserTroopsDetails() {
        return userTroopsDetails;
    }

    public void setUserTroopsDetails(String userTroopsDetails) {
        this.userTroopsDetails = userTroopsDetails;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getSoldierLevel() {
        return soldierLevel;
    }

    public void setSoldierLevel(long soldierLevel) {
        this.soldierLevel = soldierLevel;
    }

    public long getElfArcherLevel() {
        return elfArcherLevel;
    }

    public void setElfArcherLevel(long elfArcherLevel) {
        this.elfArcherLevel = elfArcherLevel;
    }

    public long getGnomeThiefLevel() {
        return gnomeThiefLevel;
    }

    public void setGnomeThiefLevel(long gnomeThiefLevel) {
        this.gnomeThiefLevel = gnomeThiefLevel;
    }

    public long getTitanLevel() {
        return titanLevel;
    }

    public void setTitanLevel(long titanLevel) {
        this.titanLevel = titanLevel;
    }

    public long getExplosiveSpiritLevel() {
        return explosiveSpiritLevel;
    }

    public void setExplosiveSpiritLevel(long explosiveSpiritLevel) {
        this.explosiveSpiritLevel = explosiveSpiritLevel;
    }

    public long getBalloonBomberLevel() {
        return balloonBomberLevel;
    }

    public void setBalloonBomberLevel(long balloonBomberLevel) {
        this.balloonBomberLevel = balloonBomberLevel;
    }

    public long getWizardLevel() {
        return wizardLevel;
    }

    public void setWizardLevel(long wizardLevel) {
        this.wizardLevel = wizardLevel;
    }

    public long getSacredElfLevel() {
        return sacredElfLevel;
    }

    public void setSacredElfLevel(long sacredElfLevel) {
        this.sacredElfLevel = sacredElfLevel;
    }

    public long getBehemothLevel() {
        return behemothLevel;
    }

    public void setBehemothLevel(long behemothLevel) {
        this.behemothLevel = behemothLevel;
    }

    public long getTitanKnightLevel() {
        return titanKnightLevel;
    }

    public void setTitanKnightLevel(long titanKnightLevel) {
        this.titanKnightLevel = titanKnightLevel;
    }

    public long getCyclopsLevel() {
        return cyclopsLevel;
    }

    public void setCyclopsLevel(long cyclopsLevel) {
        this.cyclopsLevel = cyclopsLevel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Map toMap() {
        Map<String,Object> userTroopDetails = new HashMap<>();
        userTroopDetails.put("user_troops_details", this.getUserTroopsDetails());
        userTroopDetails.put("uid", this.getUserId());
        userTroopDetails.put("soldier_level", this.getSoldierLevel());
        userTroopDetails.put("elf_archer_level", this.getElfArcherLevel());
        userTroopDetails.put("gnome_thief_level", this.gnomeThiefLevel);
        userTroopDetails.put("titan_level", this.titanLevel);
        userTroopDetails.put("explosive_spirit_level", this.explosiveSpiritLevel);
        userTroopDetails.put("balloon_bomber_level", this.balloonBomberLevel);
        userTroopDetails.put("wizard_level", this.wizardLevel);
        userTroopDetails.put("sacred_elf_level", this.sacredElfLevel);
        userTroopDetails.put("behemoth_level", this.behemothLevel);
        userTroopDetails.put("titan_knight_level", this.titanKnightLevel);
        userTroopDetails.put("cyclops_level", this.cyclopsLevel);
        if(this.getUser() != null)
            userTroopDetails.put("user", this.getUser().toMap());
        return userTroopDetails; 
    }

   

}

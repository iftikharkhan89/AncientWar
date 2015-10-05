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
public class UserShields extends BasicDBObject {
 private long sheildId;
 private String userId;
 private String activateTime;
 private String name;
 private String tid;
 private String infoTid;
 private long timeH;
 private long spens;
 private String iconSWF;
 private String iconExportName;
 private long cooldowns;
 private long lockedAboveScore;
 private User user;

    public UserShields(long sheildId, String userId) {
        this.sheildId = sheildId;
        this.userId = userId;
    }

    public UserShields() {
    }

    public UserShields(Map m) {
        super(m);
    }

    public long getSheildId() {
        return sheildId;
    }

    public void setSheildId(long sheildId) {
        this.sheildId = sheildId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(String activateTime) {
        this.activateTime = activateTime;
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

    public long getTimeH() {
        return timeH;
    }

    public void setTimeH(long timeH) {
        this.timeH = timeH;
    }

    public long getSpens() {
        return spens;
    }

    public void setSpens(long spens) {
        this.spens = spens;
    }

    public String getIconSWF() {
        return iconSWF;
    }

    public void setIconSWF(String iconSWF) {
        this.iconSWF = iconSWF;
    }

    public String getIconExportName() {
        return iconExportName;
    }

    public void setIconExportName(String iconExportName) {
        this.iconExportName = iconExportName;
    }

    public long getCooldowns() {
        return cooldowns;
    }

    public void setCooldowns(long cooldowns) {
        this.cooldowns = cooldowns;
    }

    public long getLockedAboveScore() {
        return lockedAboveScore;
    }

    public void setLockedAboveScore(long lockedAboveScore) {
        this.lockedAboveScore = lockedAboveScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Map toMap() {
        Map<String,Object> userShields = new HashMap<>();
        userShields.put("sheild_id", this.getSheildId());
        userShields.put("uid", this.getUserId());
        userShields.put("activate_time", this.getActivateTime());
        userShields.put("name", this.getName());
        userShields.put("tid", this.getTid());
        userShields.put("infotid", this.getInfoTid());
        userShields.put("timeh", this.getTimeH());
        userShields.put("spens", this.getSpens());
        userShields.put("iconswf", this.getIconSWF());
        userShields.put("iconexportname", this.getIconExportName());
        userShields.put("cooldowns", this.getCooldowns());
        userShields.put("lockedabovescore", this.getLockedAboveScore());
        if(this.getUser() != null)
            userShields.put("user", this.getUser().toMap());
       
        return userShields; //To change body of generated methods, choose Tools | Templates.
    }

    

}

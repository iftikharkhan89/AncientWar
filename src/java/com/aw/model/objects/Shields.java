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

public class Shields extends BasicDBObject  {
 private long shieldId;
 private String name;
 private String tid;
 private String infoTid;
 private int timeH;
 private int spens;
 private String iconSWF;
 private String iconExportName;
 private int cooldowns;
 private long lockedAboveScore;

    public Shields(long shieldId, String name) {
        this.shieldId = shieldId;
        this.name = name;
    }

    public Shields() {
    }

    public Shields(Map m) {
        super(m);
    }

    public long getShieldId() {
        return shieldId;
    }

    public void setShieldId(long shieldId) {
        this.shieldId = shieldId;
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

    public int getTimeH() {
        return timeH;
    }

    public void setTimeH(int timeH) {
        this.timeH = timeH;
    }

    public int getSpens() {
        return spens;
    }

    public void setSpens(int spens) {
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

    public int getCooldowns() {
        return cooldowns;
    }

    public void setCooldowns(int cooldowns) {
        this.cooldowns = cooldowns;
    }

    public long getLockedAboveScore() {
        return lockedAboveScore;
    }

    public void setLockedAboveScore(long lockedAboveScore) {
        this.lockedAboveScore = lockedAboveScore;
    }

    @Override
    public Map toMap() {
        Map<String,Object> shields = new HashMap<>();
        shields.put("shield_id", this.getShieldId());
        shields.put("name", this.getName());
        shields.put("tid", this.getTid());
        shields.put("infotid", this.getInfoTid());
        shields.put("timeh", this.getTimeH());
        shields.put("spens", this.getSpens());
        shields.put("iconswf", this.getIconSWF());
        shields.put("iconexportname", this.getIconExportName());
        shields.put("cooldowns", this.getCooldowns());
        shields.put("lockedabovescore", this.getLockedAboveScore());
        
        return shields; //To change body of generated methods, choose Tools | Templates.
    }

    
}

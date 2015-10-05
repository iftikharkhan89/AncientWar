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
public class Decorations extends BasicDBObject {
 private long decorationId;
 private String name;
 private String tid;
 private String infoTid;
 private String swf;
 private String exportName;
 private String exportNameconstruction;
 private String buildResource;
 private long buildCost;
 private long requiredExpLevel;
 private long maxCount;
 private long width;
 private long height;
 private String icon;
 private String exportNameBase;
 private String exportNameBaseNPC;

    public Decorations(long decorationId, String name) {
        this.decorationId = decorationId;
        this.name = name;
    }

    public Decorations(Map m) {
        super(m);
    }

    public Decorations() {
    }

    public long getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(long decorationId) {
        this.decorationId = decorationId;
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

    public String getExportNameconstruction() {
        return exportNameconstruction;
    }

    public void setExportNameconstruction(String exportNameconstruction) {
        this.exportNameconstruction = exportNameconstruction;
    }

    public String getBuildResource() {
        return buildResource;
    }

    public void setBuildResource(String buildResource) {
        this.buildResource = buildResource;
    }

    public long getBuildCost() {
        return buildCost;
    }

    public void setBuildCost(long buildCost) {
        this.buildCost = buildCost;
    }

    public long getRequiredExpLevel() {
        return requiredExpLevel;
    }

    public void setRequiredExpLevel(long requiredExpLevel) {
        this.requiredExpLevel = requiredExpLevel;
    }

    public long getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(long maxCount) {
        this.maxCount = maxCount;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExportNameBase() {
        return exportNameBase;
    }

    public void setExportNameBase(String exportNameBase) {
        this.exportNameBase = exportNameBase;
    }

    public String getExportNameBaseNPC() {
        return exportNameBaseNPC;
    }

    public void setExportNameBaseNPC(String exportNameBaseNPC) {
        this.exportNameBaseNPC = exportNameBaseNPC;
    }

    @Override
    public Map toMap() {
        Map<String,Object> decorations = new HashMap<>();
        decorations.put("decoration_id", this.getDecorationId());
        decorations.put("name", this.getName());
        decorations.put("tid", this.getTid());
        decorations.put("swf", this.getSwf());
        decorations.put("infotid", this.getInfoTid());
        decorations.put("exportname", this.getExportName());
        decorations.put("exportnameconstruction", this.getExportNameconstruction());
        decorations.put("buildresource", this.getBuildResource());
        decorations.put("buildcost", this.getBuildCost());
        decorations.put("requiredexplevel", this.getRequiredExpLevel());
        decorations.put("maxcount", this.getMaxCount());
        decorations.put("width", this.getWidth());
        decorations.put("height", this.getHeight());
        decorations.put("icon", this.getIcon());
        decorations.put("exportnamebase", this.getExportNameBase());
        decorations.put("exportnamebasenpc", this.getExportNameBaseNPC());
        return decorations; //To change body of generated methods, choose Tools | Templates.
    }

   
}

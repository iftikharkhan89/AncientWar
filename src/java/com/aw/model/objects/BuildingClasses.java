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
public class BuildingClasses extends BasicDBObject {
 private long buildingClassId;
 private String name;
 private String tid;
 private int canBuy;
 private int shopCategoryResource;
 private int shopCategoryArmy;
 private int shopCategoryDefense;
 private int parent;

    public BuildingClasses(long buildingClassId, String name, String tid, int canBuy, int shopCategoryResource, int shopCategoryArmy, int shopCategoryDefense, int parent) {
        this.buildingClassId = buildingClassId;
        this.name = name;
        this.tid = tid;
        this.canBuy = canBuy;
        this.shopCategoryResource = shopCategoryResource;
        this.shopCategoryArmy = shopCategoryArmy;
        this.shopCategoryDefense = shopCategoryDefense;
        this.parent = parent;
    }

    public BuildingClasses(Map m) {
        super(m);
    }

    public BuildingClasses() {
    }

    public long getBuildingClassId() {
        return buildingClassId;
    }

    public void setBuildingClassId(long buildingClassId) {
        this.buildingClassId = buildingClassId;
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

    public int getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(int canBuy) {
        this.canBuy = canBuy;
    }

    public int getShopCategoryResource() {
        return shopCategoryResource;
    }

    public void setShopCategoryResource(int shopCategoryResource) {
        this.shopCategoryResource = shopCategoryResource;
    }

    public int getShopCategoryArmy() {
        return shopCategoryArmy;
    }

    public void setShopCategoryArmy(int shopCategoryArmy) {
        this.shopCategoryArmy = shopCategoryArmy;
    }

    public int getShopCategoryDefense() {
        return shopCategoryDefense;
    }

    public void setShopCategoryDefense(int shopCategoryDefense) {
        this.shopCategoryDefense = shopCategoryDefense;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Override
    public Map toMap() {
        Map<String,Object> buildingClasses = new HashMap<>();
        buildingClasses.put("building_class_id", this.getBuildingClassId());
        buildingClasses.put("name", this.getName());
        buildingClasses.put("tid", this.getTid());
        buildingClasses.put("canbuy", this.getCanBuy());
        buildingClasses.put("shopcategoryresource", this.getShopCategoryResource());
        buildingClasses.put("shopcategoryarmy", this.getShopCategoryArmy());
        buildingClasses.put("shopcategorydefense", this.getShopCategoryDefense());
        buildingClasses.put("parent", this.getParent());
        
        return buildingClasses; 
    }

 
}

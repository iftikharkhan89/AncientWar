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
public class BarrackTroops extends BasicDBObject {
 private long bcId;
 private long uId;
 private int buildingId;
 private String tid;
 private int level;
 private int isFirstInQueue;
 private long sort;
 private long trainingStartTime;
 private long count;
 private BuildingBase buildingBase;

    public BarrackTroops(long bcId, long uId, int buildingId, String tid, int level, int isFirstInQueue, long sort, long trainingStartTime, long count) {
        this.bcId = bcId;
        this.uId = uId;
        this.buildingId = buildingId;
        this.tid = tid;
        this.level = level;
        this.isFirstInQueue = isFirstInQueue;
        this.sort = sort;
        this.trainingStartTime = trainingStartTime;
        this.count = count;
    }

    public BarrackTroops(Map m) {
        super(m);
    }

    public long getBcId() {
        return bcId;
    }

    public void setBcId(long bcId) {
        this.bcId = bcId;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIsFirstInQueue() {
        return isFirstInQueue;
    }

    public void setIsFirstInQueue(int isFirstInQueue) {
        this.isFirstInQueue = isFirstInQueue;
    }

    public long getSort() {
        return sort;
    }

    public void setSort(long sort) {
        this.sort = sort;
    }

    public long getTrainingStartTime() {
        return trainingStartTime;
    }

    public void setTrainingStartTime(long trainingStartTime) {
        this.trainingStartTime = trainingStartTime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public BuildingBase getBuildingBase() {
        return buildingBase;
    }

    public void setBuildingBase(BuildingBase buildingBase) {
        this.buildingBase = buildingBase;
    }

    @Override
    public Map toMap() {
        Map<String,Object> barrackTroop = new HashMap<>();
        barrackTroop.put("bc_id", this.getBcId());
        barrackTroop.put("uid", this.getuId());
        barrackTroop.put("building_id", this.getBuildingId());
        barrackTroop.put("tid", this.getTid());
        barrackTroop.put("level", this.getLevel());
        barrackTroop.put("is_first_in_queue", this.getIsFirstInQueue());
        barrackTroop.put("sort", this.getSort());
        barrackTroop.put("training_start_time", this.getTrainingStartTime());
        barrackTroop.put("count", this.getCount());
        if(this.getBuildingBase() != null)
            barrackTroop.put("buildingBase", this.getBuildingBase().toMap());
        else
           barrackTroop.put("buildingBase", this.getBuildingBase()); 
        return barrackTroop; 
    }

    
}

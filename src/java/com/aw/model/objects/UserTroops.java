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
public class UserTroops extends BasicDBObject {
 private String troopToUsers;
 private String troopId;
 private String userid;
 private String tid;
 private String isCreated;
 private boolean isOwner;
 private String donarUserId;
 private int inBarrack;
 private String barrackId;
 private TroopsConfiguration troops;

    public UserTroops(String troopToUsers, String troopId, String userid, String tid, String isCreated, boolean isOwner, String donarUserId, int inBarrack, String barrackId) {
        this.troopToUsers = troopToUsers;
        this.troopId = troopId;
        this.userid = userid;
        this.tid = tid;
        this.isCreated = isCreated;
        this.isOwner = isOwner;
        this.donarUserId = donarUserId;
        this.inBarrack = inBarrack;
        this.barrackId = barrackId;
    }

    public UserTroops() {
        super();
    }

    public UserTroops(Map m) {
        super(m);
    }

    public String getTroopToUsers() {
        return troopToUsers;
    }

    public void setTroopToUsers(String troopToUsers) {
        this.troopToUsers = troopToUsers;
    }

    public String getTroopId() {
        return troopId;
    }

    public void setTroopId(String troopId) {
        this.troopId = troopId;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    public boolean isIsOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    public String getDonarUserId() {
        return donarUserId;
    }

    public void setDonarUserId(String donarUserId) {
        this.donarUserId = donarUserId;
    }

    public int getInBarrack() {
        return inBarrack;
    }

    public void setInBarrack(int inBarrack) {
        this.inBarrack = inBarrack;
    }

    public String getBarrackId() {
        return barrackId;
    }

    public void setBarrackId(String barrackId) {
        this.barrackId = barrackId;
    }

    public TroopsConfiguration getTroops() {
        return troops;
    }

    public void setTroops(TroopsConfiguration troops) {
        this.troops = troops;
    }

    @Override
    public Map toMap() {
        Map<String,Object> userTroops = new HashMap<>();
        userTroops.put("troop_to_users", this.getTroopToUsers());
        userTroops.put("troop_id", this.getTroopId());
        userTroops.put("uid", this.getUserid());
        userTroops.put("tid", this.getTid());
        userTroops.put("is_created", this.getIsCreated());
        userTroops.put("is_owner", this.isIsOwner());
        userTroops.put("donar_uid", this.getDonarUserId());
        userTroops.put("in_barrack", this.getInBarrack());
        userTroops.put("barrack_id", this.getBarrackId());
        if(this.getTroops() != null)
            userTroops.put("troop", this.getTroops().toMap());     
        return userTroops; 
    }

   
}

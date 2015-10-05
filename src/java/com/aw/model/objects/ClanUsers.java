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
public class ClanUsers extends BasicDBObject {
 private String memberId;
 private String userId;
 private String clanId;
 private String type;
 private String isCreated;
 private Clan clan;
 private User user;
 

    public ClanUsers(String memberId, String userId, String clanId) {
        this.memberId = memberId;
        this.userId = userId;
        this.clanId = clanId;
    }

    public ClanUsers(Map m) {
        super(m);
    }

    public ClanUsers() {
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClanId() {
        return clanId;
    }

    public void setClanId(String clanId) {
        this.clanId = clanId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Map toMap() {
        Map<String,Object> clanUsers = new HashMap<>();
        clanUsers.put("member_id", this.getMemberId());
        clanUsers.put("uid", this.getUserId());
        clanUsers.put("clan_id", this.getClanId());
        clanUsers.put("type", this.getType());
        clanUsers.put("is_created", this.getIsCreated());
        if(this.getClan() != null)
            clanUsers.put("clan", this.getClan().toMap());
        if(this.getUser() != null)
            clanUsers.put("user", this.getUser().toMap());
        return clanUsers; //To change body of generated methods, choose Tools | Templates.
    }

 
}

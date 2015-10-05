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
public class Clan extends BasicDBObject {
 private String clanId;
 private String name;
 private String flag;
 private String owner;
 private String requireTroophies;
 private String invitationType;
 private String isCreated;

    public Clan(String clanId, String name) {
        this.clanId = clanId;
        this.name = name;
    }

    public Clan(Map m) {
        super(m);
    }

    public Clan() {
    }

    public String getClanId() {
        return clanId;
    }

    public void setClanId(String clanId) {
        this.clanId = clanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRequireTroophies() {
        return requireTroophies;
    }

    public void setRequireTroophies(String requireTroophies) {
        this.requireTroophies = requireTroophies;
    }

    public String getInvitationType() {
        return invitationType;
    }

    public void setInvitationType(String invitationType) {
        this.invitationType = invitationType;
    }

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    @Override
    public String toString() {
        return "Clan{" + "clanId=" + clanId + ", name=" + name + ", flag=" + flag + ", owner=" + owner + ", requireTroophies=" + requireTroophies + ", invitationType=" + invitationType + ", isCreated=" + isCreated + '}';
    }

    @Override
    public Map toMap() {
        Map<String,Object> clan = new HashMap<>();
        clan.put("clan_id", this.getClanId());
        clan.put("name", this.getName());
        clan.put("flag", this.getFlag());
        clan.put("owner", this.getOwner());
        clan.put("require_troophies", this.getRequireTroophies());
        clan.put("invitation_type", this.getInvitationType());
        clan.put("is_created", this.isCreated);
        return clan; //To change body of generated methods, choose Tools | Templates.
    }
 
}

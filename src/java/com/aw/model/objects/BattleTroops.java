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
public class BattleTroops extends BasicDBObject {
 private long battleTroopId;
 private long battleId;
 private String tid;
 private long count;
 private int level;
 private long isCreated;
 private Battle battle;

    public BattleTroops(long battleTroopId, long battleId, String tid, long count, int level, long isCreated) {
        this.battleTroopId = battleTroopId;
        this.battleId = battleId;
        this.tid = tid;
        this.count = count;
        this.level = level;
        this.isCreated = isCreated;
    }

    public BattleTroops() {
    }

    public BattleTroops(Map m) {
        super(m);
    }

    public long getBattleTroopId() {
        return battleTroopId;
    }

    public void setBattleTroopId(long battleTroopId) {
        this.battleTroopId = battleTroopId;
    }

    public long getBattleId() {
        return battleId;
    }

    public void setBattleId(long battleId) {
        this.battleId = battleId;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(long isCreated) {
        this.isCreated = isCreated;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    @Override
    public Map toMap() {
        Map<String,Object> battleTroop = new HashMap<>();
        battleTroop.put("battle_troop_id", this.getBattleTroopId());
        battleTroop.put("battle_id", this.getBattleId());
        battleTroop.put("tid", this.getTid());
        battleTroop.put("count", this.getCount());
        battleTroop.put("level", this.getLevel());
        battleTroop.put("is_created", this.getIsCreated());
        if(this.getBattle() != null)
            battleTroop.put("battle", this.getBattle().toMap());
        else
            battleTroop.put("battle", this.getBattle());
        
        return battleTroop; //To change body of generated methods, choose Tools | Templates.
    }

   

}

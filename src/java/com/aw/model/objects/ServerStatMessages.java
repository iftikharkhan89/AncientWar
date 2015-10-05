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

public class ServerStatMessages extends BasicDBObject {
 private long serverStateMessageId;
 private int serverStateCode;
 private String serverStateMessage;

    public ServerStatMessages(long serverStateMessageId, int serverStateCode, String serverStateMessage) {
        this.serverStateMessageId = serverStateMessageId;
        this.serverStateCode = serverStateCode;
        this.serverStateMessage = serverStateMessage;
    }

    public ServerStatMessages() {
        super();
    }

    public ServerStatMessages(Map m) {
        super(m);
    }

    public long getServerStateMessageId() {
        return serverStateMessageId;
    }

    public void setServerStateMessageId(long serverStateMessageId) {
        this.serverStateMessageId = serverStateMessageId;
    }

    public int getServerStateCode() {
        return serverStateCode;
    }

    public void setServerStateCode(int serverStateCode) {
        this.serverStateCode = serverStateCode;
    }

    public String getServerStateMessage() {
        return serverStateMessage;
    }

    public void setServerStateMessage(String serverStateMessage) {
        this.serverStateMessage = serverStateMessage;
    }

    @Override
    public Map toMap() {
        Map<String,Object> ssm = new HashMap<>();
        ssm.put("server_stat_message_id", this.getServerStateMessageId());
        ssm.put("server_stat_code", this.getServerStateCode());
        ssm.put("server_stat_message", this.getServerStateMessage());
        return ssm; //To change body of generated methods, choose Tools | Templates.
    }

    
}

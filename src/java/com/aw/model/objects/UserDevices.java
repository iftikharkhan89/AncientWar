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
public class UserDevices extends BasicDBObject {
  private String awDeviceId;
 private String deviceId;
 private String userId;
 private String isCreated;
 private User user;

    public UserDevices(String key, Object value) {
        super(key, value);
    }

    public UserDevices() {
    }

    public UserDevices(Map m) {
        super(m);
    }

    public String getAwDeviceId() {
        return awDeviceId;
    }

    public void setAwDeviceId(String awDeviceId) {
        this.awDeviceId = awDeviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    @Override
    public Map toMap() {
        Map<String,Object> userDevices = new HashMap<>();
        userDevices.put("aw_device_id", this.getAwDeviceId());
        userDevices.put("device_id", this.getDeviceId());
        userDevices.put("uid", this.getUserId());
        userDevices.put("is_created", this.getIsCreated());
        if(this.getUser() != null)
            userDevices.put("user", this.getUser().toMap());
        return userDevices; //To change body of generated methods, choose Tools | Templates.
    }

    
}

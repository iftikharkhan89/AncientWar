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
public class SystemSettings extends BasicDBObject {
 private String id;
 private String title;
 private String key;
 private String value;
 private String image;
 private String isCreated;
 private String isModified;

    public SystemSettings(String id, String title, String key, String value, String image, String isCreated, String isModified) {
        this.id = id;
        this.title = title;
        this.key = key;
        this.value = value;
        this.image = image;
        this.isCreated = isCreated;
        this.isModified = isModified;
    }

    public SystemSettings() {
        super();
    }

    public SystemSettings(Map m) {
        super(m);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    public String getIsModified() {
        return isModified;
    }

    public void setIsModified(String isModified) {
        this.isModified = isModified;
    }

    @Override
    public Map toMap() {
        Map<String,Object> ss = new HashMap<>();
        ss.put("id", this.getId());
        ss.put("title", this.getTitle());
        ss.put("key", this.getKey());
        ss.put("value", this.getValue());
        ss.put("image", this.getImage());
        ss.put("is_created", this.getIsCreated());
        ss.put("is_modified", this.getIsModified());          
        return ss; //To change body of generated methods, choose Tools | Templates.
    }

  
}

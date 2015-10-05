/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.model.objects;

import com.mongodb.BasicDBObject;
import java.util.Map;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author iftikhar
 */
public class QueryCriteria extends BasicDBObject {
 private String awCriteriaId;
 private String criteria;
 private String value;
 private String isCreated;

    public QueryCriteria(String awCriteriaId, String criteria, String value, String isCreated) {
        this.awCriteriaId = awCriteriaId;
        this.criteria = criteria;
        this.value = value;
        this.isCreated = isCreated;
    }

    public QueryCriteria(Map m) {
        super(m);
    }

    public QueryCriteria() {
    }

    public String getAwCriteriaId() {
        return awCriteriaId;
    }

    public void setAwCriteriaId(String awCriteriaId) {
        this.awCriteriaId = awCriteriaId;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIsCreated() {
        return isCreated;
    }

    public void setIsCreated(String isCreated) {
        this.isCreated = isCreated;
    }

    @Override
    public String toString() {
        return "QueryCriteria{" + "awCriteriaId=" + awCriteriaId + ", criteria=" + criteria + ", value=" + value + ", isCreated=" + isCreated + '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.services;

import com.aw.model.objects.User;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author iftikhar
 */
public interface AncientWarService {
 public JSONObject browseUserVillage(Long userId) throws JSONException;
 public JSONObject getUserVillage(Long userId) throws JSONException;
 public JSONObject getUserVillage(Long userId,String action) throws JSONException;
 public JSONObject getSystemSettingByKey(String key) throws JSONException;
 public JSONObject login(String deviceId) throws JSONException;
 public User createUser(JSONObject data) throws JSONException;
 public JSONObject updateUserName(JSONObject data) throws JSONException;
 public JSONObject addBattleInfo(JSONObject data) throws JSONException;
 public JSONObject getUserBattleLogs(long userId,String type);
 public JSONObject addBuilding(JSONObject data);
 public JSONObject updateBuilding(JSONObject data) throws JSONException;
 public JSONObject trainTroops(JSONObject data) throws JSONException;
 public JSONObject upgradeTroops(JSONObject data) throws JSONException;

}

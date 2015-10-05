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
public class UserToken extends BasicDBObject {
 private String userTokenId;
 private String userId;
 private String accessToken;
 private boolean isLogin;
 private User user;

    public UserToken(String userTokenId, String userId, String accessToken, boolean isLogin) {
        this.userTokenId = userTokenId;
        this.userId = userId;
        this.accessToken = accessToken;
        this.isLogin = isLogin;
    }

    public UserToken() {
        super();
    }

    public UserToken(Map m) {
        super(m);
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Map toMap() {
        Map<String,Object> userToken = new HashMap<>();
        userToken.put("user_token_id", this);
        userToken.put("uid", this);
        userToken.put("access_token", this);
        userToken.put("is_login", this);
        if(this.getUser() != null)
            userToken.put("user", this.getUser().toMap());
        return userToken;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.app.action;

import java.util.UUID;

/**
 *
 * @author iftikhar
 */
public class AuthAction {
    /**
     * 
     * @return 
     */
    public String createToken() {
        String uuid = UUID.randomUUID().toString();    
        return uuid.replaceAll("-", "");
    }
}

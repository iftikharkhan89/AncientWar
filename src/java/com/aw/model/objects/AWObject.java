/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.model.objects;

import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author iftikhar
 */
public interface AWObject {
    public JSONObject toJason();
}

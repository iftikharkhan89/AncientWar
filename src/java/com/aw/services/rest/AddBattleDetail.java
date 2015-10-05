/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.services.rest;

import com.aw.app.action.UserAction;
import com.aw.services.AncientWarServiceImpl;
import com.aw.util.AWUtil;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 *
 * @author iftikhar
 */
@Path("AddBattleDetail")
public class AddBattleDetail {
private String errorMessage;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AddBattleDetail
     */
    public AddBattleDetail() {
    }

    /**
     * Retrieves representation of an instance of com.aw.services.rest.AddBattleDetail
     * @param data
     * @param token
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String addBattleDetail(@FormParam("data") String data,
                                  @HeaderParam("access_token") String token) {
         int status = new UserAction().checkAccess(token);
         boolean isAllowed = AWUtil.validateUser(status);
         if(!isAllowed)
             errorMessage = AWUtil.getMessageForStatus(status);;
        try {
            
             JSONObject response = new JSONObject();
             JSONObject inputData = new JSONObject(data);
             
                if(isAllowed && validate(inputData)) {
                    response =   AncientWarServiceImpl.getInstance().addBattleInfo(inputData);
                    return response.toString();
                }
                else {
                    response.put("status", false);
                    response.put("message", errorMessage);
                    return response.toString();
                }
            }
            catch(JSONException e) {
                return "{\"status\":false, \"message\":\""+e.getMessage()+"\"}";
            }
    }
    private boolean validate(JSONObject json) throws JSONException {
        boolean valid = true;
        if(!json.has("uid") || json.getString("uid").equals(""))
            valid = false;
        if(!json.has("tid") || json.getString("tid").equals(""))
            valid = false;
        if(!json.has("level") || json.getString("level").equals(""))
            valid = false;
        
        if(!valid) {
            errorMessage = "Data is missing please check uid, tid & level fields.";
        }        
      return valid;
    }
}

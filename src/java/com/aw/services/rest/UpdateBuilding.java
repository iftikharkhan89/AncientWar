/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.services.rest;

import com.aw.app.action.UserAction;
import com.aw.services.AncientWarServiceImpl;
import com.aw.util.AWUtil;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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
@Path("UpdateBuilding")
public class UpdateBuilding {
    private String errorMessage;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UpdateBuilding
     */
    public UpdateBuilding() {
    }

    /**
     * Retrieves representation of an instance of com.aw.services.rest.UpdateBuilding
     * @param data
     * @param token
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String updateBuilding(@FormParam("data") String data,
                              @HeaderParam("access_token") String token) {
       int status = new UserAction().checkAccess(token);
        boolean isAllowed = AWUtil.validateUser(status);       
        if(!isAllowed) {
            errorMessage = AWUtil.getMessageForStatus(status);
        }
        try {
            if(isAllowed && validate(data)) {
                JSONObject inputData = new JSONObject(data);
                return AncientWarServiceImpl.getInstance().updateBuilding(inputData).toString();
            }
            else {
                JSONObject response = new JSONObject();
                response.put("status", false);
                response.put("message", errorMessage);
                return response.toString();
            }
        }
        catch(JSONException e) {
            return "{\"status\":false, \"message\":\""+e.getMessage()+"\"}";
        }
    }
    private boolean validate(String data) {
        boolean valid = true;
        if(data == null || data.length() == 0) {
            errorMessage = "Data is missing";
            return false;
        }
        try {
            JSONObject object = new JSONObject(data);
            if(!object.has("position_x") || !object.has("position_y") || !object.has("building_id")) {
                errorMessage = "Data is missing. Please Check uid, building_id, Position X & Y.";
                valid = false;
                return valid;
            }
        }
        catch(JSONException e) {
            errorMessage = "Invalid json string.";
            valid = false;
            return valid;
        }
        return valid;
    }
}

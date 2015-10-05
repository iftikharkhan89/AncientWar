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
import javax.ws.rs.DELETE;
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
@Path("TrainTroops")
public class TrainTroops {
    private String errorMessage;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TrainTroops
     */
    public TrainTroops() {
    }

    /**
     * Retrieves representation of an instance of com.aw.services.rest.TrainTroops
     * @param data
     * @param token
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String trainTroops(@FormParam("data") String data, @HeaderParam("access_token") String token) {
        int status = new UserAction().checkAccess(token);
        boolean isAllowed = AWUtil.validateUser(status);       
        if(!isAllowed) {
            errorMessage = AWUtil.getMessageForStatus(status);
        }
        try {
            if(isAllowed && validate(data)) {
                JSONObject inputData = new JSONObject(data);
                inputData.put("action", "train");
                return AncientWarServiceImpl.getInstance().trainTroops(inputData).toString();
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
    /**
     * 
     * @param data
     * @param token
     * @return 
     */
    @DELETE
    @Consumes("application/json")
    @Produces("application/json")
    public String removeTroopsFromTraining(@FormParam("data") String data, @HeaderParam("access_token") String token){
        int status = new UserAction().checkAccess(token);
        boolean isAllowed = AWUtil.validateUser(status);       
        if(!isAllowed) {
            errorMessage = AWUtil.getMessageForStatus(status);
        }
        try {
            if(isAllowed && validate(data)) {
                JSONObject inputData = new JSONObject(data);
                inputData.put("action", "delete");
                return AncientWarServiceImpl.getInstance().trainTroops(inputData).toString();
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
    /**
     * 
     * @param data
     * @return 
     */
    private boolean validate(String data) {
        boolean valid = true;
        if(data == null || data.length() == 0) {
            errorMessage = "Json String is empty";
            return false;
        }
        try {
            JSONObject object = new JSONObject(data);
            if(!object.has("uid") || !object.has("tid") || !object.has("level") || 
               !object.has("building_id") || !object.has("is_first_in_queue")) {
                errorMessage = "is missing. Please Check uid,tid,building_id,sort order & level.";
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.services.rest;

import com.aw.app.action.UserAction;
import com.aw.services.AncientWarServiceImpl;
import com.aw.util.AWUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("UpdateUserName")
public class UpdateUserName {

    private String errorMessage;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UpdateUserName
     */
    public UpdateUserName() {
    }

    /**
     * Retrieves representation of an instance of com.aw.services.rest.UpdateUserName
     * @param data
     * @param token
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")    
    public String updateUserName(@FormParam("data") String data,
                                 @HeaderParam("access_token") String token) {
        int status = new UserAction().checkAccess(token);
        boolean isAllowed = AWUtil.validateUser(status);
        if(!isAllowed)
            errorMessage = AWUtil.getMessageForStatus(status);
        try {
            JSONObject inputData = new JSONObject(data);
            JSONObject response = new JSONObject();
            if(isAllowed && validateInput(inputData)) {  
                response =  AncientWarServiceImpl.getInstance().updateUserName(inputData);
                return response.toString();            
            }
            else {
                response = new JSONObject();
                response.put("status", false);
                response.put("message", errorMessage);
                return response.toString();
            }
        }
        catch(JSONException e) {
            return "{status:false \"message\":"+e.getMessage()+"}";
        }
    }
    /**
     * 
     * @param data
     * @return 
     */
    private boolean validateInput(JSONObject data) {
        try {
            boolean valid = true;
            if(!data.has("uid") || data.getString("uid").equals("")) {
                errorMessage = "uid field missing.";
                return false;
            }
            if(!data.has("name") || data.getString("name").equals("")) {
                errorMessage = "name field missing.";
                return false;
            }
            return valid;
        } catch (JSONException ex) {
            Logger.getLogger(UpdateUserName.class.getName()).log(Level.SEVERE, null, ex);
            errorMessage = "uid field missing.";
            return false;
        }
    }
}

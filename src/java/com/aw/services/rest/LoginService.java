/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.services.rest;

import com.aw.services.AncientWarService;
import com.aw.services.AncientWarServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 *
 * @author iftikhar
 */
@Path("Login")
public class LoginService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginService
     */
    public LoginService() {
    }

    /**
     * Retrieves representation of an instance of com.aw.services.rest.LoginService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        return "Login...";
    }

    /**
     * POST method for creating an instance of LoginResource
     * @param data
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String login(@FormParam("data") String data) {      
        
        String deviceId = null;
        try {
            if(data != null) {
                JSONObject input = new JSONObject(data);
                JSONObject response = new JSONObject();
                deviceId = input.getString("device_id");
                AncientWarService service = AncientWarServiceImpl.getInstance();
                response = service.login(deviceId);
                return response.toString();
            }
            else {
                JSONObject status = new JSONObject();
                status.put("status", false);
                status.put("message", "No input information provided.");
                return status.toString();
            }
        } catch (JSONException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }     
    }
}

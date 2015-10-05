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
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 *
 * @author iftikhar
 */
@Path("GetBattleVillage")
public class GetBattleVillage {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GetBattleVillage
     */
    public GetBattleVillage() {
    }

    /**
     * Retrieves representation of an instance of com.aw.services.rest.GetBattleVillage
     * @param token
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBattleVillage(@HeaderParam("access_token") String token) {
        int status = new UserAction().checkAccess(token);
        boolean isAllowed = AWUtil.validateUser(status);
        JSONObject response = new JSONObject();
       if (!isAllowed) {
          String message = AWUtil.getMessageForStatus(status);
            try {
                return response.put("message", message).toString();
            } 
            catch (JSONException ex) {
                Logger.getLogger(GetBattleVillage.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       else {
            try {
                response = AncientWarServiceImpl.getInstance().browseUserVillage(new UserAction().getLoginUserId(token));
            } catch (JSONException ex) {
                Logger.getLogger(GetBattleVillage.class.getName()).log(Level.SEVERE, null, ex);
            }
       }     
       return response.toString();
    }
}

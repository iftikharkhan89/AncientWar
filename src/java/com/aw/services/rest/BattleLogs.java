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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 *
 * @author iftikhar
 */
@Path("BattleLogs/param/{param}")
public class BattleLogs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BattleLogs
     */
    public BattleLogs() {
    }

    /**
     * Retrieves representation of an instance of com.aw.services.rest.BattleLogs
     * @param token
     * @param logType
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String attackBattleLogs(@HeaderParam("access_token") String token,
                                   @PathParam("param") String logType) {
        
        int status = new UserAction().checkAccess(token);
        boolean isAllowed = AWUtil.validateUser(status);
        JSONObject response = new JSONObject();
        if (!isAllowed) {
            try {
                String message = AWUtil.getMessageForStatus(status);
                return response.put("message", message).toString();
            } catch (JSONException ex) {
                Logger.getLogger(BattleLogs.class.getName()).log(Level.SEVERE, null, ex);
                return "{\"status\":false, \"message\":\""+ex.getMessage()+"\"}";
            }
        }
        else {
              long uid = new UserAction().getLoginUserId(token);
              response = AncientWarServiceImpl.getInstance().getUserBattleLogs(uid,logType);
              return response.toString();
        }
    }
}

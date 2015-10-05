/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.services.rest;

import com.aw.services.AncientWarService;
import com.aw.services.AncientWarServiceImpl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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
@Path("CheckServerState")
public class ServerSettingsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServerSettingsResource
     */
    public ServerSettingsResource() {
    }

    /**
     * Retrieves representation of an instance of com.aw.services.rest.ServerSettingsResource
     * @return an instance of java.lang.String
     * @throws org.codehaus.jettison.json.JSONException
     */
    @GET
    @Produces("application/json")
    public String getServerState() throws JSONException {
        AncientWarService service = AncientWarServiceImpl.getInstance();
        JSONObject json = service.getSystemSettingByKey("SERVER_STATE");     
        return json.toString();
    }
}

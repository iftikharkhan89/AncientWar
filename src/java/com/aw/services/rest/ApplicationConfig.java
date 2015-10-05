/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.services.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author iftikhar
 */
@javax.ws.rs.ApplicationPath("API")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.aw.services.rest.AddBattleDetail.class);
        resources.add(com.aw.services.rest.AddBuilding.class);
        resources.add(com.aw.services.rest.BattleLogs.class);
        resources.add(com.aw.services.rest.GetBattleVillage.class);
        resources.add(com.aw.services.rest.GetVillageInfo.class);
        resources.add(com.aw.services.rest.LoginResource.class);
        resources.add(com.aw.services.rest.LoginService.class);
        resources.add(com.aw.services.rest.ServerSettingsResource.class);
        resources.add(com.aw.services.rest.TrainTroops.class);
        resources.add(com.aw.services.rest.UpdateBuilding.class);
        resources.add(com.aw.services.rest.UpdateUserName.class);
        resources.add(com.aw.services.rest.UpgradeTroops.class);
    }
    
}

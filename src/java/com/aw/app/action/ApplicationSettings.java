/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.app.action;

import com.mongodb.DBObject;

/**
 *
 * @author iftikhar
 */
public class ApplicationSettings {
   /**
    * 
    * @param configuration
    * @return 
    */
    public static long convertToTimeStamp(DBObject configuration){
       long d = (Integer)configuration.get("build_time_d");
       long h = (Integer)configuration.get("build_time_h");
       long m = (Integer)configuration.get("build_time_m"); 
       return (d * 86400) + (h * 3600) + (m * 60);      
    }
}

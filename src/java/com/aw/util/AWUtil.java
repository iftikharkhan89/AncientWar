/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author iftikhar
 */
public class AWUtil {
   public static boolean validateUser(int status) {
       return status == 1;
   }
   public static String getMessageForStatus(int status){
       switch(status) {
           case 2:
               return "User logout";
           case 3:
               return "Invalid User";
           default:
               return "Unknown ERROR!";
       }
   }
   public static Map jsonToMap(JSONObject data) throws JSONException {
       Iterator<String> nameItr = data.keys();
        Map<String, String> outMap = new HashMap<>();
        while(nameItr.hasNext()) {
        outMap.put(nameItr.next(), data.getString(nameItr.next()));
        }
        return outMap;
   }
   
   public static boolean isInArray(String [] sourc, String toFind) {
       boolean in = false;
       for(String entry : sourc) {
           if(entry.equalsIgnoreCase(toFind)) {
               in = true;
               break;
           }         
       }
       return in;
   }
}

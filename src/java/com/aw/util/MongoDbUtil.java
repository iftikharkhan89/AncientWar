/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aw.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iftikhar
 */
public class MongoDbUtil {
    private static final String HOST_NAME = "localhost";
    private static final int port = 27017;
    private static DB db;
    private static MongoClient mongoClient;
    public static String defaultDBName = "ancient_war";
   
    public static MongoClient getMongoClient(){
        if(mongoClient != null) {
            return mongoClient;
        }
        try {
                MongoClient mongo = new MongoClient(HOST_NAME, port);
                mongoClient = mongo;
                return mongoClient;
        } 
        catch (UnknownHostException ex) {
            Logger.getLogger(MongoDbUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     *
     * @param dbName
     * @return
     */
    public static DB getDB(String dbName) {
        if(db != null) {
            return db;
        }
        MongoClient client = getMongoClient();
        if(client != null) {
            db = client.getDB(dbName);
            return db;
        }
        else {
            return null;
        }
    }
    
    public static DBCollection getCollection(String dbName, String name){
        DB db = getDB(dbName);
        if(db != null) {
            return db.getCollection(name);
        }
        else {
            return null;
        }
    }
 //   public static DBObject getDbObject(String dbName,String collectionName,String criteria){
        
 //   }
    
    public static WriteResult saveCollection(String dbName,String collectionName,DBObject document) {
        DB dataBase = getDB(dbName);
        if (dataBase != null) {
            DBCollection collection = dataBase.getCollection(collectionName);
            return collection.insert(document);
        }
        else {
            return null;
        }
    }
    
    public static WriteResult saveCollection(String collectionName,DBObject document) {
        DB dataBase = getDB(defaultDBName);
        if (dataBase != null) {
            DBCollection collection = dataBase.getCollection(collectionName);
            return collection.insert(document);
        }
        else {
            return null;
        }
    }
    
    public static WriteResult updateCollection(String collectionName,DBObject query, DBObject updateObject){
        DBCollection table = getCollection(defaultDBName, collectionName);      
        return table.update(query, updateObject);     
    }
    
    public static WriteResult updateCollection(String collectionName, Map data) {
      Map queryData = (Map)data.get("query");
      Map updateData = (Map) data.get("update");
      BasicDBObject query = new BasicDBObject();
      Set queryDataKeys = queryData.keySet();
      Iterator queryDataKeysIterator = queryDataKeys.iterator();
      while(queryDataKeysIterator.hasNext()){
          String key = (String)queryDataKeysIterator.next();
          query.put(key, queryData.get(key));
      }
      BasicDBObject updateObject = new BasicDBObject();
      Set updateDataKeys = updateData.keySet();
      Iterator updateDataKeysIterator = updateDataKeys.iterator();
      while(updateDataKeysIterator.hasNext()) {
          String key = (String)updateDataKeysIterator.next();
          updateObject.put(key, updateData.get(key));
      }
      
      return updateCollection(collectionName, query, updateObject);
      
    }
    
    public static WriteResult removeCollection(String collection, DBObject query) {
        DBCollection table = getCollection(defaultDBName,collection);
        return table.remove(query);
    }
    
    public static Object findMaxValueForKey(String collection,String key){        
        DBCollection table = getCollection(defaultDBName, collection);
        BasicDBObject query = new BasicDBObject();
        query.put(key, -1);
        DBCursor cursor = table.find().sort(query).limit(1);
        Object value = null;
        while(cursor.hasNext()) {
           DBObject object = cursor.next();
           value = object.get(key);
        }
        return value;
    }
    
    public static void main(String args[]) {
      MongoDbUtil.findMaxValueForKey("aw_user", "uid");
    }
}

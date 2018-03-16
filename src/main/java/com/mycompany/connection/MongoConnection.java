/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mycompany.mongodb.ServerProperties;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sonia
 */
public abstract class MongoConnection {
    private MongoClient mongoClient;
    private DB mongoDatabase;
    private DBCollection farmDB,cropDB,deviceDB;
    
    @Autowired
    private ServerProperties serverProperties;
    
    public MongoClient getSession(){
        try{
            if(mongoClient==null){
                mongoClient = new MongoClient(new MongoClientURI(serverProperties.getMongoURI()));
                mongoDatabase = mongoClient.getDB("prueba");
                farmDB = mongoDatabase.getCollection(serverProperties.getFarmDB());
                cropDB = mongoDatabase.getCollection(serverProperties.getCropDB());
                deviceDB = mongoDatabase.getCollection(serverProperties.getDeviceDB());
            }
        }catch(UnknownHostException ex){
            System.out.println("No fue posible acceder al servidor");            
        }
        return mongoClient;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public DBCollection getFarmDB() {
        return farmDB;
    }

    public DBCollection getCropDB() {
        return cropDB;
    }

    public DBCollection getDeviceDB() {
        return deviceDB;
    }
    
}

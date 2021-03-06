package com.mycompany.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("server")
public class ServerProperties {

    private String mongoURI;
    private String farmDB;
    private String cropDB;
    private String deviceDB;
    private String mongoDB;

    public String getMongoURI() {
        return mongoURI;
    }

    public void setMongoURI(String mongoURI) {
        this.mongoURI = mongoURI;
    }

    public String getFarmDB() {
        return farmDB;
    }

    public void setFarmDB(String farmDB) {
        this.farmDB = farmDB;
    }

    public String getCropDB() {
        return cropDB;
    }

    public void setCropDB(String cropDB) {
        this.cropDB = cropDB;
    }

    public String getDeviceDB() {
        return deviceDB;
    }

    public void setDeviceDB(String deviceDB) {
        this.deviceDB = deviceDB;
    }

    public String getMongoDB() {
        return mongoDB;
    }

    public void setMongoDB(String mongoDB) {
        this.mongoDB = mongoDB;
    }
    
    @Override
    public String toString(){
        return "MongoURI= "+mongoURI+" ,FarmDB:"+farmDB+" ,CropDB:"+cropDB+" ,DeviceDB:"+deviceDB;
    }
    
}

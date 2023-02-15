package de.alexanderwodarz.code.hetzner.model;

import org.json.JSONObject;

public class Backup extends Model{
    public Backup(JSONObject obj) {
        super(obj);
    }

    public double getSize(){
        return getDouble("image_size");
    }

    public String getCreated(){
        return getString("created");
    }

}

package de.alexanderwodarz.code.hetzner.model;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServerType extends Model{
    public ServerType(JSONObject obj) {
        super(obj);
    }

    public String getStorageType(){
        return getString("storage_type");
    }

    public int getDisk(){
        return getInt("disk");
    }

    public int getCores(){
        return getInt("cores");
    }

    public int getMemory(){
        return getInt("memory");
    }

    public boolean isDeprecated(){
        return getBoolean("deprecated");
    }

    public String getCpuType(){
        return getString("cpu_type");
    }

    public String getName() {
        return getString("name");
    }

    public String getDescription(){
        return getString("description");
    }

    public int getId(){
        return getInt("id");
    }

    public JSONArray getPrices(){
        return getObj().getJSONArray("prices");
    }

}

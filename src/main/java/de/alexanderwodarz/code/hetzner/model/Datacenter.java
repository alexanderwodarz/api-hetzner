package de.alexanderwodarz.code.hetzner.model;

import org.json.JSONObject;

public class Datacenter extends Model {

    public Datacenter(JSONObject obj) {
        super(obj);
    }

    public Location getLocation() {
        return new Location(getObj().getJSONObject("location"));
    }

    public String getName() {
        return getString("name");
    }

    public String getDescription() {
        return getString("description");
    }

    public int getId() {
        return getInt("id");
    }

}

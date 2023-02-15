package de.alexanderwodarz.code.hetzner.model;

import org.json.JSONObject;

public class Location extends Model {
    public Location(JSONObject obj) {
        super(obj);
    }

    public String getCountry() {
        return getString("country");
    }

    public String getNetworkZone() {
        return getString("network_zone");
    }

    public String getCity() {
        return getString("city");
    }

    public double getLatitude() {
        return getDouble("latitude");
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

    public double getLongitude() {
        return getDouble("longitude");
    }

}

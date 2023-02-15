package de.alexanderwodarz.code.hetzner.model;

import org.json.JSONObject;

public class Ip extends Model {

    public Ip(JSONObject obj) {
        super(obj);
    }

    public boolean isBlocked() {
        return getBoolean("blocked");
    }

    public String getIp() {
        return getString("ip");
    }

    public int getId() {
        return getInt("id");
    }

    public boolean hasDnsPtr() {
        return get("dns_ptr") instanceof String;
    }

    public String getDnsPtr() {
        return getString("dns_ptr");
    }

}

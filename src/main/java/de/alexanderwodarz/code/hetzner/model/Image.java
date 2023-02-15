package de.alexanderwodarz.code.hetzner.model;

import org.json.JSONObject;

public class Image extends Model {

    public Image(JSONObject obj) {
        super(obj);
    }

    public String getCreationDate() {
        return getString("created");
    }

    public String getOsVersion() {
        return getString("os_version");
    }

    public String getOsFlavor() {
        return getString("os_flavor");
    }

    public String getDescription() {
        return getString("description");
    }

    public int getDiskSize() {
        return getInt("disk_size");
    }

    public boolean isProtectionDeleted() {
        return getObj().getJSONObject("protection").getBoolean("delete");
    }

    public String getType() {
        return getString("type");
    }

    public boolean getRapidDeploy() {
        return getBoolean("rapid_deploy");
    }

    public String getName() {
        return getString("name");
    }

    public int getBoundTo() {
        return getInt("bound_to");
    }

    public int getId() {
        return getInt("id");
    }

    public String getStatus() {
        return getString("status");
    }

}

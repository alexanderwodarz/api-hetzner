package de.alexanderwodarz.code.hetzner.model;

import org.json.JSONObject;

import java.util.UUID;

public class Incident extends Model {

    public Incident(JSONObject obj) {
        super(obj);
    }

    public boolean isVisibleToAffectedClientsOnly() {
        return getBoolean("visibleToAffectedClientsOnly");
    }

    public String getDescriptionEn() {
        return getString("descriptionEn");
    }

    public String getSystemId() {
        return getString("systemId");
    }

    public String getIncidentState() {
        return getString("incidentState");
    }

    public String getVisibility() {
        return getString("visibility");
    }

    public boolean isEndTimeFixed() {
        return getBoolean("endTimeFixed");
    }

    public UUID getUuid() {
        return UUID.fromString(getString("uuid"));
    }

    public String getTitleDe() {
        return getString("titleDe");
    }

    public String getCreatedAt() {
        return getString("createdAt");
    }

    public String getTitleEn() {
        return getString("titleEn");
    }

    public String getDescriptionDe() {
        return getString("descriptionDe");
    }

    public String getStartTime() {
        return getString("startTime");
    }

    public int getId() {
        return getInt("id");
    }

    public String getEndTime() {
        return getString("endTime");
    }

}

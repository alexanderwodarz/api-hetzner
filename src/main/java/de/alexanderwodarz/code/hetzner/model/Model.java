package de.alexanderwodarz.code.hetzner.model;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;

@RequiredArgsConstructor
public class Model {

    private final JSONObject obj;

    public JSONObject getObj() {
        return obj;
    }

    public Double getDouble(String get) {
        return Double.parseDouble(get(get) + "");
    }

    public Object get(String get) {
        return obj.has(get) ? obj.get(get) : null;
    }

    public String getString(String get) {
        return get(get).toString();
    }

    public boolean getBoolean(String get) {
        return Boolean.parseBoolean(getString(get));
    }

    public Long getLong(String get) {
        return Long.parseLong(get(get) + "");
    }

    public int getInt(String get) {
        return Integer.parseInt(getString(get));
    }

}

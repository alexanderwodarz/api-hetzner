package de.alexanderwodarz.code.hetzner.model;

import de.alexanderwodarz.code.hetzner.Hetzner;
import de.alexanderwodarz.code.rest.ClientThread;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server extends Model {

    private final Hetzner hetzner;

    public Server(Hetzner hetzner, JSONObject obj) {
        super(obj);
        this.hetzner = hetzner;
    }

    public String getCreated() {
        return getString("created");
    }

    public Image getImage() {
        return new Image(getObj().getJSONObject("image"));
    }

    public boolean hasPrivateIpv4() {
        return getObj().get("private_net") instanceof JSONObject &&
                getObj().getJSONObject("private_net").get("ipv4") instanceof JSONObject;
    }

    public boolean hasPrivateIpv6() {
        return getObj().get("private_net") instanceof JSONObject &&
                getObj().getJSONObject("private_net").get("ipv6") instanceof JSONObject;
    }

    public boolean hasPublicIpv4() {
        return getObj().get("public_net") instanceof JSONObject &&
                getObj().getJSONObject("public_net").get("ipv4") instanceof JSONObject;
    }

    public boolean hasPublicIpv6() {
        return getObj().get("public_net") instanceof JSONObject &&
                getObj().getJSONObject("public_net").get("ipv6") instanceof JSONObject;
    }

    public long getIngoingTraffic() {
        return getLong("ingoing_traffic");
    }

    public long getIncludedTraffic() {
        return getLong("included_traffic");
    }

    public long getOutgoingTraffic() {
        return getLong("outgoing_traffic");
    }

    public boolean isRescueEnabled() {
        return getBoolean("rescue_enabled");
    }

    public int getId() {
        return getInt("id");
    }

    public boolean isLocked() {
        return getBoolean("locked");
    }

    public String getStatus() {
        return getString("status");
    }

    public int getPrimaryDiskSize() {
        return getInt("primary_disk_size");
    }

    public HashMap<String, String> getLabels() {
        HashMap<String, String> labels = new HashMap<>();
        for (String s : getObj().getJSONObject("labels").keySet())
            labels.put(s, getObj().getJSONObject("labels").getString(s));
        return labels;
    }

    public ServerType getServerType() {
        return new ServerType(getObj().getJSONObject("server_type"));
    }

    public Ip getPublicIpv4() {
        return hasPublicIpv4() ? new Ip(getObj().getJSONObject("public_net").getJSONObject("ipv4")) : null;
    }

    public Ip getPublicIpv6() {
        return hasPublicIpv4() ? new Ip(getObj().getJSONObject("public_net").getJSONObject("ipv6")) : null;
    }

    public Ip getPrivateIpv4() {
        return hasPublicIpv4() ? new Ip(getObj().getJSONObject("private_net").getJSONObject("ipv4")) : null;
    }

    public Ip getPrivateIpv6() {
        return hasPublicIpv4() ? new Ip(getObj().getJSONObject("private_net").getJSONObject("ipv6")) : null;
    }

    public boolean powerOff() {
        return hetzner.request("/servers/" + getId() + "/actions/poweroff", ClientThread.RequestMethod.POST).getResponseObj().isNull("error");
    }

    public boolean powerOn() {
        return hetzner.request("/servers/" + getId() + "/actions/poweron", ClientThread.RequestMethod.POST).getResponseObj().isNull("error");
    }

    public boolean reboot() {
        return hetzner.request("/servers/" + getId() + "/actions/reboot", ClientThread.RequestMethod.POST).getResponseObj().isNull("error");
    }

    public boolean reset() {
        return hetzner.request("/servers/" + getId() + "/actions/reset", ClientThread.RequestMethod.POST).getResponseObj().isNull("error");
    }
    public boolean shutdown() {
        return hetzner.request("/servers/" + getId() + "/actions/shutdown", ClientThread.RequestMethod.POST).getResponseObj().isNull("error");
    }

    public List<Image> getBackUps() {
        JSONArray arr = hetzner.request("/images?bound_to=22747251", ClientThread.RequestMethod.GET).getResponseObj().getJSONArray("images");
        List<Image> images = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            images.add(new Image(arr.getJSONObject(i)));
        }
        return images;
    }

    public Datacenter getDatacenter() {
        return new Datacenter(getObj().getJSONObject("datacenter"));
    }

    public String getName() {
        return getString("name");
    }


}

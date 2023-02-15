package de.alexanderwodarz.code.hetzner;

import de.alexanderwodarz.code.hetzner.model.Image;
import de.alexanderwodarz.code.hetzner.model.Incident;
import de.alexanderwodarz.code.hetzner.model.Server;
import de.alexanderwodarz.code.rest.ClientThread;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Hetzner {

    private final String key;

    public Request request(String path, ClientThread.RequestMethod method) {
        return new Request(this, path, method);
    }

    public Server getServer(int id) {
        return new Server(this, request("/servers/" + id, ClientThread.RequestMethod.GET).getResponseObj().getJSONObject("server"));
    }

    public List<Image> getImages() {
        List<Image> images = new ArrayList<>();
        JSONArray img = request("/images", ClientThread.RequestMethod.GET).getResponseObj().getJSONArray("images");
        for (int i = 0; i < img.length(); i++)
            images.add(new Image(img.getJSONObject(i)));
        return images;
    }

    public List<Server> getServers() {
        List<Server> serverList = new ArrayList<>();
        Request request = request("/servers", ClientThread.RequestMethod.GET);
        JSONArray arr = request.getResponseObj().getJSONArray("servers");
        for (int i = 0; i < arr.length(); i++)
            serverList.add(new Server(this, arr.getJSONObject(i)));
        return serverList;
    }

    public List<Incident> getIncidents() {
        List<Incident> incidents = new ArrayList<>();
        ClientThread thread = new ClientThread("https://status.hetzner.com/_next/data/JircgBtSyYazvu9cn6mzC/de.json", ClientThread.RequestMethod.GET);
        thread.run();
        while (thread.isAlive()) {
        }
        JSONArray result = new JSONObject(thread.getResponse()).getJSONObject("pageProps").getJSONArray("incidents");
        for (int i = 0; i < result.length(); i++) {
            incidents.add(new Incident(result.getJSONObject(i)));
        }
        return incidents;
    }

}

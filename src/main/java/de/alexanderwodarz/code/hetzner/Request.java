package de.alexanderwodarz.code.hetzner;

import de.alexanderwodarz.code.rest.ClientThread;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

@Getter
public class Request {

    private final Hetzner hetzner;
    private String response;
    private JSONObject responseObj;
    private JSONArray responseArray;
    private int status;

    public Request(Hetzner hetzner, String path, ClientThread.RequestMethod method) {
        this.hetzner = hetzner;
        ClientThread thread = new ClientThread("https://api.hetzner.cloud/v1" + path, method);
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + hetzner.getKey());
        thread.setHeaders(headers);
        thread.run();
        while(thread.isAlive()){
        }
        this.status = thread.getStatus();
        this.response = thread.getResponse();
        try{
            this.responseObj = new JSONObject(getResponse());
        }catch (Exception ignored){
        }
        try{
            this.responseArray = new JSONArray(getResponse());
        }catch (Exception ignored){
        }
    }
}

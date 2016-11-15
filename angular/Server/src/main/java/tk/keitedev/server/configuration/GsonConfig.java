/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dani
 */
public class GsonConfig {

    private Gson myGson;
    private static GsonConfig gConfig = null;

    private GsonConfig() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yyyy");
        myGson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
    }

    public static Gson getGson() {
        if (gConfig == null) {
            gConfig = new GsonConfig();
        }
        return gConfig.getMyGson();
    }

    public Gson getMyGson() {
        return myGson;
    }

    public static Map<String, Object> getJson(int code, Object data) {
        Map<String, Object> map = new HashMap();
        map.put("status", code);
        map.put("message", data);
        return map;
    }
}

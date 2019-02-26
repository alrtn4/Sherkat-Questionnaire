package com.example.ideapad510.sherkatquestionear.JsonHandler;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {


    public static String toJson(Identity identity) {
        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("username", identity.getUsername());
            jsonObject.put("password", identity.getPassword());
            jsonObject.put("jmrcode", identity.getJmrCode());

            return jsonObject.toString();

        }
        catch (JSONException e){

        }

        return null;
    }
}

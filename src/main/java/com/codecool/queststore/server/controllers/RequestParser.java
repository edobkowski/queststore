package com.codecool.queststore.server.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {
    public static Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();

        String[] pairs = formData.split("&");
        for(String pair : pairs){
            String[] keyAndValue = pair.split("=");
            String key = keyAndValue[0];
            String value = new URLDecoder().decode(keyAndValue[1], "UTF-8");
            map.put(key, value);
        }

        return map;
    }
}

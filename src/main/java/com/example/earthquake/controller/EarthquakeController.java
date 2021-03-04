package com.example.earthquake.controller;

import com.example.earthquake.client.EarthquakeClient;
import com.example.earthquake.model.EarthquakeResult;
import com.example.earthquake.model.Feature;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EarthquakeController {

    @Autowired
    EarthquakeClient earthquakeClient;


    @GetMapping("/earthquake")
    public List<String> getEarthquakes() {
        List<String> features = new ArrayList<>();
        Gson gson = new Gson();
        EarthquakeResult result;

        try {
            String s = earthquakeClient.get();
            result = gson.fromJson(s, EarthquakeResult.class);
            for (Feature f: result.getFeatures()) {
                features.add(f.toString());
            }
        } catch (Exception e) {
            return  null;
        }
        return features;

    }


}

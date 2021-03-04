package com.example.earthquake.client;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class EarthquakeClient {

    @Autowired
    private URL url;

    public String get() throws Exception{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + connection.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getInputStream())));

        String result = "";
        String output;

        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println("Line " + output);
            result += output;
        }

        connection.disconnect();

        return result;
    }


}

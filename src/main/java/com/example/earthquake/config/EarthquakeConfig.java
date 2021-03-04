package com.example.earthquake.config;

import com.example.earthquake.client.EarthquakeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

@Configuration
public class EarthquakeConfig {

    @Value("${url:}")
    private String address;

    private URL url;

    @Bean
    public EarthquakeClient earthquakeClient() {
        return new EarthquakeClient();
    }

    @Bean
    public URL url() throws MalformedURLException {
        if (url == null) {
            url = new URL(address);
        }
        return url;
    }

}

package com.kodilla.fishingnotebookfrontend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpGetRequestToHydroWeatherApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpGetRequestToHydroWeatherApi.class);

    private String userAgent = "User-Agent";

    private String browser = "Mozilla/5.0";

    public void sendGetToBackendHydroWeatherApi() throws Exception {
        String url = "http://localhost:8080/v1/report/getFishingConditionsReport";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty(userAgent, browser);
        int responseCode = connection.getResponseCode();
        LOGGER.info("'GET' request to URL conditionsAPI : " + url + "  has been sent");
        LOGGER.info("Response Code : " + responseCode);
    }
}

package com.kodilla.fishingnotebookfrontend.client;

import com.kodilla.fishingnotebookfrontend.configuration.FishingNotebookConfiguration;
import com.kodilla.fishingnotebookfrontend.domain.HydroAndWeatherReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FishingNotebookApiClient {

    @Autowired
    private FishingNotebookConfiguration fishingNotebookConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HydroAndWeatherReportDto hydroAndWeatherReportDto;

    public List <HydroAndWeatherReportDto> getBackendConditionsReport() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpoint() + "getFishingCondistionsReport")
                .build()
                .encode()
                .toUri();

        HydroAndWeatherReportDto[] backendResponse = restTemplate.getForObject(url, HydroAndWeatherReportDto[].class);
        //hydroAndWeatherReportDto.setWaterAndWeatherConditions(backendResponse);

        if (backendResponse != null) {
            return Arrays.asList(backendResponse);
        }
        return new ArrayList <>();
    }
}

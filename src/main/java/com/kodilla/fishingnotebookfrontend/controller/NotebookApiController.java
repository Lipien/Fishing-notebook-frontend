package com.kodilla.fishingnotebookfrontend.controller;

import com.kodilla.fishingnotebookfrontend.client.FishingNotebookApiClient;
import com.kodilla.fishingnotebookfrontend.domain.HydroAndWeatherReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/water")
public class NotebookApiController {

    @Autowired
    private FishingNotebookApiClient fishingNotebookApiClient;

    @GetMapping(value = "getConditionsReport")
    public List <HydroAndWeatherReportDto> getConditionsReport() {
        return fishingNotebookApiClient.getBackendConditionsReport();
    }
}

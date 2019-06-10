package com.kodilla.fishingnotebookfrontend.service;

import com.kodilla.fishingnotebookfrontend.client.FishingNotebookApiClient;
import com.kodilla.fishingnotebookfrontend.domain.HydroAndWeatherReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FishingBackendService {

    private List <HydroAndWeatherReportDto> reportList;
    private FishingBackendService fishingBackendService;

    @Autowired
    FishingNotebookApiClient fishingNotebookApiClient;

    public List <HydroAndWeatherReportDto> getReport() {
        fishingNotebookApiClient.getBackendConditionsReport();
        return reportList;
    }
}

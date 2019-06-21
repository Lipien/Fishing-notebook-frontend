package com.kodilla.fishingnotebookfrontend.service;

import com.kodilla.fishingnotebookfrontend.client.FishingNotebookApiClient;
import com.kodilla.fishingnotebookfrontend.domain.HydroAndWeatherReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FishingBackendService {

    @Autowired
    private FishingNotebookApiClient fishingNotebookApiClient;

    public void getImgw() {

        List <HydroAndWeatherReportDto> hydroData = fishingNotebookApiClient.getBackendConditionsReport();

        hydroData.forEach(temp ->
                System.out.println(temp));
    }
}

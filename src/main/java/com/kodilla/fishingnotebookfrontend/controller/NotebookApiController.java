package com.kodilla.fishingnotebookfrontend.controller;

import com.kodilla.fishingnotebookfrontend.client.FishingNotebookApiClient;
import com.kodilla.fishingnotebookfrontend.domain.SanLeskoWaterLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/water")
public class NotebookApiController {

    @Autowired
    private FishingNotebookApiClient fishingNotebookApiClient;

    @Autowired
    private SanLeskoWaterLevel sanLeskoWaterLevel;

    @GetMapping(value = "getSanLeskoWaterLevel")
    public SanLeskoWaterLevel getSanLeskoWaterLevel() {
        fishingNotebookApiClient.getSanLeskoWaterLevel();
        return sanLeskoWaterLevel;
    }
}

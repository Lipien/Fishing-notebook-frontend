package com.kodilla.fishingnotebookfrontend.controller;

import com.kodilla.fishingnotebookfrontend.client.FishingNotebookApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/water")
public class NotebookApiController {

    @Autowired
    private FishingNotebookApiClient fishingNotebookApiClient;

    @GetMapping(value = "getSanLeskoWater")
    public void getSanLeskoWaterLevel() {
        // return fishingNotebookApiClient.getSanLeskoWaterLevel();
    }
}

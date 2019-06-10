package com.kodilla.fishingnotebookfrontend.controller;

import com.kodilla.fishingnotebookfrontend.client.FishingRegistrySanLeskoClient;
import com.kodilla.fishingnotebookfrontend.domain.FishingRegistrySanLeskoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishingRegistrySanLeskoController {

    @Autowired
    FishingRegistrySanLeskoClient fishingRegistrySanLeskoClient;

    @GetMapping(value = "getSanLeskoregistry")
    public List <FishingRegistrySanLeskoDto> getSanLeskoFishingRegistry() {
        return fishingRegistrySanLeskoClient.getSanLeskoFishingRegistry();
    }
}

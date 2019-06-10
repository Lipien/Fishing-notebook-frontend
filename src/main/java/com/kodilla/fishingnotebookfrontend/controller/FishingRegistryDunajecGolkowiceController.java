package com.kodilla.fishingnotebookfrontend.controller;

import com.kodilla.fishingnotebookfrontend.client.FishingRegistryDunajecGolkowiceClient;
import com.kodilla.fishingnotebookfrontend.domain.FishingRegistryDunajecGolkowiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishingRegistryDunajecGolkowiceController {

    @Autowired
    FishingRegistryDunajecGolkowiceClient fishingRegistryDunajecGolkowiceClient;

    @GetMapping(value = "getDunajecGolkowiceRegistry")
    public List <FishingRegistryDunajecGolkowiceDto> getDunajecGolkowiceRegistry() {
        return fishingRegistryDunajecGolkowiceClient.getDunajecGolkowiceFishingRegistry();
    }
}

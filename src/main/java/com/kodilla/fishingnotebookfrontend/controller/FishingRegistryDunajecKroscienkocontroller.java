package com.kodilla.fishingnotebookfrontend.controller;

import com.kodilla.fishingnotebookfrontend.client.FishingRegistryDunajecKroscienkoClient;
import com.kodilla.fishingnotebookfrontend.domain.FishingRegistryDunajecKroscienkoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishingRegistryDunajecKroscienkocontroller {

    @Autowired
    FishingRegistryDunajecKroscienkoClient fishingRegistryDunajecKroscienkoClient;

    @GetMapping(value = "getDunajecKroscienkoRegistry")
    public List <FishingRegistryDunajecKroscienkoDto> getDunajecKroscienkoRegistry() {
        return fishingRegistryDunajecKroscienkoClient.getDunajecKroscienkoFishingRegistry();
    }
}

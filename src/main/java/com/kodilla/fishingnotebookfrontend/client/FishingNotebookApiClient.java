package com.kodilla.fishingnotebookfrontend.client;

import com.kodilla.fishingnotebookfrontend.configuration.FishingNotebookConfiguration;
import com.kodilla.fishingnotebookfrontend.domain.DunajecGolkowiceWaterLevel;
import com.kodilla.fishingnotebookfrontend.domain.DunajecKroscienkoWaterLevel;
import com.kodilla.fishingnotebookfrontend.domain.SanLeskoWaterLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class FishingNotebookApiClient {

    @Autowired
    private FishingNotebookConfiguration fishingNotebookConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SanLeskoWaterLevel sanLeskoWaterLevel;

    public void getSanLeskoWaterLevel() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpoint() + "getSanLeskoWater")
                .build()
                .encode()
                .toUri();

        Integer levelsResponse = restTemplate.getForObject(url, Integer.TYPE);
        SanLeskoWaterLevel sanLevel = new SanLeskoWaterLevel();
        sanLevel.setSanLeskoWaterLevel(levelsResponse);
    }

    public void getDunajecKroscienkoWaterLevel() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpoint() + "getDunajecKroscienkoWater")
                .build()
                .encode()
                .toUri();

        Integer levelsResponse = restTemplate.getForObject(url, Integer.TYPE);
        DunajecKroscienkoWaterLevel dunajecKroscienkoWaterLevel = new DunajecKroscienkoWaterLevel();
        dunajecKroscienkoWaterLevel.setDunajecKroscienkoWaterLevel(levelsResponse);
    }

    public void getDunajecGolkowiceWaterLevel() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpoint() + "getDunajecGolkowiceWater")
                .build()
                .encode()
                .toUri();

        Integer levelsResponse = restTemplate.getForObject(url, Integer.TYPE);
        DunajecGolkowiceWaterLevel dunajecGolkowiceWaterLevel = new DunajecGolkowiceWaterLevel();
        dunajecGolkowiceWaterLevel.setDunajecGolkowiceWaterLevel(levelsResponse);
    }
}

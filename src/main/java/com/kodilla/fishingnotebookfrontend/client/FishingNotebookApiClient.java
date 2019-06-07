package com.kodilla.fishingnotebookfrontend.client;

import com.kodilla.fishingnotebookfrontend.configuration.FishingNotebookConfiguration;
import com.kodilla.fishingnotebookfrontend.domain.DunajecGolkowiceWaterLevel;
import com.kodilla.fishingnotebookfrontend.domain.DunajecKroscienkoWaterLevel;
import com.kodilla.fishingnotebookfrontend.domain.SanLeskoWaterLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class FishingNotebookApiClient {

    @Autowired
    private FishingNotebookConfiguration fishingNotebookConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SanLeskoWaterLevel sanLeskoWaterLevel;

    @Autowired
    DunajecKroscienkoWaterLevel dunajecKroscienkoWaterLevel;

    @Autowired
    DunajecGolkowiceWaterLevel dunajecGolkowiceWaterLevel;

    public SanLeskoWaterLevel getSanLeskoWaterLevel() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpoint() + "getSanLeskoWater")
                .build()
                .encode()
                .toUri();

        Integer levelsResponse = restTemplate.getForObject(url, Integer.TYPE);
        sanLeskoWaterLevel.setSanLeskoWaterLevel(levelsResponse);

        return sanLeskoWaterLevel;
    }

    public DunajecKroscienkoWaterLevel getDunajecKroscienkoWaterLevel() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpoint() + "getDunajecKroscienkoWater")
                .build()
                .encode()
                .toUri();

        Integer levelsResponse = restTemplate.getForObject(url, Integer.TYPE);
        dunajecKroscienkoWaterLevel.setDunajecKroscienkoWaterLevel(levelsResponse);

        return dunajecKroscienkoWaterLevel;
    }

    public DunajecGolkowiceWaterLevel getDunajecGolkowiceWaterLevel() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpoint() + "getDunajecGolkowiceWater")
                .build()
                .encode()
                .toUri();

        Integer levelsResponse = restTemplate.getForObject(url, Integer.TYPE);
        dunajecGolkowiceWaterLevel.setDunajecGolkowiceWaterLevel(levelsResponse);

        return dunajecGolkowiceWaterLevel;
    }
}

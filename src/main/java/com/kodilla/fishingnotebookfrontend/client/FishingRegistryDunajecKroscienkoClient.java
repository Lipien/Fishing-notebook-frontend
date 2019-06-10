package com.kodilla.fishingnotebookfrontend.client;

import com.kodilla.fishingnotebookfrontend.configuration.FishingNotebookConfiguration;
import com.kodilla.fishingnotebookfrontend.domain.FishingRegistryDunajecKroscienkoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FishingRegistryDunajecKroscienkoClient {

    @Autowired
    private FishingNotebookConfiguration fishingNotebookConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    public List <FishingRegistryDunajecKroscienkoDto> getDunajecKroscienkoFishingRegistry() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpointRegistry() + "getDunajecKroscienkoRegistry")
                .build()
                .encode()
                .toUri();

        FishingRegistryDunajecKroscienkoDto[] backendResponse = restTemplate.getForObject(url, FishingRegistryDunajecKroscienkoDto[].class);

        if (backendResponse != null) {
            return Arrays.asList(backendResponse);
        }
        return new ArrayList <>();
    }
}

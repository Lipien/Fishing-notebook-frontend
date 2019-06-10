package com.kodilla.fishingnotebookfrontend.client;

import com.kodilla.fishingnotebookfrontend.configuration.FishingNotebookConfiguration;
import com.kodilla.fishingnotebookfrontend.domain.FishingRegistrySanLeskoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FishingRegistrySanLeskoClient {

    @Autowired
    private FishingNotebookConfiguration fishingNotebookConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    public List <FishingRegistrySanLeskoDto> getSanLeskoFishingRegistry() {

        URI url = UriComponentsBuilder.fromHttpUrl(fishingNotebookConfiguration.getFishingNotebookApiEndpointRegistry() + "getSanLeskoRegistry")
                .build()
                .encode()
                .toUri();

        FishingRegistrySanLeskoDto[] backendResponse = restTemplate.getForObject(url, FishingRegistrySanLeskoDto[].class);

        if (backendResponse != null) {
            return Arrays.asList(backendResponse);
        }
        return new ArrayList <>();
    }
}

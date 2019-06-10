package com.kodilla.fishingnotebookfrontend.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class FishingNotebookConfiguration {

    @Value("${fishingNotebookApiEndpoint}")
    private String fishingNotebookApiEndpoint;

    @Value("${fishingNotebookApiEndpointRegistry}")
    private String fishingNotebookApiEndpointRegistry;
}

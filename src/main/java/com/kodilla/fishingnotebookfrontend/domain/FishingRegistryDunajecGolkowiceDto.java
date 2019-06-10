package com.kodilla.fishingnotebookfrontend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class FishingRegistryDunajecGolkowiceDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("catchDate")
    private String catchDate;

    @JsonProperty("fishType")
    private String fishType;

    @JsonProperty("length")
    private String length;

    @JsonProperty("qty")
    private String qty;
}

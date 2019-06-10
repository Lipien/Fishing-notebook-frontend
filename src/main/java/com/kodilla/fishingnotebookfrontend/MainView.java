package com.kodilla.fishingnotebookfrontend;

import com.kodilla.fishingnotebookfrontend.client.FishingNotebookApiClient;
import com.kodilla.fishingnotebookfrontend.domain.HydroAndWeatherReportDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@Route
@UIScope
public class MainView extends VerticalLayout {

    private FishingNotebookApiClient fishingNotebookApiClient = new FishingNotebookApiClient();

    private Grid <HydroAndWeatherReportDto> grid = new Grid <>(HydroAndWeatherReportDto.class);

    public MainView() {

        add(grid);
        setSizeFull();
        //  getReport();
    }

    public void getReport() {
        grid.setItems(fishingNotebookApiClient.getBackendConditionsReport());
    }
}

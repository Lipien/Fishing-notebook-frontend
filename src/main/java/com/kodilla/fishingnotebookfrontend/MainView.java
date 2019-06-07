package com.kodilla.fishingnotebookfrontend;

import com.kodilla.fishingnotebookfrontend.client.FishingNotebookApiClient;
import com.kodilla.fishingnotebookfrontend.domain.SanLeskoWaterLevel;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Route()
@UIScope
@Component
public class MainView extends VerticalLayout {

    @Autowired
    private FishingNotebookApiClient fishingNotebookApiClient;

    @Autowired
    private SanLeskoWaterLevel sanLeskoWaterLevel;

    public MainView() {

        Grid <SanLeskoWaterLevel> grid = new Grid <>();

        grid.addColumn((SanLeskoWaterLevel::getSanLeskoWaterLevel)).setHeader("San (Lesko)water level in cm");

        add(grid);
        setSizeFull();
        add(new Text("Vaadin with RestTemplate demo"));
        getSanLeskoWaterLevelVaadin();
    }

    public SanLeskoWaterLevel getSanLeskoWaterLevelVaadin() {
        fishingNotebookApiClient.getSanLeskoWaterLevel();
        return sanLeskoWaterLevel;
    }
}

package com.kodilla.fishingnotebookfrontend;

import com.kodilla.fishingnotebookfrontend.domain.FishingRegistryDunajecGolkowiceDto;
import com.kodilla.fishingnotebookfrontend.domain.FishingRegistryDunajecKroscienkoDto;
import com.kodilla.fishingnotebookfrontend.domain.FishingRegistrySanLeskoDto;
import com.kodilla.fishingnotebookfrontend.domain.HydroAndWeatherReportDto;
import com.kodilla.fishingnotebookfrontend.service.FishingBackendService;
import com.kodilla.fishingnotebookfrontend.service.HttpGetRequestToHydroWeatherApi;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@Route
@UIScope
@org.springframework.stereotype.Component
public class MainView extends VerticalLayout {

    private HttpGetRequestToHydroWeatherApi httpGetRequestToHydroWeatherApi = new HttpGetRequestToHydroWeatherApi();

    private FishingBackendService fishing = new FishingBackendService();

    private Grid <HydroAndWeatherReportDto> grid = new Grid <>(HydroAndWeatherReportDto.class);
    private Grid <FishingRegistrySanLeskoDto> gridLesko = new Grid <>(FishingRegistrySanLeskoDto.class);
    private Grid <FishingRegistryDunajecKroscienkoDto> gridKroscienko = new Grid <>(FishingRegistryDunajecKroscienkoDto.class);
    private Grid <FishingRegistryDunajecGolkowiceDto> gridGolkowice = new Grid <>(FishingRegistryDunajecGolkowiceDto.class);

    private TextField catchDate = new TextField("Catch date");
    private TextField fishType = new TextField("Fish type");
    private TextField id = new TextField("Id");
    private TextField length = new TextField("Length");
    private TextField qty = new TextField("Qty");

    Button createRegistryRecordButton = new Button("Register");
    Div errorLayout = new Div();

    public MainView() throws Exception {

        add(grid);
        add(new H3("Lesko fishing registry"),
                buildFormLesko(),
                gridLesko);
        add(new H3("Kroscienko fishing registry"),
                buildFormKroscienko(),
                gridKroscienko);
        add(new H3("Golkowice fishing registry"),
                buildFormGolkowice(),
                gridGolkowice);
        setSizeFull();

        //getConditionsReport();
        //getConditionsReportMainView();
    }

    public void getConditionsReport() throws Exception {
        httpGetRequestToHydroWeatherApi.sendGetToBackendHydroWeatherApi();
    }

    public void getConditionsReportMainView() {
        fishing.getImgw();
    }

    private Component buildFormLesko() {

        createRegistryRecordButton.setThemeName("primary");

        Binder <FishingRegistrySanLeskoDto> binderLesko = new Binder(FishingRegistrySanLeskoDto.class);

        HorizontalLayout formLayout = new HorizontalLayout(catchDate, fishType, id, length, qty, createRegistryRecordButton);
        Div wrapperLayout = new Div(formLayout, errorLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        return wrapperLayout;
    }

    private Component buildFormKroscienko() {

        createRegistryRecordButton.setThemeName("primary");

        Binder <FishingRegistrySanLeskoDto> binderKroscienko = new Binder(FishingRegistryDunajecKroscienkoDto.class);

        HorizontalLayout formLayout = new HorizontalLayout(catchDate, fishType, id, length, qty, createRegistryRecordButton);
        Div wrapperLayout = new Div(formLayout, errorLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        return wrapperLayout;
    }

    private Component buildFormGolkowice() {

        createRegistryRecordButton.setThemeName("primary");

        Binder <FishingRegistrySanLeskoDto> binderGolkowice = new Binder(FishingRegistryDunajecGolkowiceDto.class);

        HorizontalLayout formLayout = new HorizontalLayout(catchDate, fishType, id, length, qty, createRegistryRecordButton);
        Div wrapperLayout = new Div(formLayout, errorLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        return wrapperLayout;
    }
}

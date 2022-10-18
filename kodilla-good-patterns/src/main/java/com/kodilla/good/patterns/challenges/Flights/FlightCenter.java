package com.kodilla.good.patterns.challenges.Flights;

import java.util.List;

public class FlightCenter {
    private final FlightUserService flightUserService;
    private final FlightSearchEngine flightSearchEngine;
    private final List<String> cityList;

    public FlightCenter(FlightUserService flightUserService, FlightSearchEngine flightSearchEngine, List<String> cityList) {
        this.flightUserService = flightUserService;
        this.flightSearchEngine = flightSearchEngine;
        this.cityList = cityList;
    }

    private int startPlaceRequest() {
        return flightUserService.choseCity("Chose your start city") - 1;
    }

    private int finishPlaceRequest() {
        return flightUserService.choseCity("Chose your finish city") - 1;
    }

    private int throughPlaceRequest() {
        return flightUserService.choseCity("Chose your through city") - 1;
    }
}

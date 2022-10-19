package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.builders.Flight;

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

    public void process() {
        flightUserService.showAvailableCities(cityList);

        List<Flight> cityFlightList = foundCityInformation();
        if (!cityFlightList.isEmpty()) {
            flightUserService.showFlightInformation(cityFlightList, "Flight information for chosen city");
        } else {
            flightUserService.showNotFoundInformation();
        }

        List<Flight> travelFlightList = foundTravelInformation();
        if (travelFlightList.size() > 1) {
            flightUserService.showFlightInformation(travelFlightList, "Flight information for chosen travel");
        } else {
            flightUserService.showNotFoundInformation();
        }
    }

    private List<Flight> foundCityInformation() {
        String city = cityList.get(flightUserService.choseCity("For which city you want to see all flight "));
        return flightSearchEngine.searchCity(city);
    }

    private List<Flight> foundTravelInformation() {
        String startCity = cityList.get(flightUserService.choseCity("Chose your travel \nChose your start city "));
        String middleCity = cityList.get(flightUserService.choseCity("Chose your middle city "));
        String finishCity = cityList.get(flightUserService.choseCity("Chose your finish city "));

        return flightSearchEngine.advancedSearch(startCity, middleCity, finishCity);
    }
}
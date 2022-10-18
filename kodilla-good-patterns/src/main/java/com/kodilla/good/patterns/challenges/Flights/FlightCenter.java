package com.kodilla.good.patterns.challenges.Flights;

import com.kodilla.good.patterns.challenges.Flights.builders.Flight;
import com.kodilla.good.patterns.challenges.Flights.builders.FlightDto;

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

    public void sequence() {
        flightUserService.showAvailableCities();
        int chose = flightUserService.choseSearchMode();

        if (chose == 1) {
            int city = flightUserService.choseCity("For which you want to see all flight ") - 1;
            cityFlightInformation(cityList.get(city));

        } else {
            int startCity = flightUserService.choseCity("Chose your start city") - 1;
            int finishCity = flightUserService.choseCity("Chose your finish city") - 1;
            List<FlightDto> flightDtoList = flightSearchEngine.advancedSearch(cityList.get(startCity), cityList.get(finishCity));
            List<Flight> flightList = flightSearchEngine.search(cityList.get(startCity), cityList.get(finishCity));

        }
    }

    private void cityFlightInformation(String city) {
        List<Flight> cityFlightList = flightSearchEngine.searchFrom(city);
        cityFlightList.addAll(flightSearchEngine.searchTo(city));
        cityFlightList.stream().forEach(System.out::println);
    }
}

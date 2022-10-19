package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.interfaces.SearchEngine;
import com.kodilla.good.patterns.challenges.flights.builders.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchEngine implements SearchEngine {
    private final List<Flight> flightList;

    public FlightSearchEngine(List<Flight> flightList) {
        this.flightList = flightList;
    }
    
    @Override
    public List<Flight> searchCity(String base) {
        List<Flight> foundFlights = flightList.stream()
                .filter(flight -> flight.getDestination().equals(base) || flight.getBaseLocation().equals(base))
                .collect(Collectors.toList());

        return foundFlights;
    }

    @Override
    public List<Flight> advancedSearch(String base, String middle, String destination) {
        List<Flight> foundFlights = flightList.stream()
                .filter(flight -> flight.getBaseLocation().equals(base) && flight.getDestination().equals(middle))
                .collect(Collectors.toList());

        foundFlights.addAll(flightList.stream()
                .filter(flight -> flight.getBaseLocation().equals(middle) && flight.getDestination().equals(destination))
                .toList());

        return foundFlights;
    }
}

package com.kodilla.good.patterns.challenges.Flights;

import com.kodilla.good.patterns.challenges.Flights.Interfaces.SearchEngine;
import com.kodilla.good.patterns.challenges.Flights.builders.Flight;
import com.kodilla.good.patterns.challenges.Flights.builders.FlightDto;

import java.util.ArrayList;
import java.util.List;

public class FlightSearchEngine implements SearchEngine {
    private final List<Flight> flightList;

    public FlightSearchEngine(List<Flight> flightList) {
        this.flightList = flightList;
    }
    
    @Override
    public List<Flight> searchFrom(String base) {
        List<Flight> foundFlights = new ArrayList<>();
        
        for (Flight flight : flightList) {
            if (flight.getBaseLocation().equals(base)) foundFlights.add(flight);
        }

        return foundFlights;
    }

    @Override
    public List<Flight> searchTo(String destination) {
        List<Flight> foundFlights = new ArrayList<>();

        for (Flight flight : flightList) {
            if (flight.getDestination().equals(destination)) foundFlights.add(flight);
        }

        return foundFlights;
    }

    @Override
    public List<FlightDto> advancedSearch(String base, String destination, String middle) {
        List<FlightDto> foundFlights = new ArrayList<>();
        Flight startingFlight = new Flight(base, middle);
        Flight finishFlight = new Flight(middle, destination);

        for (Flight flight : flightList) {
            if (flight.equals(startingFlight)) {
                for (Flight anotherFlight : flightList) {
                    if (flight.equals(finishFlight)) foundFlights.add(new FlightDto(flight, anotherFlight));
                }
            }
        }

        return foundFlights;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}

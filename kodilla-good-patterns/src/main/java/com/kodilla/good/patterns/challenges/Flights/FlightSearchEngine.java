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
    public List<Flight> search(String base, String destination) {
        List<Flight> foundFlights = new ArrayList<>();
        Flight lookingFlight = new Flight(base, destination);

        for (Flight flight : flightList) {
            if (flight.equals(lookingFlight)) foundFlights.add(flight);
        }

        return foundFlights;
    }

    @Override
    public List<FlightDto> advancedSearch(String base, String destination) {
        List<FlightDto> foundFlights = new ArrayList<>();

        for (Flight startFlight : flightList) {
            if (startFlight.getBaseLocation().equals(base)) {
                for (Flight finishFlight : flightList) {
                    if (finishFlight.getDestination().equals(destination)) foundFlights.add(new FlightDto(startFlight, finishFlight));
                }
            }
        }
        return foundFlights;
    }
}

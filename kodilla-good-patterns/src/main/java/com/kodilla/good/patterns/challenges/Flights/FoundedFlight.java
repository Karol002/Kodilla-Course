package com.kodilla.good.patterns.challenges.Flights;

import com.kodilla.good.patterns.challenges.Flights.builders.Flight;
import com.kodilla.good.patterns.challenges.Flights.builders.FlightDto;

import java.util.List;

public class FoundedFlight {
    private final List<Flight> flightList;
    private final List<FlightDto> flightDtoList;

    private final List<Flight> cityFlightList;

    public FoundedFlight(List<Flight> flightList, List<FlightDto> flightDtoList, List<Flight> cityFlightList) {
        this.flightList = flightList;
        this.flightDtoList = flightDtoList;
        this.cityFlightList = cityFlightList;
    }

    @Override
    public String toString() {
        return "Information about flight in city \n" + cityFlightList + "\n"
                + "Founded flight: \n" + flightList + "\n" + flightDtoList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public List<FlightDto> getFlightDtoList() {
        return flightDtoList;
    }

    public List<Flight> getCityFlightList() {
        return cityFlightList;
    }
}

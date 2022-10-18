package com.kodilla.good.patterns.challenges.Flights;

import com.kodilla.good.patterns.challenges.Flights.builders.Flight;
import com.kodilla.good.patterns.challenges.Flights.builders.FlightDto;

import java.util.List;
import java.util.Scanner;

public class FlightUserService {
    private final Scanner scanner = new Scanner(System.in);

    public void showAvailableCities() {
        System.out.println("""
                Available cities:
                1. Wrocław
                2. Warszawa
                3. Gdańsk
                4. Gdynia""");
    }

    public int choseCity(String text) {
        System.out.print("text");
        return scanner.nextInt();
    }


    public void showFoundFlightsTo(List<Flight> flightList) {
        System.out.println("Found flights to " + flightList.get(0).getDestination());
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }

    public void showFoundFlightsForm(List<Flight> flightList) {
        System.out.println("Found flights from " + flightList.get(0).getBaseLocation());
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }

    public void showFoundFlightsThrough(List<FlightDto> flightDtoList) {
        System.out.println("Found flights through " + flightDtoList.get(0).getStartFlight().getDestination());
        for (FlightDto flightDto : flightDtoList) {
            System.out.println(flightDto);
        }
    }
}

package com.kodilla.good.patterns.challenges.flights;

import com.kodilla.good.patterns.challenges.flights.builders.Flight;

import java.util.List;
import java.util.Scanner;

public class FlightUserService {
    private final Scanner scanner = new Scanner(System.in);

    public void showAvailableCities(List<String> cityList) {
        System.out.println("Available cities: ");
        for (int i=0; i<cityList.size(); i++) {
            System.out.println((i + 1) +  ". " + cityList.get(i));
        }
        System.out.println();
    }

    public int choseCity(String informationText) {
        System.out.print(informationText);
        return scanner.nextInt() - 1;
    }

    public void showNotFoundInformation() {
        System.out.println("We have not found what you looking");
    }

    public void showFlightInformation(List<Flight> flightList, String infoText) {
        System.out.println(infoText);
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
        System.out.println();
    }
}

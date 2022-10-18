package com.kodilla.good.patterns.challenges.Flights.builders;

import java.util.ArrayList;
import java.util.List;

public class FlightRetriever {

    public List<Flight> retrieve() {
        Flight flight1 = new Flight("Wrocław", "Gdańsk");
        Flight flight2 = new Flight("Gdańsk", "Wrocław");
        Flight flight3 = new Flight("Gdańsk", "Warszawa");
        Flight flight4 = new Flight("Wrocław", "Gdynia");
        Flight flight5 = new Flight("Warszawa", "Wrocław");
        Flight flight6 = new Flight("Gdynia", "Gdańsk");

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);
        flightList.add(flight6);

        return flightList;
    }

    public List<String> retrieveCities() {
        List<String> cities = new ArrayList<>();
        cities.add("Wrocław");
        cities.add("Warszawa");
        cities.add("Gdańsk");
        cities.add("Gdynia");

        return cities;
    }
}

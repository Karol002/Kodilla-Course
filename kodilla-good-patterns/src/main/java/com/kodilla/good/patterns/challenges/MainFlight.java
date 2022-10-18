package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.Flights.FlightCenter;
import com.kodilla.good.patterns.challenges.Flights.FlightSearchEngine;
import com.kodilla.good.patterns.challenges.Flights.FlightUserService;
import com.kodilla.good.patterns.challenges.Flights.builders.FlightRetriever;

public class MainFlight {

    public static void main(String [] args) {

        FlightRetriever flightRetriever = new FlightRetriever();
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine(flightRetriever.retrieve());

        FlightCenter flightCenter = new FlightCenter(new FlightUserService(), flightSearchEngine, flightRetriever.retrieveCities());
        flightCenter.sequence();
    }
}

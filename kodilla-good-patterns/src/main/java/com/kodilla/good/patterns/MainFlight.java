package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.flights.FlightCenter;
import com.kodilla.good.patterns.challenges.flights.FlightSearchEngine;
import com.kodilla.good.patterns.challenges.flights.FlightUserService;
import com.kodilla.good.patterns.challenges.flights.builders.FlightRetriever;

public class MainFlight {

    public static void main(String [] args) {

        FlightRetriever flightRetriever = new FlightRetriever();
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine(flightRetriever.retrieve());

        FlightCenter flightCenter = new FlightCenter(new FlightUserService(), flightSearchEngine, flightRetriever.retrieveCities());
        flightCenter.process();
    }
}

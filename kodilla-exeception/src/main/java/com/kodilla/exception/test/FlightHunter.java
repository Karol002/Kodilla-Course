package com.kodilla.exception.test;

import java.security.KeyException;
import java.util.HashMap;
import java.util.Map;

public class FlightHunter {
    Map<String, Boolean> airPortMap = new HashMap<>();

    public FlightHunter() {
        airPortMap.put("Wrocław", true);
        airPortMap.put("Warszawa", false);
        airPortMap.put("Gdańsk", true);
        airPortMap.put("Kraków", true);
        airPortMap.put("Poznań", true);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Boolean arrivalAirport = airPortMap.get(flight.getArrivalAirport());
        Boolean departureAirport = airPortMap.get(flight.getDepartureAirport());

        if (arrivalAirport == null || departureAirport == null) {
            throw new RouteNotFoundException();
        } else {
            return arrivalAirport && departureAirport;
        }
    }
}

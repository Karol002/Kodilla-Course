package com.kodilla.exception.test;

public class FlightHunterRunner {

    public static void main(String[] args) {
        FlightHunter flightHunter = new FlightHunter();
        Flight existFlight = new Flight("Wrocław", "Gdańsk");
        Flight unExistFlight = new Flight("Wrocław", "Warszawa");
        Flight unExistAirport = new Flight("Wrocław", "Opole");


        try {
            if (flightHunter.findFlight(existFlight)) {
                System.out.println("Flight exist");
            } else {
                System.out.println("Flight doesn't exist");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Airport doesn't exist");
        } finally {
            System.out.println("Searching done! \n");
        }

        try {
            if (flightHunter.findFlight(unExistFlight)) {
                System.out.println("Flight exist");
            } else {
                System.out.println("Flight doesn't exist");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Airport doesn't exist");
        } finally {
            System.out.println("Searching done! \n");
        }

        try {
            if (flightHunter.findFlight(unExistAirport)) {
                System.out.println("Flight exist");
            } else {
                System.out.println("Flight doesn't exist");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Airport doesn't exist");
        } finally {
            System.out.println("Searching done! \n");
        }
    }
}

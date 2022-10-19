package com.kodilla.good.patterns.challenges.flights.builders;

public class Flight {
    private final String baseLocation;
    private final String destination;


    public Flight(String baseLocation, String destination) {
        this.baseLocation = baseLocation;
        this.destination = destination;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;

        if (!getBaseLocation().equals(flight.getBaseLocation())) return false;
        return getDestination().equals(flight.getDestination());
    }

    @Override
    public int hashCode() {
        int result = getBaseLocation().hashCode();
        result = 31 * result + getDestination().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight form " + baseLocation + " to " + destination;
    }
}

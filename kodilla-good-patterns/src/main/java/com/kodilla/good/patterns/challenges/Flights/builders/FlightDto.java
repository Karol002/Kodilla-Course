package com.kodilla.good.patterns.challenges.Flights.builders;

public class FlightDto {
    private final Flight startFlight;
    private final Flight finishFlight;

    public FlightDto(Flight startFlight, Flight finishFlight) {
        this.startFlight = startFlight;
        this.finishFlight = finishFlight;
    }

    public Flight getStartFlight() {
        return startFlight;
    }

    public Flight getFinishFlight() {
        return finishFlight;
    }

    @Override
    public String toString() {
        return "startFlight=" + startFlight + "\n" +
                "finishFlight=" + finishFlight;
    }
}

package com.kodilla.good.patterns.challenges.skyscanner;

public class FlightRequest {
    private final AirportService airportStart;
    private final AirportService airportFinish;
    private final int function;

    public FlightRequest(AirportService airportStart, AirportService airportFinish,int function) {
        this.airportStart = airportStart;
        this.airportFinish = airportFinish;
        this.function = function;
    }

    public AirportService getAirportStart() {

        return airportStart;
    }

    public AirportService getAirportFinish() {

        return airportFinish;
    }

    public int getFunction() {

        return function;
    }
}

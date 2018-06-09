package com.kodilla.good.patterns.challenges.skyscanner;

import java.time.LocalDateTime;

public class AirportService {
    private final String airportLocation;
    private final LocalDateTime localDateTime;

    public AirportService(String airportLocation, LocalDateTime localDateTime) {
        this.airportLocation = airportLocation;
        this.localDateTime = localDateTime;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return  airportLocation + " " + localDateTime;
    }
}



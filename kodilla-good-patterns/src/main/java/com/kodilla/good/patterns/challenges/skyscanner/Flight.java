package com.kodilla.good.patterns.challenges.skyscanner;

import java.util.Objects;

public class Flight {
    private final int flightId;
    private final AirportService airportFrom;
    private final AirportService airportTo;
    private final double flightPrice;

    public Flight(int flightId, AirportService airportFrom, AirportService airpottTo, double flightPrice) {
        this.flightId = flightId;
        this.airportFrom = airportFrom;
        this.airportTo = airpottTo;
        this.flightPrice = flightPrice;
    }

    public int getFlightId() {

        return flightId;
    }

    public AirportService getAirportFrom() {

        return airportFrom;
    }

    public AirportService getAirportTo() {

        return airportTo;
    }

    public double getFlightPrice() {

        return flightPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId &&
                Double.compare(flight.flightPrice, flightPrice) == 0 &&
                Objects.equals(airportFrom, flight.airportFrom) &&
                Objects.equals(airportTo, flight.airportTo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flightId, airportFrom, airportTo, flightPrice);
    }

    @Override
    public String toString() {

        return "FROM " + airportFrom.toString() + " TO " + airportTo.toString() + " PRICE: " + flightPrice;
    }
}

package com.kodilla.good.patterns.challenges.skyscanner;

import java.util.Objects;

public class Flight {
    private final int flightId;
    private final String airportFrom;
    private final String airportTo;
    private final double flightPrice;

    public Flight(int flightId, String airportFrom, String airpottTo, double flightPrice) {
        this.flightId = flightId;
        this.airportFrom = airportFrom;
        this.airportTo = airpottTo;
        this.flightPrice = flightPrice;
    }

    public int getFlightId() {

        return flightId;
    }

    public String getAirportFrom() {

        return airportFrom;
    }

    public String getAirportTo() {

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
        return "Flight{" +
                "flightId=" + flightId +
                ", airportFrom='" + airportFrom + '\'' +
                ", airportTo='" + airportTo + '\'' +
                ", flightPrice=" + flightPrice +
                '}';
    }
}

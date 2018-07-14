package com.kodilla.good.patterns.challenges.skyscanner;

import java.util.ArrayList;
import java.util.List;

public class FlightsDatabaseStub implements FlightsDatabase {
    @Override
    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(1, "Heatrow", "Paris-CDG"));
        flights.add(new Flight(2, "Amsterdam", "Heatrow"));
        flights.add(new Flight(3, "Frankfurt", "Heatrow"));
        flights.add(new Flight(4, "Heatrow", "Dubaj"));
        flights.add(new Flight(5, "Dubaj", "Tokio"));
        flights.add(new Flight(6, "Dubaj", "Sydney"));
        flights.add(new Flight(7, "Dubaj", "Pekin"));
        return flights;
    }
}

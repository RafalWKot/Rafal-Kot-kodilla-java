package com.kodilla.good.patterns.challenges.skyscanner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsDatebase {

    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight(1,
                new AirportService("Heathrow", LocalDateTime.of(2018, 6, 5, 11, 15)),
                new AirportService("Paris-CDG", LocalDateTime.of(2018, 6, 5, 12, 30)),
                150)
        );

        flights.add(new Flight(2,
                new AirportService("Amsterdam", LocalDateTime.of(2018, 6, 6, 17, 45)),
                new AirportService("Heathrow", LocalDateTime.of(2018, 6, 6, 18, 55)),
                125));

        flights.add(new Flight(3,
                new AirportService("Frankfurt", LocalDateTime.of(2018, 6, 6, 17, 45)),
                new AirportService("Heathrow", LocalDateTime.of(2018, 6, 6, 18, 55)),
                125));

        flights.add(new Flight(4,
                new AirportService("Heathrow", LocalDateTime.of(2018, 6, 9, 23, 45)),
                new AirportService("Dubaj", LocalDateTime.of(2018, 6, 10, 6, 25)),
                325));

        flights.add(new Flight(5,
                new AirportService("Dubaj", LocalDateTime.of(2018, 6, 10, 13, 25)),
                new AirportService("Tokio", LocalDateTime.of(2018, 6, 10, 21, 10)),
                555));

        return flights;
    }
}

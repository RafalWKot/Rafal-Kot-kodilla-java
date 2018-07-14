package com.kodilla.good.patterns.challenges.skyscanner;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsService {

    private FlightsDatabase flightsDatabase;

    public FlightsService(FlightsDatabase flightsDatabase) {
        this.flightsDatabase = flightsDatabase;
    }

    public List<Flight> flightsFrom(String airportFrom){
        return flightsDatabase.getFlights().stream()
                .filter(t -> t.getAirportFrom().equals(airportFrom))
                .collect(Collectors.toList());
    }

    public List<Flight> flightsTo(String airportTo){
        return flightsDatabase.getFlights().stream()
                .filter(t -> t.getAirportTo().equals(airportTo))
                .collect(Collectors.toList());
    }

    public List<Flight> connectingFlightsThrough(String airportVia) {
        List<String> airportViaEnd = flightsDatabase.getFlights().stream()
                .filter(t -> t.getAirportTo().equals(airportVia))
                .map(t -> t.getAirportFrom())
                .collect(Collectors.toList());
        List<String> airportViaStart = flightsDatabase.getFlights().stream()
                .filter(t -> t.getAirportFrom().equals(airportVia))
                .map(t -> t.getAirportTo())
                .collect(Collectors.toList());

        List<Flight> flightsViaAirport = new ArrayList<>();

        for(String airportStart : airportViaEnd) {
            for (String airportEnd : airportViaStart) {
                flightsViaAirport.add(new Flight(0, airportStart, airportEnd ));
            }
        }
        return flightsViaAirport;
    }
}

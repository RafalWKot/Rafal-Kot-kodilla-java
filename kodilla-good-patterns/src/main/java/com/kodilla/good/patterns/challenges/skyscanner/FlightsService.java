package com.kodilla.good.patterns.challenges.skyscanner;


import java.util.List;

public class FlightsService {

    public void process(FlightsDatebase flightsDatebase, FlightRequest flightRequest) {

        if (flightRequest.getFunction() == 1) {
            flightsDatebase.getFlights().stream()
                    .filter(t -> t.getAirportFrom().getAirportLocation().equals(flightRequest.getAirportStart().getAirportLocation()))
                    .forEach(System.out::println);
        } else if (flightRequest.getFunction() == 2) {
            flightsDatebase.getFlights().stream()
                    .filter(t -> t.getAirportTo().getAirportLocation().equals(flightRequest.getAirportFinish().getAirportLocation()))
                    .forEach(System.out::println);
        } else {
            flightsDatebase.getFlights().stream()
                    .filter(t ->  t.getAirportTo().getAirportLocation().equals(flightRequest.getAirportFinish().getAirportLocation())
                                || t.getAirportFrom().getAirportLocation().equals(flightRequest.getAirportFinish().getAirportLocation()))
                    .forEach(System.out::println);
        }
    }
}

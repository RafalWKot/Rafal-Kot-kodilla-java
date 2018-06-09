package com.kodilla.good.patterns.challenges.skyscanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to the skyscanner application");

        FlightRequestRetriever flightRequestRetriever = new FlightRequestRetriever();

        FlightsDatebase flightsDatebase = new FlightsDatebase();

        FlightsService flightsServiceFrom = new FlightsService();
        flightsServiceFrom.process(flightsDatebase, flightRequestRetriever.retrieve());

    }
}

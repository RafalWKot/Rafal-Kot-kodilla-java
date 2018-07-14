package com.kodilla.good.patterns.challenges.skyscanner;

import org.junit.Assert;
import org.junit.Test;

public class FlightServiceTestSuite {

    @Test
    public void testFlightsFrom() {
        //Given
        FlightsDatabase flightsDatabase = new FlightsDatabaseStub();
        FlightsService flightsService = new FlightsService(flightsDatabase);
        //When
        int numberOfFlightsFrom = flightsService.flightsFrom("Heatrow").size();
        //Then
        Assert.assertEquals(2, numberOfFlightsFrom);
    }

    @Test
    public void testFlightsTo() {
        //Given
        FlightsDatabase flightsDatabase = new FlightsDatabaseStub();
        FlightsService flightsService = new FlightsService(flightsDatabase);
        //When
        int numberOfFlightsTo = flightsService.flightsTo("Heatrow").size();
        //Then
        Assert.assertEquals(2, numberOfFlightsTo);
    }

    @Test
    public void testConnectingFlightsThrough() {
        //Given
        FlightsDatabase flightsDatabase = new FlightsDatabaseStub();
        FlightsService flightsService = new FlightsService(flightsDatabase);
        //When
        int numberOfFlightsThrough = flightsService.connectingFlightsThrough("Dubaj").size();
        //Then
        Assert.assertEquals(3, numberOfFlightsThrough);
    }
}

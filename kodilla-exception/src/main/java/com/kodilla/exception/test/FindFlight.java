package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindFlight {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportsMap = new HashMap<>();
        airportsMap.put("Heathrow", true);
        airportsMap.put("Denver", false);

        if(!airportsMap.containsKey(flight.getArrivalAirport())) throw new RouteNotFoundException("No airport in the base");
        if(airportsMap.get(flight.getArrivalAirport())) return true;
        return false;
    }

    public static void main(String[] args) {
        Flight flight = new Flight("Miami", "Chicago-O’Hare");

        try {
            if(new FindFlight().findFlight(flight)) {
                System.out.println("The flight is possible");
            }
            else {
                System.out.println("The flight is not possible");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("No destination airport");
        } finally {
            System.out.println("Thank you, welcome again!");
        }

    }
}

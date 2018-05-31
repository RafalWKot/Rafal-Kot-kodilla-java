package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindFlight {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportsMap = new HashMap<>();
        airportsMap.put("Heathrow", true);
        airportsMap.put("Denver", false);

        boolean result = false;
        boolean status = true;

        System.out.println(airportsMap.get(flight.getArrivalAirport()));
        System.out.println(airportsMap.containsKey(flight.getArrivalAirport()));
        /*
        for (Map.Entry<String, Boolean> entry: airportsMap.entrySet()) {
            if(flight.getArrivalAirport().equals(entry.getKey())) {
                if ( entry.getValue()) result = true;
                status = false;
            }
        }
        if(status) throw new RouteNotFoundException("No airport in the base");
        */
        return result;
    }

    public static void main(String[] args) {
        Flight flight = new Flight("Miami", "Chicago-O’Hare");
        //Flight flight = new Flight("Miami", "Heathrow");
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

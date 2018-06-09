package com.kodilla.good.patterns.challenges.skyscanner;

import java.time.LocalDateTime;
import java.util.Scanner;

public class FlightRequestRetriever {

    public FlightRequest retrieve() {

        System.out.println("Option to choose: ");
        System.out.println("1 - all flights from departure city");
        System.out.println("2 - all flights to arrival city");
        System.out.println("3 or other - multi-city");

        Scanner choice = new Scanner(System.in);
        int choiceINT = choice.nextInt();

        if(choiceINT == 1) {
            System.out.println("Write departure city: ");
            Scanner city = new Scanner(System.in);

            FlightRequest flightRequest = new FlightRequest(
                    new AirportService(city.nextLine(), LocalDateTime.of(2018, 6, 5, 9, 0)), null, 1);
            city.close();
            choice.close();
            return  flightRequest;
        } else if (choiceINT == 2) {
            System.out.println("Write arrival city: ");
            Scanner city = new Scanner(System.in);

            FlightRequest flightRequest = new FlightRequest(null,
                    new AirportService( city.nextLine(), LocalDateTime.of(2018, 6, 5, 9, 0)), 2);
            city.close();
            choice.close();
            return  flightRequest;
        } else {
            System.out.println("Write stopover city: ");
            Scanner city = new Scanner(System.in);

            FlightRequest flightRequest = new FlightRequest(null,
                    new AirportService( city.nextLine(), LocalDateTime.of(2018, 6, 5, 9, 0)), 3);
            city.close();
            choice.close();
            return  flightRequest;
        }
    }
}

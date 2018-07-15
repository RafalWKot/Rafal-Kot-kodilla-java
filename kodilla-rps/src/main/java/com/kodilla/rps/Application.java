package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("RPS 1.0");
        System.out.println("Podaj swoje imię: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("\nWitaj " + name + " w grze RPS");

        List<Game> games = new ArrayList<>();
        List<Configuration> configurations = new ArrayList<>();
        configurations.add(new ConfigurationRPS());

        boolean end = false;
        while(!end) {
            System.out.println("Jaki wariant gry chcesz wybrać. (naciśnij odpowiedni numer)");
            for(int i = 0; i < configurations.size(); i++) {
                System.out.print(i + 1);
                System.out.print(". ");
                System.out.println(configurations.get(i).getGameName());
            }

            System.out.println("\nTwój wybór: ");
            int choice = scanner.nextInt();
            System.out.println("\n");
            System.out.println(configurations.get(choice - 1).getDescription());
            games.add(new Game(configurations.get(choice - 1)));
            games.get(games.size() - 1).runGame();

            System.out.println("Czy chcesz zagrać jeszcze raz. (1 - tak, 2 - nie)");
            if(scanner.nextInt() == 2) {
                end = true;
            }
        }

    }
}

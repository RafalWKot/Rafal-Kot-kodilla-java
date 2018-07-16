package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Configuration configuration;
    private int quantityOfRounds;
    private List<Round> moves = new ArrayList<>();
    private int humanPoints;
    private int computerPoints;

    public Game(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public int getQuantityOfRounds() {
        return quantityOfRounds;
    }

    public List<Round> getMoves() {
        return moves;
    }

    public int getHumanPoints() {
        return humanPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public void setHumanPoints(int humanPoints) {
        this.humanPoints = humanPoints;
    }

    public void setComputerPoints(int computerPoints) {
        this.computerPoints = computerPoints;
    }

    public void runGame() {
        System.out.println("Ile rund na grę? (podaj liczbę)");
        Scanner scanner = new Scanner(System.in);
        quantityOfRounds = scanner.nextInt();

        for(int i = 0; i < this.getQuantityOfRounds(); i++) {
            Round round = new Round(getConfiguration());

            System.out.print("Runda  ");
            System.out.println(i + 1);
            round.runRound();
            addPoint(round);
            moves.add(round);
            if(i < this.getQuantityOfRounds() - 1) {
                System.out.println("Bieżący wynik --> Ty: " + getHumanPoints() + " Computer: " + getComputerPoints() + "\n");
            }
            else {
                System.out.println("Ostateczny wynik --> Ty: " + getHumanPoints() + " Computer: " + getComputerPoints());
                if(getHumanPoints() > getComputerPoints()) {
                    System.out.println("\nGRATULUJE ZWYCIĘSTWA !!!");
                }
                else {
                    System.out.println("\nNIE MARTW SIĘ NASTĘPNYM RAZEM BĘDZIE LEPIEJ.\n");
                }
            }
        }
    }

    public void addPoint(Round round) {
        if(round.getResult().equals("WYGRALES")) {
            setHumanPoints(getHumanPoints() + 1);
        } else if (round.getResult().equals("PRZEGRALES")) {
            setComputerPoints(getComputerPoints() + 1);
        } else {}
    }
}

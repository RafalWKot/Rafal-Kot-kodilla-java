package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Configuration configuration;
    private int quantityOfRounds;
    private List<Round> moves = new ArrayList<>();

    public Game(Configuration configuration) {
        this.configuration = configuration;
        this.quantityOfRounds = quantityOfRounds;
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

    public void runGame() {
        System.out.println("Ile rund na grę? (podaj liczbę)");
        Scanner scanner = new Scanner(System.in);
        quantityOfRounds = scanner.nextInt();

        for(int i = 0; i < this.getQuantityOfRounds(); i++) {
            Round round = new Round(getConfiguration());

            System.out.print("Runda  ");
            System.out.println(i + 1);
            round.runRound();;
            moves.add(round);
        }
    }
}

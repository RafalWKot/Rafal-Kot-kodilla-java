package com.kodilla.rps;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Round {
    private Configuration configuration;
    private String result;
    private Move humanMove;
    private Move computerMove;

    public Round(Configuration configuration) {
        this.configuration = configuration;
    }
    public String getResult() {
        return result;
    }

    public Move getHumanMove() {
        return humanMove;
    }

    public Move getComputerMove() {
        return computerMove;
    }

    public void setHumanMove(Move humanMove) {
        this.humanMove = humanMove;
    }

    public void setComputerMove(Move computerMove) {
        this.computerMove = computerMove;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return Objects.equals(result, round.result) &&
                Objects.equals(humanMove, round.humanMove) &&
                Objects.equals(computerMove, round.computerMove);
    }

    @Override
    public int hashCode() {

        return Objects.hash(result, humanMove, computerMove);
    }

    public void runRound() {
        System.out.println("Wybierz symbol: (wybierz numer)");
        for (int j = 0; j < configuration.getPossibleMoves().size(); j++) {
            System.out.print(j + 1);
            System.out.println(" " + configuration.getPossibleMoves().get(j).getMoveName());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTwój symbol :");
        int choice = scanner.nextInt();

        setHumanMove(configuration.getPossibleMoves().get(choice - 1));
        randComputerMove();
        System.out.print("\nTy wybrales: " + getHumanMove().getMoveName() + " - Komputer wybral: " + getComputerMove().getMoveName() );
        setResult(fight());
        System.out.println(" --> " + getResult());
    }

    public String fight() {
        if(humanMove.equals(computerMove)) {
            return "REMIS";
        }
        else if (humanMove.getWinWith().contains(computerMove.getMoveName()))
        {
            return "WYGRALES";
        }
        else {
            return "PRZEGRALES";
        }
    }

    public void randComputerMove() {
        Random random = new Random();
        setComputerMove(configuration.getPossibleMoves().get(random.nextInt(3)));
    }
}

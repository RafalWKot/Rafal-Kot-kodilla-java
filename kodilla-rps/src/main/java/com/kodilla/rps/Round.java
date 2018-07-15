package com.kodilla.rps;

import java.util.Objects;

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
            System.out.println(" " + configuration.getPossibleMoves().get(j).moveName);
        }
    }

    public String fight() {
        if(humanMove.equals(computerMove)) {
            return "draw";
        }
        else if (humanMove.getWinWith().contains(computerMove))
        {
            return "win";
        }
        return "lose";
    }
}

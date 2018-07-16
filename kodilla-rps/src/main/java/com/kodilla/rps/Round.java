package com.kodilla.rps;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.Scanner;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Round {
    private final Configuration configuration;
    private String result;
    private Move humanMove;
    private Move computerMove;

    public void setHumanMove(Move humanMove) {
        this.humanMove = humanMove;
    }

    public void setComputerMove(Move computerMove) {
        this.computerMove = computerMove;
    }
    public void setResult(String result) {
        this.result = result;
    }


    public void runRound() {
        System.out.println("Wybierz symbol: (wybierz odpowiedninumer)");

        for (int j = 0; j < configuration.getPossibleMoves().size(); j++) {
            System.out.println(j + 1 +" " + configuration.getPossibleMoves().get(j).getMoveName());
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

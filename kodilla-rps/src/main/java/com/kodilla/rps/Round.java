package com.kodilla.rps;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class Round {
    private final Configuration configuration;
    @Setter private String result;
    @Setter private Move humanMove;
    @Setter private Move computerMove;

    private void humanMove() {
        System.out.println("Wybierz symbol: ");
        for (int j = 0; j < configuration.getPossibleMoves().size(); j++) {
            System.out.println(j + 1 +" "+ configuration.getPossibleMoves().get(j).getMoveName());
        }
        System.out.println("\nTwój symbol :");
        Scanner scanner = new Scanner(System.in);
        setHumanMove(configuration.getPossibleMoves().get(scanner.nextInt() - 1));
    }

    private void computerMove() {
        Random random = new Random();
        setComputerMove(configuration.getPossibleMoves().get(random.nextInt(getConfiguration().getPossibleMoves().size())));
    }

    private String fight() {
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
    public void runRound() {
        humanMove();
        computerMove();
        System.out.print("\nTy wybrales: " + humanMove.getMoveName() + " - Komputer wybral: " + computerMove.getMoveName() );
        setResult(fight());
        System.out.println(" --> " + result);
    }
}

package com.kodilla.rps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
@Getter
public class Game {
    private final Configuration configuration;
    private int quantityOfRounds;
    private List<Round> rounds = new ArrayList<>();
    @Setter private int humanPoints;
    @Setter private int computerPoints;

    private void setQuantityOfRounds() {
        System.out.println("Ile rund na grę?");
        Scanner scanner = new Scanner(System.in);
        quantityOfRounds = scanner.nextInt();
    }

    private void addPoint(Round round) {
        if(round.getResult().equals("WYGRALES")) {
            setHumanPoints(getHumanPoints() + 1);
        } else if (round.getResult().equals("PRZEGRALES")) {
            setComputerPoints(getComputerPoints() + 1);
        } else {}
    }

    private void printResult(int i) {
        if(i < quantityOfRounds - 1) {
            System.out.println("Bieżący wynik --> " + toString() + "\n");
        }
        else {
            System.out.println("Ostateczny wynik --> " + toString());
            if(humanPoints > computerPoints) {
                System.out.println("\nGRATULUJE ZWYCIĘSTWA !!!");
            }
            else {
                System.out.println("\nNIESTETY NIE WYGRAŁEŚ. NIE MARTW SIĘ NASTĘPNYM RAZEM BĘDZIE LEPIEJ.\n");
            }
        }
    }

    @Override
    public String toString() {
        return  "Rund " + quantityOfRounds +
                " TY = " + humanPoints +
                " vs COMPUTER  = " + computerPoints;
    }

    public void runGame() {
        setQuantityOfRounds();
        for(int i = 0; i < this.getQuantityOfRounds(); i++) {
            System.out.print("Runda  ");
            System.out.println(i + 1);
            rounds.add(new Round(configuration));
            rounds.get(i).runRound();
            addPoint(rounds.get(i));
            printResult(i);
        }
    }
}

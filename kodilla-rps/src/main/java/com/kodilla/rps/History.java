package com.kodilla.rps;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class History {
    private List<Game> games;

    public void printHistoryOfGames() {
        System.out.println("Historia twoich gier:");
        for(int i = 1; i < games.size() + 1; i++) {
            System.out.println("Gra " + i +" "+" Rund " + getGames().get(i - 1).getRounds().size() + " " + getGames().get(i - 1).toString());
        }
    }
}
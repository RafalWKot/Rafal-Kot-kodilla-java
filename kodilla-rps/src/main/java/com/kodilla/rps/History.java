package com.kodilla.rps;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
@Getter
public class History {
    private List<Game> games;

    public void printHistoryOfGames() {
        System.out.println("Historia twoich gier:");
        IntStream.range(0, games.size()).forEach(i -> System.out.println("Gra " + i + 1 + " " + getGames().get(i).toString()));
    }
}
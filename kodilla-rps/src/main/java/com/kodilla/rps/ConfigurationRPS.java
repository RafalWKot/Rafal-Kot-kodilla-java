package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigurationRPS implements Configuration {

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        possibleMoves.add(new Move("Kamień", Arrays.asList("Nożyce"), Arrays.asList("Papier")));
        possibleMoves.add(new Move("Papier", Arrays.asList("Kamień"), Arrays.asList("Nożyce")));
        possibleMoves.add(new Move("Nożyce", Arrays.asList("Papier"), Arrays.asList("Kamień")));
        return possibleMoves;
    }

    @Override
    public String getGameName() {
        return "Papier - Kamień - Nożyce";
    }

    @Override
    public String getDescription() {
        return  "Wybrałeś Papier - Kamień - Nożyce. \n" +
                "Oto krótkie zasady. \n" +
                "Gra składa się z kolejnych tur. W każdej turze ty i komputer wybieracie:  papier, kamień lub nożyce. \n" +
                "Gracz, który wybrał silniejszy symbol, otrzymuje jeden punkt. \n" +
                "W przypadku wybrania dwóch takich samych symboli następuje remis – punktu brak. \n" +
                "Oto hierarchia symboli: \n" +
                "nożyce są silniejsze od papieru, ponieważ go tną, \n" +
                "kamień jest silniejszy od nożyc, ponieważ je tępi, \n" +
                "papier jest silniejszy od kamienia, ponieważ go owija. \n" +
                "Gracz, który pierwszy uzyska umówioną wcześniej ilość punktów, wygrywa partię. \n" +
                "No to zaczynamy! Powodzenia! \n";
    }
}

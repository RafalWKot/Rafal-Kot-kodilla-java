package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigurationRPSSL implements Configuration {
    @Override
    public List<Move> getPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        possibleMoves.add(new Move("Kamień", Arrays.asList("Nożyce","Jaszczurka"), Arrays.asList("Papier","Spock")));
        possibleMoves.add(new Move("Papier", Arrays.asList("Kamień","Spock"), Arrays.asList("Nożyce","Jaszczurka")));
        possibleMoves.add(new Move("Nożyce", Arrays.asList("Papier","Jaszczurka"), Arrays.asList("Kamień","Spock")));
        possibleMoves.add(new Move("Spock", Arrays.asList("Nożyce","Kamień"), Arrays.asList("Papier","Jaszczurka")));
        possibleMoves.add(new Move("Jaszczurka", Arrays.asList("Papier","Spock"), Arrays.asList("Kamień","Nożyce")));
        return possibleMoves;
    }

    @Override
    public String getGameName() {
        return "Papier - Kamień - Nożyce - Spock - Jaszczurka";
    }

    @Override
    public String getDescription() {
        return  "Wybrałeś Papier - Kamień - Nożyce - Spock - Jaszczurka. \n" +
                "Oto krótkie zasady. \n" +
                "Gra składa się z kolejnych tur. W każdej turze ty i komputer wybieracie:  papier, kamień, nożyce, spocka lub jaszczurkę \n" +
                "Gracz, który wybrał silniejszy symbol, otrzymuje jeden punkt. \n" +
                "W przypadku wybrania dwóch takich samych symboli następuje remis – punktu brak. \n" +
                "Oto hierarchia symboli: \n" +
                "nożyce są silniejsze od papieru, ponieważ go tną, \n" +
                "kamień jest silniejszy od nożyc, ponieważ je tępi, \n" +
                "papier jest silniejszy od kamienia, ponieważ go owija, \n" +
                "kamień zgniata jaszczurkę, \n" +
                "jaszczurka truje Spocka, \n" +
                "Spock niszczy nożyce, \n" +
                "nożyce dekapitują jaszczurkę, \n" +
                "jaszczurka zjada papier, \n" +
                "papier obala Spocka, \n" +
                "Spock dezintegruje kamień. \n" +
                "Gracz, który pierwszy uzyska umówioną wcześniej ilość punktów, wygrywa partię. \n" +
                "No to zaczynamy! Powodzenia! \n";
    }
}

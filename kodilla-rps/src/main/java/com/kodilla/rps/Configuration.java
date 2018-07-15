package com.kodilla.rps;

import java.util.List;

public interface Configuration {
    List<Move> getPossibleMoves();
    String getGameName();
    String getDescription();
}

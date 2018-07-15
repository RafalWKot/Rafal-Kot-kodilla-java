package com.kodilla.rps;

import java.util.List;
import java.util.Objects;

public class Move {
    String moveName;
    List<String> winWith;
    List<String> loseWith;

    public Move(String moveName, List<String> winWith, List<String> loseWith) {
        this.moveName = moveName;
        this.winWith = winWith;
        this.loseWith = loseWith;
    }

    public String getMoveName() {
        return moveName;
    }

    public List<String> getWinWith() {
        return winWith;
    }

    public List<String> getLoseWith() {
        return loseWith;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(moveName, move.moveName) &&
                Objects.equals(winWith, move.winWith) &&
                Objects.equals(loseWith, move.loseWith);
    }

    @Override
    public int hashCode() {

        return Objects.hash(moveName, winWith, loseWith);
    }
}

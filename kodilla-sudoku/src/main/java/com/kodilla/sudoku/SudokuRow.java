package com.kodilla.sudoku;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Getter
@EqualsAndHashCode
public class SudokuRow {
    public static int ELEMENTQUANTITY = 9;
    private List<SudokuElement> sudokuElements = new ArrayList<>();

    SudokuRow() {
        IntStream.range(0, ELEMENTQUANTITY).forEach(i -> sudokuElements.add(new SudokuElement()));
    }

    @Override
    public String toString() {
        return "| " + sudokuElements.get(0).printMark() +
                " | " + sudokuElements.get(1).printMark() +
                " | " + sudokuElements.get(2).printMark() +
                " || " + sudokuElements.get(3).printMark() +
                " | " + sudokuElements.get(4).printMark() +
                " | " + sudokuElements.get(5).printMark() +
                " || " + sudokuElements.get(6).printMark() +
                " | " + sudokuElements.get(7).printMark() +
                " | " + sudokuElements.get(8).printMark() + " |";
    }
}

package com.kodilla.sudoku;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class SudokuElement {
    public static int EMPTY = -1;
    public static int POSSIBLEVALUES = 9;
    @Setter private Integer value;
    private List<Integer> possibleValues = new ArrayList<>();

    SudokuElement() {
        this.value = EMPTY;
        IntStream.range(0, POSSIBLEVALUES).forEach(i -> possibleValues.add(i + 1));
    }

    public String printMark() {
        if (value == EMPTY) {
            return " ";
        }
        return value.toString();
    }
}

package com.kodilla.sudoku;

import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class SudokuBoard {
    public static int ROWQUANTITY = 9;
    private List<SudokuRow> sudokuRows = new ArrayList<>();

    public void createEmpty() {
        IntStream.range(0, ROWQUANTITY).forEach(i -> sudokuRows.add(new SudokuRow()));
    }

    public void fillFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        createEmpty();
        IntStream.range(0, ROWQUANTITY).forEach(i -> sudokuRows.get(i).getSudokuElements().stream().
                forEach(t -> t.setValue(scanner.nextInt())));
        scanner.close();
    }

    public String toString() {
        return  "    1   2   3    4   5   6    7   8   9  "+ "\n" +
                "  ---------------------------------------" + "\n" +
                "1 " + sudokuRows.get(0).toString() + "\n" +
                "  ---------------------------------------" + "\n" +
                "2 " + sudokuRows.get(1).toString() + "\n" +
                "  ---------------------------------------" + "\n" +
                "3 " + sudokuRows.get(2).toString() + "\n" +
                "  =======================================" + "\n" +
                "4 " + sudokuRows.get(3).toString() + "\n" +
                "  ---------------------------------------" + "\n" +
                "5 " + sudokuRows.get(4).toString() + "\n" +
                "  ---------------------------------------" + "\n" +
                "6 " + sudokuRows.get(5).toString() + "\n" +
                "  =======================================" + "\n" +
                "7 " + sudokuRows.get(6).toString() + "\n" +
                "  ---------------------------------------" + "\n" +
                "8 " + sudokuRows.get(7).toString() + "\n" +
                "  ---------------------------------------" + "\n" +
                "9 " + sudokuRows.get(8).toString() + "\n" +
                "  ---------------------------------------" + "\n";
    }
}

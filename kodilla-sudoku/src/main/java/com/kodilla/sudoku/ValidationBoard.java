package com.kodilla.sudoku;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidationBoard {
    private static int SQUAREBYCOLUMN = 3;
    private static int SQUAREBYROW = 3;
    private SudokuBoard sudokuBoard;

    //usuwa możliwe ruchy dla danego pola w wierszu
    public void verifyRows(int rowNumber) {
        for (int i = 0; i < SudokuRow.ELEMENTQUANTITY; i++) {
            if(sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().get(i).getValue() == SudokuElement.EMPTY) {
                for (SudokuElement sudokuElement: sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements()) {
                    sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElements().get(i).getPossibleValues().remove(sudokuElement.getValue());
                }
            }
        }
    }
    //usuwa możliwe ruchy dla danego pola w kolumnie
    public void verifyColumn(int columnNumber) {
        for (int i = 0; i < SudokuRow.ELEMENTQUANTITY; i++) {
            if (sudokuBoard.getSudokuRows().get(i).getSudokuElements().get(columnNumber).getValue() == SudokuElement.EMPTY) {
                for (int j = 0; j < SudokuRow.ELEMENTQUANTITY; j++) {
                    sudokuBoard.getSudokuRows().get(i).getSudokuElements().get(columnNumber).getPossibleValues().remove(sudokuBoard.getSudokuRows().get(j).getSudokuElements().get(columnNumber).getValue());
                }
            }
        }
    }
    // możliwe ruchy z jednego kwadrata, nalezy podac index pierwszego elementu w kwadracie
    public void veryfiSquare(int row, int column) {
        row = Math.round(row / 3) * 3;
        column = Math.round(column / 3) * 3;

        for (int k = 0; k < SQUAREBYROW; k++) {
            for (int l = 0; l < SQUAREBYCOLUMN; l++) {
                for (int i = 0; i < SQUAREBYROW; i++) {
                    for (int j = 0; j < SQUAREBYCOLUMN; j++) {
                        if (sudokuBoard.getSudokuRows().get(row + k).getSudokuElements().get(column + l).getValue() == SudokuElement.EMPTY) {
                            sudokuBoard.getSudokuRows().get(row + k).getSudokuElements().get(column + l).getPossibleValues().
                                    remove(sudokuBoard.getSudokuRows().get(row + i).getSudokuElements().get(column + j).getValue());
                        }
                    }
                }
            }
        }
    }

    public void veryfiRowColumnSquareByIndex(int row, int column) {
        verifyRows(row);
        verifyColumn(column);
        veryfiSquare(row, column);
    }

    public  void veryfiAllBoard() {
        for (int i = 0; i < SudokuRow.ELEMENTQUANTITY; i++) {
            verifyRows(i);
        }
        for (int i = 0; i < SudokuRow.ELEMENTQUANTITY; i++) {
            verifyColumn(i);
        }
        for (int i = 0; i < SQUAREBYROW; i++) {
            for (int j = 0; j < SQUAREBYCOLUMN; j++) {
                veryfiSquare(i*3, j*3);
            }
        }
    }
}


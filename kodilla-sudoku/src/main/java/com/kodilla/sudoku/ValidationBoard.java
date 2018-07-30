package com.kodilla.sudoku;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidationBoard {
    private static int SQUAREBYCOLUMN = 3;
    private static int SQUAREBYROW = 3;
    private static int SQUAREBYSIDEBOARD = 3;
    private SudokuBoard sudokuBoard;

    public void findPossibilitiesInRow(int rowNumber) {
        for (int i = 0; i < SudokuRow.ELEMENTSQUANTITYINROW; i++) {
            if(sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElementsInRow().get(i).getValue() == SudokuElement.EMPTY) {
                for (SudokuElement sudokuElement: sudokuBoard.getSudokuRows().get(rowNumber).getSudokuElementsInRow()) {
                    sudokuBoard.getSudokuRows().get(rowNumber)
                                .getSudokuElementsInRow().get(i)
                                    .getPossibleValues()
                                        .remove(sudokuElement.getValue());
                }
            }
        }
    }

    public void findPossibilitiesInColumn(int columnNumber) {
        for (int i = 0; i < SudokuRow.ELEMENTSQUANTITYINROW; i++) {
            if (sudokuBoard.getSudokuRows().get(i).getSudokuElementsInRow().get(columnNumber).getValue() == SudokuElement.EMPTY) {
                for (int j = 0; j < SudokuRow.ELEMENTSQUANTITYINROW; j++) {
                    sudokuBoard.getSudokuRows().get(i)
                                 .getSudokuElementsInRow().get(columnNumber)
                                    .getPossibleValues()
                                        .remove(sudokuBoard.getSudokuRows().get(j).getSudokuElementsInRow().get(columnNumber).getValue());
                }
            }
        }
    }

    public void findPossibilitiesInSquare(int rowNumber, int columnNumber) {
        int firstElementInSquareByRow = Math.round(rowNumber / 3) * 3;
        int firstElementInSquareByCOlumn = Math.round(columnNumber / 3) * 3;

        for (int k = 0; k < SQUAREBYROW; k++) {
            for (int l = 0; l < SQUAREBYCOLUMN; l++) {
                for (int i = 0; i < SQUAREBYROW; i++) {
                    for (int j = 0; j < SQUAREBYCOLUMN; j++) {
                        if (sudokuBoard.getSudokuRows().get(firstElementInSquareByRow + k).getSudokuElementsInRow().get(firstElementInSquareByCOlumn + l).getValue() == SudokuElement.EMPTY) {
                            sudokuBoard.getSudokuRows().get(firstElementInSquareByRow + k)
                                            .getSudokuElementsInRow().get(firstElementInSquareByCOlumn + l)
                                                .getPossibleValues()
                                                    .remove(sudokuBoard.getSudokuRows().get(firstElementInSquareByRow + i).getSudokuElementsInRow().get(firstElementInSquareByCOlumn + j).getValue());
                        }
                    }
                }
            }
        }
    }

    public void findPossibilitiesForRowColumnSquareByIndex(int rowNumber, int columnNumber) {
        findPossibilitiesInRow(rowNumber);
        findPossibilitiesInColumn(columnNumber);
        findPossibilitiesInSquare(rowNumber, columnNumber);
    }

    public  void findPossibilitiesForAllBoard() {
        for (int i = 0; i < SudokuBoard.ROWQUANTITY; i++) {
            findPossibilitiesInRow(i);
        }
        for (int i = 0; i < SudokuRow.ELEMENTSQUANTITYINROW; i++) {
            findPossibilitiesInColumn(i);
        }
        for (int i = 0; i < SQUAREBYSIDEBOARD; i++) {
            for (int j = 0; j < SQUAREBYSIDEBOARD; j++) {
                findPossibilitiesInSquare(i * SQUAREBYROW, j * SQUAREBYCOLUMN );
            }
        }
    }
}


package com.kodilla.sudoku;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class SudokuGame {
    private final SudokuBoard sudokuBoard;
    @Getter private ValidationBoard validationBoard;
    @Getter private List<SudokuElement> sudokuElementsList;
    private boolean atFirstCheckAllBoard = true;

    public SudokuGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        validationBoard = new ValidationBoard(sudokuBoard);
    }

    public boolean resolveSudoku() throws NoPossibleMoveToDo {

        if (atFirstCheckAllBoard) {
            validationBoard.findPossibilitiesForAllBoard();
            atFirstCheckAllBoard = false;
        }

        boardElementsToList();
        setValueInEmptyPlace(getListOfIndexMinPossibleValues());

        return isSudokuFinished();
    }

    public int getRowNumberFromIndexList(int indexMinPossibleValues) {
        return Math.round(indexMinPossibleValues / SudokuRow.ELEMENTSQUANTITYINROW);
    }

    public int getColumnNumberFromIndexList(int indexMinPossibleValues) {
        return Math.round(indexMinPossibleValues % SudokuRow.ELEMENTSQUANTITYINROW);
    }

    public void boardElementsToList() {
        sudokuElementsList = sudokuBoard.getSudokuRows().stream()
                .flatMap(row -> row.getSudokuElementsInRow().stream())
                .collect(Collectors.toList());
    }

    public int getMinNumberOfPossibleValues() {
        return Collections.min(sudokuElementsList.stream()
                .map(t -> t.getPossibleValues().size())
                .collect(Collectors.toList()));
    }

    public List<Integer> getListOfIndexMinPossibleValues() {
        int minValues = getMinNumberOfPossibleValues();

        List<Integer> listOfIndex = new ArrayList<>();
        for (int i = 0; i < sudokuElementsList.size(); i++) {
            if (sudokuElementsList.get(i).getPossibleValues().size() == minValues && sudokuElementsList.get(i).getValue() == SudokuElement.EMPTY) {
                listOfIndex.add(i);
            }
        }
        return  listOfIndex;
    }

    public boolean isSudokuFinished() {
        if(sudokuElementsList.stream().filter(t -> t.getValue() == SudokuElement.EMPTY).count() == 0) return true;
        return false;
    }

    public void setValueInEmptyPlace(List<Integer> listOfIndex) throws NoPossibleMoveToDo {
        if (listOfIndex.isEmpty()) {
            throw new NoPossibleMoveToDo();
        }

        Random random = new Random();
        int choosenMove = random.nextInt(listOfIndex.size());
        int choosenValue = random.nextInt(sudokuBoard.getSudokuRows().get(getRowNumberFromIndexList(listOfIndex.get(choosenMove)))
                                                        .getSudokuElementsInRow().get(getColumnNumberFromIndexList(listOfIndex.get(choosenMove)))
                                                            .getPossibleValues().size());

        sudokuBoard.getSudokuRows().get(getRowNumberFromIndexList(listOfIndex.get(choosenMove)))
                        .getSudokuElementsInRow().get(getColumnNumberFromIndexList(listOfIndex.get(choosenMove)))
                            .setValue(sudokuBoard.getSudokuRows().get(getRowNumberFromIndexList(listOfIndex.get(choosenMove)))
                                    .getSudokuElementsInRow().get(getColumnNumberFromIndexList(listOfIndex.get(choosenMove)))
                                        .getPossibleValues().get(choosenValue)
                            );

        validationBoard.findPossibilitiesForRowColumnSquareByIndex(getRowNumberFromIndexList(listOfIndex.get(choosenMove)),getColumnNumberFromIndexList(listOfIndex.get(choosenMove)));
    }

    //metoda testowa - do usuniecia ostatecznie
//    public void printPosibilities() {
//        sudokuElementsList.stream().forEach(t -> System.out.println(t.getPossibleValues().toString()));
//    }
}

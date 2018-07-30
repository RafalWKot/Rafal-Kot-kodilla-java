package com.kodilla.sudoku;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SudokuGame {
    private final SudokuBoard sudokuBoard;
    private final ValidationBoard validationBoard;
    @Getter private List<SudokuElement> sudokuElementsList;


    public void run() {
        validationBoard.veryfiAllBoard();
        boardElementsToList();

        try {
            takeStep(getListOfIndexMinPossibleValues());
        } catch (NoPossibleMoveToDo noPossibleMoveToDo) {
            noPossibleMoveToDo.printStackTrace();
        }
    }

    public int getRowNumberFromIndexList(int indexMinPossibleValues) {
        return Math.round(indexMinPossibleValues / SudokuRow.ELEMENTQUANTITY);
    }

    public int getColumnNumberFromIndexList(int indexMinPossibleValues) {
        return Math.round(indexMinPossibleValues % SudokuRow.ELEMENTQUANTITY);
    }

    // 1. pakujemy elementy do listy
    public void boardElementsToList() {
        sudokuElementsList = sudokuBoard.getSudokuRows().stream().
                flatMap(row -> row.getSudokuElements().stream()).
                collect(Collectors.toList());
    }
    // 2. szukamy elementu lub elementów gdzie jest najmniej możliwości ruchu
    public int getMinNumberOfPossiblevalues() {
        return Collections.min(sudokuElementsList.stream().
                map(t -> t.getPossibleValues().size()).
                collect(Collectors.toList()));
    }

    // 3. zwraca listę indeksów gdzie jest najmniej możliwości ruchu w kroku
    public List<Integer> getListOfIndexMinPossibleValues() {
        int minValues = getMinNumberOfPossiblevalues();

        List<Integer> listOfIndex = new ArrayList<>();

        for (int i = 0; i < sudokuElementsList.size(); i++) {
            if (sudokuElementsList.get(i).getPossibleValues().size() == minValues) {
                listOfIndex.add(i);
            }
        }
        return  listOfIndex;
    }

    // 4. wykonywany jest ruch
    public void  takeStep(List<Integer> listOfIndex) throws NoPossibleMoveToDo {
        if (listOfIndex.isEmpty()) {
            throw new NoPossibleMoveToDo();
        } else if (listOfIndex.size() == 1) { // gdy jest jedno minimum ale wiecej możliwośći to co ??

            sudokuBoard.getSudokuRows().get(getRowNumberFromIndexList(listOfIndex.get(0))).getSudokuElements().get(getColumnNumberFromIndexList(listOfIndex.get(0))).
                    setValue(sudokuBoard.getSudokuRows().get(getRowNumberFromIndexList(listOfIndex.get(0))).getSudokuElements().get(getColumnNumberFromIndexList(listOfIndex.get(0))).getPossibleValues().get(0));
        } else {
            System.out.println("wiele możliwośći");
            //musi losować w polu oraz losować którą wartośc wpisać
//        Random random = new Random();
//        int moveValue =  random.nextInt(listOfIndex.size());
//        //sudokuBoard.getSudokuRows().get(getRowNumberFromIndexList(listOfIndex.get(moveValue))).getSudokuElements().get(getColumnNumberFromIndexList(listOfIndex.get(moveValue)));
        }
    }

    //do usuniecia ostatecznie
    public void printPosibilities() {
        sudokuElementsList.stream().forEach(t -> System.out.println(t.getPossibleValues().toString()));
    }
}

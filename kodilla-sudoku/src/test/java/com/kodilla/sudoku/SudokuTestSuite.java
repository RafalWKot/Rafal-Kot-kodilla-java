package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class SudokuTestSuite {

    private Application app;

    private void readSudokuFromFile(Application app, SudokuBoard sudokuBoard) {
        try {
            sudokuBoard.fillFromFile(app.getFile("sudoku1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
        app = new Application();
    }

    @Test
    public void testCheckValueOfElement() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        //When


        //Then
        Assert.assertEquals(Integer.valueOf(SudokuElement.EMPTY), sudokuBoard.getSudokuRows().get(4).getSudokuElementsInRow().get(0).getValue());
        Assert.assertEquals(Integer.valueOf(SudokuElement.EMPTY), sudokuBoard.getSudokuRows().get(6).getSudokuElementsInRow().get(7).getValue());
    }

    @Test
    public void testValidationPossibleValuesForElementByRow() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);

        //When
        validationBoard.findPossibilitiesInRow(4);
        validationBoard.findPossibilitiesInRow(6);

        //Then
        Assert.assertEquals(Arrays.asList(2,4,6,8,9), sudokuBoard.getSudokuRows().get(4).getSudokuElementsInRow().get(0).getPossibleValues());
        Assert.assertEquals(Arrays.asList(2,4,6,7,8,9), sudokuBoard.getSudokuRows().get(6).getSudokuElementsInRow().get(7).getPossibleValues());
    }

    @Test
    public void testValidationPossibleValueForElementByColumn() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);

        //When
        validationBoard.findPossibilitiesInColumn(0);
        validationBoard.findPossibilitiesInColumn(7);

        //Then
        Assert.assertEquals(Arrays.asList(4,7,8,9), sudokuBoard.getSudokuRows().get(4).getSudokuElementsInRow().get(0).getPossibleValues());
        Assert.assertEquals(Arrays.asList(1,2,3,5,8,9), sudokuBoard.getSudokuRows().get(6).getSudokuElementsInRow().get(7).getPossibleValues());
    }

    @Test
    public void testValidationPosibleValueForElementBySquare() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);

        //When
        validationBoard.findPossibilitiesInSquare(4, 0);
        validationBoard.findPossibilitiesInSquare(6, 7);

        //Then
        Assert.assertEquals(Arrays.asList(1,6,7,8,9), sudokuBoard.getSudokuRows().get(4).getSudokuElementsInRow().get(0).getPossibleValues());
        Assert.assertEquals(Arrays.asList(1,2,7,8,9), sudokuBoard.getSudokuRows().get(6).getSudokuElementsInRow().get(7).getPossibleValues());
    }

    @Test
    public void testBoardElementsToList(){
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);

        SudokuGame sudokuGame = new SudokuGame(sudokuBoard);
        sudokuGame.getValidationBoard().findPossibilitiesForAllBoard();


        //When
        sudokuGame.boardElementsToList();

        //Then
        Assert.assertEquals(81, sudokuGame.getSudokuElementsList().size());
        Assert.assertEquals(Arrays.asList(8,9), sudokuGame.getSudokuElementsList().get(36).getPossibleValues());


    }

    @Test
    public void testGetMinNumberOfPossiblevalues() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        SudokuGame sudokuGame = new SudokuGame(sudokuBoard);
        sudokuGame.getValidationBoard().findPossibilitiesForAllBoard();
        sudokuGame.boardElementsToList();

        //When
        int quantityOfPossibleValuesInStep = sudokuGame.getMinNumberOfPossibleValues();

        //Then
        Assert.assertEquals(1, quantityOfPossibleValuesInStep);
    }

    @Test
    public void testGetListOfIndexMinPossibleValues() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        SudokuGame sudokuGame = new SudokuGame(sudokuBoard);
        sudokuGame.getValidationBoard().findPossibilitiesForAllBoard();
        sudokuGame.boardElementsToList();

        //When
        List<Integer> listOfIndex = sudokuGame.getListOfIndexMinPossibleValues();

        //Then
        Assert.assertEquals(1, listOfIndex.size());
        Assert.assertEquals(Integer.valueOf(80), listOfIndex.get(0));
    }

    @Test
    public void testTakeStep() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        SudokuGame sudokuGame = new SudokuGame(sudokuBoard);
        sudokuGame.getValidationBoard().findPossibilitiesForAllBoard();
        sudokuGame.boardElementsToList();

        //When
        try {
            sudokuGame.setValueInEmptyPlace(sudokuGame.getListOfIndexMinPossibleValues());
        } catch (NoPossibleMoveToDo noPossibleMoveToDo) {
            noPossibleMoveToDo.printStackTrace();
        }

        //Then
        Assert.assertEquals(Integer.valueOf(9) , sudokuBoard.getSudokuRows().get(8).getSudokuElementsInRow().get(8).getValue());


    }
}


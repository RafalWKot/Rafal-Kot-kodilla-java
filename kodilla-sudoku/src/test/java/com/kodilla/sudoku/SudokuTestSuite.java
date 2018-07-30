package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class SudokuTestSuite {



    public void readSudokuFromFile(Application app, SudokuBoard sudokuBoard) {
        try {
            sudokuBoard.fillFromFile(app.getFile("sudoku1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckValueOfElement() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        //When


        //Then
        Assert.assertEquals(Integer.valueOf(SudokuElement.EMPTY), sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(0).getValue());
        Assert.assertEquals(Integer.valueOf(SudokuElement.EMPTY), sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(7).getValue());
    }

    @Test
    public void testValidationPossibleValuesForElementByRow() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);

        //When
        validationBoard.verifyRows(4);
        validationBoard.verifyRows(6);

        //Then
        Assert.assertEquals(Arrays.asList(2,4,6,8,9), sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(0).getPossibleValues());
        Assert.assertEquals(Arrays.asList(2,4,6,7,8,9), sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(7).getPossibleValues());
    }

    @Test
    public void testValidationPossibleValueForElementByColumn() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);

        //When
        validationBoard.verifyColumn(0);
        validationBoard.verifyColumn(7);

        //Then
        Assert.assertEquals(Arrays.asList(4,7,8,9), sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(0).getPossibleValues());
        Assert.assertEquals(Arrays.asList(1,2,3,5,8,9), sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(7).getPossibleValues());
    }

    @Test
    public void testValidationPosibleValueForElementBySquare() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);

        //When
        validationBoard.veryfiSquare(4, 0);
        validationBoard.veryfiSquare(6, 7);

        //Then
        Assert.assertEquals(Arrays.asList(1,6,7,8,9), sudokuBoard.getSudokuRows().get(4).getSudokuElements().get(0).getPossibleValues());
        Assert.assertEquals(Arrays.asList(1,2,7,8,9), sudokuBoard.getSudokuRows().get(6).getSudokuElements().get(7).getPossibleValues());
    }

    @Test
    public void testBoardElementsToList(){
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);
        SudokuGame sudokuGame = new SudokuGame(sudokuBoard, validationBoard);
        validationBoard.veryfiAllBoard();


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
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);
        SudokuGame sudokuGame = new SudokuGame(sudokuBoard, validationBoard);
        validationBoard.veryfiAllBoard();
        sudokuGame.boardElementsToList();

        //When
        int quantityOfPossibleValuesInStep = sudokuGame.getMinNumberOfPossiblevalues();

        //Then
        Assert.assertEquals(1, quantityOfPossibleValuesInStep);
    }

    @Test
    public void testGetListOfIndexMinPossibleValues() {
        //Given
        Application app = new Application();
        SudokuBoard sudokuBoard = new SudokuBoard();
        readSudokuFromFile(app, sudokuBoard);
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);
        SudokuGame sudokuGame = new SudokuGame(sudokuBoard, validationBoard);
        validationBoard.veryfiAllBoard();
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
        ValidationBoard validationBoard = new ValidationBoard(sudokuBoard);
        SudokuGame sudokuGame = new SudokuGame(sudokuBoard, validationBoard);
        validationBoard.veryfiAllBoard();
        sudokuGame.boardElementsToList();

        //When
        try {
            sudokuGame.takeStep(sudokuGame.getListOfIndexMinPossibleValues());
        } catch (NoPossibleMoveToDo noPossibleMoveToDo) {
            noPossibleMoveToDo.printStackTrace();
        }

        //Then
        Assert.assertEquals(Integer.valueOf(9) , sudokuBoard.getSudokuRows().get(8).getSudokuElements().get(8).getValue());


    }
}


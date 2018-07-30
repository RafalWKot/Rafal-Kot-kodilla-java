package com.kodilla.sudoku;

import java.io.File;
import java.io.FileNotFoundException;


public class Application {

    public static void main(String[] args) {

        Application app = new Application();

        Texts texts = new Texts((app.getFile("textsPL.txt")));
        try {
            texts.readTexts();
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku z tekstami!");
        }
        System.out.println(texts.getGameName());
        System.out.println(texts.getIntroduce());

        SudokuBoard sudokuBoard = new SudokuBoard();

        try {
            sudokuBoard.fillFromFile(app.getFile("sudoku1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku z Sudoku");
        }

        SudokuGame sudokuGame = new SudokuGame(sudokuBoard);

        System.out.println(sudokuBoard.toString());

        boolean gameFinished = false;
        while(!gameFinished) {
            try {
                gameFinished = sudokuGame.resolveSudoku();
            } catch (NoPossibleMoveToDo noPossibleMoveToDo) {
                System.out.println("Sudoku nie do rowiązania!");
            }
        }
        System.out.println(texts.getRosolve());
        System.out.println(sudokuBoard.toString());
    }

    public File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return  new File(classLoader.getResource(fileName).getFile());
    }
}

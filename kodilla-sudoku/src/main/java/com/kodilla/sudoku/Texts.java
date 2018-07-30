package com.kodilla.sudoku;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

@RequiredArgsConstructor
@Getter
public class Texts {
    private final File file;
    private String gameName;
    private String introduce;
    private String rosolve;

    public void readTexts() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        gameName = scanner.nextLine();
        introduce = scanner.nextLine();
        rosolve = scanner.nextLine();
        scanner.close();
    }

}

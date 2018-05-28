package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        String result = "Not done";

        try {
            result = secondChallenge.probablyIWillThrowException(2, 2);
        } catch (Exception e) {
            System.out.println("Remember! The x must be between 1 and 2 while the y must be different from 1.5");
        }
        finally {
            System.out.println(result);
        }
    }
}

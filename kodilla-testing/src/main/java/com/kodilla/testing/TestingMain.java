package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUserName();

        if (result.equals("theForumUser")) {
            System.out.println("Ok");
        }
        else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        if (calculator.add(1, 2) == 3) {
            System.out.println("Method add - Ok");
        }
        else {
            System.out.println("Method add - Error");
        }

        if (calculator.subtract(5, 3) == 2) {
            System.out.println("Method subtract - Ok");
        }
        else {
            System.out.println("Method subtract - Error");
        }
    }
}

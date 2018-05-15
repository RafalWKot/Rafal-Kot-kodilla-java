package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
   ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
       ArrayList<Integer> even = new ArrayList<>();
       if(numbers.isEmpty()) {
           even = numbers;
       }
       else {
           for (Integer number : numbers) {
               if(number % 2 == 0) {
                   even.add(number);
               }
           }
       }
       return even;
   }
}

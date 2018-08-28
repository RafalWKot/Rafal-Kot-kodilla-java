package com.kodilla.patterns2.observer.homework;

import static org.junit.Assert.*;
import org.junit.Test;

public class MentorTestSuite {

    @Test
    public void updateTest() {
        //Given
        TaskList student1 = new TaskList("Rafal", "Kot");
        TaskList student2 = new TaskList("Adam","Mickiewicz" );
        Mentor mentor = new Mentor("Chuck", "Norris");
        student1.registerObserver(mentor);
        student2.registerObserver(mentor);

        //When
        student1.addTask("First task to do");
        student2.addTask("Another task to do");
        student1.addTask("Something which is done.");

        //Then
        assertEquals(3, mentor.getCountTask());
    }
}

package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskToDoAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        //When
        board.addToDoList("The task to do.");
        //Then
        System.out.println(board.getToDoList().getTasks().get(0));
        Assert.assertEquals("The task to do.", board.getToDoList().getTasks().get(0));
    }

    @Test
    public void testTaskInProgressAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        //When
        board.addInProgressList("The task in progress.");
        //Then
        System.out.println(board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("The task in progress.", board.getInProgressList().getTasks().get(0));
    }

    @Test
    public void testTaskDoneAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        //When
        board.addDoneList("The task is done.");
        //Then
        System.out.println(board.getDoneList().getTasks().get(0));
        Assert.assertEquals("The task is done.", board.getDoneList().getTasks().get(0));
    }
}

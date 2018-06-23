package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask("DRIVING");
        driving.executeTask();
        //Then
        Assert.assertEquals("Driving", driving.getTaskName());
        Assert.assertEquals(true, driving.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask("PAINTING");
        painting.executeTask();
        //Then
        Assert.assertEquals("Painting", painting.getTaskName());
        Assert.assertEquals(true, painting.isTaskExecuted());
    }

    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask("SHOPPING");
        shopping.executeTask();
        //Then
        Assert.assertEquals("Shopping", shopping.getTaskName());
        Assert.assertEquals(true, shopping.isTaskExecuted());
    }
}

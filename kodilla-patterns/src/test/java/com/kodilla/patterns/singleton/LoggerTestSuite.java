package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeClass
    public static void setInstance() {
        logger = Logger.getLoggerInstance();
        logger.log("create task");
        logger.log("delete task");
    }


    @Test
    public void testGetLastLog() {

        //Given

        //Then

        //When
        Assert.assertEquals("delete task",logger.getLastLog());
    }
}

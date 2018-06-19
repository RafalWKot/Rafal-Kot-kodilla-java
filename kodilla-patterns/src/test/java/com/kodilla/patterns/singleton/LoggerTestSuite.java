package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLasLog() {

        //Given
        Logger logger = Logger.getLoggerInstance();


        //Then
        logger.log("Last log.");

        //When
        Assert.assertEquals("Last log.",logger.getLastLog());
    }
}

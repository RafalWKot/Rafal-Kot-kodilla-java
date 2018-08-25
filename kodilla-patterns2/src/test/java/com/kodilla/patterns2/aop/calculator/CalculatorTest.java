package com.kodilla.patterns2.aop.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTest.class);


    @Test
    public void add() {
        double result = calculator.add(15, 5);
        LOGGER.info("Testing add method");
        assertEquals(20.0, result, 0);
    }

    @Test
    public void sub() {
        double result = calculator.sub(15, 5);
        LOGGER.info("Testing sub method");
        assertEquals(10.0, result, 0);
    }

    @Test
    public void mul() {
        double result = calculator.mul(15, 5);
        LOGGER.info("Testing mul method");
        assertEquals(75.0, result, 0);
    }

    @Test
    public void div() {
        double result = calculator.div(15, 5);
        LOGGER.info("Testing div method");
        assertEquals(3.0, result, 0);
    }

    @Test
    public void factorial() {
        //Given
        //When
        BigDecimal result = calculator.factorial(new BigDecimal("1000"));
        //Then
        LOGGER.info("Testing factorial method");
        System.out.println(result);
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }
}
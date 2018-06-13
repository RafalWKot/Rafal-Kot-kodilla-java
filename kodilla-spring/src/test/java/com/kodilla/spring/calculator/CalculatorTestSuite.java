package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        Calculator calculator = context.getBean(Calculator.class);

        //When
        double add = calculator.add(1,2);
        double sub = calculator.sub(5,3);
        double mul = calculator.mul(3,4);
        double div = calculator.div(10,2);

        //Then
        Assert.assertEquals(3,add,0);
        Assert.assertEquals(2,sub,0);
        Assert.assertEquals(12,mul,0);
        Assert.assertEquals(5,div,0);
    }
}

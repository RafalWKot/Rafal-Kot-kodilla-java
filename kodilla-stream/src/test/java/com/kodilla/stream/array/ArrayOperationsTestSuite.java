package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int [] numbers = {1,2,3,4,5};
        //When
        double averageValue = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(3.0,averageValue,0.0);
    }
}

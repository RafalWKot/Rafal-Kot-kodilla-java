package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }
    @After
    public  void after() {
        System.out.println("Test case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> listInput = new ArrayList<>();
        ArrayList<Integer> listExpected = new ArrayList<>();
        ArrayList<Integer> listResult = oddNumbersExterminator.exterminate(listInput);
        System.out.println("Testing empty list");
        Assert.assertEquals(listExpected, listResult);
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> listInput = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        ArrayList<Integer> listExpected = new ArrayList<>(Arrays.asList(2,4,6,8));
        ArrayList<Integer> listResult = oddNumbersExterminator.exterminate(listInput);
        System.out.println("Testing normal list");
        Assert.assertEquals(listExpected, listResult);
    }
}

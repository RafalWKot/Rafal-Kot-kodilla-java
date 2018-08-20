package com.kodilla.patterns2.decorator.pizza;


import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderDecoratorTest {

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        //Then
        String description = thePizza.getDescription();
        //When
        assertEquals("Ordered pizza", description);
    }

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        //Then
        BigDecimal theCount = thePizza.getCost();
        //When
        assertEquals(new BigDecimal(10), theCount);
    }


    @Test
    public void testPizzaDoughGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaDough(thePizza, " on traditional dough", new BigDecimal(5));
        //Then
        String description = thePizza.getDescription();
        //When
        assertEquals("Ordered pizza on traditional dough", description);
    }

    @Test
    public void testPizzaDoughGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaDough(thePizza, " on traditional dough", new BigDecimal(5));
        //Then
        BigDecimal theCost = thePizza.getCost();
        //When
        assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    public void testPizzaCheeseGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaCheese(thePizza, " with gouda cheese", new BigDecimal(5));
        //Then
        String description = thePizza.getDescription();
        //When
        assertEquals("Ordered pizza with gouda cheese", description);
    }

    @Test
    public void testPizzaCheeseGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaCheese(thePizza, " with gouda cheese", new BigDecimal(5));
        //Then
        BigDecimal theCost = thePizza.getCost();
        //When
        assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    public void testPizzaSizeGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaSize(thePizza, " size 30 cm", new BigDecimal(3));
        //Then
        String description = thePizza.getDescription();
        //When
        assertEquals("Ordered pizza size 30 cm", description);
    }

    @Test
    public void testPizzaSizeGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaSize(thePizza, " size 30 cm", new BigDecimal(3));
        //Then
        BigDecimal theCost = thePizza.getCost();
        //When
        assertEquals(new BigDecimal(13), theCost);
    }

    @Test
    public void testPizzaFruitsAndVegetablesGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaFruitsAndVegetables(thePizza, " with pineapple", new BigDecimal(2));
        //Then
        String description = thePizza.getDescription();
        //When
        assertEquals("Ordered pizza with pineapple", description);
    }

    @Test
    public void testPizzaFruitsAndVegetablesGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaFruitsAndVegetables(thePizza, " with pineapple", new BigDecimal(2));
        //Then
        BigDecimal theCost = thePizza.getCost();
        //When
        assertEquals(new BigDecimal(12), theCost);
    }

    @Test
    public void testPizzaMeatAndFishGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaMeatAndFish(thePizza, " with salami", new BigDecimal(2));
        //Then
        String description = thePizza.getDescription();
        //When
        assertEquals("Ordered pizza with salami", description);
    }

    @Test
    public void testPizzaMeatAndFishGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaMeatAndFish(thePizza, " with salami", new BigDecimal(2));
        //Then
        BigDecimal theCost = thePizza.getCost();
        //When
        assertEquals(new BigDecimal(12), theCost);
    }

    @Test
    public void testPizzaAllGetDescription() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaDough(thePizza, " on traditional dough", new BigDecimal(5));
        thePizza = new PizzaCheese(thePizza, " with gouda cheese", new BigDecimal(5));
        thePizza = new PizzaSize(thePizza, " size 30 cm", new BigDecimal(3));
        thePizza = new PizzaFruitsAndVegetables(thePizza, " with pineapple", new BigDecimal(2));
        thePizza = new PizzaMeatAndFish(thePizza, " with salami", new BigDecimal(2));
        //Then
        String description = thePizza.getDescription();
        //When
        assertEquals("Ordered pizza on traditional dough with gouda cheese size 30 cm with pineapple with salami", description);
    }

    @Test
    public void testPizzaAllGetCost() {
        //Given
        PizzaOrder thePizza = new BasicPizzaOrder();
        thePizza = new PizzaDough(thePizza, " on traditional dough", new BigDecimal(5));
        thePizza = new PizzaCheese(thePizza, " with gouda cheese", new BigDecimal(5));
        thePizza = new PizzaSize(thePizza, " size 30 cm", new BigDecimal(3));
        thePizza = new PizzaFruitsAndVegetables(thePizza, " with pineapple", new BigDecimal(2));
        thePizza = new PizzaMeatAndFish(thePizza, " with salami", new BigDecimal(2));
        //Then
        BigDecimal theCost = thePizza.getCost();
        //When
        assertEquals(new BigDecimal(27), theCost);
    }

}

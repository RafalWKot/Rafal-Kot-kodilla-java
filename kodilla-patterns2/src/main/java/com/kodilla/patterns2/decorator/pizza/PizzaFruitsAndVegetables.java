package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaFruitsAndVegetables extends AbstractPizzaOrder {
    private final String fruitsAndVegetablesName;
    private final BigDecimal fruitsAndVegetablesCost;

    public PizzaFruitsAndVegetables(PizzaOrder pizzaOrder, String fruitsAndVegetablesName, BigDecimal fruitsAndVegetablesCost) {
        super(pizzaOrder);
        this.fruitsAndVegetablesName = fruitsAndVegetablesName;
        this.fruitsAndVegetablesCost = fruitsAndVegetablesCost;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(fruitsAndVegetablesCost);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + fruitsAndVegetablesName;
    }
}

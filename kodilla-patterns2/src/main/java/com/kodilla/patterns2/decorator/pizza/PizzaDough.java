package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaDough extends AbstractPizzaOrder{
    private final String doughName;
    private final BigDecimal doughCost;


    public PizzaDough(PizzaOrder pizzaOrder, String doughName, BigDecimal doughCost) {
        super(pizzaOrder);
        this.doughName = doughName;
        this.doughCost = doughCost;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(doughCost);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + doughName;
    }
}

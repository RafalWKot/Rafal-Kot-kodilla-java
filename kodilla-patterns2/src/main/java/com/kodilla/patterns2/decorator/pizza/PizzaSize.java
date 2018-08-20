package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaSize extends AbstractPizzaOrder{
    private final String sizeName;
    private final BigDecimal sizeCost;

    public PizzaSize(PizzaOrder pizzaOrder, String sizeName, BigDecimal sizeCost) {
        super(pizzaOrder);
        this.sizeName = sizeName;
        this.sizeCost = sizeCost;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(sizeCost);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + sizeName;
    }
}

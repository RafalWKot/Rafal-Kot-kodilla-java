package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaCheese extends AbstractPizzaOrder {
    private final String cheeseName;
    private final BigDecimal cheeseCost;

    public PizzaCheese(PizzaOrder pizzaOrder, String cheeseName, BigDecimal cheeseCost) {
        super(pizzaOrder);
        this.cheeseName = cheeseName;
        this.cheeseCost = cheeseCost;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(cheeseCost);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + cheeseName;
    }
}

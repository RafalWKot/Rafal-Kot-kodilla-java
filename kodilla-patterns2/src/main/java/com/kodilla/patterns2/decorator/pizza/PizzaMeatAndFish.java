package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaMeatAndFish extends AbstractPizzaOrder{
    private final String meatAndFishName;
    private final BigDecimal meatAndFishCost;

    public PizzaMeatAndFish(PizzaOrder pizzaOrder, String meatAndFishName, BigDecimal meatAndFishCost) {
        super(pizzaOrder);
        this.meatAndFishName = meatAndFishName;
        this.meatAndFishCost = meatAndFishCost;
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(meatAndFishCost);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + meatAndFishName;
    }
}

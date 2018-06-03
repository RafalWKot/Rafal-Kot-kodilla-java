package com.kodilla.good.patterns.challenges.productorderservice;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final List<Item> listOfItems;
    private final int idOrder;

    public Order(List<Item> listOfItems, int idOrder) {
        this.listOfItems = listOfItems;
        this.idOrder = idOrder;
    }

    public List<Item> getListOfItems() {
        return listOfItems;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public double getTotalValue() {
        return listOfItems.stream()
                .collect(Collectors.summingDouble(Item::getValue));
    }
}

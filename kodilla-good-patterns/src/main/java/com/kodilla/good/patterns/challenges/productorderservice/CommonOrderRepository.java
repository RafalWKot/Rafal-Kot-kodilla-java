package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public class CommonOrderRepository implements OrderRepository {

    @Override
    public void create(User user, Order order, LocalDateTime localDateTime) {
        System.out.println("Order " + order.getIdOrder() + " is created in the datebase");
    }
}

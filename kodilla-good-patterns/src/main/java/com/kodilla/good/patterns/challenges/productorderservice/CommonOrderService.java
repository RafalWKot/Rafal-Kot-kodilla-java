package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public class CommonOrderService implements OrderService {

    @Override
    public boolean order(User user, Order order, LocalDateTime localDateTime) {
        System.out.println("Order " + order.getIdOrder() + " for user " + user.getIdUser() + " from date " + localDateTime.toString() + " is done");
        return true;
    }
}

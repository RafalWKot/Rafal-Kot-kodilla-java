package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public interface OrderRepository {

    void create(User user, Order order, LocalDateTime localDateTime);
}

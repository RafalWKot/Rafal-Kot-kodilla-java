package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public interface OrderService {
    boolean order(User user, Order order, LocalDateTime localDateTime);
}

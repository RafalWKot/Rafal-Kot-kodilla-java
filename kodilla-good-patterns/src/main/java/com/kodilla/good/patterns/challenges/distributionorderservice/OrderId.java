package com.kodilla.good.patterns.challenges.distributionorderservice;

import java.time.LocalDateTime;

public class OrderId {
    private User user;
    private Order order;
    private LocalDateTime localDateTime;
    private boolean isOrdered;

    public OrderId(User user, Order order, LocalDateTime localDateTime, boolean isOrdered) {
        this.user = user;
        this.order = order;
        this.localDateTime = localDateTime;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

}

package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public class OrderRequest {
    private final User user;
    private final Order order;
    private final LocalDateTime dateOfOrder;

    public OrderRequest(User user, Order order, LocalDateTime dateOfOrder) {
        this.user = user;
        this.order = order;
        this.dateOfOrder = dateOfOrder;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }


}

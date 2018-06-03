package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("Rafal","Kot", 1);

        Product product = new Product("Toothbrush",10);

        Item item = new Item(product,2);

        List<Item> items = new ArrayList<>();
        items.add(item);

        Order order = new Order(items,1);

        LocalDateTime dateOfOrder = LocalDateTime.of(2018, 5,31,12,10);

        return new OrderRequest(user,order, dateOfOrder);
    }
}

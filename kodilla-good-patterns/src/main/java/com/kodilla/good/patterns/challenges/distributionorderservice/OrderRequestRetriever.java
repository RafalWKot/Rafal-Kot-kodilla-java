package com.kodilla.good.patterns.challenges.distributionorderservice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User(5, "Rafal", "Kot");

        List<Item> items = new ArrayList<>();
        items.add(new Item(new Product("Carrot", 2.0, new HealthyShopDistributor()),2));
        items.add(new Item(new Product("Apples", 1.59, new ExtraFoodShopDistributor()),3));
        items.add(new Item(new Product("Bread", 2.5, new ExtraFoodShopDistributor()),1));

        Order order = new Order(items,1);
        LocalDateTime dateOfOrder = LocalDateTime.of(2018, 5,31,12,10);

        return new OrderRequest(user,order, dateOfOrder);
    }
}

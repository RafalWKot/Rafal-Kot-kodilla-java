package com.kodilla.good.patterns.challenges.distributionorderservice;

public class ProductOrderService {

    public OrderId process(OrderRequest orderRequest){

        orderRequest.getOrder().getListOfItems().stream()
                .forEach(t -> t.getProduct().getDistributor().process());

        return new OrderId(orderRequest.getUser(), orderRequest.getOrder(), orderRequest.getDateOfOrder(),true);
    }
}

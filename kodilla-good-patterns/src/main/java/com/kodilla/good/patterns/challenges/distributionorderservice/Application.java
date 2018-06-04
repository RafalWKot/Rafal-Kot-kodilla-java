package com.kodilla.good.patterns.challenges.distributionorderservice;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService();
        OrderId orderId =  productOrderService.process(orderRequest);
    }
}

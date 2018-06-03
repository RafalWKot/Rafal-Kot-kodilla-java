package com.kodilla.good.patterns.challenges.productorderservice;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();

        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new CommonOrderService(), new CommonInformationService(), new CommonOrderRepository());
        OrderId orderId = productOrderService.process(orderRequest);
    }
}

package com.kodilla.good.patterns.challenges.productorderservice;

public class ProductOrderService {

    private OrderService orderService;
    private InformationService informationService;
    private OrderRepository orderRepository;

    public ProductOrderService(OrderService orderService, InformationService informationService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.informationService = informationService;
        this.orderRepository = orderRepository;
    }

    public OrderId process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getOrder(), orderRequest.getDateOfOrder());

        if (isOrdered) {
            informationService.information(orderRequest.getUser());
            orderRepository.create(orderRequest.getUser(),  orderRequest.getOrder(), orderRequest.getDateOfOrder());
            return  new OrderId(orderRequest.getUser(), orderRequest.getOrder(), orderRequest.getDateOfOrder(), isOrdered);
        } else {
            return  new OrderId(orderRequest.getUser(), orderRequest.getOrder(), orderRequest.getDateOfOrder(), isOrdered);
        }
    }
}

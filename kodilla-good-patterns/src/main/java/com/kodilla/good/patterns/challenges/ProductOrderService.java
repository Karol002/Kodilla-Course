package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.Shop.OrderInformator;
import com.kodilla.good.patterns.challenges.Shop.OrderStarter;
import com.kodilla.good.patterns.challenges.Shop.OrderPayer;
import com.kodilla.good.patterns.challenges.Shop.*;

public class ProductOrderService {
    private final OrderPayer paymentService;
    private final OrderInformator informationService;
    private final OrderStarter orderService;

    public ProductOrderService(OrderPayer paymentService, OrderInformator informationService, OrderStarter orderService) {
        this.paymentService = paymentService;
        this.informationService = informationService;
        this.orderService = orderService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isAccept = orderService.checkPaymentPossibility(orderRequest.getUser(), orderRequest.getOrder());
        
        if (isAccept) {
            paymentService.pay(orderRequest.getUser(), orderRequest.getOrder());
            informationService.informUser(orderRequest.getUser(), orderRequest.getOrder());
            return  new OrderDto(orderRequest.getUser(), orderRequest.getOrder(),isAccept);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getOrder(), isAccept);
        }
    }
}

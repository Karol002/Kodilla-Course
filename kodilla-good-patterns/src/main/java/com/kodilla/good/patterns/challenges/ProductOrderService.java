package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.Shop.*;

public class ProductOrderService {
    private final PaymentService paymentService;
    private final InformationService informationService;
    private final OrderService orderService;

    public ProductOrderService(PaymentService paymentService, InformationService informationService, OrderService orderService) {
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

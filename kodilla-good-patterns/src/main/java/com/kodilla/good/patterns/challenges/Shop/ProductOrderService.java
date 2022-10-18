package com.kodilla.good.patterns.challenges.Shop;

import com.kodilla.good.patterns.challenges.Shop.OrderCreators.OrderDto;
import com.kodilla.good.patterns.challenges.Shop.OrderCreators.OrderRequest;
import com.kodilla.good.patterns.challenges.Shop.OrderLogic.ShopInformationService;
import com.kodilla.good.patterns.challenges.Shop.OrderLogic.ShopOrderService;
import com.kodilla.good.patterns.challenges.Shop.OrderLogic.ShopPaymentService;

public class ProductOrderService {
    private final ShopPaymentService paymentService;
    private final ShopInformationService informationService;
    private final ShopOrderService orderService;

    public ProductOrderService(ShopPaymentService paymentService, ShopInformationService informationService, ShopOrderService orderService) {
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

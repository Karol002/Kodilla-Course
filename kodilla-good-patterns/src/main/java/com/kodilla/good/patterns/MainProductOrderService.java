package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.shop.ordercreators.OrderRequest;
import com.kodilla.good.patterns.challenges.shop.ordercreators.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.shop.orderlogic.ShopInformationService;
import com.kodilla.good.patterns.challenges.shop.orderlogic.ShopOrderService;
import com.kodilla.good.patterns.challenges.shop.orderlogic.ShopPaymentService;
import com.kodilla.good.patterns.challenges.shop.ProductOrderService;

public class MainProductOrderService {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService
                (new ShopPaymentService(), new ShopInformationService(), new ShopOrderService());

        productOrderService.process(orderRequest);
    }
}

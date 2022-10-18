package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.Shop.OrderCreators.OrderRequest;
import com.kodilla.good.patterns.challenges.Shop.OrderCreators.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.Shop.OrderLogic.ShopInformationService;
import com.kodilla.good.patterns.challenges.Shop.OrderLogic.ShopOrderService;
import com.kodilla.good.patterns.challenges.Shop.OrderLogic.ShopPaymentService;
import com.kodilla.good.patterns.challenges.Shop.ProductOrderService;

public class MainProductOrderService {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService
                (new ShopPaymentService(), new ShopInformationService(), new ShopOrderService());

        productOrderService.process(orderRequest);
    }
}

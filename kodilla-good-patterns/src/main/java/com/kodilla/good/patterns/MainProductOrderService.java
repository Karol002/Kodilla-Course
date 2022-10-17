package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.ProductOrderService;
import com.kodilla.good.patterns.challenges.Shop.*;

public class MainProductOrderService {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService
                (new PaymentService(), new InformationService(), new OrderService());

        productOrderService.process(orderRequest);
    }
}

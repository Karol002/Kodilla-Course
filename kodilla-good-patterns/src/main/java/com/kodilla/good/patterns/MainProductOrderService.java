package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.Shop.OrderInformator;
import com.kodilla.good.patterns.challenges.Shop.OrderStarter;
import com.kodilla.good.patterns.challenges.Shop.OrderPayer;
import com.kodilla.good.patterns.challenges.ProductOrderService;
import com.kodilla.good.patterns.challenges.Shop.*;

public class MainProductOrderService {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService
                (new OrderPayer(), new OrderInformator(), new OrderStarter());

        productOrderService.process(orderRequest);
    }
}

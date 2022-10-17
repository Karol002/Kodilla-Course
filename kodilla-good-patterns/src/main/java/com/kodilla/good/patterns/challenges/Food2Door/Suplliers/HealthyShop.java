package com.kodilla.good.patterns.challenges.Food2Door.Suplliers;

import com.kodilla.good.patterns.challenges.Food2Door.OrderDto;

public class HealthyShop extends Supplier{

    public HealthyShop(String supplierName, String product, double productPrice) {
        super(supplierName, product, productPrice);
    }

    @Override
    public OrderDto process(int productQuantity) {
        return new OrderDto(10, productQuantity * getProductPrice(), 15.0);
    }
}

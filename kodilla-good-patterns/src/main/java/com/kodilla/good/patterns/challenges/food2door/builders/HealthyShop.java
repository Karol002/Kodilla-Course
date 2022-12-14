package com.kodilla.good.patterns.challenges.food2door.builders;

public class HealthyShop extends Supplier{

    public HealthyShop(String supplierName, String product, double productPrice) {
        super(supplierName, product, productPrice);
    }

    @Override
    public OrderDto process(int productQuantity) {
        return new OrderDto(10, productQuantity * getProductPrice(), 15.0);
    }
}

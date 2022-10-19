package com.kodilla.good.patterns.challenges.food2door.builders;

public class GlutenFreeShop extends Supplier{

    public GlutenFreeShop(String supplierName, String product, double productPrice) {
        super(supplierName, product, productPrice);
    }

    @Override
    public OrderDto process(int productQuantity) {
        return new OrderDto(20, productQuantity * getProductPrice(), 5.0);
    }
}

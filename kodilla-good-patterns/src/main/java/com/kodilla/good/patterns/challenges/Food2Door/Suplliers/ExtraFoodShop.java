package com.kodilla.good.patterns.challenges.Food2Door.Suplliers;

import com.kodilla.good.patterns.challenges.Food2Door.OrderDto;

public class ExtraFoodShop extends Supplier {

    public ExtraFoodShop(String supplierName, String product, double productPrice) {
        super(supplierName, product, productPrice);
    }

    @Override
    public OrderDto process(int productQuantity) {
        return new OrderDto(30, productQuantity * getProductPrice(), 0.0);
    }
}

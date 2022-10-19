package com.kodilla.good.patterns.challenges.food2door.builders;

public abstract class Supplier {
    private final String supplierName;
    private final String product;
    private final double productPrice;

    public Supplier(String supplierName, String product, double productPrice) {
        this.supplierName = supplierName;
        this.product = product;
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    abstract public OrderDto process(int productQuantity);

    @Override
    public String toString() {
        return supplierName + ": " + product + " price " + productPrice + " zł";
    }
}

package com.kodilla.good.patterns.challenges.Food2Door.builders;

public class OrderDto {
    private final double totalCost;
    private final double shippingCost;
    private final double foodCost;
    private final int deliveryTimeInMin;

    public OrderDto(int deliveryTimeInMin , double foodCost, double shippingCost) {
        this.deliveryTimeInMin = deliveryTimeInMin;
        this.shippingCost = shippingCost;
        this.foodCost = foodCost;
        totalCost = shippingCost + foodCost;
    }

    @Override
    public String toString() {
        return "\nOrder information:\n" +
                "Shipping cost: " + shippingCost + "\n" +
                "Food cost: " + foodCost + "\n" +
                "Total cost: " + totalCost + "\n" +
                "Delivery time: " + deliveryTimeInMin + " min";
    }
}

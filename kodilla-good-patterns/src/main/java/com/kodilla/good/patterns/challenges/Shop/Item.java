package com.kodilla.good.patterns.challenges.Shop;

public class Item {
    private final String itemName;
    private final double price;

    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}

package com.kodilla.good.patterns.challenges.Shop.Builders;

import com.kodilla.good.patterns.challenges.Shop.Builders.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Item> orderList = new ArrayList<>();
    public void addItem (Item item) {
        orderList.add(item);
    }

    public double callculatePrice() {
        double allItemPrice = 0;

        for (Item item : orderList) {
            allItemPrice += item.getPrice();
        }

        return allItemPrice;
    }

    public LocalDate getDeliveryTime() {
        return LocalDate.now().plusDays(orderList.size());
    }
}

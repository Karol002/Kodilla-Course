package com.kodilla.good.patterns.challenges.shop.ordercreators;

import com.kodilla.good.patterns.challenges.shop.builders.Item;
import com.kodilla.good.patterns.challenges.shop.builders.Order;
import com.kodilla.good.patterns.challenges.shop.builders.User;

public class OrderRequestRetriever {

    public OrderRequest retrieve () {
        User user = new User("Karol", "Warszawa", 1500);

        Order order = new Order();
        order.addItem(new Item("Rower", 1000));
        order.addItem(new Item("GamePad", 150));
        order.addItem(new Item("Lampka nocna", 100));

        return new OrderRequest(user, order);
    }

}

package com.kodilla.good.patterns.challenges.Shop;

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

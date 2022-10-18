package com.kodilla.good.patterns.challenges.Shop.OrderCreators;

import com.kodilla.good.patterns.challenges.Shop.Builders.Order;
import com.kodilla.good.patterns.challenges.Shop.Builders.User;

public class OrderRequest {
    private final User user;
    private final Order order;

    public OrderRequest(User user, Order order) {
        this.user = user;
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }
}

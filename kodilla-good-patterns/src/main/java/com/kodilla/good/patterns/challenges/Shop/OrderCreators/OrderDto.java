package com.kodilla.good.patterns.challenges.Shop.OrderCreators;

import com.kodilla.good.patterns.challenges.Shop.Builders.Order;
import com.kodilla.good.patterns.challenges.Shop.Builders.User;

public class OrderDto {
    private final User user;
    private final Order order;
    private final boolean orderAccept;

    public OrderDto(User user, Order order, boolean orderAccept) {
        this.user = user;
        this.order = order;
        this.orderAccept = orderAccept;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrderAccept() {
        return orderAccept;
    }

    public Order getOrder() {
        return order;
    }
}

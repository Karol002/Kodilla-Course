package com.kodilla.good.patterns.challenges.shop.ordercreators;

import com.kodilla.good.patterns.challenges.shop.builders.Order;
import com.kodilla.good.patterns.challenges.shop.builders.User;

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

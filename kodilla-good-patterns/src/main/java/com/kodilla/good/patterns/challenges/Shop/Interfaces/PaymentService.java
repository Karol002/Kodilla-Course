package com.kodilla.good.patterns.challenges.Shop.Interfaces;

import com.kodilla.good.patterns.challenges.Shop.Builders.Order;
import com.kodilla.good.patterns.challenges.Shop.Builders.User;

public interface PaymentService {

    void pay(User user, Order order);
}

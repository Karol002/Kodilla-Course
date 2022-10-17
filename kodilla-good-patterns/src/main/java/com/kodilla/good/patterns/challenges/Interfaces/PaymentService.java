package com.kodilla.good.patterns.challenges.Interfaces;

import com.kodilla.good.patterns.challenges.Shop.Order;
import com.kodilla.good.patterns.challenges.Shop.User;

public interface PaymentService {

    void pay(User user, Order order);
}

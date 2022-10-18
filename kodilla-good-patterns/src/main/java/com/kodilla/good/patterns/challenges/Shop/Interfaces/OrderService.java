package com.kodilla.good.patterns.challenges.Shop.Interfaces;

import com.kodilla.good.patterns.challenges.Shop.Builders.Order;
import com.kodilla.good.patterns.challenges.Shop.Builders.User;

public interface OrderService {

    boolean checkPaymentPossibility(User user, Order order);
}

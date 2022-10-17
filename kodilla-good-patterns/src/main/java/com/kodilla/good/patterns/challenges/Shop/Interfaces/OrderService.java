package com.kodilla.good.patterns.challenges.Shop.Interfaces;

import com.kodilla.good.patterns.challenges.Shop.Order;
import com.kodilla.good.patterns.challenges.Shop.User;

public interface OrderService {

    boolean checkPaymentPossibility(User user, Order order);
}

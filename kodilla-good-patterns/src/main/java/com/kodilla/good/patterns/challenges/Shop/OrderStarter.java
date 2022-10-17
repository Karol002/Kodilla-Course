package com.kodilla.good.patterns.challenges.Shop;

import com.kodilla.good.patterns.challenges.Shop.Interfaces.OrderService;

public class OrderStarter implements OrderService {

    @Override
    public boolean checkPaymentPossibility(User user, Order order) {
        return user.getWallet() >= order.callculatePrice();
    }
}

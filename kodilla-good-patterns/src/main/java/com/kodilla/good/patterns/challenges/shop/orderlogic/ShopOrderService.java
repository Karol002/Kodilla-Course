package com.kodilla.good.patterns.challenges.shop.orderlogic;

import com.kodilla.good.patterns.challenges.shop.builders.Order;
import com.kodilla.good.patterns.challenges.shop.builders.User;
import com.kodilla.good.patterns.challenges.shop.interfaces.OrderService;

public class ShopOrderService implements OrderService {

    @Override
    public boolean checkPaymentPossibility(User user, Order order) {
        return user.getWallet() >= order.callculatePrice();
    }
}

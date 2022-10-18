package com.kodilla.good.patterns.challenges.Shop.OrderLogic;

import com.kodilla.good.patterns.challenges.Shop.Builders.Order;
import com.kodilla.good.patterns.challenges.Shop.Builders.User;
import com.kodilla.good.patterns.challenges.Shop.Interfaces.OrderService;

public class ShopOrderService implements OrderService {

    @Override
    public boolean checkPaymentPossibility(User user, Order order) {
        return user.getWallet() >= order.callculatePrice();
    }
}

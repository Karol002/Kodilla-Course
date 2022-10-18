package com.kodilla.good.patterns.challenges.Shop.OrderLogic;

import com.kodilla.good.patterns.challenges.Shop.Builders.Order;
import com.kodilla.good.patterns.challenges.Shop.Builders.User;
import com.kodilla.good.patterns.challenges.Shop.Interfaces.PaymentService;

public class ShopPaymentService implements PaymentService {

    @Override
    public void pay(User user, Order order) {
            user.minusMoneyFromWallet(order.callculatePrice());
    }
}

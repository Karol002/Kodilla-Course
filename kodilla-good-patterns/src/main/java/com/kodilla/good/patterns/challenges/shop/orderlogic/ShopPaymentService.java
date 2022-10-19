package com.kodilla.good.patterns.challenges.shop.orderlogic;

import com.kodilla.good.patterns.challenges.shop.builders.Order;
import com.kodilla.good.patterns.challenges.shop.builders.User;
import com.kodilla.good.patterns.challenges.shop.interfaces.PaymentService;

public class ShopPaymentService implements PaymentService {

    @Override
    public void pay(User user, Order order) {
            user.minusMoneyFromWallet(order.callculatePrice());
    }
}

package com.kodilla.good.patterns.challenges.Shop;

import com.kodilla.good.patterns.challenges.Interfaces.PaymentService;

public class OrderPayer implements PaymentService {

    @Override
    public void pay(User user, Order order) {
            user.minusMoneyFromWallet(order.callculatePrice());
    }
}

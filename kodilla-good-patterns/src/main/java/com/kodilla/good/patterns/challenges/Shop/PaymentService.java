package com.kodilla.good.patterns.challenges.Shop;

public class PaymentService {

    public void pay(User user, Order order) {
        user.minusMoneyFromWallet(order.callculatePrice());
    }
}

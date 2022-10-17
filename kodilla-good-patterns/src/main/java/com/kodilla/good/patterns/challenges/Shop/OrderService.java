package com.kodilla.good.patterns.challenges.Shop;

public class OrderService {
    public boolean checkPaymentPossibility(User user, Order order) {
        return user.getWallet() >= order.callculatePrice();
    }
}

package com.kodilla.good.patterns.challenges.Shop;

public class InformationService {

    public void informUser(User user, Order order) {
        System.out.println(user.getName() + " na adress " + user.getAddress() +
                " zostało wysłane twoje zamówienie. Przewidywana data dostawy to " + order.getDeliveryTime() +
                " twój obecny stan konta to " + user.getWallet());
    }
}

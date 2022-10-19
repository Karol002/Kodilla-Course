package com.kodilla.good.patterns.challenges.shop.orderlogic;

import com.kodilla.good.patterns.challenges.shop.builders.Order;
import com.kodilla.good.patterns.challenges.shop.builders.User;
import com.kodilla.good.patterns.challenges.shop.interfaces.InformationService;

public class ShopInformationService implements InformationService {

    @Override
    public void informUser(User user, Order order) {
        System.out.println(user.getName() + " na adress " + user.getAddress() +
                " zostało wysłane twoje zamówienie. Przewidywana data dostawy to " + order.getDeliveryTime() +
                " twój obecny stan konta to " + user.getWallet());
    }
}

package com.kodilla.good.patterns.challenges.Shop.OrderLogic;

import com.kodilla.good.patterns.challenges.Shop.Builders.Order;
import com.kodilla.good.patterns.challenges.Shop.Builders.User;
import com.kodilla.good.patterns.challenges.Shop.Interfaces.InformationService;

public class ShopInformationService implements InformationService {

    @Override
    public void informUser(User user, Order order) {
        System.out.println(user.getName() + " na adress " + user.getAddress() +
                " zostało wysłane twoje zamówienie. Przewidywana data dostawy to " + order.getDeliveryTime() +
                " twój obecny stan konta to " + user.getWallet());
    }
}

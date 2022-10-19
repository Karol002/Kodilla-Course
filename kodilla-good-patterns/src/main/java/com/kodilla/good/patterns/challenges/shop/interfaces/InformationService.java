package com.kodilla.good.patterns.challenges.shop.interfaces;

import com.kodilla.good.patterns.challenges.shop.builders.Order;
import com.kodilla.good.patterns.challenges.shop.builders.User;

public interface InformationService {

    public void informUser(User user, Order order);
}

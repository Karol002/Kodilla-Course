package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.Food2Door.FoodOrder;
import com.kodilla.good.patterns.challenges.Food2Door.Suplliers.SupplierRetriever;
import com.kodilla.good.patterns.challenges.Food2Door.UserService;

public class MainFoodShop {

    public static void main(String [] args) {
        SupplierRetriever supplierRetriever = new SupplierRetriever();
        FoodOrder foodOrder = new FoodOrder(supplierRetriever.retrieve(), new UserService());

        foodOrder.createOrder();
    }
}

package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.Food2Door.FoodOrder;
import com.kodilla.good.patterns.challenges.Food2Door.builders.SupplierRetriever;
import com.kodilla.good.patterns.challenges.Food2Door.FoodUserService;

public class MainFoodShop {

    public static void main(String [] args) {
        SupplierRetriever supplierRetriever = new SupplierRetriever();
        FoodOrder foodOrder = new FoodOrder(supplierRetriever.retrieve(), new FoodUserService());

        foodOrder.createOrder();
    }
}

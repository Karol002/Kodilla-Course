package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.food2door.FoodOrder;
import com.kodilla.good.patterns.challenges.food2door.builders.SupplierRetriever;
import com.kodilla.good.patterns.challenges.food2door.FoodUserService;

public class MainFoodShop {

    public static void main(String [] args) {
        SupplierRetriever supplierRetriever = new SupplierRetriever();
        FoodOrder foodOrder = new FoodOrder(supplierRetriever.retrieve(), new FoodUserService());

        foodOrder.createOrder();
    }
}

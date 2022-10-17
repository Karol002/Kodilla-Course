package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.Suplliers.Supplier;

import java.util.List;

public class FoodOrder {
    private final List<Supplier> suppliers;
    private final UserService userInterface;

    public FoodOrder(List<Supplier> suppliers, UserService userInterface) {
        this.suppliers = suppliers;
        this.userInterface = userInterface;
    }

    public void createOrder() {
        userInterface.showShopInformation(suppliers);
        int supplier = userInterface.choseSupplier();

        OrderDto orderInfo = suppliers.get(supplier).process(userInterface.scanProductQuantity());
        userInterface.orderInformation(orderInfo);
    }
}

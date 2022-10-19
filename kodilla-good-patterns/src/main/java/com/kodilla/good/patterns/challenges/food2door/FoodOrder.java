package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.builders.Supplier;
import com.kodilla.good.patterns.challenges.food2door.builders.OrderDto;

import java.util.List;

public class FoodOrder {
    private final List<Supplier> suppliers;
    private final FoodUserService userInterface;

    public FoodOrder(List<Supplier> suppliers, FoodUserService userInterface) {
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

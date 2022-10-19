package com.kodilla.good.patterns.challenges.food2door.builders;

import java.util.ArrayList;
import java.util.List;

public class SupplierRetriever {

    public List<Supplier> retrieve() {
        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(new ExtraFoodShop("Extra food shop", "Burger", 8.0));
        suppliers.add(new GlutenFreeShop("Gluten free shop", "Musli", 5.0));
        suppliers.add(new HealthyShop("Healthy shop", "Greek salat", 10.0));

        return suppliers;
    }
}

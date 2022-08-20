package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<Continent> worldPeopleQuantity = new ArrayList<>();

    public void addContinent(Continent continent) {
        if (worldPeopleQuantity.contains(continent)) {
            System.out.println("Continent already is on the list");
        } else {
            worldPeopleQuantity.add(continent);
        }
    }

    public BigDecimal getWorldPeopleQuantity() {
        return worldPeopleQuantity.stream()
                .flatMap(continent -> continent.getCountriesPeopleQuantity().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

    }
}

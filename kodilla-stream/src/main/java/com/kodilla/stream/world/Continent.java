package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> continentsPeopleQuantity = new ArrayList<>();

    public void addCountry(Country country) {
        continentsPeopleQuantity.add(country);
    }

    public List<Country> getCountriesPeopleQuantity() {
        return continentsPeopleQuantity;
    }
}

package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {
    SALAD("salad"),
    ONION("onion"),
    BACON("bacon"),
    CUCUMBER("cucumber"),
    PEPPERS("peppers"),
    CHAMPIGNONS("champignons"),
    PRAWNS("prawns"),
    CHEESE("cheese");

    private final String name;

    Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

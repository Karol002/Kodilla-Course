package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final List<String> ingredients;
    private final Bread bread;
    private final Sauce sauce;
    private final int burgers;

    public static class BigmacBuilder {
        private List<String> ingredients = new ArrayList<>();
        private Bread bread;
        private Sauce sauce;
        private int burgers;

        public BigmacBuilder addIngredients(Ingredient ingredient) {
            ingredients.add(ingredient.getName());
            return this;
        }

        public BigmacBuilder setBread(String bread) {
            this.bread = new Bread(bread);
            return this;
        }

        public BigmacBuilder setSauce(String sauce) {
            this.sauce = new Sauce(sauce);
            return this;
        }

        public BigmacBuilder setBurgersQuantity(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public Bigmac build() {
            if (bread != null && sauce != null && burgers != 0) {
                return new Bigmac(ingredients, bread, sauce, burgers);
            } else {
                throw new IllegalStateException("Choose all required component");
            }
        }
    }

    private Bigmac(List<String> ingredients, Bread breadType, Sauce sauce, int burgers) {
        this.ingredients = ingredients;
        this.bread = breadType;
        this.sauce = sauce;
        this.burgers = burgers;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getBread() {
        return bread.getBreadType();
    }

    public String getSauce() {
        return sauce.getSauceType();
    }

    public int getBurgers() {
        return burgers;
    }

    @Override
    public String toString() {
        return "Your Bigmac " +
                "\nBread type: " + bread.getBreadType() +
                "\nSauce: " + sauce.getSauceType() +
                "\nBurgers quantity: " + burgers +
                "\nIngredients: " + ingredients;
    }
}

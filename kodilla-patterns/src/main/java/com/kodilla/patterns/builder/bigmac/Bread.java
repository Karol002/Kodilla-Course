package com.kodilla.patterns.builder.bigmac;

public class Bread {
    public static final String BUN = "bun";
    public static final String ROLL = "roll";
    public static final String SESAME_ROLL = "roll with sesame";
    private final String breadType;

    public Bread(String breadType) {
        if (breadType.equals(BUN) || breadType.equals(ROLL) || breadType.equals(SESAME_ROLL)) {
            this.breadType = breadType;
        } else {
            throw new IllegalStateException("We don't have this type of bread in menu");
        }
    }

    public String getBreadType() {
        return breadType;
    }
}

package com.kodilla.patterns.builder.bigmac;

public class Sauce {
    public static final String STANDARD = "standard";
    public static final String THOUSAND_ISLANDS = "1000 islands";
    public static final String BARBECUE = "barbecue";
    private final String sauceType;

    public Sauce(String sauceType) {
        if (sauceType.equals(STANDARD) || sauceType.equals(THOUSAND_ISLANDS) || sauceType.equals(BARBECUE)) {
            this.sauceType = sauceType;
        } else {
            throw new IllegalStateException("We don't have this type of sauce in menu");
        }
    }

    public String getSauceType() {
        return sauceType;
    }
}

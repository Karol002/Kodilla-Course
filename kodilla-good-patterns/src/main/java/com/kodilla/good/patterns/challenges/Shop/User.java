package com.kodilla.good.patterns.challenges.Shop;

public class User {
    private final String name;
    private final String address;
    private double wallet;

    public User(String name, String address, double wallet) {
        this.name = name;
        this.address = address;
        this.wallet = wallet;
    }

    public void addMoneyToWallet(double money) {
        wallet += money;
    }

    public void minusMoneyFromWallet(double money) {
        wallet -= money;
    }

    public double getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

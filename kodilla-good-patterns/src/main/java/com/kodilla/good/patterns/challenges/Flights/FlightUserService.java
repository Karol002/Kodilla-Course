package com.kodilla.good.patterns.challenges.Flights;

import java.util.Scanner;

public class FlightUserService {
    private final Scanner scanner = new Scanner(System.in);

    public void showAvailableCities() {
        System.out.println("""
                Available cities:
                1. Wrocław
                2. Warszawa
                3. Gdańsk
                4. Gdynia""");
    }

    public int choseCity(String text) {
        System.out.print(text + " ");
        return scanner.nextInt();
    }

    public int choseSearchMode() {
        System.out.print("""
                1. Check information about flight for chosen city
                2. check all flight from one city to other city
                Chose: """);
        return scanner.nextInt();
    }
}

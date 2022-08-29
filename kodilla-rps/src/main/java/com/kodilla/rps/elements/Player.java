package com.kodilla.rps.elements;

public class Player {
    private String name;
    private int points = 0;
    Figure actualMove;

    public void choseActualMove(int choice) {
        if (choice == 1) actualMove = Figure.stone;
        if (choice == 2) actualMove = Figure.paper;
        if (choice == 3) actualMove = Figure.scissors;
        if (choice == 4) actualMove = Figure.spock;
        if (choice == 5) actualMove = Figure.lizard;
    }

    public Figure getActualMove() {
        return actualMove;
    }

    public void addPoint() {
        points++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cleanPoints() {
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }
}

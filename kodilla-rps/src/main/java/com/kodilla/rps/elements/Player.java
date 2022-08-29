package com.kodilla.rps.elements;

public class Player {
    private String name;
    private int points;
    Figure actualMove;

    public Player() {
        this.name = name;
        this.points = 0;
    }

    public void setActualMove(int choice) {
        if (choice == 1) actualMove = Figure.stone;
        if (choice == 2) actualMove = Figure.paper;
        if (choice == 3) actualMove = Figure.scissors;
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

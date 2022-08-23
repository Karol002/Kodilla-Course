package com.kodilla.rps.elements;

public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
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

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}

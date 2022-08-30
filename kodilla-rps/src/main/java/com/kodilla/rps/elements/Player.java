package com.kodilla.rps.elements;

public class Player {
    private String name;
    private int points = 0;
    Figure actualMove;

    public Player() {
        this.name = "UnNamedPlayer";
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;

        if (getPoints() != player.getPoints()) return false;
        if (!getName().equals(player.getName())) return false;
        return getActualMove() == player.getActualMove();
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getPoints();
        result = 31 * result + getActualMove().hashCode();
        return result;
    }
}

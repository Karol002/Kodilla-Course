package com.kodilla.rps.elements;

public class Game {
    private Player player;
    private Player computer;
    private int roundsQuantity;
    private int actualRound = 1;

    public Game(Player player, Player computer) {
        this.player = player;
        this.computer = computer;
    }

    public boolean gameDecision(String decision) {
        if (decision.equals("x") || decision.equals("X")) {
            return true;
        } else if (decision.equals("n") || decision.equals("N")) {
            return false;
        } else {
            System.out.println("Error!!! You have entered incorrect data. Ending the game");
            return true;
        }
    }

    public String showStatistics() {
        return  "Round " + (actualRound-1) +
                "\n" + player.getName()  + " points: " + player.getPoints() +
                "\n" + computer.getName() + " points: " + computer.getPoints();
    }

    public String getRoundWinner(int playerDecision, int computerDecision) {
        actualRound++;

        if (playerDecision == computerDecision) {
            return "Remis";
        }
        if ((playerDecision == 1 && computerDecision == 3) ||
                (playerDecision == 2 && computerDecision == 1) ||
                (playerDecision == 3 && computerDecision == 2)) {
            player.addPoint();
            return "The winner is " + player.getName();
        } else {
            computer.addPoint();
            return "The winner is " + computer.getName();
        }
    }

    public boolean checkRoundsQuantity() {
       return (actualRound > roundsQuantity);
    }

    public String checkWinner() {
        if (player.getPoints() > computer.getPoints()) {
            return "The winner is " + player.getName();
        } else if (computer.getPoints() > player.getPoints()) {
            return "The winner is " + computer.getName();
        } else {
            return "Remis!";
        }
    }

    public void clean() {
        roundsQuantity = 0;
        actualRound = 1;
        computer.cleanPoints();
        player.cleanPoints();
    }

    public void setRoundsQuantity(int n) {
        roundsQuantity = n;
    }

    public String gameInfo() {
        return """
                1 key – playing stone
                2 key – playing paper
                3 key – playing scissors
                x key – the end of the game preceded by the question
                Are you sure to end the game?
                n key – starting the game from scratch preceded by the question
                Are you sure to end the current game?""";
    }
}

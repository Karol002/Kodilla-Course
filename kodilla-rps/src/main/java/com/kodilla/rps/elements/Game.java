package com.kodilla.rps.elements;

import java.util.Scanner;

public class Game {
    private Player player;
    private Player computer;

    private int playerDec;
    private int computerDec;
    private int roundsQuantity;
    private int actualRound;

    public Game(Player player, Player computer) {
        this.player = player;
        this.computer = computer;
        this.roundsQuantity = 0;
        this.actualRound = 1;
        this.playerDec = 0;
        this.computerDec = 0;
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

    public void selectMove(int p, int c) {
        playerDec = p;
        computerDec = c;
    }

    public String getRoundWinner() {
        if (playerDec == computerDec) {
            actualRound++;
            return "Remis";
        }
        if ((playerDec == 1 && computerDec == 3) ||
                (playerDec == 2 && computerDec == 1) ||
                (playerDec == 3 && computerDec == 2)) {
            player.addPoint();
            actualRound++;
            return "The winner is " + player.getName();
        } else {
            computer.addPoint();
            actualRound++;
            return "The winner is " + computer.getName();
        }
    }

    public boolean checkRoundsQuantity() {
        if (actualRound > roundsQuantity) {
            return true;
        } else {
            return false;
        }
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

    public void cleaner() {
        roundsQuantity = 0;
        actualRound = 1;
        playerDec = 0;
        computerDec = 0;
        computer.setPoints(0);
        player.setPoints(0);
    }

    public String gameInfo() {
        return "1 key – playing \"stone\",\n" +
                "2 key – playing \"paper\",\n" +
                "3 key – playing \"scissors\",\n" +
                "x key – the end of the game preceded by the question " +
                "\"Are you sure to end the game?\",\n" +
                "n key – starting the game from scratch preceded by the question " +
                "\"Are you sure to end the current game?\",";
    }

    public void setRoundsQuantity(int n) {
        roundsQuantity = n;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }

    public int getPlayerDec() {
        return playerDec;
    }

    public int getComputerDec() {
        return computerDec;
    }

    public int getRoundsQuantity() {
        return roundsQuantity;
    }

    public int getActualRound() {
        return actualRound;
    }
}

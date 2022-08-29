package com.kodilla.rps.elements;

import java.util.ArrayList;
import java.util.List;

public class Game implements Judge{
    private final List<Player> playerList = new ArrayList<>();
    private int roundsQuantity;
    private int actualRound = 1;

    public Game(Player player, Player computer1, Player computer2) {
        this.playerList.add(player);
        this.playerList.add(computer1);
        this.playerList.add(computer2);
    }

    public boolean checkGameDecision(String decision) {
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
        String statistics = "Round " + (actualRound-1);
        for(Player thePlayer : playerList) {
            statistics += "\n" + thePlayer.getName() + " points: " + thePlayer.getPoints();
        }
        return statistics;
    }

    public String singleRoundBattle(int userDecision, int computerDecision1, int computerDecision2) {
        playerList.get(0).choseActualMove(userDecision);
        playerList.get(1).choseActualMove(computerDecision1);
        playerList.get(2).choseActualMove(computerDecision2);
        String winnersLog = "";
        actualRound++;

        for (int i=0; i<playerList.size(); i++) {
            if (i==0) winnersLog += singleMoveBattle(playerList.get(i).getActualMove(),
                    playerList.get(1).getActualMove(), playerList.get(2).getActualMove(), i);

            if (i==1) winnersLog += singleMoveBattle(playerList.get(i).getActualMove(),
                    playerList.get(0).getActualMove(), playerList.get(2).getActualMove(), i);

            if (i==2) winnersLog += singleMoveBattle(playerList.get(i).getActualMove(),
                    playerList.get(1).getActualMove(), playerList.get(0).getActualMove(), i);

        }
        if (winnersLog.equals("")) return "There is no winners in this round";
        else return "Winners: " + winnersLog;
    }

    public String singleMoveBattle(Figure actualPlayerMove, Figure otherPlayerMove1, Figure otherPlayerMove2, int playerNumber) {

        if (actualPlayerMove.equals(Figure.stone) && Judge.checkResultForStone(otherPlayerMove1, otherPlayerMove2)) {
            playerList.get(playerNumber).addPoint();
            return playerList.get(playerNumber).getName() + " ";
        }
        else if (actualPlayerMove.equals(Figure.paper) && Judge.checkResultForPaper(otherPlayerMove1, otherPlayerMove2)) {
            playerList.get(playerNumber).addPoint();
            return playerList.get(playerNumber).getName() + " ";
        }
        else if (actualPlayerMove.equals(Figure.scissors) && Judge.checkResultForScissors(otherPlayerMove1, otherPlayerMove2)) {
            playerList.get(playerNumber).addPoint();
            return playerList.get(playerNumber).getName() + " ";
        }
        else if (actualPlayerMove.equals(Figure.spock) && Judge.checkResultForSpock(otherPlayerMove1, otherPlayerMove2)) {
            playerList.get(playerNumber).addPoint();
            return playerList.get(playerNumber).getName() + " ";
        }
        else if (actualPlayerMove.equals(Figure.lizard) && Judge.checkResultForLizard(otherPlayerMove1, otherPlayerMove2)) {
            playerList.get(playerNumber).addPoint();
            return playerList.get(playerNumber).getName() + " ";
        }
        else return "";
    }

    public boolean checkRoundsQuantity() {
       return (actualRound > roundsQuantity);
    }

    public String checkMatchWinner() {
        String winner = "Match winners: ";
        int theBiggestPointsQuantity = 0;
        int winnersQuantity = 0;

        for (Player thePlayer : playerList) {
            if (thePlayer.getPoints() > theBiggestPointsQuantity) theBiggestPointsQuantity = thePlayer.getPoints();
        }
        for (Player thePlayer : playerList) {
            if (thePlayer.getPoints() == theBiggestPointsQuantity) {
                winner += thePlayer.getName() + " ";
                winnersQuantity++;
            }
        }

        if (winnersQuantity >= 3) return "Draw!";
        else return  winner;
    }

    public void setPlayerNames(String playerName, String computerName1, String computerName2) {
        playerList.get(0).setName(playerName);
        playerList.get(1).setName(computerName1);
        playerList.get(2).setName(computerName2);
    }

    public void clean() {
        roundsQuantity = 0;
        actualRound = 1;
        for (Player thePlayer : playerList) {
            thePlayer.cleanPoints();
        }
    }

    public void setRoundsQuantity(int userInput) {
        roundsQuantity = userInput;
    }

    public int getActualRound() {
        return actualRound;
    }

    public int getRoundsQuantity() {
        return roundsQuantity;
    }

    public Player getPlayer(int playerNumber) {
        return playerList.get(playerNumber);
    }

    public String gameInfo() {
        return """
                1 key – playing stone
                2 key – playing paper
                3 key – playing scissors
                4 key – playing spock
                5 key – playing lizard
                x key – the end of the game preceded by the question
                Are you sure to end the game?
                n key – starting the game from scratch preceded by the question
                Are you sure to end the current game?""";
    }
}

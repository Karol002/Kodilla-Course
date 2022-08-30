package com.kodilla.rps.elements;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Game implements Judge{
    private final List<Player> playerList = new ArrayList<>();
    private int actualRound = 1;

    public Game(Player player, Player computer1, Player computer2) {
        this.playerList.add(player);
        this.playerList.add(computer1);
        this.playerList.add(computer2);
    }

    public String doRoundBattleSequence(int [] playersMoves) {
        Deque<Figure> battleDeque = new ArrayDeque<>();
        StringBuilder winnersLog = new StringBuilder();
        int playerNumber = 0;

        setPlayersMove(playersMoves);

        for (Player thePlayer : playerList) {
            for (Player checkingPlayer : playerList){
                if (!thePlayer.equals(checkingPlayer)) battleDeque.add(checkingPlayer.getActualMove());
            }
            winnersLog.append(doSingleMoveInBattle(thePlayer.getActualMove(),
                    battleDeque.poll(), battleDeque.poll(), playerNumber));
            playerNumber++;
        }

        actualRound++;
        if (winnersLog.toString().equals("")) return "There is no winners in this round";
        else return "Winners: " + winnersLog;
    }

    private String doSingleMoveInBattle(Figure actualPlayerMove, Figure otherPlayerMove1, Figure otherPlayerMove2, int playerNumber) {

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

    private void setPlayersMove(int [] playersMoves) {
        for (int i=0; i<playerList.size(); i++) {
            playerList.get(i).choseActualMove(playersMoves[i]);
        }
    }

    public String showStatistics() {
        String statistics = "Round " + (actualRound-1);
        for(Player thePlayer : playerList) {
            statistics += "\n" + thePlayer.getName() + " points: " + thePlayer.getPoints();
        }
        return statistics;
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

    public void setPlayerNames(String [] names) {
        for (int i=0; i<playerList.size(); i++) {
            playerList.get(i).setName(names[i]);
        }
    }

    public void clean() {
        actualRound = 1;
        for (Player thePlayer : playerList) {
            thePlayer.cleanPoints();
        }
    }


    public int getActualRound() {
        return actualRound;
    }


    public List<Player> getPlayerList() {
        return playerList;
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

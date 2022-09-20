package com.tictactoe.builders.logic;

import com.tictactoe.builders.presentation.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final List<String> gameData = new ArrayList<>();
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private final Presenter presenter = new Presenter();
    private final Judge judge = new Judge();
    private final int boardSize;
    private boolean endGame = false;
    private int lastMove;

    public Game(int boardSize) {
        this.boardSize = boardSize;
    }

    private void loadBoard() {
        if (!presenter.askForLoadGame()) {
            loadNewBoard();
        } else {
            loadOldBoard();
        }
    }

    private void loadOldBoard() {
        List<String> oldGame = presenter.askForOldGame();

        if (oldGame.size() != 9) {
            presenter.showLoadGameError();
            loadNewBoard();
        } else {
            gameData.addAll(oldGame);
        }
    }

    private void loadNewBoard() {
        for (int i=0; i<boardSize * boardSize; i++) {
            gameData.add(" ");
        }
    }

    private void setOpponentControl() {
        player2.setAi(presenter.askForOpponentControl());
    }

    private void setPlayersNames() {
        player1.setName(presenter.askForName(1));
        if (player2.isAi()) player2.setName("Computer");
        else player2.setName(presenter.askForName(2));
    }

    private void setFigures() {
        player1.setFigure("O");
        player2.setFigure("X");
    }

    private boolean choseRoundMove(Player player) {
        int decision;
        Random random = new Random();

        if (player.isAi()) decision = random.nextInt(9);
        else decision = presenter.askForRoundMove(player);

        lastMove = decision;
        if (decision == -1) {
            chosePauseModeDecision();
            return false;
        } else {
            return choseMovePlace(player, decision);
        }
    }

    private boolean choseMovePlace(Player player, int move) {
        String figure = player.getFigure();

        if (checkMovePossibility(move)) {
            gameData.set(move, figure);
            endGame = judge.checkEndGame(gameData);
            return judge.checkWinner(gameData, player, boardSize);
        } else {
            return choseRoundMove(player);
        }
    }

    private void chosePauseModeDecision() {
        if (presenter.askForGamePauseModeDecision().equals("e")) endGame = true;
        else presenter.askForSaveGame(gameData);
    }

    private void makeEndGame(Player player1, Player player2) {
        if (player1.isWinner()) presenter.showWinner(player1);
        else if (player2.isWinner()) presenter.showWinner(player2);
        else presenter.showDrawResult();
    }

    private boolean checkMovePossibility(int move) {
        return gameData.get(move).equals(" ");
    }

    private void prepareGame() {
        presenter.showInstruction(boardSize);
        setOpponentControl();
        setPlayersNames();
        setFigures();
        loadBoard();
    }

    public void makeSequence() {
        boolean turn = false;
        prepareGame();

        while (!endGame) {
            presenter.showBoard(gameData, boardSize);
            if (!turn) {
                player1.setWinner(choseRoundMove(player1));
                if (player1.isWinner()) {endGame = true;}
                if (lastMove != -1) turn = true;
            }
            else {
                player2.setWinner(choseRoundMove(player2));
                if  (player2.isWinner()) {endGame = true;}
                if (lastMove != -1) turn = false;
            }
            presenter.showEndRound();
        }
        makeEndGame(player1, player2);
        presenter.showBoard(gameData, boardSize);
    }

}

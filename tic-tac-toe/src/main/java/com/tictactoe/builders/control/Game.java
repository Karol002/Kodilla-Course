package com.tictactoe.builders.control;

import com.tictactoe.builders.ingredients.Judge;
import com.tictactoe.builders.ingredients.Player;
import com.tictactoe.builders.presentation.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    protected static final Presenter presenter = new Presenter();
    protected static final Judge judge = new Judge();
    private final List<String> gameData = new ArrayList<>();
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private boolean endGame = false;
    private int boardSize = 3;
    private int strike = 3;
    private int lastMove;

    protected void setStrike(int strike) {
        this.strike = strike;
    }

    protected List<String> getGameData() {
        return gameData;
    }

    protected void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    protected void loadBoard() {
        if (!presenter.askForLoadGame()) {
            loadNewBoard();
        } else {
            loadOldBoard();
        }
    }

    protected void loadOldBoard() {
        List<String> oldGame = presenter.askForOldGame();

        if (oldGame.size() != 9) {
            presenter.showLoadGameError();
            loadNewBoard();
        } else {
            gameData.addAll(oldGame);
        }
    }

    protected void loadNewBoard() {
        for (int i=0; i<boardSize * boardSize; i++) {
            gameData.add(" ");
        }
    }

    protected void setOpponentControl() {
        player2.setAi(presenter.askForOpponentControl());
    }

    protected void setPlayersNames() {
        player1.setName(presenter.askForName(1));
        if (player2.isAi()) player2.setName("Computer");
        else player2.setName(presenter.askForName(2));
    }

    protected void setFigures() {
        player1.setFigure("O");
        player2.setFigure("X");
    }

    protected boolean choseRoundMove(Player player) {
        int decision;
        Random random = new Random();

        if (player.isAi()) decision = random.nextInt(boardSize * boardSize);
        else decision = presenter.askForRoundMove(player, boardSize);

        lastMove = decision;
        if (decision == -1) {
            chosePauseModeDecision();
            return false;
        } else {
            return choseMovePlace(player, decision);
        }
    }

    protected boolean choseMovePlace(Player player, int move) {
        String figure = player.getFigure();

        if (checkMovePossibility(move)) {
            gameData.set(move, figure);
            endGame = judge.checkEndGame(gameData);
            return judge.checkWinner(gameData, player.getFigure(), boardSize);
        } else {
            return choseRoundMove(player);
        }
    }

    protected void chosePauseModeDecision() {
        if (presenter.askForGamePauseModeDecision().equals("e")) endGame = true;
        else presenter.askForSaveGame(gameData);
    }

    protected void makeEndGame(Player player1, Player player2) {
        if (player1.isWinner()) presenter.showWinner(player1);
        else if (player2.isWinner()) presenter.showWinner(player2);
        else presenter.showDrawResult();
    }

    protected boolean checkMovePossibility(int move) {
        return gameData.get(move).equals(" ");
    }

    protected void prepareGame() {
        presenter.showInstruction(boardSize);
        setOpponentControl();
        setPlayersNames();
        setFigures();
        loadBoard();
    }

    protected void makeBattle() {
        boolean turn = false;

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
    }

    public void makeSequence() {
        prepareGame();
        makeBattle();
        makeEndGame(player1, player2);
        presenter.showBoard(gameData, boardSize);
    }
}

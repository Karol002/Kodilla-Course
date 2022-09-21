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
    private final List<String> gameBoard = new ArrayList<>();
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private boolean endGame = false;
    boolean turn = false;
    private int boardSize = 3;
    private int strike = 3;

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    protected void setStrike(int strike) {
        this.strike = strike;
    }

    protected List<String> getGameBoard() {
        return gameBoard;
    }

    protected void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    protected void loadBoard() {
        for (int i=0; i<boardSize * boardSize; i++) {
            gameBoard.add(" ");
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
        if (decision < 0) choseRoundMove(player);
        return choseMovePlace(player, decision);
    }

    protected boolean choseMovePlace(Player player, int move) {
        String figure = player.getFigure();

        if (checkMovePossibility(move)) {
            gameBoard.set(move, figure);
            endGame = judge.checkEndGame(gameBoard);
            return judge.checkWinner(gameBoard, player.getFigure(), boardSize, strike);
        } else {
            return choseRoundMove(player);
        }
    }

    protected void makeEndGame(Player player1, Player player2) {
        if (player1.isWinner()) presenter.showWinner(player1);
        else if (player2.isWinner()) presenter.showWinner(player2);
        else presenter.showDrawResult();
    }

    protected boolean checkMovePossibility(int move) {
        return gameBoard.get(move).equals(" ");
    }

    protected void prepareGameData() {
        presenter.showBasicInstruction(boardSize);
        setOpponentControl();
        setPlayersNames();
        setFigures();
        loadBoard();
    }

    protected boolean controlActualTurn(boolean actualTurn)  {
        return !actualTurn;
    }

    protected void makeBattle() {
        presenter.showBoard(gameBoard, boardSize);
        if (!turn) {
            player1.setWinner(choseRoundMove(player1));
            if (player1.isWinner()) endGame = true;
        } else {
            player2.setWinner(choseRoundMove(player2));
            if (player2.isWinner()) endGame = true;
        }
        turn = controlActualTurn(turn);
        presenter.showEndRound();
    }

    public void makeSequence() {
        prepareGameData();
        while (!endGame) makeBattle();
        makeEndGame(player1, player2);
        presenter.showBoard(gameBoard, boardSize);
    }
}

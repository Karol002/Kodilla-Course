package com.tictactoe.builders.control;

import com.tictactoe.builders.ingredients.Judge;
import com.tictactoe.builders.ingredients.Player;
import com.tictactoe.builders.presentation.DataConverter;
import com.tictactoe.builders.presentation.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    protected static final Presenter presenter = new Presenter();
    private DataConverter dataConverter = new DataConverter();
    protected static final Judge judge = new Judge();
    private final List<String> gameBoard = new ArrayList<>();
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private boolean endGame = false;
    private boolean turn = false;
    private int rowSize = 3;
    private int strike = 3;
    private String path;
    private boolean newGame = false;
    private boolean isAdvanced = false;
    private boolean isHard = false;

    public void setHard(String hard) {
        isHard = hard.equals("Hard");
    }

    public boolean isEndGame() {
        return endGame;
    }

    public int getRowSize() {
        return rowSize;
    }

    public void setOpponentControl(String ai) {player2.setAi(ai.equals("Computer"));}

    public void setPlayersNames(String playerName, String opponentName) {
        player1.setName(playerName);
        if (player2.isAi()) player2.setName("Computer");
        else player2.setName(opponentName);
    }

    protected void setFigures() {
        player1.setFigure("O");
        player2.setFigure("X");
    }

    protected void loadNewBoard() {
        for (int i = 0; i< rowSize * rowSize; i++) {
            gameBoard.add(" ");
        }
    }

    protected boolean choseMovePlace(Player player, int move) {
        String figure = player.getFigure();

        gameBoard.set(move, figure);
        endGame = judge.checkEndGame(gameBoard);
        return judge.checkWinner(gameBoard, player.getFigure(), rowSize, strike);
    }

    public boolean checkMovePossibility(int move) {
        return gameBoard.get(move).equals(" ");
    }
    public boolean checkMovePossibilityMinMax(int move, List<String> minMax) {
        return minMax.get(move).equals(" ");
    }

    public void prepareGameData() {
        setFigures();
        loadBoard();
    }

    public boolean makeBattle(int move) {

        if (!turn) {
            player1.setWinner(choseMovePlace(player1, move));
            if (player1.isWinner()) endGame = true;
        } else {
            player2.setWinner(choseMovePlace(player2, move));
            if (player2.isWinner()) endGame = true;
        }

        turn = controlActualTurn(turn);
        return  !turn;
    }

    /////////////////////////////////////////////////////////////////////////////
    public void setNewGame(String newGame) {
        this.newGame = (newGame.equals("New Game"));
    }

    public void setAdvancedRowSize(String advanced) {
        isAdvanced = (advanced.equals("10x10 to 5"));
        if (isAdvanced) {
            rowSize = 10;
            strike = 5;
            path = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/OldGameTo5.txt";

        } else {
            rowSize = 3;
            strike = 3;
            path = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/OldGameTo3.txt";
        }
    }

    private void loadBoard() {
        if (newGame) {
            loadNewBoard();
        } else {
            loadOldBoard();
        }
    }

    private void loadOldBoard() {
        List<String> oldGame = dataConverter.loadGame(path);

        if (oldGame.size() != rowSize * rowSize) {
            loadNewBoard();
        } else {
            gameBoard.addAll(oldGame);
        }
    }

    private boolean controlActualTurn(boolean actualTurn) {
        return !actualTurn;
    }

    public void print () {
        System.out.println(endGame);
        presenter.showBoard(gameBoard, rowSize);
    }

    public void saveGame() {
        dataConverter.saveGame(gameBoard, path);
    }

    public boolean isNewGame() {
        return newGame;
    }

    public List<String> getGameBoard() {
        return gameBoard;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int makeAiMve() {
        if (!isHard) return makeEasyMove();
        else {
            int moven = makeHardMove();
           System.out.println(moven + " this is move");
           return moven;
        }
    }

    public int minMax(List<String> boardMinMax, int moveQuantity, int actualMove) {
        boardMinMax.set(actualMove, player2.getFigure());
        if (judge.checkEndGame(boardMinMax)) moveQuantity = 1000;
        else {
            for (int i = 0; i<boardMinMax.size(); i++) {
                if (checkMovePossibilityMinMax(i, boardMinMax)) {
                    boardMinMax.set(i, player2.getFigure());
                    System.out.println("board " + boardMinMax.size() + " player figure " + player2.getFigure() + " row size " + rowSize + " strike " +strike + " i " + i);
                    if (judge.checkWinner(boardMinMax, player2.getFigure(), rowSize, strike)) {
                        return moveQuantity++;
                    } else {
                        return minMax(boardMinMax, moveQuantity++, i);
                    }
                }
            }
        }
        return moveQuantity;
    }

    public int makeHardMove() {
        List<String> boardMinMax = new ArrayList<>();
        int lowestQuantity = 999999998;
        int quantityMoveToWin = 999999999;
        int bestMove = 777;

        for (String s : gameBoard) {
            boardMinMax.add(s);
        }

        for (int i=0; i<gameBoard.size(); i++) {
            if (checkMovePossibilityMinMax(i, boardMinMax)) {
                boardMinMax.set(i, player2.getFigure());
                if (judge.checkWinner(boardMinMax, player2.getFigure(), rowSize, strike)) {
                    bestMove = i;
                    System.out.println("Wygraj");
                    return i;
                }
                boardMinMax.set(i, " ");
            }
        }
        for (int i=0; i<gameBoard.size(); i++) {
            if (checkMovePossibilityMinMax(i, boardMinMax)) {
                boardMinMax.set(i, player1.getFigure());
                if (judge.checkWinner(boardMinMax, player1.getFigure(), rowSize, strike)) {
                    System.out.println("Blokuj");
                    bestMove = i;
                    return i;
                }
                boardMinMax.set(i, " ");
            }
        }

        for (int i=0 ; i<gameBoard.size(); i++) {
            if (checkMovePossibilityMinMax(i, boardMinMax)) {
                quantityMoveToWin = minMax(boardMinMax, quantityMoveToWin, i);
                if (quantityMoveToWin < lowestQuantity) bestMove = i;
            }
        }
        if (bestMove > gameBoard.size()) {
            System.out.println("Głupi ruch");
            return makeEasyMove();
        }
        //else
        return bestMove;
    }

    private int makeEasyMove() {
        Random random = new Random();
        int move = random.nextInt(gameBoard.size());

        while (!checkMovePossibility(move)) {
            move = random.nextInt(gameBoard.size());
        }
        return move;
    }

    public void repeatGame() {
        endGame = false;
        gameBoard.clear();
        player2.setWinner(false);
        player1.setWinner(false);
        turn = false;
        newGame = true;
        loadBoard();
    }

    public String winCredits() {
        String winner = "The winner is ";
        if (player1.isWinner()) winner += player1.getName();
        else if (player2.isWinner()) winner += player2.getName();
        else return "Draw!";

        return winner;
    }

}

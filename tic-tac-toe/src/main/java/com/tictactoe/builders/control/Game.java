package com.tictactoe.builders.control;

import com.tictactoe.builders.ingredients.Judge;
import com.tictactoe.builders.ingredients.Player;
import com.tictactoe.builders.presentation.DataConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final DataConverter dataConverter = new DataConverter();
    private static final Judge judge = new Judge();
    private final List<String> gameBoard = new ArrayList<>();
    private List<Integer> winnerLog;
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private boolean endGame = false;
    private boolean turn = false;
    private int rowSize = 3;
    private int strike = 3;
    private String savePath;
    private boolean newGame = false;
    private boolean isHard = false;
    private String winQuantityPath;

    public void setHard(String hard) {
        isHard = hard.equals("Hard");
    }

    public boolean isEndGame() {
        return endGame;
    }

    public int getRowSize() {
        return rowSize;
    }
    private boolean controlActualTurn(boolean actualTurn) {
        return !actualTurn;
    }

    public void setOpponentControl(String ai) {player2.setAi(ai.equals("Computer"));}

    public void saveGame() {
        dataConverter.saveGame(gameBoard, savePath);
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

    public Player getPlayer1() {return player1;}

    public void setNewGame(String newGame) {
        this.newGame = (newGame.equals("New Game"));
    }

    public List<Integer> getWinnerLog() {return winnerLog;}

    private void setWinQuantityPath() {
       if (player2.isAi() && rowSize == 3) winQuantityPath = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/PVC_to3.txt";
       else if (player2.isAi() && rowSize == 10) winQuantityPath = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/PVC_to5.txt";
       else if (!player2.isAi() && rowSize == 3) winQuantityPath = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/PVP_to3.txt";
       else if (!player2.isAi() && rowSize == 10) winQuantityPath = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/PVP_to5.txt";

       winnerLog = dataConverter.getWinQuantity(winQuantityPath);
    }

    private void saveWinQuantity() {
        dataConverter.saveWinQuantity(winnerLog, winQuantityPath);
    }


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

    public void prepareGameData() {
        setFigures();
        loadBoard();
        setWinQuantityPath();
    }

    public void setAdvancedRowSize(String advanced) {
        boolean isAdvanced = (advanced.equals("10x10 to 5"));
        if (isAdvanced) {
            rowSize = 10;
            strike = 5;
            savePath = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/OldGameTo5.txt";

        } else {
            rowSize = 3;
            strike = 3;
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
        List<String> oldGame = dataConverter.loadGame(savePath);

        if (oldGame.size() != rowSize * rowSize) {
            loadNewBoard();
        } else {
            gameBoard.addAll(oldGame);
        }
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

    private boolean choseMovePlace(Player player, int move) {
        String figure = player.getFigure();

        gameBoard.set(move, figure);
        endGame = judge.checkEndGame(gameBoard);
        return judge.checkWinner(gameBoard, player.getFigure(), rowSize, strike);
    }

    public boolean checkMovePossibility(int move) {
        return gameBoard.get(move).equals(" ");
    }
    private boolean checkMovePossibilityMinMax(int move, List<String> minMax) {
        return minMax.get(move).equals(" ");
    }

    public int makeAiMve() {
        if (!isHard) return makeEasyMove();
        else {
           return makeHardMove();
        }
    }

    private int minMax(List<String> boardMinMax, int moveQuantity, int actualMove) {
        boardMinMax.set(actualMove, player2.getFigure());
        if (judge.checkEndGame(boardMinMax)) moveQuantity = 1000;
        else {
            for (int i = 0; i<boardMinMax.size(); i++) {
                if (checkMovePossibilityMinMax(i, boardMinMax)) {
                    boardMinMax.set(i, player2.getFigure());
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

    private int makeHardMove() {
        List<String> boardMinMax = new ArrayList<>(gameBoard);
        int lowestQuantity = 999999998;
        int quantityMoveToWin = 999999999;
        int bestMove = 777;

        for (int i=0; i<gameBoard.size(); i++) {
            if (checkMovePossibilityMinMax(i, boardMinMax)) {
                boardMinMax.set(i, player2.getFigure());
                if (judge.checkWinner(boardMinMax, player2.getFigure(), rowSize, strike)) {
                    return i;
                }
                boardMinMax.set(i, " ");
            }
        }
        for (int i=0; i<gameBoard.size(); i++) {
            if (checkMovePossibilityMinMax(i, boardMinMax)) {
                boardMinMax.set(i, player1.getFigure());
                if (judge.checkWinner(boardMinMax, player1.getFigure(), rowSize, strike)) {
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
            return makeEasyMove();
        }

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

    public String makeEndGame() {
        String winner = "The winner is ";
        if (player1.isWinner()) {
            winner += player1.getName();
            winnerLog.set(0, winnerLog.get(0)+1);
        }
        else if (player2.isWinner()) {
            winner += player2.getName();
            winnerLog.set(1, winnerLog.get(1)+1);
        }
        else return "Draw!";

        saveWinQuantity();
        return winner;
    }
}

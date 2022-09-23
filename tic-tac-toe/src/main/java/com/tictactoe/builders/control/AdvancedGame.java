package com.tictactoe.builders.control;

import com.tictactoe.builders.ingredients.Player;

import java.util.List;
import java.util.Random;

public class AdvancedGame extends Game {
    private String path;
    private int lastMove;
    private int pauseValue = -1;

    protected void setAdvancedBoardSize() {
        boolean isAdvanced = (presenter.askForBoardSize().equals("b"));
        if (isAdvanced) {
            setBoardSize(10);
            setStrike(5);
            path = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/OldGameTo5.txt";

        } else {
            setBoardSize(3);
            setStrike(3);
            path = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/OldGameTo3.txt";
        }
    }

    protected void chosePauseModeDecision() {
        if (presenter.askForGamePauseModeDecision().equals("e")) setEndGame(true);
        else presenter.askForSaveGame(getGameBoard(), path);
    }

    protected void loadBoard() {
        if (!presenter.askForLoadGame()) {
            super.loadBoard();
        } else {
            loadOldBoard();
        }
    }

    protected void loadOldBoard() {
        List<String> oldGame = presenter.askForOldGame(path);

        if (oldGame.size() != getBoardSize() * getBoardSize()) {
            presenter.showLoadGameError();
            super.loadBoard();
        } else {
            getGameBoard().addAll(oldGame);
        }
    }

    protected boolean choseRoundMove(Player player) {
        int decision;
        Random random = new Random();

        if (player.isAi()) decision = random.nextInt(getGameBoard().size());
        else decision = presenter.askForRoundMove(player, getBoardSize());

        lastMove = decision;
        if (decision == pauseValue) {
            chosePauseModeDecision();
            return false;
        } else {
            return choseMovePlace(player, decision);
        }
    }

    protected boolean controlActualTurn(boolean actualTurn) {
        if (lastMove == pauseValue) return actualTurn;
        else return !actualTurn;
    }

    public void makeSequence() {
        setAdvancedBoardSize();
        super.makeSequence();
    }
}

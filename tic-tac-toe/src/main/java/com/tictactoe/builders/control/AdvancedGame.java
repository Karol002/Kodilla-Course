package com.tictactoe.builders.control;

import com.tictactoe.builders.ingredients.Player;

import java.util.List;
import java.util.Random;

public class AdvancedGame extends Game {
    private int lastMove;
    private boolean isAdvanced;

    protected void setAdvancedBoardSize() {
        isAdvanced = presenter.askForBoardSize();
        if (isAdvanced) {
            setBoardSize(10);
            setStrike(5);
        } else {
            setBoardSize(3);
            setStrike(3);
        }
    }

    protected void chosePauseModeDecision() {
        if (presenter.askForGamePauseModeDecision().equals("e")) setEndGame(true);
        else presenter.askForSaveGame(getGameBoard());
    }

    protected void loadBoard() {
        if (!presenter.askForLoadGame()) {
            super.loadBoard();
        } else {
            loadOldBoard();
        }
    }

    protected void loadOldBoard() {
        List<String> oldGame = presenter.askForOldGame();

        if (oldGame.size() != 9) {
            presenter.showLoadGameError();
            this.loadBoard();
        } else {
            getGameBoard().addAll(oldGame);
        }
    }

    protected boolean choseAdvancedRoundMove(Player player) {
        int decision;
        Random random = new Random();

        if (player.isAi()) decision = random.nextInt(getGameBoard().size() * getGameBoard().size());
        else decision = presenter.askForRoundMove(player, getGameBoard().size());

        lastMove = decision;
        if (decision == -1) {
            chosePauseModeDecision();
            return false;
        } else {
            return choseMovePlace(player, decision);
        }
    }

    protected boolean controlActualTurn(boolean actualTurn) {
        if (lastMove == -1) return actualTurn;
        else return !actualTurn;
    }

    public void makeSequence() {
        setAdvancedBoardSize();
        super.makeSequence();
    }
}

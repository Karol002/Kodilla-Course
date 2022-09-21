package com.tictactoe.builders.control;

import java.util.List;

public class AdvancedGame extends Game {
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
            getGameData().addAll(oldGame);
        }
    }

    public void makeAdvancedSequence() {
        setAdvancedBoardSize();
        makeSequence();
    }
}

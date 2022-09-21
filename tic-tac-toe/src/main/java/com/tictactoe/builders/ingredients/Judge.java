package com.tictactoe.builders.ingredients;

import java.util.List;

public class Judge {

    public boolean checkWinnerTo3(List <String> gameData, Player player, int size){
        String figure = player.getFigure();
        boolean isWinner = false;

        for (int i=0; i<gameData.size(); i+=size) {
            isWinner = true;
            for (int j=0; j<size; j++) {
                if (!(gameData.get(j+i).equals(figure))) isWinner = false;
            }
            if (isWinner) break;
        }

        if (!isWinner) {
            for (int i=0; i<size; i++) {
                isWinner = true;
                for (int j=0; j<gameData.size(); j+=size) {
                    if (!(gameData.get(j+i).equals(figure))) isWinner = false;
                }
                if (isWinner) break;
            }
        }

        if (!isWinner) {
            isWinner = true;
            for (int i=0; i<gameData.size(); i+=size+1) {
                if (!(gameData.get(i).equals(figure))) {
                    isWinner = false;
                    break;
                }
            }
        }

        if (!isWinner) {
            isWinner = true;
            for (int i=size-1; i<gameData.size(); i+=size-1) {
                if (!(gameData.get(i).equals(figure))) {
                    isWinner = false;
                    break;
                }
            }
        }

        return isWinner;
    }

    public boolean checkWinner(List <String> gameData, String figure, int size, int strike){
        boolean isWinner = false;
        int figuresStrike = 0;

        for (int i=0; i<gameData.size(); i+=size) {
            isWinner = true;
            for (int j=0; j<size; j++) {
                if (!(gameData.get(j+i).equals(figure))) figuresStrike = 0;
                else figuresStrike++;
                if (figuresStrike > (size/2)-1) break;
            }
            if (figuresStrike < strike) isWinner = false;
            if (isWinner) break;
        }

        if (!isWinner) {
            for (int i=0; i<size; i++) {
                isWinner = true;
                for (int j=0; j<gameData.size(); j+=size) {
                    if (!(gameData.get(j+i).equals(figure))) figuresStrike = 0;
                    else figuresStrike++;
                    if (figuresStrike > (size/2)-1) break;
                }
                if (figuresStrike < strike) isWinner = false;
                if (isWinner) break;
            }
        }

        if (!isWinner) {
            isWinner = true;
            for (int i=0; i<gameData.size(); i+=size+1) {
                if (!(gameData.get(i).equals(figure))) figuresStrike = 0;
                else figuresStrike++;
                isWinner = figuresStrike >= strike;
                if (isWinner) break;
            }
        }

        if (!isWinner) {
            isWinner = true;
            for (int i=size-1; i<gameData.size(); i+=size-1) {
                if (!(gameData.get(i).equals(figure))) figuresStrike = 0;
                else figuresStrike++;
                isWinner = figuresStrike >= strike;
                if (isWinner) break;
            }
        }

        return isWinner;
    }

    public boolean checkEndGame(List <String> gameData) {
        boolean end = true;
        for(String theGame : gameData) {
            if (theGame.equals(" ")) {
                end = false;
                break;
            }
        }
        return end;
    }

}

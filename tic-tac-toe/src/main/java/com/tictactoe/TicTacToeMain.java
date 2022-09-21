package com.tictactoe;


import com.tictactoe.builders.control.Game;


public class TicTacToeMain {
    public static void main(String[] args){
        Game gameBuilder = new Game();

        gameBuilder.makeSequence();
    }
}
if (isAdvanced) return judge.checkWinnerTo5(gameData, player, boardSize);
        else return judge.checkWinnerTo3(gameData, player, boardSize);
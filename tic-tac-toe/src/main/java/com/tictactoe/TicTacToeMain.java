package com.tictactoe;


import com.tictactoe.builders.logic.Game;


public class TicTacToeMain {
    public static void main(String[] args){
        Game gameBuilder = new Game(3);

        gameBuilder.makeSequence();
    }
}

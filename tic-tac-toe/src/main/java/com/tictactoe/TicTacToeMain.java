package com.tictactoe;


import com.tictactoe.builders.control.AdvancedGame;


public class TicTacToeMain {
    public static void main(String[] args){
        AdvancedGame gameBuilder = new AdvancedGame();
        gameBuilder.makeSequence();
    }
}
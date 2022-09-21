package com.tictactoe.builders.presentation;

import com.tictactoe.builders.ingredients.Player;

import java.util.List;

public class Presenter {
    private final DataConverter dataConverter = new DataConverter();

    public void showBoard (List board, int size) {
        int indexNumber = 0;
        for(int i=0; i<size; i++) {
            System.out.print("|");
            for (int j=0; j<size; j++) {
                System.out.print(board.get(indexNumber) + "|");
                indexNumber++;
            }
            System.out.println();
        }
    }

    public void showEndRound() {
        System.out.println("##################");
    }

    public void showWinner(Player player) {
        System.out.println("The winner is " + player.getName() + " Figure: " + player.getFigure());
    }

    public void showDrawResult() {
        System.out.println("Draw!");
    }

    public String askForName(int playerNumber) {
        System.out.print("Player " + playerNumber + " enter your name: ");
        return dataConverter.askForName();
    }

    public boolean askForOpponentControl() {
        System.out.print("""
            If you want to play with computer press 'c'
            If you want to play with player press 'p'
            Chose opponent:""");
        return dataConverter.getOpponentControl();
    }

    public boolean askForLoadGame() {
        System.out.print("If you like start new game press 'n', If you want load old game press 'l': ");
        return dataConverter.getNewGameDecision();
    }

    public int askForRoundMove(Player player, int size){
        System.out.print("Enter your move " + player.getName() + ": ");
        return dataConverter.getRoundMove(size) - 1;
    }

    public String askForGamePauseModeDecision() {
        System.out.print("Enter your decision: ");
        return dataConverter.getGamePauseModeDecision();
    }

    public List<String> askForOldGame() {
        System.out.println("Loading the game");
        return dataConverter.loadGame();
    }

    public void showLoadGameError() {
        System.out.println("Invalid old game data. Starting new Game");
    }

    public void askForSaveGame(List<String> thGame) {
        System.out.println("Saving the game");
        if (dataConverter.saveGame(thGame)) System.out.println("Save successful");
        else System.out.println("Save error");
    }

    public boolean askForBoardSize() {
        System.out.print("""
                If you want to play normal game to 3 on board 3x3 press 'n'
                If you want to play big size game to 5 on board 10x10 press 'b'""");
        return dataConverter.setBoardSize();
    }

    public void showInstruction(int size) {
        System.out.println("""
             Hey, here is simple instruction
             1. If you want to enter in Save/Exit mode press 0.
             Then
             - If you want to save game press 's'.
             - If you want to exit game press 'e'.
             2. If you want to chose move place press 1-9,
             here is places numbers""");

        int indexNumber = 1;
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(indexNumber + "|");
                indexNumber++;
            }
            System.out.println();
        }
    }
}

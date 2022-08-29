package com.kodilla.rps;

import com.kodilla.rps.elements.Game;
import com.kodilla.rps.elements.Player;

import java.util.Random;
import java.util.Scanner;

public class RPSMain {
    public static void main(String[] args){
        Game game = new Game(new Player(), new Player(), new Player());

        boolean repeat = false;
        boolean end = false;
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        while (!repeat) {
            System.out.println("------------THE NEW GAME STARTS------------");

            System.out.println("Enter your name");
            game.setPlayerNames(scan.next(), "VirtualPlayer1", "VirtualPlayer2");
            System.out.println("How many rounds should the game have");
            game.setRoundsQuantity(scan.nextInt());
            System.out.println(game.gameInfo());

            while (!end) {
                System.out.println("\nSelect your move " + game.getPlayer(0).getName());
                System.out.println("Round result: " + game.singleRoundBattle(scan.nextInt(),
                        random.nextInt(3)+1, random.nextInt(3)+1));
                System.out.println(game.showStatistics());
                end = game.checkRoundsQuantity();
            }

            System.out.println("\n \n \n" + "---------------" + game.checkMatchWinner() + "---------------");
            System.out.println("Statistics: \n" + game.showStatistics());
            System.out.println();

            System.out.println("Do you want to repeat the game? ");
            System.out.println("If yes press n, if dont press x");
            repeat = game.checkGameDecision(scan.next());
            end = repeat;
            game.clean();
        }

    }
}

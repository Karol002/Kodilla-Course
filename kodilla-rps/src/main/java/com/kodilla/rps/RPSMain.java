package com.kodilla.rps;

import com.kodilla.rps.elements.Game;
import com.kodilla.rps.elements.Player;

import java.util.Random;
import java.util.Scanner;

public class RPSMain {
    public static void main(String[] args){
        boolean repeat = false;
        boolean end = false;

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        Player player = new Player();
        Player computer = new Player();
        Game game = new Game(player, computer);

        while (!repeat) {
            System.out.println("------------THE NEW GAME STARTS------------");

            System.out.println("Enter your name");
            player.setName(scan.next());

            System.out.println("How many rounds should the game have");
            game.setRoundsQuantity(scan.nextInt());

            System.out.println(game.gameInfo());

            while (!end) {
                System.out.println("\nSelect your move " + player.getName());
                System.out.println("Round result: " + game.getRoundWinner(scan.nextInt(),
                        random.nextInt(3)+1));
                System.out.println(game.showStatistics());
                end = game.checkRoundsQuantity();
            }

            System.out.println("\n \n \nThe game result: " + game.checkWinner());
            System.out.println("Statistics: \n" + game.showStatistics());
            System.out.println();

            System.out.println("Do you want to repeat the game? ");
            System.out.println("If yes press n, if dont press x");
            repeat = game.gameDecision(scan.next());
            end = repeat;
            game.clean();
        }

    }
}

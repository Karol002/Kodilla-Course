package com.kodilla.rps;

import com.kodilla.rps.elements.Game;
import com.kodilla.rps.elements.Player;

import java.util.Random;
import java.util.Scanner;

public class RPSMain {
    public static void main(String[] args){
        int playerMove;
        int computerMove;
        int rounds;
        String gameDecision;
        boolean repeat = false;
        boolean end = false;
        String name;
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        Player player = new Player("Player");
        Player computer = new Player("NPC");
        Game game = new Game(player, computer);

        while (!repeat) {
            System.out.println("------------THE NEW GAME STARTS------------");

            System.out.println("Enter your name");
            name = scan.next();
            player.setName(name);

            System.out.println("How many rounds should the game have");
            rounds = scan.nextInt();
            game.setRoundsQuantity(rounds);

            System.out.println(game.gameInfo());

            while (!end) {
                System.out.println();
                System.out.println("Select your move " + player.getName());
                playerMove = scan.nextInt();
                computerMove = random.nextInt(3)+1;
                game.selectMove(playerMove, computerMove);

                System.out.println("Round result: " + game.getRoundWinner());
                System.out.println(game.showStatistics());
                end = game.checkRoundsQuantity();
            }
            System.out.println("\n \n \nThe game result: " + game.checkWinner());
            System.out.println("Statistics: \n" + game.showStatistics());
            System.out.println();

            System.out.println("Do you want to repeat the game? ");
            System.out.println("If yes press n, if dont press x");
            gameDecision = scan.next();
            repeat = game.gameDecision(gameDecision);
            end = repeat;
            game.cleaner();
        }

    }
}

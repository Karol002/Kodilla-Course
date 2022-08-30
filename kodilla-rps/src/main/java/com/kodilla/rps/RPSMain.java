package com.kodilla.rps;

import com.kodilla.rps.elements.Game;
import com.kodilla.rps.elements.Player;

import java.util.Scanner;

import static com.kodilla.rps.elements.DataConverter.selectMoves;
import static com.kodilla.rps.elements.DataConverter.selectPlayersName;
import static com.kodilla.rps.elements.Judge.checkGameDecision;
import static com.kodilla.rps.elements.Judge.checkRoundsQuantity;

public class RPSMain {
    public static void main(String[] args){
        Player userPlayer = new Player();
        Game game = new Game(userPlayer, new Player(), new Player());
        Scanner scan = new Scanner(System.in);

        int playersQuantity = game.getPlayerList().size();
        int roundsQuantity;
        boolean repeat = false;
        boolean end = false;

        while (!repeat) {
            System.out.println("------------THE NEW GAME STARTS------------");

            System.out.println("Enter your name");
            game.setPlayerNames(selectPlayersName(playersQuantity, scan.next()));
            System.out.println("How many rounds should the game have");
            roundsQuantity = scan.nextInt();
            System.out.println(game.gameInfo());

            while (!end) {
                System.out.println("\nSelect your move " + userPlayer.getName());
                System.out.println("Round result: " + game.doRoundBattleSequence(selectMoves
                        (playersQuantity, scan.nextInt())));
                System.out.println(game.showStatistics());
                end = checkRoundsQuantity(game, roundsQuantity);
            }

            System.out.println("\n \n \n" + "---------------" + game.checkMatchWinner() + "---------------");
            System.out.println("Statistics: \n" + game.showStatistics());
            System.out.println();

            System.out.println("Do you want to repeat the game? ");
            System.out.println("If yes press n, if dont press x");
            repeat = checkGameDecision(scan.next());
            end = repeat;
            game.clean();
        }
    }
}

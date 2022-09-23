package com.tictactoe.builders.presentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DataConverter {
    private final Scanner scan = new Scanner(System.in);

    public int getRoundMove(int size) {
        int userInput = 10;

        try {
            userInput = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
        } finally {
            if (userInput < 0 || userInput > size * size) {
                System.out.print("Incorrect data try again: ");
                userInput = getRoundMove(size);
            }
        }
        return userInput;
    }

    public boolean getNewGameDecision() {
        String userInput = scan.next();

        while(!(userInput.equals("n") || userInput.equals("l"))) {
            System.out.print("Incorrect data try again: ");
            userInput = scan.next();
        }
        return userInput.equals("l");
    }

    public boolean getOpponentControl() {
        String userInput = scan.next();

        while(!(userInput.equals("c") || userInput.equals("p"))) {
            System.out.print("Incorrect data try again: ");
            userInput = scan.next();
        }
        return userInput.equals("c");
    }

    public String getGamePauseModeDecision() {
        String userInput = scan.next();

        while(!(userInput.equals("s") || userInput.equals("e"))) {
            System.out.print("Incorrect data try again: ");
            userInput = scan.next();
        }
        return userInput;
    }

    public List<String> loadGame(String path) {
        ArrayList<String> oldGame = new ArrayList<>();
        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) oldGame.add(scanner.nextLine());
        } catch (IOException e) {
            System.out.println("Loading error");
        }

        return convertOldGameData(oldGame);
    }

    private List<String> convertOldGameData(List<String> oldGame) {
        List<String> convertGame = new ArrayList<>();
        boolean dataCorrect = true;

        for (String thePlace : oldGame) {
            if (thePlace.equals("X") || thePlace.equals("O") || thePlace.equals(".")) {
                if (thePlace.equals(".")) convertGame.add(" ");
                else convertGame.add(thePlace);
            } else {
                dataCorrect = false;
            }
        }
        if (!dataCorrect) convertGame.clear();
        return convertGame;
    }

    public boolean saveGame(List<String> theGame, String path) {
        boolean saveSuccessful = true;

        try {
            FileWriter writer = new FileWriter(path);
            for (String thePlace : theGame) {
                if (thePlace.equals(" ")) writer.write(".\n");
                else writer.write(thePlace + "\n");
            }
            writer.close();
        } catch (IOException e) {
            saveSuccessful = false;
        }
        return saveSuccessful;
    }

    public String setBoardSize() {
        String chose = scan.next();

        while (!(chose.equals("b") || chose.equals("n"))) {
            System.out.println("Incorrect data try again: ");
            chose = setBoardSize();
        }
        return  chose;
    }

    public String askForName() {
        return scan.next();
    }
}

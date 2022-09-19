package com.tictactoe.builders.presentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DataConverter {
    private final Scanner scan = new Scanner(System.in);

    public int getRoundMove() {
        int userInput = 10;

        try {
            userInput = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
        } finally {
            if (userInput < 0 || userInput > 9) {
                System.out.print("Incorrect data try again: ");
                userInput = getRoundMove();
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

    public List<String> loadGame() {
        ArrayList<String> oldGame = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("OldGame.txt")).getFile());
        Path path = Paths.get(file.getPath());

        try{
            Scanner scanner = new Scanner(path);
            while(scanner.hasNextLine()) {
                oldGame.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("File not found");
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

    public boolean saveGame(List<String> theGame) {
        boolean saveSuccessful = true;

        try {
            FileWriter writer = new FileWriter("/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/OldGame.txt");
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

    public String askForName() {
        return scan.next();
    }
}

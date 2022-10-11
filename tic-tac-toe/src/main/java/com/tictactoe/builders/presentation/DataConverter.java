package com.tictactoe.builders.presentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DataConverter {
    private final Scanner scan = new Scanner(System.in);

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

    public void saveGame(List<String> theGame, String path) {

        try {
            FileWriter writer = new FileWriter(path);
            for (String thePlace : theGame) {
                if (thePlace.equals(" ")) writer.write(".\n");
                else writer.write(thePlace + "\n");
            }
            writer.close();
        } catch (IOException ignored) {
        }
    }

    public ArrayList<Integer> getWinQuantity(String path) {
        ArrayList<Integer> oldGame = new ArrayList<>();
        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) oldGame.add(Integer.parseInt(scanner.nextLine()));
        } catch (IOException e) {
            System.out.println("Loading error");
        }

        if (oldGame.size() != 2) {
            oldGame.clear();
            oldGame.add(0);
            oldGame.add(0);
        }

        return oldGame;
    }

    public void saveWinQuantity(List<Integer> theGame, String path) {

        try {
            FileWriter writer = new FileWriter(path);
            for (Integer thePlace : theGame) {
                writer.write(thePlace + "\n");
            }
            writer.close();
        } catch (IOException ignored) {
        }
    }
}

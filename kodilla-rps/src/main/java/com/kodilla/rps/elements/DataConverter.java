package com.kodilla.rps.elements;

import java.util.Random;

public interface DataConverter {
    static int [] selectMoves(int size, int userChoice) {
        Random random = new Random();
        int [] moveChoice = new int[size];

        for (int i=0; i < moveChoice.length; i++) {
            if (i == 0) moveChoice[i] = userChoice;
            else moveChoice[i] = random.nextInt(3) + 1;
        }
        return moveChoice;
    }

    static String [] selectPlayersName(int size, String userName) {
        String [] selectedNames = new String[4];

        for (int i = 0; i < selectedNames.length; i++) {
            if (i == 0) selectedNames[i] = userName;
            else selectedNames[i] = "VirtualPlayer" +  i;
        }
        return selectedNames;
    }
}

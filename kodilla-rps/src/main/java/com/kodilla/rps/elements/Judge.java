package com.kodilla.rps.elements;

public interface Judge {
    static boolean checkResultForStone(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return ((otherPlayerMove1.equals(Figure.scissors) || otherPlayerMove2.equals(Figure.scissors)
                || otherPlayerMove1.equals(Figure.lizard) || otherPlayerMove2.equals(Figure.lizard))
                && !otherPlayerMove2.equals(Figure.paper) && !otherPlayerMove1.equals(Figure.paper)
                && !otherPlayerMove2.equals(Figure.spock) && !otherPlayerMove1.equals(Figure.spock));
    }

    static boolean checkResultForPaper(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return (otherPlayerMove1.equals(Figure.stone) || otherPlayerMove2.equals(Figure.stone)
                || otherPlayerMove1.equals(Figure.spock) || otherPlayerMove2.equals(Figure.spock))
                && !otherPlayerMove2.equals(Figure.scissors) && !otherPlayerMove1.equals(Figure.scissors)
                && !otherPlayerMove2.equals(Figure.lizard) && !otherPlayerMove1.equals(Figure.lizard);
    }

    static boolean checkResultForScissors(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return (otherPlayerMove1.equals(Figure.paper) || otherPlayerMove2.equals(Figure.paper)
                || otherPlayerMove1.equals(Figure.lizard) || otherPlayerMove2.equals(Figure.lizard))
                && !otherPlayerMove2.equals(Figure.stone) && !otherPlayerMove1.equals(Figure.stone)
                && !otherPlayerMove2.equals(Figure.spock) && !otherPlayerMove1.equals(Figure.spock);
    }

    static boolean checkResultForSpock(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return (otherPlayerMove1.equals(Figure.scissors) || otherPlayerMove2.equals(Figure.scissors)
                || otherPlayerMove1.equals(Figure.stone) || otherPlayerMove2.equals(Figure.stone))
                && !otherPlayerMove2.equals(Figure.lizard) && !otherPlayerMove1.equals(Figure.lizard)
                && !otherPlayerMove2.equals(Figure.paper) && !otherPlayerMove1.equals(Figure.paper);
    }

    static boolean checkResultForLizard(Figure otherPlayerMove1, Figure otherPlayerMove2) {
        return (otherPlayerMove1.equals(Figure.paper) || otherPlayerMove2.equals(Figure.paper)
                || otherPlayerMove1.equals(Figure.spock) || otherPlayerMove2.equals(Figure.spock))
                && !otherPlayerMove2.equals(Figure.stone) && !otherPlayerMove1.equals(Figure.stone)
                && !otherPlayerMove2.equals(Figure.scissors) && !otherPlayerMove1.equals(Figure.scissors);
    }
}

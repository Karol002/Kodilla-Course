package com.tictactoe.builders.control;

public class AdvancedGame  {
    private String path;
    private int lastMove;
    private int pauseValue = -1;
    private boolean newGame = false;
    private boolean isAdvanced = false;


    //public void setNewGame(String newGame) {
     //   this.newGame = (newGame.equals("New Game"));
   // }

  //  protected void setAdvanced(String advanced) {
      //  isAdvanced = (advanced.equals("10x10 to 5"));
   // }

//    public void setAdvancedRowSize(String advanced) {
       // setAdvanced(advanced);
      //  if (isAdvanced) {
     //       setRowSize(10);
    //        setStrike(5);
   //         path = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/OldGameTo5.txt";

       // } else {
            //setRowSize(3);
          //  setStrike(3);
        //    path = "/home/karol/GitHub/kodilla-course/tic-tac-toe/src/main/resources/OldGameTo3.txt";
      //  }
    //}

   // protected void chosePauseModeDecision() {
     //   if (presenter.askForGamePauseModeDecision().equals("e")) setEndGame(true);
   //     else presenter.askForSaveGame(getGameBoard(), path);
 //   }

   // protected void loadBoard() {
        //if (newGame) {
        //    super.loadBoard();
       // } else {
       //     loadOldBoard();
      //  }
    //}

   // protected void loadOldBoard() {
      //  List<String> oldGame = presenter.askForOldGame(path);

       // if (oldGame.size() != getRowSize() * getRowSize()) {
         //   presenter.showLoadGameError();
        //    super.loadBoard();
       // } else {
       //     getGameBoard().addAll(oldGame);
     //   }
   // }

    //protected boolean choseRoundMove(Player player) {
        //int decision;
        //Random random = new Random();

        //if (player.isAi()) decision = random.nextInt(getGameBoard().size());
        //else decision = presenter.askForRoundMove(player, getRowSize());

        //lastMove = decision;
        //if (decision == pauseValue) {
        //    chosePauseModeDecision();
        //    return false;
      //  } else {
       //     return choseMovePlace(player, decision);
      //  }
  //  }

   // protected boolean controlActualTurn(boolean actualTurn) {
    //    if (lastMove == pauseValue) return actualTurn;
   //     else return !actualTurn;
  //  }

    public void print() {
        System.out.println("New game " + newGame);
        System.out.println("Advanced  " + isAdvanced);
     //   System.out.println(getRowSize());
     //   System.out.println(player1.getName());
     //   System.out.println(player2.getName());
    }

    public void makeSequence() {
        //setNewGame
        //setAdvancedRowSize();
       // super.makeSequence();
    }
}

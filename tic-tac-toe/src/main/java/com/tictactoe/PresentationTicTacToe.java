package com.tictactoe;

import com.tictactoe.builders.control.Game;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.RED;

public class PresentationTicTacToe extends Application {
    Game game = new Game();
    List<Tile> board = new ArrayList<>();
    TurnTile turnTile = new TurnTile();
    Label winLabel = new Label();
    Button repeatButton = new Button("Repeat Game");
    Label turnLabel = new Label("Turn player: ");
    final int paneWidth = 450;
    final int paneHeight = 600;


    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(paneWidth,paneHeight);

        final int rowSize = game.getRowSize();
        final int tilePosition = paneWidth / rowSize;
        int tileNumber = 0;

        winLabel.setVisible(false);
        winLabel.setLayoutX(120); winLabel.setLayoutY(510);
        winLabel.setPrefSize(250, 29);
        winLabel.setFont(Font.font(19));




        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<rowSize; j++) {
                board.add(new Tile());
                board.get(tileNumber).setTranslateY((i * tilePosition) + 40);
                board.get(tileNumber).setTranslateX(j * tilePosition);

                root.getChildren().add(board.get(tileNumber));
                board.get(tileNumber).setTileNumber(tileNumber);
                tileNumber++;
            }
        }


        turnLabel.setPrefSize(150.0, 29.0);
        turnLabel.setLayoutX(150.0); turnLabel.setLayoutY(510.0);
        turnLabel.setFont(Font.font(19.0));

        Toolbar toolbar = new Toolbar();
        root.getChildren().addAll(turnLabel, turnTile, toolbar, winLabel, repeatButton);

        if (!game.isNewGame()) {
            for (int i=0; i<board.size(); i++) {
                if (game.getGameBoard().get(i).equals("X")) board.get(i).draw("X");
                else if (game.getGameBoard().get(i).equals("O")) board.get(i).draw("O");
            }
        }

        return root;
    }

    public void repeatGame() {
        game.repeatGame();
        board.clear();
        repeatButton.setVisible(false);
        winLabel.setVisible(false);
        turnLabel.setVisible(true);
        turnTile.draw("O");
        turnTile.setVisible(true);
    }

    private static class TurnTile extends StackPane {
        private final Text text = new Text();

        public TurnTile() {
            Rectangle border = new Rectangle(20, 20);
            setTranslateX(280); setTranslateY(515);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            text.setFont(Font.font(15));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

        }

        private void draw(String figure) {
            text.setText(figure);
            Color color;
            if (figure.equals("X")) color = BLUE;
            else color = RED;
            text.setFill(color);
        }
    }

    public class Toolbar extends ToolBar {

        public Toolbar() {

            this.setLayoutX(1); this.setLayoutY(0);
            this.setPrefSize(449, 40);
            Button saveGameButton = new Button("Save Game");
            saveGameButton.setOnMouseClicked(event -> saveGame());
            this.getItems().addAll(saveGameButton);
        }

        private void saveGame() {
            game.saveGame();
        }
    }


    private class Tile extends StackPane {
        private final Text text = new Text();
        private int tileNumber = 0;
        final int rowSize = game.getRowSize();

        public void setTileNumber(int tileNumber) {
            this.tileNumber = tileNumber;
        }

        public Tile() {
            int rectangleSize = paneWidth / rowSize;
            Rectangle border = new Rectangle(rectangleSize, rectangleSize);
            border.setFill(null);
            border.setStroke(Color.BLACK);
            if (rowSize == 3) text.setFont(Font.font(72));
            else text.setFont(Font.font(24));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text, turnTile);
            setCursor(Cursor.HAND);

            setOnMouseClicked(event -> {
                    if (makeMove()) showWinner();
            });
        }

        public void draw(String figure) {
            text.setText(figure);
            Color color;
            if (figure.equals("X")) color = BLUE;
            else color = RED;
            text.setFill(color);
        }

        public boolean makeMove() {
            if (!game.isEndGame()) {
                if (game.checkMovePossibility(tileNumber)) {
                    setCursor(Cursor.DEFAULT);
                    if (game.makeBattle(tileNumber)) {
                        draw("X");
                        turnTile.draw("O");
                    }
                    else {
                        draw("O");
                        turnTile.draw("X");
                    }
                    computerMove();
                }
            }
            game.print();
            return game.isEndGame();
        }
    }


    public void showWinner() {
        winLabel.setText(game.winCredits());
        winLabel.setVisible(true);
        turnLabel.setVisible(false);
        turnTile.setVisible(false);
        repeatButton.setVisible(true);
    }

    public void computerMove() {
        if (game.getPlayer2().isAi() && !game.isEndGame()) {
            int pcMove = game.makeAiMve();
            System.out.println(pcMove);
            game.makeBattle(pcMove);
            board.get(pcMove).draw("X");
            turnTile.draw("O");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(600, 450);

        Label welcomeLabel = new Label("Player please configure your game");
        welcomeLabel.setPrefSize(513.0, 44.0);
        welcomeLabel.setLayoutX(44.0); welcomeLabel.setLayoutY(14.0);
        welcomeLabel.setFont(Font.font(29.0));

        Label gameModeLabel = new Label("Chose game mode");
        gameModeLabel.setPrefSize(330.0, 29.0);
        gameModeLabel.setLayoutX(24.0); gameModeLabel.setLayoutY(75.0);
        gameModeLabel.setFont(Font.font(18.0));

        ChoiceBox<String> gameMode = new ChoiceBox<>();
        gameMode.getItems().addAll("3x3 to 3", "10x10 to 5");
        gameMode.setValue("Chose");
        gameMode.setPrefSize(198.0, 35.0);
        gameMode.setLayoutX(364.0); gameMode.setLayoutY(73.0);

        Label difficultlyLevelLabel = new Label("Chose difficultly Level");
        difficultlyLevelLabel.setPrefSize(330.0, 29.0);
        difficultlyLevelLabel.setLayoutX(24.0); difficultlyLevelLabel.setLayoutY(265.0);
        difficultlyLevelLabel.setFont(Font.font(18.0));
        difficultlyLevelLabel.setVisible(false);

        ChoiceBox<String> difficultlyLevel = new ChoiceBox<>();
        difficultlyLevel.getItems().addAll("Easy", "Hard");
        difficultlyLevel.setValue("Chose");
        difficultlyLevel.setPrefSize(198.0, 35.0);
        difficultlyLevel.setLayoutX(364.0); difficultlyLevel.setLayoutY(265.0);
        difficultlyLevel.setVisible(false);

        Label newGameLabel = new Label("Would you like load old game?");
        newGameLabel.setPrefSize(330.0, 29.0);
        newGameLabel.setLayoutX(24.0); newGameLabel.setLayoutY(118.0);
        newGameLabel.setFont(Font.font(18.0));

        ChoiceBox<String> newGame = new ChoiceBox<>();
        newGame.getItems().addAll("New Game", "Load Game");
        newGame.setValue("Chose");
        newGame.setPrefSize(198.0, 35.0);
        newGame.setLayoutX(364.0); newGame.setLayoutY(118.0);

        Label opponentNameLabel = new Label("Enter your name Player 2");
        opponentNameLabel.setPrefSize(330.0, 29.0);
        opponentNameLabel.setLayoutX(24.0); opponentNameLabel.setLayoutY(265.0);
        opponentNameLabel.setFont(Font.font(18.0));
        opponentNameLabel.setVisible(false);

        TextField opponentName = new TextField();
        opponentName.setPrefSize(198.0, 35.0);
        opponentName.setLayoutX(364.0); opponentName.setLayoutY(265.0);
        opponentName.setFont(Font.font(19));
        opponentName.setVisible(false);

        Label opponentLabel = new Label("Set opponent");
        opponentLabel.setPrefSize(330.0, 29.0);
        opponentLabel.setLayoutX(24.0); opponentLabel.setLayoutY(166.0);
        opponentLabel.setFont(Font.font(18.0));

        ChoiceBox<String> opponent = new ChoiceBox<>();
        opponent.getItems().addAll("Computer", "Other Player");
        opponent.setValue("Chose");
        opponent.setPrefSize(198.0, 35.0);
        opponent.setLayoutX(364.0); opponent.setLayoutY(166.0);
        opponent.setOnAction(e -> getOpponentChoice(opponent, opponentNameLabel, opponentName, difficultlyLevelLabel, difficultlyLevel));

        Label playerNameLabel = new Label("Enter your name Player 1");
        playerNameLabel.setPrefSize(330.0, 29.0);
        playerNameLabel.setLayoutX(24.0); playerNameLabel.setLayoutY(218.0);
        playerNameLabel.setFont(Font.font(18.0));

        TextField playerName = new TextField();
        playerName.setPrefSize(198.0, 35.0);
        playerName.setLayoutX(364.0); playerName.setLayoutY(218.0);
        playerName.setFont(Font.font(19));

        repeatButton.setPrefSize(388.0, 38.0);
        repeatButton.setLayoutX(31.0); repeatButton.setLayoutY(550.0);
        repeatButton.setVisible(false);
        repeatButton.setFont(Font.font(19));
        repeatButton.setOnMouseClicked(e -> {
            repeatGame();
            primaryStage.setScene(new Scene((createContent())));
            primaryStage.show();
        });

        Button startGameButton = new Button("StartGame");
        startGameButton.setPrefSize(388.0, 38.0);
        startGameButton.setLayoutX(106.0); startGameButton.setLayoutY(370.0);
        startGameButton.setVisible(false);
        startGameButton.setFont(Font.font(19));
        startGameButton.setOnAction(e -> {
            primaryStage.setScene(new Scene(createContent()));
            primaryStage.show();
        });

        Button saveGameButton = new Button("Save settings");
        saveGameButton.setPrefSize(388.0, 38.0);
        saveGameButton.setLayoutX(106.0); saveGameButton.setLayoutY(320.0);
        saveGameButton.setFont(Font.font(19));
        saveGameButton.setOnAction(e -> checkDataCorrect(gameMode, newGame, opponent, opponentName, playerName, welcomeLabel, game, startGameButton, difficultlyLevel));

        root.getChildren().addAll(gameMode, newGame, opponent, playerName, opponentName,saveGameButton, startGameButton, difficultlyLevelLabel);
        root.getChildren().addAll(welcomeLabel,gameModeLabel, newGameLabel, opponentLabel, playerNameLabel, opponentNameLabel, difficultlyLevel);
        Scene scene = new Scene(root, 600, 451, Color.GRAY);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void getOpponentChoice(ChoiceBox<String> opponent, Label opponentNameLabel, TextField opponentName, Label difficultlyLevelLabel, ChoiceBox<String> difficultlyLevel) {
        if (opponent.getValue().equals("Computer")) {
            opponentNameLabel.setVisible(false);
            opponentName.setVisible(false);
            difficultlyLevelLabel.setVisible(true);
            difficultlyLevel.setVisible(true);
        } else {
            opponentNameLabel.setVisible(true);
            opponentName.setVisible(true);
            difficultlyLevelLabel.setVisible(false);
            difficultlyLevel.setVisible(false);
        }
    }

    public void checkDataCorrect(ChoiceBox<String> gameMode, ChoiceBox<String> newGame,
                                 ChoiceBox<String> opponent, TextField opponentName, TextField playerName,
                                 Label welcomeLabel, Game game, Button startGameButton, ChoiceBox<String> difficultlyLevel) {

        if (opponent.getValue().equals("Other Player") || (opponent.getValue().equals("Chose"))) {
            if (gameMode.getValue().equals("Chose") || newGame.getValue().equals("Chose") || opponent.getValue().equals("Chose")
                    || opponentName.getText().equals("") || playerName.getText().equals("")) {
                welcomeLabel.setText("               Enter all data!");
            } else {
                game.setNewGame(newGame.getValue());
                game.setAdvancedRowSize(gameMode.getValue());
                game.setOpponentControl(opponent.getValue());
                game.setPlayersNames(playerName.getText(), opponentName.getText());
                game.prepareGameData();
                game.setHard(difficultlyLevel.getValue());

                startGameButton.setVisible(true);
            }
        }  else {
            if (gameMode.getValue().equals("Chose") || newGame.getValue().equals("Chose") || opponent.getValue().equals("Chose")
                    || playerName.getText().equals("") || difficultlyLevel.getValue().equals("Chose")) {
                welcomeLabel.setText("               Enter all data!");
            } else {
                game.setNewGame(newGame.getValue());
                game.setAdvancedRowSize(gameMode.getValue());
                game.setOpponentControl(opponent.getValue());
                game.setPlayersNames(playerName.getText(), opponentName.getText());
                game.prepareGameData();
                game.setHard(difficultlyLevel.getValue());

                startGameButton.setVisible(true);
            }
        }
    }
}


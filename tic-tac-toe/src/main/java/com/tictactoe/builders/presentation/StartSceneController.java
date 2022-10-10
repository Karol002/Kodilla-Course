package com.tictactoe.builders.presentation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StartSceneController implements Initializable {

    @FXML
    private ChoiceBox<String> gameMode;

    @FXML
    private ChoiceBox<String> oldGame;

    @FXML
    private ChoiceBox<String> opponent;

    @FXML
    private TextField opponentName;

    @FXML
    private TextField playerName;

    @FXML
    private Button startGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameMode.getItems().addAll("3x3 to 3", "10x10 to 5");
        oldGame.getItems().addAll("Old Game", "New Game");
        opponent.getItems().addAll("Player", "Computer");
    }
}




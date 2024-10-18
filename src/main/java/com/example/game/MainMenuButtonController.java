package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MainMenuButtonController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button startButton;
    MainMenuViewManager viewManager=new MainMenuViewManager();
    @FXML
    protected void onStartButtonClick()  {
        viewManager.createGameView();
        startButton.getScene().getWindow().hide();
    }

}


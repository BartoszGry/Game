package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private Button startButton;
    ViewManager viewManager=new ViewManager();
    @FXML
    protected void onStartButtonClick()  {
        viewManager.createGameView();
        startButton.getScene().getWindow().hide();
    }

}


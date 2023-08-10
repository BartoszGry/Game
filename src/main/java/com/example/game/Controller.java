package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.awt.event.ActionEvent;

public class Controller {
    @FXML
    private Label welcomeText;

    ViewManager viewManager=new ViewManager();
    @FXML
    protected void onStartButtonClick()  {
        viewManager.createGameView();
    }

}


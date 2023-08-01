package com.example.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {
    @FXML
    private Label welcomeText;
    private Parent root;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private Stage stage;
    private ViewMenager menager;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    protected void switchSceneMenu(ActionEvent event) throws IOException {

    }
    protected void switchSceneGame(ActionEvent event) throws IOException {
    }
}


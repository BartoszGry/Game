package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewMenager menager= new ViewMenager();
        menager.setMainMenu();
        stage=menager.getMainStage();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
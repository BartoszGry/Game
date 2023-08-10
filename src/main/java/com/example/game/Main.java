package com.example.game;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewManager manager= new ViewManager();
        manager.setMainMenu();
        stage=manager.getMainStage();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
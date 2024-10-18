package com.example.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuViewManager {
    private static final int HEIGHT=800;
    private static final int WIDTH=600;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    GameViewManager gameView;
    MainMenuButtonController controller;


    public MainMenuViewManager() {
      mainPane=new AnchorPane();
      mainScene=new Scene(mainPane,WIDTH,HEIGHT);
      mainStage=new Stage();
      mainStage.setTitle("Game");
      mainStage.setResizable(false);
      mainStage.setScene(mainScene);
    }

    public Stage getMainStage(){
        return mainStage;
    }
    public void setMainMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene mainMenu= new Scene(fxmlLoader.load(),WIDTH,HEIGHT);
        mainStage.setScene(mainMenu);
    }
    public void createGameView(){
        gameView=new GameViewManager();
        gameView.gameStage.show();
    }

}

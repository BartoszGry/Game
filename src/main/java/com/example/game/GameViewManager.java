package com.example.game;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private static final int GAME_WIDTH=600;
    private static final int GAME_HEIGHT=800;
    KeyHandler keyH=new KeyHandler();
    private Stage menuP;


    public GameViewManager(){
        initializeStage();
        gameScene.setOnKeyPressed(keyH);
        gameScene.setOnKeyReleased(keyH);
    }

    public void initializeStage(){
        gamePane=new AnchorPane();
        gameScene= new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage=new Stage();
        gameStage.setScene(gameScene);
    }

    public void createNewGame(Stage menuP){
        this.menuP=menuP;
        this.menuP.hide();
        gameStage.show();
    }
}

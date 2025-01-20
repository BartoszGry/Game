package com.example.game;

import com.example.entity.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Set;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    public Stage gameStage;
    public static final int GAME_WIDTH=600;
    public static final int GAME_HEIGHT=800;
    KeyHandler keyH = new KeyHandler();//todo przeniesc do game satte

    private GameState gameState;
    private UpdateHandler updateHandler;

    public GameViewManager(){
        gameState=new GameState();
        gamePane=new AnchorPane();
        gameScene= new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage=new Stage();
        gameStage.setScene(gameScene);
        gamePane.getChildren().add(gameState.getLevel());
        gameScene.setOnKeyPressed(keyH);
        gameScene.setOnKeyReleased(keyH);
        updateHandler=new UpdateHandler(gameState, keyH);

    }





}

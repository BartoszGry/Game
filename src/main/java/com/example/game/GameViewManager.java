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

    boolean goLeft,goRight,idle;
    public Player player;
    private Scene gameScene;
    public Stage gameStage;
    private static final int GAME_WIDTH=600;
    private static final int GAME_HEIGHT=800;
    KeyHandler keyH = new KeyHandler();
    private AnimationTimer gameLoop;
    private GameState gameState=new GameState();
    private UpdateHandler updateHandler=new UpdateHandler(gameState);


    public GameViewManager(){
        initializeStage();
        setLevel();
        gameScene.setOnKeyPressed(keyH);
        gameScene.setOnKeyReleased(keyH);
        gameLoop=createGameLoop();
        gameLoop.start();
    }

    private AnimationTimer createGameLoop() {
        return new AnimationTimer() {
            public void handle(long now) {
                updateHandler.update(keyH.getActiveKeys());
//                if (gameState.isGameOver()) {
//                    this.stop();
//                }
            }
        };
    }



    public void setLevel(){
        gamePane.getChildren().add(gameState.getLevel());
    }
    public void initializeStage(){
        gamePane=new AnchorPane();
        gameScene= new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage=new Stage();
        gameStage.setScene(gameScene);
    }


}

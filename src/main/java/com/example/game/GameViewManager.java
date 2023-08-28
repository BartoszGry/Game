package com.example.game;

import com.example.entity.Player;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameViewManager {
    private AnchorPane gamePane;
    private Group level;
    boolean goLeft,goRight,idle;
    public Player player;
    private Scene gameScene;
    public Stage gameStage;
    private static final int GAME_WIDTH=600;
    private static final int GAME_HEIGHT=800;
    KeyHandler keyH=new KeyHandler();

    public GameViewManager(){
        initializeStage();
        setPlayer();
        gameScene.setOnKeyPressed(keyH);
        gameScene.setOnKeyReleased(keyH);
    }

    public void setPlayer(){
        player=new Player();
        level=new Group(player);
        gamePane.getChildren().add(level);
        player.setLayoutX(252);
        player.setLayoutY(650);
    }
    public void initializeStage(){
        gamePane=new AnchorPane();
        gameScene= new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage=new Stage();
        gameStage.setScene(gameScene);
    }

}

package com.example.game;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameViewManager {
    private AnchorPane gamePane;
    private Node ship;
    boolean goLeft,goRight,idle;
    private static final String SHIP_IMAGE_LOC ="C:\\Users\\beneh\\intelij\\Game\\src\\main\\resources\\images\\spaceship.png";
    private Image spaceShipImg;
    private Scene gameScene;
    public Stage gameStage;
    private static final int GAME_WIDTH=600;
    private static final int GAME_HEIGHT=800;
    KeyHandler keyH=new KeyHandler();
    private Stage menuP;


    public GameViewManager(){
        initializeStage();
        setShip();
        gameScene.setOnKeyPressed(keyH);
        gameScene.setOnKeyReleased(keyH);
    }

    public void setShip(){
        spaceShipImg=new Image(SHIP_IMAGE_LOC);
        ship=new ImageView(spaceShipImg);
        Group level = new Group(ship);
        gamePane.getChildren().add(level);
        ship.setLayoutX(252);
        ship.setLayoutY(650);
    }
    public void initializeStage(){
        gamePane=new AnchorPane();
        gameScene= new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage=new Stage();
        gameStage.setScene(gameScene);
    }

}

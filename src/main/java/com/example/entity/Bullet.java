package com.example.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet extends ImageView {
    private static final String ENEMY_IMAGE_LOC ="C:\\Users\\beneh\\intelij\\Game\\src\\main\\resources\\images\\spaceship.png";
    private Image enemyShipImg;
    private final double width=10;
    private final double height=10;
    public Bullet() {
        super();
        this.enemyShipImg=new Image(ENEMY_IMAGE_LOC);
        setImage(enemyShipImg);
        setFitWidth(width);
        setFitHeight(height);
    }

    public Bullet(double startPositionX, double startPositionY) {
        super();
        this.enemyShipImg=new Image(ENEMY_IMAGE_LOC);
        setImage(enemyShipImg);
        setFitWidth(width);
        setFitHeight(height);
        setLayoutX(startPositionX);
        setLayoutY(startPositionY);
    }
}

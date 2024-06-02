package com.example.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends ImageView {
    private static final String ENEMY_IMAGE_LOC ="C:\\Users\\beneh\\intelij\\Game\\src\\main\\resources\\images\\spaceship.png";
    private Image enemyShipImg;
    public Enemy() {
        super();
        this.enemyShipImg=new Image(ENEMY_IMAGE_LOC);
        setImage(enemyShipImg);
    }
}

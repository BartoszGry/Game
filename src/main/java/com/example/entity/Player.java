package com.example.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView {
    private static final String SHIP_IMAGE_LOC ="C:\\Users\\beneh\\intelij\\Game\\src\\main\\resources\\images\\spaceship.png";
    private Image spaceShipImg;
    public Player() {
        super();
        this.spaceShipImg=new Image(SHIP_IMAGE_LOC);
        setImage(spaceShipImg);
    }
}

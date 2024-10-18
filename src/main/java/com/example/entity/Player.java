package com.example.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView {
    private static final String SHIP_IMAGE_LOC ="C:\\Users\\beneh\\intelij\\Game\\src\\main\\resources\\images\\spaceship.png";
    private Image spaceShipImg;
    public final static double speed=2;
    private int layoutX=252;
    private int layoutY=650;
    private final int width=1;
    private final int height=1;
    public Player() {
        super();
        this.spaceShipImg=new Image(SHIP_IMAGE_LOC);
        setImage(spaceShipImg);
        setLayoutX(layoutX);
        setLayoutY(layoutY);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setLayoutX(int layoutX) {
        this.layoutX = layoutX;
    }

    public void setLayoutY(int layoutY) {
        this.layoutY = layoutY;
    }

    public double getSpeed() {
        return speed;
    }
}

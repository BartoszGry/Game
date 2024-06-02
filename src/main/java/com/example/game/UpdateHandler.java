package com.example.game;

import com.example.entity.Player;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class UpdateHandler {

    private GameState gameState;

    private final Bounds wallBounds;
    private Player player;

    private double minX=0,minY=400,width=600,height=350;


    private int layoutX=252;
    private int layoutY=650;
    private static final Point2D LEFT_VECTOR = new Point2D(-1, 0);
    private static final Point2D RIGHT_VECTOR = new Point2D(1, 0);
    private static final Point2D UP_VECTOR = new Point2D(0, 1);
    private static final Point2D DOWN_VECTOR = new Point2D(0, -1);

    public UpdateHandler(GameState gameState) {
        this.gameState = gameState;
        this.player=gameState.getPlayer();
        wallBounds = new BoundingBox(
        minX,minY,width,height
        );
        double defaultSpeed = Player.speed;
    }


    private Point2D reflect(Point2D vector, Point2D normal) {
        return vector.subtract(normal.multiply(vector.dotProduct(normal) * 2));
    }


    public void update(Set<KeyCode> activeKeys) {
        if (activeKeys.contains(KeyCode.W)){
            layoutY=layoutY-2;
            player.relocate(layoutX,layoutY);
        }
        if (activeKeys.contains(KeyCode.A)){
            layoutX=layoutX-4;
            player.relocate(layoutX-1,layoutY);
        }
        if (activeKeys.contains(KeyCode.D)){
            layoutX=layoutX+4;
            player.relocate(layoutX,layoutY);
        }
        if (activeKeys.contains(KeyCode.S)) {
            layoutY=layoutY+2;
            player.relocate(layoutX,layoutY);
        }

    }



}



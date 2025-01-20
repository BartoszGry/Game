package com.example.game;

import com.example.entity.Player;
import javafx.animation.AnimationTimer;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class UpdateHandler {

    private GameState gameState;
    private AnimationTimer gameLoop;
    private final Bounds wallBounds;
    private Player player;

    private double minX = 0, minY = 400, width = 600, height = 350;
private KeyHandler keyH;
    private EnemyManager enemyManager;
    private int layoutX = 252;
    private int layoutY = 650;

    public UpdateHandler(GameState gameState, KeyHandler keyH) {
        this.gameState = gameState;
        this.player = gameState.getPlayer();
        this.enemyManager = gameState.getEnemyManager();
        wallBounds = new BoundingBox(
                minX, minY, width, height
        );
        this.keyH=keyH;
        double defaultSpeed = Player.speed;
        gameLoop=createGameLoop();
        gameLoop.start();
    }


    public void update(Set<KeyCode> activeKeys) {
        Bounds playerBounds = player.getBoundsInParent();

        if (activeKeys.contains(KeyCode.W)) {
            int newY = layoutY - 5;
            if (newY >= wallBounds.getMinY()) {
                layoutY = newY;
                player.relocate(layoutX, layoutY);
            }
        }
        if (activeKeys.contains(KeyCode.A)) {
            int newX = layoutX - 6;
            if (newX >= wallBounds.getMinX()) {
                layoutX = newX;
                player.relocate(layoutX, layoutY);
            }
        }
        if (activeKeys.contains(KeyCode.D)) {
            int newX = layoutX + 6;
            if (newX + playerBounds.getWidth() <= wallBounds.getMaxX()) {
                layoutX = newX;
                player.relocate(layoutX, layoutY);
            }
        }
        if (activeKeys.contains(KeyCode.S)) {
            int newY = layoutY + 5;
            if (newY + playerBounds.getHeight() <= wallBounds.getMaxY()) {
                layoutY = newY;
                player.relocate(layoutX, layoutY);
            }
        }
        enemyManager.updateLayoutForEnemies();
    }
    private AnimationTimer createGameLoop() {
        return new AnimationTimer() {
            public void handle(long now) {
                update(keyH.getActiveKeys());
//                if (gameState.isGameOver()) {
//                    this.stop();
//                }
            }
        };
    }

}







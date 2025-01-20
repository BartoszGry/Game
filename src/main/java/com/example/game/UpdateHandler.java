package com.example.game;

import com.example.entity.Bullet;
import com.example.entity.Player;
import javafx.animation.AnimationTimer;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
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
    private List<Bullet> bullets;
    private long lastShootTime = 0; // Czas ostatniego strzału
    private static final long SHOOT_COOLDOWN = 100; // Cooldown w milisekundach (np. 300ms)

    public UpdateHandler(GameState gameState, KeyHandler keyH) {
        this.gameState = gameState;
        this.player = gameState.getPlayer();
        this.enemyManager = gameState.getEnemyManager();
        wallBounds = new BoundingBox(
                minX, minY, width, height
        );
        bullets=new ArrayList<>();
        this.keyH = keyH;
        double defaultSpeed = Player.speed;
        gameLoop = createGameLoop();
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
        if (activeKeys.contains(KeyCode.SPACE)) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastShootTime >= SHOOT_COOLDOWN) {
                shootBullet(player); // Strzał
                lastShootTime = currentTime; // Zaktualizuj czas ostatniego strzału
            }
        }

        updateBullets();
        enemyManager.updateLayoutForEnemies();
    }

    private void updateBullets() {
        if (bullets!=null&&!bullets.isEmpty()) {
            bullets.removeIf(bullet -> {
                bullet.relocate(bullet.getLayoutX(), bullet.getLayoutY() - 2);
                if (bullet.getLayoutY() < 0) {
                    gameState.getLevel().getChildren().remove(bullet); // Usuń z poziomu
                    return true; // Usuń z listy bullets
                }
                return false; // Nie usuwaj, jeśli warunek nie jest spełniony
            });
        }
    }

    private void shootBullet(Player player) {
        Bullet bullet = new Bullet(player.getLayoutX(), player.getLayoutY());
        bullets.add(bullet);
        gameState.getLevel().getChildren().add(bullet);
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







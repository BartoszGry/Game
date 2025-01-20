package com.example.game;

import com.example.entity.Enemy;
import javafx.scene.Group;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.game.GameViewManager.GAME_WIDTH;

public class EnemyManager {
    private static final int ROW_HEIGHT = 100;
    private List<Enemy> enemies;
    private final int ENEMIES_PER_ROW = 5;
    private final int SPACE_BETWEEN_ENEMY=10;
    private int rows=0;
    private List<List<Enemy>> enemyRows;
    private Group enemyGroup;
    public EnemyManager() {
        enemies = new ArrayList<>();
        enemyRows=new ArrayList<>();
        enemyGroup=new Group();
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void deleteEnemy(){//dodac id enemy albo cos??
        if (!enemies.isEmpty()) {
            enemies.remove(enemies.size() - 1);
            updateLayoutForEnemies();
        }
    }

    public void addEnemies(int enemiesCount){
        for (int i = 0; i < enemiesCount; i++){
            addEnemy();
        }
    }

    public void addEnemy(){
        Enemy enemy=new Enemy();
        this.enemies.add(enemy);
     //   this.enemyGroup.getChildren().add(enemy);
    }

    public void updateLayoutForEnemies() {
        int enemiesSize = enemies.size();

        // Jeśli mamy więcej wrogów niż może zmieścić się w jednym rzędzie
        if (enemiesSize > ENEMIES_PER_ROW) {
            // Najpierw dodajemy wrogów do pierwszego rzędu
            int remainingEnemies = enemiesSize % ENEMIES_PER_ROW;  // Liczba wrogów w pierwszym, "niepełnym" rzędzie
            List<Enemy> firstRow = new ArrayList<>();

            for (int i = 0; i < remainingEnemies; i++) {
                firstRow.add(enemies.remove(0));  // Usuwamy pierwszego wroga z listy enemies i dodajemy go do pierwszego rzędu
                enemiesSize--;
            }
            if (!firstRow.isEmpty()) {
                enemyRows.add(firstRow);  // Dodajemy pierwszy rząd, jeśli jest niepusty
            }

            // Dodajemy pozostałych wrogów do pełnych rzędów
            int fullRows = enemiesSize / ENEMIES_PER_ROW;

            for (int i = 0; i < fullRows; i++) {
                List<Enemy> row = new ArrayList<>();
                for (int j = 0; j < ENEMIES_PER_ROW; j++) {
                    row.add(enemies.remove(0));  // Dodajemy wrogów do pełnych rzędów
                }
                enemyRows.add(row);
            }

        }

        // Dodajemy pozostałych wrogów do pierwszego rzędu (jeśli enemiesSize <= ENEMIES_PER_ROW)
        if (enemiesSize <= ENEMIES_PER_ROW && !enemies.isEmpty()) {
            List<Enemy> firstRow = new ArrayList<>();
            while (!enemies.isEmpty()) {
                firstRow.add(enemies.remove(0));  // Dodajemy wrogów do pierwszego rzędu
            }
            enemyRows.add(firstRow);
        }
        rowAlignment();

    }

    public void rowAlignment() {
        int rowYPosition = 100;  // Pozycja Y dla pierwszego rzędu
        int enemyWidth = (GAME_WIDTH / ENEMIES_PER_ROW) - SPACE_BETWEEN_ENEMY;  // Szerokość dostępna na jednego wroga

        // Iterujemy przez każdy rząd
        for (List<Enemy> row : enemyRows) {
            int startX = (GAME_WIDTH - ((ENEMIES_PER_ROW * enemyWidth) + (SPACE_BETWEEN_ENEMY * (ENEMIES_PER_ROW - 1)))) / 2; // Środkowanie wrogów na osi X

            // Iterujemy przez każdego wroga w rzędzie
            for (int i = 0; i < row.size(); i++) {
                Enemy enemy = row.get(i);
                int xPosition = startX + i * (enemyWidth + SPACE_BETWEEN_ENEMY);  // Ustal pozycję X dla wroga
                int yPosition = rowYPosition;  // Pozycja Y zależy od numeru rzędu

                // Zakładamy, że Enemy ma ImageView lub inne Node
                enemy.setLayout(xPosition, yPosition);
            }

            // Zwiększamy pozycję Y dla następnego rzędu
            rowYPosition += ROW_HEIGHT;
        }
    }

}

package com.example.game;

import com.example.entity.Enemy;
import com.example.entity.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameState {
    private ObservableList<Enemy> enemies;
    private Player player;
    private boolean gameOver;

    public GameState() {
        init();
    }

    public void init() {
        player = new Player();
        enemies = FXCollections.observableArrayList();
        gameOver=false;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Player getPlayer() {
        return player;
    }
}

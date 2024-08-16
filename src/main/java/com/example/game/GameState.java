package com.example.game;

import com.example.entity.Enemy;
import com.example.entity.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;

public class GameState {
    private ObservableList<Enemy> enemies;
    private Player player;
    private Group level;
    private boolean gameOver;

    public GameState() {
        init();
    }

    public void init() {
        enemies = FXCollections.observableArrayList();
        gameOver=false;
        player = new Player();
        level=new Group(player);
    }

    public boolean isGameOver() {
        return gameOver;
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }


    public Group getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
    }
}

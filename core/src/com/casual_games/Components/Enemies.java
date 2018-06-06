package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;

import java.util.ArrayList;

public class Enemies {

    private ArrayList<EnemyOne> enemies;
    private PlayScreen playScreen;

    public Enemies(PlayScreen playScreen){
        this.playScreen = playScreen;

        enemies = new ArrayList<EnemyOne>();
        enemies.add(new EnemyOne(playScreen));
    }

    public void update(float dt){
        for (EnemyOne enemyOne: enemies){
            enemyOne.update(dt);
        }

        this.populate();
    }

    public void draw(SpriteBatch spriteBatch){
        for (EnemyOne enemyOne: enemies){
            enemyOne.draw(spriteBatch);
        }
    }

    public void populate(){
        EnemyOne enemyOne;
        if(enemies.size()<10) {
            enemyOne = new EnemyOne(playScreen);
            enemyOne.setX(enemies.get(enemies.size() - 1).getX() + Gdx.graphics.getWidth() / 10);
            enemies.add(enemyOne);
        }
    }

    public int getSize(){
        return enemies.size();
    }

}

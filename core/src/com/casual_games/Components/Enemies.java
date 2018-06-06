package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;

import java.util.ArrayList;

public class Enemies {

    private ArrayList<EnemyOne> enemies;
    private PlayScreen playScreen;
    private int lineIndex;
    public Enemies(PlayScreen playScreen){
        this.playScreen = playScreen;

        lineIndex = 0;

        enemies = new ArrayList<EnemyOne>();
        enemies.add(new EnemyOne(playScreen));
    }

    public void update(float dt){
        for (EnemyOne enemyOne: enemies){
            enemyOne.update(dt);
        }

        this.populate();
        this.increaseLineIndex();
    }

    public void draw(SpriteBatch spriteBatch){
        for (EnemyOne enemyOne: enemies){
            enemyOne.draw(spriteBatch);
        }
    }

    public void populate(){
        EnemyOne enemyOne;
        if(enemies.size()<50) {
            enemyOne = new EnemyOne(playScreen);
            enemyOne.setOrderIndex(enemies.size()-lineIndex*10);
            enemyOne.setX(enemyOne.getOrderIndex() * Gdx.graphics.getWidth() / 10);
            enemyOne.setY(lineIndex*(Gdx.graphics.getWidth() / 10));
            enemies.add(enemyOne);
        }
    }

    public int getSize(){
        return enemies.size();
    }

    public void increaseLineIndex(){
        if (enemies.size()/10>lineIndex){
            lineIndex ++;
        }
    }

    public int getLineIndex() {
        return lineIndex;
    }


}

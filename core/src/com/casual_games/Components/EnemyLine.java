package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class EnemyLine {

    private HashSet<EnemyOne> enemies;
    private PlayScreen playScreen;
    private int lineIndex;

    private HashSet<Integer> randomEnemies;
    private Random random;

    public EnemyLine(PlayScreen playScreen, int lineIndex){
        this.playScreen = playScreen;

        this.lineIndex = lineIndex;

        randomEnemies = new HashSet<Integer>();
        random = new Random();

        enemies = new HashSet<EnemyOne>();
//        enemies.add(new EnemyOne(playScreen));
    }

    public void update(float dt){
        for (EnemyOne enemyOne: enemies){
            enemyOne.update(dt);
        }

        this.populate();
    }

    public void draw(SpriteBatch spriteBatch){
        for (EnemyOne enemyOne: enemies){
            if (enemyOne.isVisible()) {
                enemyOne.draw(spriteBatch);
            }
        }
    }

    public void populate(){
        EnemyOne enemyOne;
        randomIndexesForEnemies(2);
        if(enemies.size()<10) {
            enemyOne = new EnemyOne(playScreen);
//            enemyOne.setOrderIndex(enemies.size()-lineIndex*10); //belke burda duzelish lazim oldu
            enemyOne.setOrderIndex(enemies.size());
            enemyOne.setX(enemyOne.getOrderIndex() * Gdx.graphics.getWidth() / 10);
            enemyOne.setY(lineIndex*(Gdx.graphics.getWidth() / 10));
            if (randomEnemies.contains(enemyOne.getOrderIndex())) {
                enemyOne.setVisible(true);
            }
            enemies.add(enemyOne);
        }
    }

    public int getSize(){
        return enemies.size();
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public void setLineIndex(int lineIndex){
        this.lineIndex = lineIndex;
    }

    public void randomIndexesForEnemies(int num){
        if (randomEnemies.size()<num){
            randomEnemies.add(random.nextInt(10));
        }
    }

    public String getRandomNums(){
        return randomEnemies.toString();
    }



}

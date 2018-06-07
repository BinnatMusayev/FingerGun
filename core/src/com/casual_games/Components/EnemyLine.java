package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class EnemyLine {

    private HashSet<EnemyOne> enemies;
    private PlayScreen playScreen;
    private int lineIndex;

    private HashSet<Integer> randomEnemies;
    private Random random;
    private boolean empty;
    private float y;

    public EnemyLine(PlayScreen playScreen){
        this.playScreen = playScreen;


        randomEnemies = new HashSet<Integer>();
        random = new Random();
        empty = false;
        y=0;

        enemies = new HashSet<EnemyOne>();
//        enemies.add(new EnemyOne(playScreen));

    }

    public void update(float dt){
        for (EnemyOne enemyOne: enemies){
            enemyOne.update(dt);
        }

        this.populate();
        this.move();
    }

    public void draw(SpriteBatch spriteBatch){
        for (EnemyOne enemyOne: enemies){
            if (enemyOne.isVisible()) {
                enemyOne.draw(spriteBatch);
            }
        }
    }

    public void dispose(){
        for (EnemyOne enemyOne: enemies){
            enemyOne.dispose();
        }
    }

    //no need to call it on update - can be called in for loop once and thats it
    public void populate(){
        EnemyOne enemyOne;
        randomIndexesForEnemies(1);
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

    public boolean isEmptyEnemyLine(){
        for (EnemyOne enemyOne: enemies){
            if (enemyOne.isVisible()){
                return false;
            }
        }
        return true;
    }

    public void move(){
        Iterator<EnemyOne> iterator = enemies.iterator();
        y = iterator.next().getY();
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

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public HashSet<EnemyOne> getEnemies() {
        return enemies;
    }

    public float getY() {
        return y;
    }
}

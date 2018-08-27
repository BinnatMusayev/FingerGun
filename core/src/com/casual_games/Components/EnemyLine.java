package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class EnemyLine {

    private ArrayList<EnemyOne> enemies;
    private PlayScreen playScreen;
    private int lineIndex;

    private ArrayList<Integer> randomEnemies;
    private Random random;
    private boolean empty;
    private float y;

    public EnemyLine(PlayScreen playScreen, int lineIndex){
        this.playScreen = playScreen;


        randomEnemies = new ArrayList<Integer>();
        random = new Random();
        empty = false;
        y=0;
        this.lineIndex = lineIndex;

        enemies = new ArrayList<EnemyOne>();
//        enemies.add(new EnemyOne(playScreen));

        this.populate();

    }

    public void update(float dt){
        for (EnemyOne enemyOne: enemies){
            enemyOne.update(dt);
        }

//        this.populate();

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
        randomIndexesForEnemies(3);
        while(enemies.size()<10) {
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
//        if (randomEnemies.size()<num){
//            int tempRandInt = random.nextInt(10);
//            if (randomEnemies.size()>0) {
//
//                ListIterator<Integer> iter = randomEnemies.listIterator();
//
//                while (iter.hasNext()){
//                    Integer i = iter.next();
//
//                    if (tempRandInt != i && (tempRandInt - 1) != i && (tempRandInt + 1) != i ){
////                        randomEnemies.add(tempRandInt);
//                        iter.add(tempRandInt);
//
//                    }
//
//                }
//
////                for (int i : randomEnemies) {
////                    if ( tempRandInt != i) {
//////                        (tempRandInt - 1) != i (tempRandInt + 1) != i  &&
////                        randomEnemies.add(tempRandInt);
////                    }
////                }
//            }else{
//                randomEnemies.add(tempRandInt);
//            }
//        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<num; i++) {
            randomEnemies.add(list.get(i));
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

    public ArrayList<EnemyOne> getEnemies() {
        return enemies;
    }

    public float getY() {
        return y;
    }

    public void makeEnemiesStand(){
        for (EnemyOne enemyOne: enemies){
            enemyOne.makeEnemyStand();
        }
    }

    public void makeEnemiesWalk(){
        for (EnemyOne enemyOne: enemies){
            enemyOne.makeEnemyWalk();
        }
    }

}

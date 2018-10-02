package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Additional.Constants;
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
    private int tempCounter;

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
        //was 5
//        randomIndexesForEnemies(5);
        generateRandomIndexesForEnemies();
        while(enemies.size()<10) {
            enemyOne = new EnemyOne(playScreen);
//            enemyOne.setOrderIndex(enemies.size()-lineIndex*10); //belke burda duzelish lazim oldu
            enemyOne.setOrderIndex(enemies.size());
            enemyOne.setX(enemyOne.getOrderIndex() * Gdx.graphics.getWidth() / 10);
            enemyOne.setY(lineIndex*(Gdx.graphics.getWidth() / 10));
            //setting health of enemies depending on number of killed enemies
//            if(playScreen.getDeathCount()>360) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[12]);
//            }else if(playScreen.getDeathCount()>330) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[11]);
//            }else if(playScreen.getDeathCount()>300) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[10]);
//            }else if(playScreen.getDeathCount()>270) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[9]);
//            }else if(playScreen.getDeathCount()>240) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[8]);
//            }else if(playScreen.getDeathCount()>210) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[7]);
//            }else if(playScreen.getDeathCount()>180) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[6]);
//            }else if(playScreen.getDeathCount()>150) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[5]);
//            }else if(playScreen.getDeathCount()>120) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[4]);
//            }else if(playScreen.getDeathCount()>90) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[3]);
//            }else if(playScreen.getDeathCount()>60) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[2]);
//            }else if(playScreen.getDeathCount()>30) {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[1]);
//            }else {
//                enemyOne.setHealth(Constants.ENEMY_HEALTH[0]);
//            }

            int counterForEnemyHealth=Constants.ENEMY_HEALTH.length-1;
            for(int i=Constants.DIFFICULTY_DEATH_COUNT.length-1; i>=0; i-- ){
                if(playScreen.getDeathCount()>Constants.DIFFICULTY_DEATH_COUNT[i]){
                    enemyOne.setHealth(Constants.ENEMY_HEALTH[counterForEnemyHealth]);
                }
                //decrease health array index
                if (counterForEnemyHealth!=0) {
                    counterForEnemyHealth--;
                }

                if(playScreen.getDeathCount()>Constants.DIFFICULTY_DEATH_COUNT[i]){
                    break;
                }
            }

            //visibility of chosen enemies
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


    public void randomIndexesForEnemies(int num){

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<num; i++) {
            randomEnemies.add(list.get(i));
        }
    }

    public void generateRandomIndexesForEnemies(){

        // change DIFFICULTY_DEATH_COUNT with ENEMY_NUMBER_INCREASE_DEATH_COUNT ---> MAYBE?
        for(int i=Constants.DIFFICULTY_DEATH_COUNT.length-1; i>1; i-- ){
            if(playScreen.getDeathCount()>=Constants.DIFFICULTY_DEATH_COUNT[i]){
                tempCounter=i*Constants.MAX_NUMBER_OF_RANDOM_INDEXES/Constants.DIFFICULTY_DEATH_COUNT.length;
                break;
            }else{
                tempCounter = 1;
            }

        }
        randomIndexesForEnemies(tempCounter);
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

    public int getTempCounter() {
        return tempCounter;
    }
}

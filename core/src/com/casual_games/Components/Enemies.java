package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.casual_games.Additional.Constants;
import com.casual_games.Screens.PlayScreen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Enemies {

    private PlayScreen playScreen;
    private ArrayList<EnemyLine> enemyLines;
    private int lineIndex;

    private long startTime, waitTime;
    private String removableString;
    public Enemies(PlayScreen playScreen){
        this.playScreen = playScreen;

        enemyLines = new ArrayList<EnemyLine>();
        //Gdx.graphics.getWidth()/10 -> enemynin size-idir constantlardan gotur
        //+2 biraz yuxaridan gelmeyi ucun
        lineIndex=Gdx.graphics.getHeight()/(Gdx.graphics.getWidth()/10)+2;

        removableString = "";
        startTime = System.nanoTime();
        waitTime = System.nanoTime();

        for (int i=1; i<10; i++) {
            lineIndex ++;
            enemyLines.add(new EnemyLine(playScreen, lineIndex));
        }

    }

    public void update(float dt){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.update(dt);
        }

//        if( (System.nanoTime() - startTime)/1000000000 > 3 ){
//        }

        destroyEnemyLines();
        increaseLines();
    }

    public void draw(SpriteBatch spriteBatch){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.draw(spriteBatch);
        }

//        playScreen.font.draw(spriteBatch,"random: "+enemyLines.get(enemyLines.size()-1).getTempCounter(), 200, 200);
//        playScreen.font.draw(spriteBatch,"health: "+enemyLines.get(enemyLines.size()-1).getEnemies().get(2).getHealth(), 200, 250);
    }


    public void dispose(){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.dispose();
        }
    }

    public void increaseLines(){

        EnemyLine enemyLine;
        if(enemyLines.size()<30){
            enemyLine = new EnemyLine(playScreen,  (int)( (enemyLines.get(enemyLines.size()-1).getY() + (Gdx.graphics.getWidth()/10) )/(Gdx.graphics.getWidth()/10)) +1 );

            enemyLines.add(enemyLine);
            System.out.println("added: " + enemyLine.getLineIndex());
        }

    }


    public void destroyEnemyLines(){
            ListIterator<EnemyLine> iter = enemyLines.listIterator();

            while (iter.hasNext()) {
                EnemyLine enemyLine = iter.next();
                //replace 100 with enemyone height that i will get form Constants class
                // i will also add healthbar so something will change
                if (enemyLine.getY()<-200){
                    removableString += enemyLine.getLineIndex() +", ";
                    iter.remove();
                    break;
                }
            }
    }


    public int getNumberOfEnemyLines(){
        return enemyLines.size();
    }

    public int getNumberOfEmptyEnemyLines(){
        int n = 0;
        for (EnemyLine e: enemyLines){
            if (e.isEmptyEnemyLine()) {
                n++;
            }
        }
        return n;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public ArrayList<EnemyLine> getEnemyLines() {
        return enemyLines;
    }

    public String getRemovableLines(){
        String str = "";

//        if (enemyLines.size()==130) {
//            for (EnemyLine e : enemyLines) {
//                if (e.isEmptyEnemyLine()) {
//                    str += e.getLineIndex() + ", ";
//                }
//            }
//        }

        return removableString;
    }

    public void makeEnemiesStand(){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.makeEnemiesStand();
        }
    }

    public void makeEnemiesWalk(){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.makeEnemiesWalk();
        }
    }














}

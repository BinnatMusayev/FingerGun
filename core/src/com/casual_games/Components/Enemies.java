package com.casual_games.Components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;
import java.util.ArrayList;
import java.util.Iterator;

public class Enemies {

    private PlayScreen playScreen;
    private ArrayList<EnemyLine> enemyLines;
    private int lineIndex;

    public Enemies(PlayScreen playScreen){
        this.playScreen = playScreen;

        enemyLines = new ArrayList<EnemyLine>();
        lineIndex=10;

    }

    public void update(float dt){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.update(dt);
        }


        increaseLines();
        destroyEnemyLine();
    }

    public void draw(SpriteBatch spriteBatch){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.draw(spriteBatch);
        }
    }


    public void dispose(){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.dispose();
        }
    }

    public void increaseLines(){

        EnemyLine enemyLine;
        if(enemyLines.size()<30){
            enemyLine = new EnemyLine(playScreen);
            enemyLine.setLineIndex(lineIndex);
            enemyLines.add(enemyLine);
            System.out.println("added: " + enemyLine.getLineIndex());
            lineIndex++;
        }

    }

    public void destroyEnemyLine() {

        ArrayList<EnemyLine> removeList = new ArrayList<EnemyLine>();
        for (EnemyLine enemyLine: enemyLines){
            if (enemyLine.isEmptyEnemyLine()){
                removeList.add(enemyLine);
            }
        }

        Iterator<EnemyLine> iter = enemyLines.iterator();

        while (iter.hasNext()) {
            EnemyLine enemyLine = iter.next();

//            if (enemyLine.isEmptyEnemyLine()) {
//            if (enemyLine.getY()<200){
//                iter.remove();
//                enemyLines.remove(enemyLine);
//                System.out.println("deleted: " + enemyLine.getLineIndex());
//                System.out.println("Should be removed now: " + enemyLine.getLineIndex());
//            }

            Iterator<EnemyLine> iter2 = removeList.iterator();

            while (iter2.hasNext()) {
                EnemyLine enemyLine2 = iter2.next();

                if (enemyLine.equals(enemyLine2)){
//                    iter.remove();
                }

            }



        }


//        for (EnemyLine enemyLine: new ArrayList<EnemyLine>(enemyLines)){
//            if (enemyLine.isEmptyEnemyLine()){
//                enemyLines.remove(enemyLine);
//            }
//        }

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
}

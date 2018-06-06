package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Enemies {

    private PlayScreen playScreen;
    private ArrayList<EnemyLine> enemyLines;
    private int lineIndex;

    public Enemies(PlayScreen playScreen){
        this.playScreen = playScreen;

        enemyLines = new ArrayList<EnemyLine>();
        lineIndex=0;
    }

    public void update(float dt){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.update(dt);
        }

        increaseLines();
    }

    public void draw(SpriteBatch spriteBatch){
        for (EnemyLine enemyLine: enemyLines){
            enemyLine.draw(spriteBatch);
        }
    }

    public void increaseLines(){

        if(enemyLines.size()<20){
            enemyLines.add(new EnemyLine(playScreen, lineIndex));
            lineIndex++;
        }

    }



}

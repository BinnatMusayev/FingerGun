package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.casual_games.Screens.PlayScreen;

public class HealthBar {

    private PlayScreen playScreen;
    private float x, y;
    private float width, height;

    private float health, currentHealth;
    private Color lightGreen, darkGreen, lightYellow, darkYellow, lightRed, darkRed;

    Runnable thenForAds;
    private int gameOverCount;
    public HealthBar(PlayScreen playScreen){
        this.playScreen = playScreen;

        x = 0;
//        y=-Gdx.graphics.getHeight()/70;
        y=0;
        //health-i sharedprefenrecden gotur (shopdan increase oluna biler deye)
//        health=100;
        health = playScreen.getGame().prefs.getInteger("current_health", 100);
        currentHealth = health;
        width = Gdx.graphics.getWidth();

        height = Gdx.graphics.getHeight()/50;


        //initialize colors
        lightGreen= new Color();
        darkGreen = new Color();
        lightYellow = new Color();
        darkYellow = new Color();
        lightRed = new Color();
        darkRed = new Color();

        lightGreen.set(65f/255, 239f/255, 11f/255, 0);
        darkGreen.set(22f/255, 86f/255, 3f/255, 0);

        lightYellow.set(255f/255, 247f/255, 114f/255, 0 );
        darkYellow.set(247f/255, 235f/255, 2f/255, 0);

        lightRed.set(249f/255, 107f/255, 99f/255, 0 );
        darkRed.set(183f/255,12f/255,3f/255, 0);

    }

    public void update(float dt){
        if (currentHealth<=0){
            playScreen.setGameover(true);
            playScreen.setCanShoot(false);
            playScreen.saveCoins(playScreen.getCoinCount());
            playScreen.updateScore();
            //handling game over counter
//            if (playScreen.getGameOverCounter() == 1 && !playScreen.isAdClosed()){
//                playScreen.showAd();
//                playScreen.setGameOverCounter(0);
//            }else if(playScreen.getGameOverCounter() == 0){
//                playScreen.setGameOverCounter(playScreen.getGameOverCounter() + 1);
//            }
            if (
//                    gameOverCount == 1 &&
                        !playScreen.isAdClosed()){
                playScreen.showAd();
//                gameOverCount = 0;
//                playScreen.setAdClosed(true);
            }
//            else if(gameOverCount == 0 && !playScreen.isAdClosed()){
//                gameOverCount++;
//            }
        }
    }

    public void draw(ShapeRenderer shapeRenderer){

        width = (currentHealth*Gdx.graphics.getWidth())/health;

        // 1/4 is full dark
        float fullPart =width/4;
//        shapeRenderer.rect(x, y, fullPart, height, darkYellow, darkYellow, darkYellow, darkYellow);
//        shapeRenderer.rect(x+fullPart, y, width-fullPart, height, darkYellow, darkYellow, lightYellow, darkYellow);

        //half half
        if(health>66) {
            shapeRenderer.rect(x, y, width, height, darkGreen, darkGreen, lightGreen, darkGreen);
        }else if (health>33){
            shapeRenderer.rect(x, y, width, height, darkYellow, darkYellow, lightYellow, darkYellow);
        }else{
            shapeRenderer.rect(x, y, width, height, darkRed, darkRed, lightRed, darkRed);
        }

    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(float currentHealth) {
        this.currentHealth = currentHealth;
    }
}

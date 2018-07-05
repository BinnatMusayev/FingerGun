package com.casual_games.Components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;

import java.util.ArrayList;
import java.util.ListIterator;

public class Coins {

    private ArrayList<Coin> coins;
    private PlayScreen playScreen;
    private Coin c;

    public Coins(PlayScreen playScreen){
        this.playScreen = playScreen;

        coins = new ArrayList<Coin>();
    }

    public void update(float delta){
        for (Coin coin: coins){
            coin.update(delta);
        }
    }

    public void draw(SpriteBatch spriteBatch){
        for (Coin coin: coins){
            coin.draw(spriteBatch);
        }
    }

    public void dispose(){
        for (Coin coin: coins){
            coin.dispose();
        }
    }

    public void addCoin(float x, float y){
        c= new Coin(this.playScreen);
        c.setPosition(x, y);
        coins.add(c);
    }


    public ArrayList<Coin> getCoins() {
        return coins;
    }

}

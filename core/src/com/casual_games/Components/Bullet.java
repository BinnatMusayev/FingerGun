package com.casual_games.Components;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.casual_games.Screens.PlayScreen;

public abstract class Bullet extends Sprite {


    protected boolean destroyed;
    protected float speed;
    protected int index;
    protected long shootingTimeout;
    protected int damage;

    public Bullet(PlayScreen playScreen, float x, float y){
//        super(playScreen.getZombie().findRegion("ZombieSheet"));
        destroyed = false;

        setX(x);
        setY(y);
        index = 0;
    }

    public void update(float dt){
        move();
        destroy();
    }

    public abstract void move();

    public void destroy(){
//        if (getY() > Gdx.graphics.getHeight() + getRegionHeight() ){
//            destroyed = true;
//        }
    }

    public boolean isOffScreen(){
        if (getY() > Gdx.graphics.getHeight()  ){
            destroyed = true;
            return true;
        }
        return false;
    }

    public void dispose(){
        this.dispose();
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getShootingTimeout() {
        return shootingTimeout;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

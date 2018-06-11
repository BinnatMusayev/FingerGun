package com.casual_games.Components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.casual_games.Screens.PlayScreen;

import java.util.ArrayList;
import java.util.Iterator;

public class Bullets {

    private PlayScreen playScreen;
    private ArrayList<Bullet> bullets;
    private int bulletIndex;

    public Bullets(PlayScreen playScreen){
        this.playScreen = playScreen;

        bullets = new ArrayList<Bullet>();
        bulletIndex=0;
    }

    public void update(float dt){
        for (Bullet b: bullets){
            b.update(dt);
        }
        destroy();
    }

    public void draw(SpriteBatch spriteBatch){
        for (Bullet b: bullets){
            if (!b.isDestroyed()) {
                b.draw(spriteBatch);
            }
        }
    }

//    public void move(){
//        for (Bullet b: bullets){
//            b.move();
//        }
//    }

    public void destroy(){

        Iterator<Bullet> iterator = bullets.iterator();

        while (iterator.hasNext()){
            Bullet b = iterator.next();
            if (b.isOffScreen() ){
                iterator.remove();
            }
        }
    }

    public void dispose(){
        for (Bullet b: bullets){
            b.dispose();
        }
    }

    public void addBullet(Bullet b){
        Bullet bullet = b;
        bullet.setIndex(bulletIndex);
        bullets.add(b);
        bulletIndex++;
    }

    public String getCountOfBullets(){
        return "bullets count: " +bullets.size();
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void removeBullet(int i){
        Iterator<Bullet> iterator = bullets.iterator();

        while (iterator.hasNext()){
            Bullet bullet = iterator.next();
            if (bullet.getIndex()==i){
                iterator.remove();
            }
        }
    }
}

package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PointerOne {

    private float x, y, r1, r2;

    public PointerOne(){
        x = 200;
        y=600;
        r1 = Gdx.graphics.getWidth()/6;
        r2 = Gdx.graphics.getWidth()/8;
    }

    public void update(float dt){

    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(x, y, r1, 500);
//        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.arc(x,y,r1,65, (90-65)*2);
//        shapeRenderer.circle(x, y, r2);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}

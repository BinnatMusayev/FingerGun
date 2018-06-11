package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PointerOne {

    private float x, y, r1, r2;
    private boolean visible;

    public PointerOne(){
        x = 200;
        y=600;
        r1 = Gdx.graphics.getWidth()/7;
        r2 = Gdx.graphics.getWidth()/8;
        visible = false;

    }

    public void update(float dt){

    }

    public void draw(ShapeRenderer shapeRenderer){
        if (visible) {
            shapeRenderer.setColor(244f/255, 101f/255,66f/255, 0f);
            shapeRenderer.circle(x, y, r1, 500);
//        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.BLACK);
            shapeRenderer.arc(x, y, r1, 75, (90 - 75) * 2, 200);

//        shapeRenderer.circle(x, y, r2);
        }
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

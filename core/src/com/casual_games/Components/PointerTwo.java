package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.casual_games.Additional.Arc;

public class PointerTwo {

    private float x, y, r1, r2;
    private boolean visible;
    private float rotation;
    private int lengthOfArc;
    private Color c1, c2, c3;

    public PointerTwo(){
        x = 200;
        y=600;
        r1 = Gdx.graphics.getWidth()/6;
        r2 = Gdx.graphics.getWidth()/8;
        visible = false;

        rotation =0;
        lengthOfArc = 65;

        c1 = new Color();
        c2 = new Color();
        c3 = new Color();
        c1.set(7f/255, 102f/255,119f/255, 0f);
        c2.set(15f/255, 151f/255,175f/255, 0f);
        c3.set(87f/255, 225f/255,249f/255, 0f);


    }

    public void update(float dt){
        rotate();
    }

    public void draw(Arc shapeRenderer){
        if (visible) {
//            shapeRenderer.setColor(244f/255, 101f/255,66f/255, 0f);

            //this arc is modified method
//            shapeRenderer.arc(x, y, r1, rotation +lengthOfArc, (90 - lengthOfArc) * 2);
            //cooler with these
//            shapeRenderer.arc(x, y, r1, rotation +lengthOfArc+90, (90 - lengthOfArc) * 2);
//            shapeRenderer.arc(x, y, r1, rotation +lengthOfArc+180, (90 - lengthOfArc) * 2);
//            shapeRenderer.arc(x, y, r1, rotation +lengthOfArc+270, (90 - lengthOfArc) * 2);


//            bayraq rengi

            shapeRenderer.arc(x, y, r1, rotation +lengthOfArc, (90 ) * 2, c1); //this is mixed

            shapeRenderer.arc(x, y, r1*0.9f, rotation*1.4f +lengthOfArc+90, (90 - lengthOfArc/2) * 2, c2);

            shapeRenderer.arc(x, y, r1*0.8f, -rotation*2.5f +lengthOfArc+180, (90 - lengthOfArc) *2, c3);
        }
    }

    public void rotate(){
        rotation +=3;
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

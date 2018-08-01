package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.casual_games.Additional.Arc;
import com.casual_games.Additional.Constants;

public class PointerOne extends Pointer {

    private Color color;
    private float dx, dy;

    public PointerOne(){
        x = 0;
        y=0;
        r = Gdx.graphics.getWidth()/6.5f;

        visible = false;

        color = new Color();
        color.set(244f/255, 101f/255,66f/255, 0f);

        dx = 0;
        dy = 0;
    }

    public void update(float dt){

    }

    public void draw(Arc shapeRenderer){
        if (visible) {

            shapeRenderer.arc(x, y, r, 45, 30, color);
            shapeRenderer.arc(x, y, r, 105, 30, color);

            //lines
            shapeRenderer.setColor(color);

            dx = x + r*(float)Math.cos(105);
            dy = y + r*(float)Math.cos(75);
            shapeRenderer.line(dx, dy- Constants.SCREEN_HEIGHT/60, dx, dy+Constants.SCREEN_HEIGHT/40);

            dx = x - r*(float)Math.cos(105);
            dy = y + r*(float)Math.cos(75);
            shapeRenderer.line(dx, dy- Constants.SCREEN_HEIGHT/60, dx, dy+Constants.SCREEN_HEIGHT/40);
        }
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getR() {
        return r;
    }

    @Override
    public void setR(float r) {
        this.r = r;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
}

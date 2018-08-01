package com.casual_games.Components;

import com.casual_games.Additional.Arc;

public abstract class Pointer {

    protected float x, y, r;
    protected boolean visible;

    public abstract void update(float dt);

    public abstract void draw(Arc shapeRenderer);

    //Getters and Setters
    public abstract float getX();

    public abstract void setX(float x);

    public abstract float getY();

    public abstract void setY(float y);

    public abstract float getR();

    public abstract void setR(float r);

    public abstract boolean isVisible();

    public abstract void setVisible(boolean visible);
}

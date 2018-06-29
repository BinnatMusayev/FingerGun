package com.casual_games.Additional;

import com.badlogic.gdx.Gdx;

public class Constants {

    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    //shooting timeout
    public static final long PISTOL_SHOOTING_TIMEOUT = 400;
    public static final long SNIPER_SHOOTING_TIMEOUT = 1200;
    public static final long MINIGUN_SHOOTING_TIMEOUT = 100;

    //Bullet speed
    public static final float PISTOL_SPEED = Gdx.graphics.getHeight()/200;
    public static final float SNIPER_SPEED = Gdx.graphics.getHeight()/70;
    public static final float MINIGUN_SPEED = Gdx.graphics.getHeight()/100;

    //enemyspeed
    public static final float ENEMY_SPEED = 1.5f;

    //Hud
    public static final float HUD_HEIGHT = Gdx.graphics.getHeight()/18;
    public static final float HUD_BUTTON_WIDTH = Gdx.graphics.getWidth()/14;
    public static final float HUD_BUTTON_Y = SCREEN_HEIGHT - HUD_HEIGHT +( HUD_HEIGHT - HUD_BUTTON_WIDTH)/2 ;
    public static final float HUD_BUTTON_X = SCREEN_WIDTH - 3*HUD_BUTTON_WIDTH/2;

}

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

    //enemyspeed 1.5f
    public static final float ENEMY_SPEED = 4.5f;

    //Hud
    public static final float HUD_HEIGHT = Gdx.graphics.getHeight()/18;
    public static final float HUD_BUTTON_WIDTH = Gdx.graphics.getWidth()/14;
    public static final float HUD_BUTTON_X = SCREEN_WIDTH - 3*HUD_BUTTON_WIDTH/2;
    public static final float HUD_BUTTON_Y = SCREEN_HEIGHT - HUD_HEIGHT +( HUD_HEIGHT - HUD_BUTTON_WIDTH)/2 ;
    public static final float HUD_COINS_ICON_X = HUD_BUTTON_WIDTH;
    public static final float HUD_COINS_ICON_Y = HUD_BUTTON_Y;
    public static final float HUD_COINS_COUNT_X = HUD_COINS_ICON_X + HUD_BUTTON_WIDTH + Gdx.graphics.getWidth()/20;
    public static final float HUD_COINS_COUNT_Y = SCREEN_HEIGHT - HUD_HEIGHT/3;

    //MainMenu
    public static final float MAIN_MENU_BUTTON_SPACE = Gdx.graphics.getHeight()/10;

    public static final float MAIN_MENU_TITLE_X = Gdx.graphics.getWidth()/2;
    public static final float MAIN_MENU_TITLE_Y = Gdx.graphics.getHeight()*6/7;
    public static final float MAIN_MENU_PLAY_BUTTON_X = Gdx.graphics.getWidth()/2;
    public static final float MAIN_MENU_PLAY_BUTTON_Y = Gdx.graphics.getHeight()/2;
    public static final float MAIN_MENU_SHOP_BUTTON_X = Gdx.graphics.getWidth()/2;
    public static final float MAIN_MENU_SHOP_BUTTON_Y = MAIN_MENU_PLAY_BUTTON_Y-MAIN_MENU_BUTTON_SPACE;

    //Pause Widget
    public static final float PAUSE_WIDGET_RECTANGLE_WIDTH = Gdx.graphics.getWidth()*3/4;
    public static final float PAUSE_WIDGET_RECTANGLE_HEIGHT = Gdx.graphics.getHeight()/4;
    public static final float PAUSE_WIDGET_RECTANGLE_X = Gdx.graphics.getWidth()/2-PAUSE_WIDGET_RECTANGLE_WIDTH/2;
    public static final float PAUSE_WIDGET_RECTANGLE_Y = Gdx.graphics.getHeight()/2-PAUSE_WIDGET_RECTANGLE_HEIGHT/2;

    public static final float PAUSE_WIDGET_PLAY_BUTTON_WIDHT = PAUSE_WIDGET_RECTANGLE_WIDTH/4;
    public static final float PAUSE_WIDGET_PLAY_BUTTON_HEIGHT = PAUSE_WIDGET_PLAY_BUTTON_WIDHT;
    public static final float PAUSE_WIDGET_PLAY_BUTTON_X = PAUSE_WIDGET_RECTANGLE_X+PAUSE_WIDGET_PLAY_BUTTON_WIDHT*2/3;
    public static final float PAUSE_WIDGET_PLAY_BUTTON_Y = PAUSE_WIDGET_RECTANGLE_Y + PAUSE_WIDGET_RECTANGLE_HEIGHT/2 - PAUSE_WIDGET_PLAY_BUTTON_WIDHT*2/3;

    public static final float PAUSE_WIDGET_HOME_BUTTON_WIDHT = PAUSE_WIDGET_RECTANGLE_WIDTH/4;
    public static final float PAUSE_WIDGET_HOME_BUTTON_HEIGHT = PAUSE_WIDGET_HOME_BUTTON_WIDHT;
    public static final float PAUSE_WIDGET_HOME_BUTTON_X = PAUSE_WIDGET_PLAY_BUTTON_X +PAUSE_WIDGET_PLAY_BUTTON_WIDHT + PAUSE_WIDGET_RECTANGLE_WIDTH/6;
    public static final float PAUSE_WIDGET_HOME_BUTTON_Y = PAUSE_WIDGET_PLAY_BUTTON_Y;


    //GameOver Widget




























}

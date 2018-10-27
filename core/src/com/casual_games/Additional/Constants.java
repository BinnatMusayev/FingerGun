package com.casual_games.Additional;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class Constants {

    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    //Splash Screen
    public static final float SPLASH_LOGO_WIDTH = Gdx.graphics.getWidth();
    public static final float SPLASH_LOGO_HEIGHT = Gdx.graphics.getWidth();
    public static final float SPLASH_LOGO_Y = SCREEN_HEIGHT/2-SPLASH_LOGO_HEIGHT/2;

    //gun type
    public static enum Gun {pistol, sniper, minigun}

    //Bullet speed -> constants, does not change
    public static final float PISTOL_SPEED = Gdx.graphics.getHeight()/130;
    public static final float SNIPER_SPEED = Gdx.graphics.getHeight()/70;
    public static final float MINIGUN_SPEED = Gdx.graphics.getHeight()/95;

    //Bullet shooting timeout
    public static final long PISTOL_SHOOTING_TIMEOUT = 1000;
    public static final long SNIPER_SHOOTING_TIMEOUT = 1200;
    public static final long MINIGUN_SHOOTING_TIMEOUT = 50; //was 100

    //Bullet damage
    public static final int PISTOL_DAMAGE = 3;
    public static final int SNIPER_DAMAGE = 45;
    public static final int MINIGUN_DAMAGE = 5; //was 10

    //Enemy health -> number of array equals to last element devided by 5
    public static final int[] ENEMY_HEALTH = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70};
    //should increase as long as above array
    //and should be able to loop through to increse
    //enemy health(EnemyLine) and speed(EnemyOne) -> if it is achieved should be able to implement both on EnemyLine
    //change difference from 30 to bigger num, ex:60
    public static final int[] DIFFICULTY_DEATH_COUNT = {5, 7, 10, 20, 30, 90, 120, 150, 170, 180, 210, 240, 270, 300, 400, 600};
//    public static final int[] DIFFICULTY_DEATH_COUNT = {5, 7, 10, 20, 30, 60, 80, 90, 100, 120, 130, 160};

    // useful? needed? below one
    public static final int[] ENEMY_NUMBER_INCREASE_DEATH_COUNT = {20, 50, 100, 150};
    public static final int MAX_NUMBER_OF_RANDOM_INDEXES = 9;

    //enemyspeed
    public static final float ENEMY_SPEED_FAST = SCREEN_HEIGHT/450;
    public static final float ENEMY_SPEED_NORMAL = SCREEN_HEIGHT/650;
    public static final float ENEMY_SPEED_SLOW = SCREEN_HEIGHT/850;

    //Shop Functionality
    public static final int[] HEART_HEALTH = {100, 120, 150, 170, 200, 250, 300, 400, 500};
    public static final int[] HEART_PRICE = {200, 300, 400, 500, 600, 700, 800, 900, 1000 };
    //Pointers
    public static final int POINTER_ONE_PRICE = 100;
    public static final int POINTER_TWO_PRICE  = 200;
    //GunsShop
    //--Pistol
    public static final int[] PISTOL_SHOOTING_TIMEOUT_VALUES = {1000, 900, 800, 700, 600, 500, 300};
    public static final int[] PISTOL_SHOOTING_TIMEOUT_PRICES = {200, 300, 400, 500, 600, 700, 800};

    public static final int[] PISTOL_DAMAGE_VALUES = {3, 5, 10, 15, 20, 30, 40};
    public static final int[] PISTOL_DAMAGE_PRICES = {200, 300, 400, 500, 600, 700, 800};

    //--Sniper
    public static final int[] SNIPER_SHOOTING_TIMEOUT_VALUES = {1200, 1000, 900, 800, 700, 650, 600};
    public static final int[] SNIPER_SHOOTING_TIMEOUT_PRICES = {200, 300, 400, 500, 600, 700, 800};

    public static final int[] SNIPER_DAMAGE_VALUES = {30, 35, 40, 45, 50, 55, 300};
    public static final int[] SNIPER_DAMAGE_PRICES = {200, 300, 400, 500, 600, 700, 800};

    //--Minigun
    public static final int[] MINIGUN_SHOOTING_TIMEOUT_VALUES = {200, 150, 100, 70, 60, 55, 50};
    public static final int[] MINIGUN_SHOOTING_TIMEOUT_PRICES = {200, 300, 400, 500, 600, 700, 800};

    public static final int[] MINIGUN_DAMAGE_VALUES = {3, 5, 7, 9, 11, 13, 15};
    public static final int[] MINIGUN_DAMAGE_PRICES = {200, 300, 400, 500, 600, 700, 800};




    //Hud
    public static final float HUD_HEIGHT = Gdx.graphics.getHeight()/18;
    public static final float HUD_BUTTON_WIDTH = Gdx.graphics.getWidth()/14;
    public static final float HUD_BUTTON_X = SCREEN_WIDTH - 3*HUD_BUTTON_WIDTH/2;
    public static final float HUD_BUTTON_Y = SCREEN_HEIGHT - HUD_HEIGHT +( HUD_HEIGHT - HUD_BUTTON_WIDTH)/2 ;
    public static final float HUD_COINS_ICON_X = HUD_BUTTON_WIDTH;
    public static final float HUD_COINS_ICON_Y = HUD_BUTTON_Y;
    public static final float HUD_COINS_COUNT_X = HUD_COINS_ICON_X + HUD_BUTTON_WIDTH + Gdx.graphics.getWidth()/50;
    public static final float HUD_COINS_COUNT_Y = SCREEN_HEIGHT - HUD_HEIGHT/3;
    public static final float HUD_DEAD_ICON_X = HUD_COINS_COUNT_X+HUD_BUTTON_WIDTH+ Gdx.graphics.getWidth()/20;
    public static final float HUD_DEAD_ICON_Y = HUD_BUTTON_Y;
    public static final float HUD_DEAD_COUNT_X = HUD_DEAD_ICON_X + HUD_BUTTON_WIDTH + Gdx.graphics.getWidth()/20;
    public static final float HUD_DEAD_COUNT_Y = SCREEN_HEIGHT - HUD_HEIGHT/3;

    //MainMenu
    public static final float MAIN_MENU_BUTTON_SPACE = Gdx.graphics.getHeight()/10;

    public static final float MAIN_MENU_TITLE_X = Gdx.graphics.getWidth()/2;
    public static final float MAIN_MENU_TITLE_Y = Gdx.graphics.getHeight()*6/7;
    public static final float MAIN_MENU_PLAY_BUTTON_X = Gdx.graphics.getWidth()/2;
    public static final float MAIN_MENU_PLAY_BUTTON_Y = Gdx.graphics.getHeight()/2;
    public static final float MAIN_MENU_SHOP_BUTTON_X = Gdx.graphics.getWidth()/2;
    public static final float MAIN_MENU_SHOP_BUTTON_Y = MAIN_MENU_PLAY_BUTTON_Y-MAIN_MENU_BUTTON_SPACE;
    public static final float MAIN_MENU_BESTSCORE_Y = SCREEN_HEIGHT*0.2f;

    public static final float MAIN_MENU_BUTTON_WIDTH = SCREEN_WIDTH/4.3f;

    public static final float MUSIC_ICON_DIMENSIOINS = SCREEN_WIDTH/10;
    public static final float MUSIC_ICON_Y = SCREEN_HEIGHT*0.07f;



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

    //common back button properties
    public static final float BACK_BUTTON_X = SCREEN_WIDTH/25;
    public static final float BACK_BUTTON_Y = SCREEN_HEIGHT*13/14;
    public static final float BACK_BUTTON_WIDTH = SCREEN_WIDTH/12;

    //Shop
    public static final float BG_RECT_WIDTH = SCREEN_WIDTH/3;
    public static final float BG_RECT_HEIGHT = BG_RECT_WIDTH;
    public static final float BG_RECT_GUNS_WIDTH = SCREEN_WIDTH/4;
    public static final float BG_RECT_GUNS_HEIGHT = BG_RECT_GUNS_WIDTH;
    public static final float COINS_COLLECTIVE_WIDTH = SCREEN_WIDTH/12;
    public static final float COINS_COLLECTIVE_HEIGHT = COINS_COLLECTIVE_WIDTH;
    public static final float PLUS_ICON_WIDTH = SCREEN_WIDTH/17;
    public static final float LOCK_ICON_WIDTH = SCREEN_WIDTH/7f;
    public static final float LOCK_ICON_HEIGHT = SCREEN_WIDTH/8;



    //Health Shop
        //functionality
































}

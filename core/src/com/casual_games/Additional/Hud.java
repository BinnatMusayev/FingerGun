package com.casual_games.Additional;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.casual_games.Screens.PlayScreen;

public class Hud {

    private PlayScreen playScreen;
    private Sprite pauseButton, playButton, coinsIcon, deadIcon;
//    private int coinsCount;

    public Hud(PlayScreen playScreen){
        this.playScreen = playScreen;

        this.pauseButton = new Sprite(playScreen.getGame().assets.manager.get("pause.png", Texture.class));
        this.playButton = new Sprite(playScreen.getGame().assets.manager.get("play.png", Texture.class));
        this.coinsIcon = new Sprite(playScreen.getGame().assets.manager.get("hud_coins.png", Texture.class));
//        this.coinsIcon = new Sprite(playScreen.getGame().assets.manager.get("coins_collective.png", Texture.class));
        this.deadIcon = new Sprite(playScreen.getGame().assets.manager.get("dead.png", Texture.class));

//        this.coinsCount = playScreen.getCoinCount();

        playButton.setPosition(Constants.HUD_BUTTON_X, Constants.HUD_BUTTON_Y);
        pauseButton.setPosition(Constants.HUD_BUTTON_X, Constants.HUD_BUTTON_Y);
        coinsIcon.setPosition(Constants.HUD_COINS_ICON_X, Constants.HUD_COINS_ICON_Y);
        deadIcon.setPosition(Constants.HUD_DEAD_ICON_X, Constants.HUD_DEAD_ICON_Y);

        playButton.setSize(Constants.HUD_BUTTON_WIDTH, Constants.HUD_BUTTON_WIDTH);
        pauseButton.setSize(Constants.HUD_BUTTON_WIDTH, Constants.HUD_BUTTON_WIDTH);
        coinsIcon.setSize(Constants.HUD_BUTTON_WIDTH, Constants.HUD_BUTTON_WIDTH);
        deadIcon.setSize(Constants.HUD_BUTTON_WIDTH, Constants.HUD_BUTTON_WIDTH);

    }

    public void draw(ShapeRenderer shapeRenderer){
//        shapeRenderer.rect(0, Constants.SCREEN_HEIGHT-Constants.HUD_HEIGHT,
//                Constants.SCREEN_WIDTH, Constants.HUD_HEIGHT,
//                Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);


    }

    public void draw(SpriteBatch spriteBatch){
        if (playScreen.isPaused() ){
//            playButton.draw(spriteBatch);
        }else{
            if (!playScreen.isGameover()) {
                pauseButton.draw(spriteBatch);
            }
        }

//        this.coinsCount = playScreen.getCoinCount();

        coinsIcon.draw(spriteBatch);
        playScreen.font.draw(spriteBatch, String.valueOf(playScreen.getCoinCount()), Constants.HUD_COINS_COUNT_X, Constants.HUD_COINS_COUNT_Y );
        deadIcon.draw(spriteBatch);
        playScreen.font.draw(spriteBatch, String.valueOf(playScreen.getDeathCount()) , Constants.HUD_DEAD_COUNT_X, Constants.HUD_DEAD_COUNT_Y );
    }
}

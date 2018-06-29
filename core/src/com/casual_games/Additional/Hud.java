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
    private Sprite pauseButton, playButton;

    public Hud(PlayScreen playScreen){
        this.playScreen = playScreen;

        this.pauseButton = new Sprite();
        this.playButton = new Sprite();
        playButton.setPosition(Constants.HUD_BUTTON_X, Constants.HUD_BUTTON_Y);
        pauseButton.setPosition(Constants.HUD_BUTTON_X, Constants.HUD_BUTTON_Y);

        playButton.setSize(Constants.HUD_BUTTON_WIDTH, Constants.HUD_BUTTON_WIDTH);
        pauseButton.setSize(Constants.HUD_BUTTON_WIDTH, Constants.HUD_BUTTON_WIDTH);

        pauseButton.setRegion(new Texture(Gdx.files.internal("pause.png")));
        playButton.setRegion(new Texture(Gdx.files.internal("play.png")));

    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.rect(0, Constants.SCREEN_HEIGHT-Constants.HUD_HEIGHT,
                Constants.SCREEN_WIDTH, Constants.HUD_HEIGHT,
                Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);


    }

    public void draw(SpriteBatch spriteBatch){
        if (playScreen.isPaused() ){
            playButton.draw(spriteBatch);
        }else{
            pauseButton.draw(spriteBatch);
        }
    }
}

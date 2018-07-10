package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.TimeUtils;
import com.casual_games.Additional.Constants;
import com.casual_games.FingerGun;

public class SplashScreen implements Screen {

    private Sprite splashLogo;
    private FingerGun game;

    private long splashScreenTimeout;

    public SplashScreen(FingerGun game) {
        this.game = game;

        splashLogo = new Sprite();
        splashLogo.setRegion(new Texture(Gdx.files.internal("splashLogo.png")));
        splashLogo.setSize(Constants.SPLASH_LOGO_WIDTH, Constants.SPLASH_LOGO_HEIGHT);
        splashLogo.setY(Constants.SPLASH_LOGO_Y);

        splashScreenTimeout = TimeUtils.millis();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(247f/255,227f/255,44f/255,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

        if (TimeUtils.millis() - splashScreenTimeout > 2500){
            game.setScreen(new MainMenu(game));
        }else{

            game.batch.begin();

            splashLogo.draw(game.batch);

            game.batch.end();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

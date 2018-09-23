package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.casual_games.FingerGun;

import static com.casual_games.Additional.Constants.*;

public class MainMenu implements Screen, InputProcessor {
    private FingerGun game;
    private BitmapFont font;
    private GlyphLayout bestScoreGlupLayout;
    private Sprite logo, playButton, shopButton, background, musicOn, musicOff, musicIcon;
    private String bestScore;
    private boolean musicEnabled;

    public MainMenu(FingerGun game){
        this.game = game;

        logo = new Sprite(game.assets.manager.get("fingerGunLogoText.png", Texture.class));
        logo.setSize(SCREEN_WIDTH*0.85f, SCREEN_HEIGHT*0.15f);
        logo.setPosition((SCREEN_WIDTH-logo.getWidth())/2, SCREEN_HEIGHT-logo.getHeight()*1.7f);

        shopButton = new Sprite(game.assets.manager.get("shop.png", Texture.class));
        shopButton.setSize(MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_WIDTH);
        shopButton.setPosition(SCREEN_WIDTH/2-shopButton.getWidth()*1.5f, SCREEN_HEIGHT/2-shopButton.getHeight() );


        playButton = new Sprite(game.assets.manager.get("play2.png", Texture.class));
        playButton.setSize(MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_WIDTH);
        playButton.setPosition(SCREEN_WIDTH/2+playButton.getWidth()*0.5f, SCREEN_HEIGHT/2-playButton.getHeight() );

        background = new Sprite(game.assets.manager.get("background.png", Texture.class));
        background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        background.setPosition(0, 0);

        musicEnabled = game.prefs.getBoolean("musicEnabled", true);

        musicOn = new Sprite(game.assets.manager.get("music_on.png", Texture.class));
        musicOn.setSize(MUSIC_ICON_DIMENSIOINS, MUSIC_ICON_DIMENSIOINS);
        musicOn.setPosition(SCREEN_WIDTH/2-musicOn.getWidth()/2, MUSIC_ICON_Y);

        musicOff = new Sprite(game.assets.manager.get("music_off.png", Texture.class));
        musicOff.setSize(MUSIC_ICON_DIMENSIOINS, MUSIC_ICON_DIMENSIOINS);
        musicOff.setPosition(SCREEN_WIDTH/2-musicOn.getWidth()/2, MUSIC_ICON_Y);



        Color fontColor = new Color();
        fontColor.set(247f/255, 239f/255, 202f/255, 1f);
        font = game.createBitmapFont((int) SCREEN_WIDTH / 15, fontColor, "Lato-Heavy.ttf");


        bestScoreGlupLayout = new GlyphLayout();

    }


    @Override
    public void show() {
        int best_score = game.prefs.getInteger("highScore", 0);
        bestScore = "Best: " + best_score;
        bestScoreGlupLayout.setText(font, bestScore);

        changeMusicIcon();


        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
        //clear game screen with black
        Gdx.gl.glClearColor(0,0,0,1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //for antialiasing
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

        game.batch.begin();


        background.draw(game.batch);
        logo.draw(game.batch);
        playButton.draw(game.batch);
        shopButton.draw(game.batch);

        font.draw(game.batch, bestScore, MAIN_MENU_SHOP_BUTTON_X-bestScoreGlupLayout.width/2, MAIN_MENU_BESTSCORE_Y);

//        if (musicEnabled){
//            musicOn.draw(game.batch);
//        }else{
//            musicOff.draw(game.batch);
//        }

        musicIcon.draw(game.batch);

        game.batch.end();
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
        this.dispose();
        background.getTexture().dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (playButton.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY)){
            game.setScreen(game.playScreen);
        }else if (shopButton.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY)){
            game.setScreen(game.shopScreen);
        }
        if(musicIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY)){
            if (musicEnabled){
                musicEnabled = false;
                game.prefs.putBoolean("musicEnabled", false);
                game.prefs.flush();
            }else{
                musicEnabled = true;
                game.prefs.putBoolean("musicEnabled", true);
                game.prefs.flush();
            }
            changeMusicIcon();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void changeMusicIcon(){
        if (musicEnabled){
            musicIcon = musicOn;
        }else {
            musicIcon = musicOff;
        }
    }


}

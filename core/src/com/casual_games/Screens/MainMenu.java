package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.casual_games.Additional.Constants;
import com.casual_games.FingerGun;

public class MainMenu implements Screen, InputProcessor {
    private FingerGun game;
    private BitmapFont font;
    private GlyphLayout playGlupLayout, shopGlupLayout, titleGlupLayout;

    private String play, shop, title;

    public MainMenu(FingerGun game){
        this.game = game;

        play = "Play";
        shop = "Shop";
        title = "Finger Gun";

        font = new BitmapFont(Gdx.files.internal("fonts/favorite.fnt"));

        playGlupLayout = new GlyphLayout();
        shopGlupLayout = new GlyphLayout();
        titleGlupLayout = new GlyphLayout();

//        titleGlupLayout.setText(font, title);
//        playGlupLayout.setText(font, play);
//        shopGlupLayout.setText(font, shop);

        titleGlupLayout.setText(game.font24, title);
        playGlupLayout.setText(game.font24, play);
        shopGlupLayout.setText(game.font24, shop);



        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //clear game screen with black
        Gdx.gl.glClearColor(0,0,0,1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //for antialiasing
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

        game.batch.begin();

//        font.draw(game.batch, titleGlupLayout, Constants.MAIN_MENU_TITLE_X-titleGlupLayout.width/2, Constants.MAIN_MENU_TITLE_Y);
//        font.draw(game.batch, playGlupLayout, Constants.MAIN_MENU_PLAY_BUTTON_X-playGlupLayout.width/2, Constants.MAIN_MENU_PLAY_BUTTON_Y);
//        font.draw(game.batch, shop, Constants.MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, Constants.MAIN_MENU_SHOP_BUTTON_Y);

        game.font24.draw(game.batch, title, Constants.MAIN_MENU_TITLE_X-titleGlupLayout.width/2, Constants.MAIN_MENU_TITLE_Y);
        game.font24.draw(game.batch, play, Constants.MAIN_MENU_PLAY_BUTTON_X-playGlupLayout.width/2, Constants.MAIN_MENU_PLAY_BUTTON_Y);
        game.font24.draw(game.batch, shop, Constants.MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, Constants.MAIN_MENU_SHOP_BUTTON_Y);

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
        if (screenX >= Constants.MAIN_MENU_PLAY_BUTTON_X-playGlupLayout.width*3/2
                && screenX <= Constants.MAIN_MENU_PLAY_BUTTON_X+playGlupLayout.width*2
                && Constants.SCREEN_HEIGHT-screenY >= Constants.MAIN_MENU_PLAY_BUTTON_Y-playGlupLayout.height*3/2
                && Constants.SCREEN_HEIGHT-screenY <= Constants.MAIN_MENU_PLAY_BUTTON_Y + playGlupLayout.height*5/2) {
            game.setScreen(new PlayScreen(game));
        }else if (screenX >= Constants.MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width*3/2
                && screenX <= Constants.MAIN_MENU_SHOP_BUTTON_X+shopGlupLayout.width*2
                && Constants.SCREEN_HEIGHT-screenY >= Constants.MAIN_MENU_SHOP_BUTTON_Y-shopGlupLayout.height*3/2
                && Constants.SCREEN_HEIGHT-screenY <= Constants.MAIN_MENU_SHOP_BUTTON_Y + shopGlupLayout.height*2) {
            game.setScreen(new ShopScreen(game));
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


}

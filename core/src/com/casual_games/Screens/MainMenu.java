package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
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
    private GlyphLayout playGlupLayout, shopGlupLayout, titleGlupLayout;
    private Sprite logo, playButton, shopButton;
    private String play, shop, title;

    public MainMenu(FingerGun game){
        this.game = game;

        logo = new Sprite(game.assets.manager.get("fingerGunLogoText.png", Texture.class));
        logo.setSize(SCREEN_WIDTH*0.85f, SCREEN_HEIGHT*0.15f);
        logo.setPosition((SCREEN_WIDTH-logo.getWidth())/2, SCREEN_HEIGHT-logo.getHeight()*1.7f);

        playButton = new Sprite(game.assets.manager.get("play2.png", Texture.class));
        playButton.setSize(MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_WIDTH);
        playButton.setPosition(SCREEN_WIDTH/2-playButton.getWidth()*1.5f, SCREEN_HEIGHT/2-playButton.getHeight() );

        shopButton = new Sprite(game.assets.manager.get("shop.png", Texture.class));
        shopButton.setSize(MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_WIDTH);
        shopButton.setPosition(SCREEN_WIDTH/2+shopButton.getWidth()*0.5f, SCREEN_HEIGHT/2-playButton.getHeight() );

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




    }


    @Override
    public void show() {
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

//        font.draw(game.batch, titleGlupLayout, Constants.MAIN_MENU_TITLE_X-titleGlupLayout.width/2, Constants.MAIN_MENU_TITLE_Y);
//        font.draw(game.batch, playGlupLayout, Constants.MAIN_MENU_PLAY_BUTTON_X-playGlupLayout.width/2, Constants.MAIN_MENU_PLAY_BUTTON_Y);
//        font.draw(game.batch, shop, Constants.MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, Constants.MAIN_MENU_SHOP_BUTTON_Y);

//        game.font24.draw(game.batch, title, Constants.MAIN_MENU_TITLE_X-titleGlupLayout.width/2, Constants.MAIN_MENU_TITLE_Y);
        logo.draw(game.batch);
//        game.font24.draw(game.batch, play, MAIN_MENU_PLAY_BUTTON_X-playGlupLayout.width/2, MAIN_MENU_PLAY_BUTTON_Y);
        playButton.draw(game.batch);
//        game.font24.draw(game.batch, shop, MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, MAIN_MENU_SHOP_BUTTON_Y);
        shopButton.draw(game.batch);

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
        if (screenX >= MAIN_MENU_PLAY_BUTTON_X-playGlupLayout.width*3/2
                && screenX <= MAIN_MENU_PLAY_BUTTON_X+playGlupLayout.width*2
                && SCREEN_HEIGHT-screenY >= MAIN_MENU_PLAY_BUTTON_Y-playGlupLayout.height*3/2
                && SCREEN_HEIGHT-screenY <= MAIN_MENU_PLAY_BUTTON_Y + playGlupLayout.height*5/2) {
//            game.setScreen(new PlayScreen(game));
            game.setScreen(game.playScreen);
        }else if (screenX >= MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width*3/2
                && screenX <= MAIN_MENU_SHOP_BUTTON_X+shopGlupLayout.width*2
                && SCREEN_HEIGHT-screenY >= MAIN_MENU_SHOP_BUTTON_Y-shopGlupLayout.height*3/2
                && SCREEN_HEIGHT-screenY <= MAIN_MENU_SHOP_BUTTON_Y + shopGlupLayout.height*2) {
//            game.setScreen(new ShopScreen(game));
            game.setScreen(game.shopScreen);
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

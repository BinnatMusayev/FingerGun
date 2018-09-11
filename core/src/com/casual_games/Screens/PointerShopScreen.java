package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.casual_games.Components.Pointer;
import com.casual_games.Components.PointerOne;
import com.casual_games.Components.PointerTwo;
import com.casual_games.FingerGun;

import static com.casual_games.Additional.Constants.BACK_BUTTON_WIDTH;
import static com.casual_games.Additional.Constants.BACK_BUTTON_X;
import static com.casual_games.Additional.Constants.BACK_BUTTON_Y;
import static com.casual_games.Additional.Constants.COINS_COLLECTIVE_HEIGHT;
import static com.casual_games.Additional.Constants.COINS_COLLECTIVE_WIDTH;
import static com.casual_games.Additional.Constants.MAIN_MENU_SHOP_BUTTON_X;
import static com.casual_games.Additional.Constants.SCREEN_HEIGHT;
import static com.casual_games.Additional.Constants.SCREEN_WIDTH;

public class PointerShopScreen implements Screen, InputProcessor {

    FingerGun game;
    private BitmapFont titleFont, totalCoinsFont, buyFont;
    private String titleText, totalCoinCountText, priceText, buyText;
    private GlyphLayout shopGlupLayout, coinCountGlupLayout, priceTextGlupLayout, buyTextGlupLayout;
    private Sprite backButton, currentCoinsIcon, coinIcon, plusIcon;
    private Pointer pointerOne, pointerTwo;

    public PointerShopScreen(FingerGun game) {
        this.game = game;

        pointerOne = new PointerOne();
        pointerOne.setX(200);
        pointerOne.setY(300);
        pointerOne.setVisible(true);
        pointerTwo = new PointerTwo();
        pointerTwo.setX(200);
        pointerTwo.setY(900);
        pointerTwo.setVisible(true);

        Color totalCoinsFontColor = new Color();
        totalCoinsFontColor.set(247f/255, 239f/255, 202f/255, 1f);
        titleFont = game.createBitmapFont((int) SCREEN_WIDTH / 15);
        totalCoinsFont = game.createBitmapFont((int) SCREEN_WIDTH / 25, totalCoinsFontColor);
        buyFont = game.createBitmapFont((int) SCREEN_WIDTH / 12, totalCoinsFontColor);

        titleText = "Pointer Shop";
        shopGlupLayout = new GlyphLayout();
        shopGlupLayout.setText(titleFont, titleText);
        //--
        totalCoinCountText = "24531";
        coinCountGlupLayout = new GlyphLayout();
        coinCountGlupLayout.setText(totalCoinsFont, totalCoinCountText);


        backButton = new Sprite();
        currentCoinsIcon = new Sprite();

        backButton.setSize(BACK_BUTTON_WIDTH, BACK_BUTTON_WIDTH);
        backButton.setPosition(BACK_BUTTON_X, BACK_BUTTON_Y);
        backButton.setRegion(new Texture(Gdx.files.internal("back_button.png")));

        currentCoinsIcon.setSize(COINS_COLLECTIVE_WIDTH, COINS_COLLECTIVE_HEIGHT);
        currentCoinsIcon.setPosition(SCREEN_WIDTH-SCREEN_WIDTH/50-currentCoinsIcon.getWidth(), BACK_BUTTON_Y+coinCountGlupLayout.height/2);
        currentCoinsIcon.setRegion(new Texture(Gdx.files.internal("coins_collective.png")));


        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
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


        //sprite batch
        game.batch.begin();
            backButton.draw(game.batch);
            titleFont.draw(game.batch, titleText, MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, BACK_BUTTON_Y+shopGlupLayout.height*3/2);
            totalCoinsFont.draw(game.batch, totalCoinCountText, SCREEN_WIDTH-coinCountGlupLayout.width-currentCoinsIcon.getWidth()-SCREEN_WIDTH/40, BACK_BUTTON_Y+coinCountGlupLayout.height*2);
            currentCoinsIcon.draw(game.batch);




        game.batch.end();

        game.arc.begin(ShapeRenderer.ShapeType.Line);
            pointerOne.draw(game.arc);
            pointerTwo.draw(game.arc);

        game.arc.end();
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
        titleFont.dispose();
        buyFont.dispose();
        totalCoinsFont.dispose();
        backButton.getTexture().dispose();
        currentCoinsIcon.getTexture().dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new ShopScreen(game));
        }
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
        if (backButton.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY)){
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

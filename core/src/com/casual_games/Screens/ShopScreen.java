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
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.casual_games.Additional.Constants;
import com.casual_games.FingerGun;

import static com.casual_games.Additional.Constants.*;

public class ShopScreen implements Screen, InputProcessor{

    private FingerGun game;
    private Sprite backButton, bgRect, pistolIcon, heartIcon, pointerIcon, coinsIcon;
    private BitmapFont font;
    private GlyphLayout shopGlupLayout;
    private String titleText;

    public ShopScreen(FingerGun game){
        this.game = game;

        backButton = new Sprite();
        bgRect = new Sprite();
        pistolIcon = new Sprite();
        heartIcon = new Sprite();
        pointerIcon = new Sprite();
        coinsIcon = new Sprite();

        font = game.createBitmapFont((int)Constants.SCREEN_WIDTH/15);

        titleText  = "Shop";
        shopGlupLayout = new GlyphLayout();
        shopGlupLayout.setText(font, titleText);
        //positions
        backButton.setPosition(BACK_BUTTON_X, BACK_BUTTON_Y);

        //sizes
        backButton.setSize(BACK_BUTTON_WIDTH, BACK_BUTTON_WIDTH);

        //files
        backButton.setRegion(new Texture(Gdx.files.internal("back_button.png")));


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

        backButton.draw(game.batch);
        font.draw(game.batch, titleText, MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, BACK_BUTTON_Y+shopGlupLayout.height*3/2);

        game.batch.end();

        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(Color.RED);
        game.shapeRenderer.circle(BACK_BUTTON_X, BACK_BUTTON_Y, 2);
        game.shapeRenderer.end();
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

    //input processor

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
        return false;
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

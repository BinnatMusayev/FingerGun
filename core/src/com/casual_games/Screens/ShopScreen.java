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
import com.casual_games.FingerGun;
import static com.casual_games.Additional.Constants.*;

public class ShopScreen implements Screen, InputProcessor{

    private FingerGun game;
    private Sprite backButton, bgRect1, bgRect2, bgRect3, pistolIcon, heartIcon, pointerIcon, coinsIcon;
    private BitmapFont font;
    private GlyphLayout shopGlupLayout;
    private String titleText;

    public ShopScreen(FingerGun game){
        this.game = game;

        backButton = new Sprite(game.assets.manager.get("back_button.png", Texture.class));
        bgRect1 = new Sprite(game.assets.manager.get("orange.png", Texture.class));
        bgRect2 = new Sprite(game.assets.manager.get("orange.png", Texture.class));
        bgRect3 = new Sprite(game.assets.manager.get("orange.png", Texture.class));
        pistolIcon = new Sprite(game.assets.manager.get("pistol_icon.png", Texture.class));
        heartIcon = new Sprite(game.assets.manager.get("heart_icon.png", Texture.class));
        pointerIcon = new Sprite(game.assets.manager.get("pointer_icon.png", Texture.class));
        coinsIcon = new Sprite(game.assets.manager.get("coin_icon.png", Texture.class));

        font = game.createBitmapFont((int)SCREEN_WIDTH/15);

        titleText  = "Shop";
        shopGlupLayout = new GlyphLayout();
        shopGlupLayout.setText(font, titleText);

        //sizes
        backButton.setSize(BACK_BUTTON_WIDTH, BACK_BUTTON_WIDTH);
        bgRect1.setSize(BG_RECT_WIDTH, BG_RECT_HEIGHT);
        bgRect2.setSize(BG_RECT_WIDTH, BG_RECT_HEIGHT);
        bgRect3.setSize(BG_RECT_WIDTH, BG_RECT_HEIGHT);
        pistolIcon.setSize(bgRect1.getWidth()*4/5, bgRect1.getWidth()*4/5);
        heartIcon.setSize(bgRect2.getWidth()*2/3, bgRect2.getWidth()*0.6f);
        pointerIcon.setSize(bgRect3.getWidth()*4/5, bgRect3.getWidth()*4/5);

        //positions
        backButton.setPosition(BACK_BUTTON_X, BACK_BUTTON_Y);
        bgRect1.setPosition(SCREEN_WIDTH/10, backButton.getY() - backButton.getHeight() - bgRect1.getHeight()- SCREEN_HEIGHT/50);
        bgRect2.setPosition(SCREEN_WIDTH/2+SCREEN_WIDTH/10, backButton.getY() - backButton.getHeight() - bgRect2.getHeight()- SCREEN_HEIGHT/50);
        bgRect3.setPosition(SCREEN_WIDTH/10, backButton.getY() - backButton.getHeight() - 2*bgRect3.getHeight()- 3*SCREEN_HEIGHT/50) ;
        pistolIcon.setPosition(bgRect1.getX()+(bgRect1.getWidth()-pistolIcon.getWidth())/2, bgRect1.getY()+(bgRect1.getHeight()-pistolIcon.getHeight())/2 ) ;
        heartIcon.setPosition(bgRect2.getX()+(bgRect2.getWidth()-heartIcon.getWidth())/2, bgRect2.getY()+(bgRect2.getHeight()-heartIcon.getHeight())/2 ) ;
        pointerIcon.setPosition(bgRect3.getX()+(bgRect3.getWidth()-pointerIcon.getWidth())/2, bgRect3.getY()+(bgRect3.getHeight()-pointerIcon.getHeight())/2 ) ;

        //files
//        backButton.setRegion(new Texture(Gdx.files.internal("back_button.png")));
//        bgRect1.setRegion(new Texture(Gdx.files.internal("orange.png")));
//        bgRect2.setRegion(new Texture(Gdx.files.internal("orange.png")));
//        bgRect3.setRegion(new Texture(Gdx.files.internal("orange.png")));
//        pistolIcon.setRegion(new Texture(Gdx.files.internal("pistol_icon.png")));
//        heartIcon.setRegion(new Texture(Gdx.files.internal("heart_icon.png")));
//        heartIcon.setRegion(new Texture(Gdx.files.internal("heart_icon.png")));
//        pointerIcon.setRegion(new Texture(Gdx.files.internal("pointer_icon.png")));



    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);

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
        bgRect1.draw(game.batch);
        bgRect2.draw(game.batch);
        bgRect3.draw(game.batch);
        pistolIcon.draw(game.batch);
        heartIcon.draw(game.batch);
        pointerIcon.draw(game.batch);

        game.batch.end();

        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        game.shapeRenderer.setColor(Color.RED);
//        game.shapeRenderer.circle(BACK_BUTTON_X, BACK_BUTTON_Y, 2);
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
        this.dispose();
        game.shapeRenderer.dispose();
        game.batch.dispose();
        game.arc.dispose();
        font.dispose();
        backButton.getTexture().dispose();
        bgRect1.getTexture().dispose();
        bgRect2.getTexture().dispose();
        bgRect3.getTexture().dispose();
        pistolIcon.getTexture().dispose();
        heartIcon.getTexture().dispose();
        pointerIcon.getTexture().dispose();
        coinsIcon.getTexture().dispose();

    }

    //input processor

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
//            game.setScreen(new MainMenu(game));
            game.setScreen(game.mainMenu);
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
//            game.setScreen(new MainMenu(game));
            game.setScreen(game.mainMenu);
        }else if (bgRect1.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY)){
//            game.setScreen(new GunsShopScreen(game));
            game.setScreen(game.gunsShopScreen);
        }else if (bgRect2.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY)){
//            game.setScreen(new HealthShopScreen(game));
            game.setScreen(game.healthShopScreen);
        }else if (bgRect3.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY)){
//            game.setScreen(new PointerShopScreen(game));
            game.setScreen(game.pointerShopScreen);
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

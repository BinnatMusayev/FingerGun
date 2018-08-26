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
import com.casual_games.FingerGun;
import static com.casual_games.Additional.Constants.*;

public class GunsShopScreen implements Screen, InputProcessor {

    private FingerGun game;
    private Sprite backButton, pistolPlusIcon, bgRect1, bgRect2, bgRect3, pistolIcon, sniperIcon, minigunIcon, currentCoinsIcon;
    private Sprite coinIcon;
    private BitmapFont font, smallFont, xsFont;
    private GlyphLayout shopGlupLayout, coinCountGlupLayout, shootingTimeoutGlupLayout, damageGlupLayout;
    private String titleText, coinCountText;
    private String shootingTimeoutText, damageText;

    //put current gosterici strings here

    //price strings
    private String pistolTimeoutUpgradePrice, pistolDamageUpgradePrice;
    private GlyphLayout pistolTimeoutUpgradeGlyphLayout, pistolDamageUpgradeGlyphLayout;

    public GunsShopScreen(FingerGun game) {
        this.game = game;

        backButton = new Sprite();
        pistolPlusIcon = new Sprite();
        bgRect1 = new Sprite();
        bgRect2 = new Sprite();
        bgRect3 = new Sprite();
        pistolIcon = new Sprite();
        sniperIcon = new Sprite();
        minigunIcon = new Sprite();
        currentCoinsIcon = new Sprite();
        coinIcon = new Sprite();


        font = game.createBitmapFont((int) SCREEN_WIDTH / 15);
        Color smallFontColor = new Color();
        smallFontColor.set(247f/255, 239f/255, 202f/255, 1f);
        smallFont = game.createBitmapFont((int) SCREEN_WIDTH / 25, smallFontColor);
        xsFont = game.createBitmapFont((int) SCREEN_WIDTH / 30, smallFontColor);

        titleText = "Guns Shop";
        shopGlupLayout = new GlyphLayout();
        shopGlupLayout.setText(font, titleText);
        //--
        coinCountText = "24531";
        coinCountGlupLayout = new GlyphLayout();
        coinCountGlupLayout.setText(smallFont, coinCountText);
        //--
        shootingTimeoutText = "Shooting \nTimeout: ";
        shootingTimeoutGlupLayout = new GlyphLayout();
        shootingTimeoutGlupLayout.setText(xsFont, shootingTimeoutText);
        //--
        damageText = "Damage: ";
        damageGlupLayout = new GlyphLayout();
        damageGlupLayout.setText(xsFont, damageText);
        //--
        pistolTimeoutUpgradePrice = "200";
        pistolTimeoutUpgradeGlyphLayout = new GlyphLayout();
        pistolTimeoutUpgradeGlyphLayout.setText(smallFont, pistolTimeoutUpgradePrice);
        //--
        pistolDamageUpgradePrice = "2483";
        pistolDamageUpgradeGlyphLayout = new GlyphLayout();
        pistolDamageUpgradeGlyphLayout.setText(smallFont, pistolDamageUpgradePrice);



        //sizes
        backButton.setSize(BACK_BUTTON_WIDTH, BACK_BUTTON_WIDTH);
        pistolPlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
        bgRect1.setSize(BG_RECT_GUNS_WIDTH, BG_RECT_GUNS_HEIGHT);
        bgRect2.setSize(BG_RECT_GUNS_WIDTH, BG_RECT_GUNS_HEIGHT);
        bgRect3.setSize(BG_RECT_GUNS_WIDTH, BG_RECT_GUNS_HEIGHT);
        pistolIcon.setSize(bgRect1.getWidth() * 4 / 5, bgRect1.getWidth() * 4 / 5);
        sniperIcon.setSize(bgRect2.getWidth() * 7/8, bgRect2.getWidth() * 7/8);
        minigunIcon.setSize(bgRect3.getWidth() * 7/8, bgRect3.getWidth() * 7/8);
        currentCoinsIcon.setSize(COINS_COLLECTIVE_WIDTH, COINS_COLLECTIVE_HEIGHT);
        coinIcon.setSize(SCREEN_WIDTH/20, SCREEN_WIDTH/20);


        //positions -- try to avoid to set position to the items that are repeated -- refactor later
        backButton.setPosition(BACK_BUTTON_X, BACK_BUTTON_Y);
        bgRect1.setPosition(SCREEN_WIDTH / 20, backButton.getY() - backButton.getHeight() - bgRect1.getHeight() - SCREEN_HEIGHT / 50);
        bgRect2.setPosition(SCREEN_WIDTH / 20, bgRect1.getY()-bgRect1.getHeight()-SCREEN_HEIGHT/30);
        bgRect3.setPosition(SCREEN_WIDTH / 20, bgRect2.getY()-bgRect2.getHeight()-SCREEN_HEIGHT/30);
        pistolPlusIcon.setPosition(SCREEN_WIDTH*0.65f, bgRect1.getY()+bgRect1.getHeight()-pistolPlusIcon.getHeight()*1.7f);
        pistolIcon.setPosition(bgRect1.getX() + (bgRect1.getWidth() - pistolIcon.getWidth()) / 2, bgRect1.getY() + (bgRect1.getHeight() - pistolIcon.getHeight()) / 2);
        sniperIcon.setPosition(bgRect2.getX() + (bgRect2.getWidth() - sniperIcon.getWidth()) / 2, bgRect2.getY() + (bgRect2.getHeight() - sniperIcon.getHeight()) / 2);
        minigunIcon.setPosition(bgRect3.getX() + (bgRect3.getWidth() - minigunIcon.getWidth()) / 2, bgRect3.getY() + (bgRect3.getHeight() - minigunIcon.getHeight()) / 2);
        currentCoinsIcon.setPosition(SCREEN_WIDTH-SCREEN_WIDTH/50-currentCoinsIcon.getWidth(), BACK_BUTTON_Y+coinCountGlupLayout.height/2);

        //files
        backButton.setRegion(new Texture(Gdx.files.internal("back_button.png")));
        pistolPlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
        bgRect1.setRegion(new Texture(Gdx.files.internal("orange.png")));
        bgRect2.setRegion(new Texture(Gdx.files.internal("orange.png")));
        bgRect3.setRegion(new Texture(Gdx.files.internal("orange.png")));
        pistolIcon.setRegion(new Texture(Gdx.files.internal("pistol_icon.png")));
        sniperIcon.setRegion(new Texture(Gdx.files.internal("sniper_icon.png")));
        minigunIcon.setRegion(new Texture(Gdx.files.internal("minigun_icon.png")));
        currentCoinsIcon.setRegion(new Texture(Gdx.files.internal("coins_collective.png")));
        coinIcon.setRegion(new Texture(Gdx.files.internal("coin_icon.png")));


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

        game.batch.begin();

        backButton.draw(game.batch);
        font.draw(game.batch, titleText, MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, BACK_BUTTON_Y+shopGlupLayout.height*3/2);
        smallFont.draw(game.batch, coinCountText, SCREEN_WIDTH-coinCountGlupLayout.width-currentCoinsIcon.getWidth()-SCREEN_WIDTH/40, BACK_BUTTON_Y+coinCountGlupLayout.height*2);
        xsFont.draw(game.batch, shootingTimeoutText, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/40, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height*0.5f);
        smallFont.draw(game.batch, "3000", bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height);
        smallFont.draw(game.batch, pistolTimeoutUpgradePrice, pistolPlusIcon.getX()+pistolPlusIcon.getWidth()+SCREEN_WIDTH/40, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height);
        bgRect1.draw(game.batch);
        bgRect2.draw(game.batch);
        bgRect3.draw(game.batch);
        pistolPlusIcon.draw(game.batch);
        pistolIcon.draw(game.batch);
        sniperIcon.draw(game.batch);
        minigunIcon.draw(game.batch);
        currentCoinsIcon.draw(game.batch);

        game.batch.draw(coinIcon.getTexture(), pistolPlusIcon.getX()+pistolPlusIcon.getWidth()+SCREEN_WIDTH/20+pistolTimeoutUpgradeGlyphLayout.width,
                bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height-pistolTimeoutUpgradeGlyphLayout.height*1.3f,
                coinIcon.getWidth(), coinIcon.getHeight());

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
        font.dispose();
        smallFont.dispose();
        backButton.getTexture().dispose();
        bgRect1.getTexture().dispose();
        bgRect2.getTexture().dispose();
        bgRect3.getTexture().dispose();
        pistolPlusIcon.getTexture().dispose();
        pistolIcon.getTexture().dispose();
        sniperIcon.getTexture().dispose();
        minigunIcon.getTexture().dispose();
        currentCoinsIcon.getTexture().dispose();
        coinIcon.getTexture().dispose();
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

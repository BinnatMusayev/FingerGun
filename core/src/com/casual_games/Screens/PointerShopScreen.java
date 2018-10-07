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
import static com.casual_games.Additional.Constants.POINTER_ONE_PRICE;
import static com.casual_games.Additional.Constants.POINTER_TWO_PRICE;
import static com.casual_games.Additional.Constants.SCREEN_HEIGHT;
import static com.casual_games.Additional.Constants.SCREEN_WIDTH;

public class PointerShopScreen implements Screen, InputProcessor {

    FingerGun game;
    private BitmapFont titleFont, totalCoinsFont, buyFont, priceFont;
    private String titleText, totalCoinCountText, currentPointer;
    private GlyphLayout shopGlupLayout, coinCountGlupLayout;
    private Sprite backButton, currentCoinsIcon, coinIcon, background;
    private boolean isPointerOnePurchased, isPointerTwoPurchased;

    //pointer one
    private Pointer pointerOne;
    private String pointerOneBuyText, pointerOnePriceText, pointerOneOwningText;
    private GlyphLayout pointerOneBuyTextGlyphLayout, pointerOnePriceStringGlyphLayout, pointerOneOwningTextGlyphLayout;
    private Sprite pointerOnePlusIcon;

    //pointer two
    private Pointer pointerTwo;
    private String pointerTwoBuyText, pointerTwoPriceText, pointerTwoOwningText;
    private GlyphLayout pointerTwoBuyTextGlyphLayout, pointerTwoPriceStringGlyphLayout, pointerTwoOwningTextGlyphLayout;
    private Sprite pointerTwoPlusIcon;


    public PointerShopScreen(FingerGun game) {
        this.game = game;

        currentPointer = game.prefs.getString("currentPointer");
        isPointerOnePurchased = game.prefs.getBoolean("isPointerOnePurchased", false);
        isPointerTwoPurchased= game.prefs.getBoolean("isPointerTwoPurchased", false);

//        isPointerOnePurchased = true;
//        isPointerTwoPurchased = false;

        background = new Sprite(game.assets.manager.get("background.png", Texture.class));
        background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        background.setPosition(0, 0);

        Color totalCoinsFontColor = new Color();
        totalCoinsFontColor.set(247f/255, 239f/255, 202f/255, 1f);
        titleFont = game.createBitmapFont((int) SCREEN_WIDTH / 15);
        totalCoinsFont = game.createBitmapFont((int) SCREEN_WIDTH / 25, totalCoinsFontColor);
        buyFont = game.createBitmapFont((int) SCREEN_WIDTH / 12, totalCoinsFontColor);
        priceFont = game.createBitmapFont((int) SCREEN_WIDTH / 20, totalCoinsFontColor);

        titleText = "Pointer Shop";
        shopGlupLayout = new GlyphLayout();
        shopGlupLayout.setText(titleFont, titleText);
        //--
        coinCountGlupLayout = new GlyphLayout();
        //--
        pointerOneBuyText = "Buy";
        pointerOneBuyTextGlyphLayout = new GlyphLayout();
        pointerOneBuyTextGlyphLayout.setText(buyFont, pointerOneBuyText);
        //--
        pointerTwoBuyText = "Buy";
        pointerTwoBuyTextGlyphLayout = new GlyphLayout();
        pointerTwoBuyTextGlyphLayout.setText(buyFont, pointerTwoBuyText);
        //--
        pointerOnePriceText = String.valueOf(POINTER_ONE_PRICE);
        pointerOnePriceStringGlyphLayout = new GlyphLayout();
        pointerOnePriceStringGlyphLayout.setText(priceFont, pointerOnePriceText);
        //--
        pointerTwoPriceText = String.valueOf(POINTER_TWO_PRICE);
        pointerTwoPriceStringGlyphLayout = new GlyphLayout();
        pointerTwoPriceStringGlyphLayout.setText(priceFont, pointerTwoPriceText);
        //--
        pointerOneOwningText = "You own this item";
        pointerOneOwningTextGlyphLayout = new GlyphLayout();
        pointerOneOwningTextGlyphLayout.setText(priceFont, pointerOneOwningText);
        //--
        pointerTwoOwningText = "You own this item";
        pointerTwoOwningTextGlyphLayout = new GlyphLayout();
        pointerTwoOwningTextGlyphLayout.setText(priceFont, pointerTwoOwningText);


        backButton = new Sprite(game.assets.manager.get("back_button.png", Texture.class));
        currentCoinsIcon = new Sprite(game.assets.manager.get("coins_collective.png", Texture.class));
        pointerOnePlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        pointerTwoPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        coinIcon = new Sprite(game.assets.manager.get("coin_icon.png", Texture.class));


        backButton.setSize(BACK_BUTTON_WIDTH, BACK_BUTTON_WIDTH);
        backButton.setPosition(BACK_BUTTON_X, BACK_BUTTON_Y);
//        backButton.setRegion(new Texture(Gdx.files.internal("back_button.png")));

        currentCoinsIcon.setSize(COINS_COLLECTIVE_WIDTH, COINS_COLLECTIVE_HEIGHT);
        currentCoinsIcon.setPosition(SCREEN_WIDTH-SCREEN_WIDTH/50-currentCoinsIcon.getWidth(), BACK_BUTTON_Y+coinCountGlupLayout.height/2);
//        currentCoinsIcon.setRegion(new Texture(Gdx.files.internal("coins_collective.png")));




        //pointers
        pointerOne = new PointerOne();
        pointerOne.setR(Gdx.graphics.getWidth()/8);
        pointerOne.setX(SCREEN_WIDTH/15+pointerOne.getR());
        pointerOne.setY(backButton.getY()-SCREEN_HEIGHT/7-pointerOne.getR());
        pointerOne.setVisible(true);
        pointerTwo = new PointerTwo();
        pointerTwo.setR(Gdx.graphics.getWidth()/8);
        pointerTwo.setX(SCREEN_WIDTH/15+pointerTwo.getR());
        pointerTwo.setY(pointerOne.getY()-SCREEN_HEIGHT/12-pointerTwo.getR());
        pointerTwo.setVisible(true);


        pointerOnePlusIcon.setSize(SCREEN_WIDTH/15, SCREEN_WIDTH/15);
        pointerOnePlusIcon.setPosition(pointerOne.getX()+pointerOne.getR()+SCREEN_WIDTH/15+pointerOneBuyTextGlyphLayout.width+SCREEN_WIDTH/17, pointerOne.getY()+pointerOne.getR()*1.15f-pointerOneBuyTextGlyphLayout.height*1.2f);
//        pointerOnePlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));

        pointerTwoPlusIcon.setSize(SCREEN_WIDTH/15, SCREEN_WIDTH/15);
        pointerTwoPlusIcon.setPosition(pointerTwo.getX()+pointerTwo.getR()+SCREEN_WIDTH/15+pointerTwoBuyTextGlyphLayout.width+SCREEN_WIDTH/17, pointerTwo.getY()+pointerTwoBuyTextGlyphLayout.height/2-pointerTwoBuyTextGlyphLayout.height*1.2f);
//        pointerTwoPlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));


        //asagida evezle
        coinIcon.setSize(SCREEN_WIDTH/15, SCREEN_WIDTH/15);
//        coinIcon.setPosition(pointerOnePlusIcon.getX()+pointerOnePlusIcon.getWidth()+SCREEN_WIDTH/15+pointerOneBuyTextGlyphLayout.width, pointerOnePlusIcon.getY());
//        coinIcon.setRegion(new Texture(Gdx.files.internal("coin_icon.png")));

    }


    @Override
    public void show() {
        totalCoinCountText = String.valueOf(game.prefs.getInteger("coinCoint", 0));
        coinCountGlupLayout.setText(totalCoinsFont, totalCoinCountText);

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

        //Line width
        Gdx.gl.glLineWidth(Gdx.graphics.getWidth()/100);

        pointerTwo.update(delta);

        game.batch.begin();
            background.draw(game.batch);
        game.batch.end();

        //shaperenderer
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        Gdx.gl.glEnable(GL20.GL_BLEND); //for transparency
        game.shapeRenderer.setColor(33f/255, 142f/255, 2f/255, 0.7f);
        //if number of pointers increase. this can be replaced by switch case
        if (currentPointer.equals("pointerOne"))
            game.shapeRenderer.rect(0, pointerOne.getY(), SCREEN_WIDTH, pointerOne.getR()*2);
        else if(currentPointer.equals("pointerTwo"))
            game.shapeRenderer.rect(0, pointerTwo.getY()-pointerTwo.getR()-SCREEN_HEIGHT/100, SCREEN_WIDTH, pointerOne.getR()*2+SCREEN_HEIGHT/50);

        game.shapeRenderer.end();


        //sprite batch
        game.batch.begin();
            backButton.draw(game.batch);
            titleFont.draw(game.batch, titleText, MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, BACK_BUTTON_Y+shopGlupLayout.height*3/2);
            totalCoinsFont.draw(game.batch, totalCoinCountText, SCREEN_WIDTH-coinCountGlupLayout.width-currentCoinsIcon.getWidth()-SCREEN_WIDTH/40, BACK_BUTTON_Y+coinCountGlupLayout.height*2);
            currentCoinsIcon.draw(game.batch);
            if (!isPointerOnePurchased) {
                buyFont.draw(game.batch, pointerOneBuyText, pointerOne.getX() + pointerOne.getR() + SCREEN_WIDTH / 15, pointerOne.getY() + pointerOne.getR() * 1.15f);
                pointerOnePlusIcon.draw(game.batch);
                priceFont.draw(game.batch, pointerOnePriceText, pointerOnePlusIcon.getX() + pointerOnePlusIcon.getWidth() + SCREEN_WIDTH / 20, pointerOne.getY() + pointerOne.getR() * 1.15f - pointerOneBuyTextGlyphLayout.height + pointerOnePriceStringGlyphLayout.height);

                game.batch.draw(coinIcon.getTexture(), pointerOnePlusIcon.getX()+pointerOnePlusIcon.getWidth()+SCREEN_WIDTH/15+pointerOneBuyTextGlyphLayout.width,
                        pointerOnePlusIcon.getY(),
                        coinIcon.getWidth(), coinIcon.getHeight());

            }else{
                priceFont.draw(game.batch, pointerOneOwningText, pointerOne.getX() + pointerOne.getR() + SCREEN_WIDTH / 15, pointerOne.getY() + pointerOne.getR() );
            }

            if (!isPointerTwoPurchased) {
                buyFont.draw(game.batch, pointerTwoBuyText, pointerTwo.getX() + pointerTwo.getR() + SCREEN_WIDTH / 15, pointerTwo.getY() +pointerTwoBuyTextGlyphLayout.height/2);
                pointerTwoPlusIcon.draw(game.batch);
                priceFont.draw(game.batch, pointerTwoPriceText, pointerTwoPlusIcon.getX() + pointerTwoPlusIcon.getWidth() + SCREEN_WIDTH / 20, pointerTwo.getY() + pointerTwoBuyTextGlyphLayout.height/2 - pointerTwoBuyTextGlyphLayout.height + pointerTwoPriceStringGlyphLayout.height);

                game.batch.draw(coinIcon.getTexture(), pointerTwoPlusIcon.getX()+pointerTwoPlusIcon.getWidth()+SCREEN_WIDTH/15+pointerTwoBuyTextGlyphLayout.width,
                        pointerTwoPlusIcon.getY(),
                        coinIcon.getWidth(), coinIcon.getHeight());
            }else{
                priceFont.draw(game.batch, pointerTwoOwningText, pointerTwo.getX() + pointerTwo.getR() + SCREEN_WIDTH / 15, pointerTwo.getY() + +pointerOneOwningTextGlyphLayout.height/2);
            }




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
        this.dispose();
        titleFont.dispose();
        buyFont.dispose();
        totalCoinsFont.dispose();
        background.getTexture().dispose();
        backButton.getTexture().dispose();
        currentCoinsIcon.getTexture().dispose();
        pointerOnePlusIcon.getTexture().dispose();
        pointerTwoPlusIcon.getTexture().dispose();
        coinIcon.getTexture().dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
//            game.setScreen(new ShopScreen(game));
            game.setScreen(game.shopScreen);
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
//            game.setScreen(new ShopScreen(game));
            game.setScreen(game.shopScreen);
        }


        //buy pointer one
        if (pointerOnePlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !isPointerOnePurchased ){

            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(pointerOnePriceText) ) {

                //update coins
                currentCoins = currentCoins - Integer.valueOf(pointerOnePriceText);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                isPointerOnePurchased = true;
                currentPointer = "pointerOne";

                game.prefs.putBoolean("isPointerOnePurchased", true);
                game.prefs.putString("currentPointer", "pointerOne");
                game.prefs.flush();
            }
        }

        //buy pointer two
        if (pointerTwoPlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !isPointerTwoPurchased ){

            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(pointerTwoPriceText) ) {

                //update coins
                currentCoins = currentCoins - Integer.valueOf(pointerTwoPriceText);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                isPointerTwoPurchased = true;
                currentPointer = "pointerTwo";

                game.prefs.putBoolean("isPointerTwoPurchased", true);
                game.prefs.putString("currentPointer", "pointerTwo");
                game.prefs.flush();
            }
        }

        //choose pointer to use
        if ((SCREEN_HEIGHT-screenY) >= pointerOne.getY()
                && (SCREEN_HEIGHT-screenY) <= pointerOne.getY() + pointerOne.getR()*2
                && isPointerOnePurchased ){
            currentPointer = "pointerOne";
            game.prefs.putString("currentPointer", "pointerOne");
            game.prefs.flush();
        }else if ((SCREEN_HEIGHT-screenY) >= pointerTwo.getY()
                && (SCREEN_HEIGHT-screenY) <= pointerTwo.getY() + pointerTwo.getR()*2
                && isPointerTwoPurchased ){
            currentPointer = "pointerTwo";
            game.prefs.putString("currentPointer", "pointerTwo");
            game.prefs.flush();
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

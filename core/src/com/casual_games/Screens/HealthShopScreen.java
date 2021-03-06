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
import com.casual_games.Additional.Constants;
import com.casual_games.FingerGun;

import static com.casual_games.Additional.Constants.BACK_BUTTON_WIDTH;
import static com.casual_games.Additional.Constants.BACK_BUTTON_X;
import static com.casual_games.Additional.Constants.BACK_BUTTON_Y;
import static com.casual_games.Additional.Constants.COINS_COLLECTIVE_HEIGHT;
import static com.casual_games.Additional.Constants.COINS_COLLECTIVE_WIDTH;
import static com.casual_games.Additional.Constants.MAIN_MENU_SHOP_BUTTON_X;
import static com.casual_games.Additional.Constants.SCREEN_HEIGHT;
import static com.casual_games.Additional.Constants.SCREEN_WIDTH;

public class HealthShopScreen implements Screen, InputProcessor {

    private FingerGun game;
    private BitmapFont titleFont, healthFont, totalCoinsFont, buyFont;
    private String titleText, totalCoinCountText, priceText, currentHealth;
    private GlyphLayout shopGlupLayout, coinCountGlupLayout, priceTextGlupLayout, currentHealthGlupLayout;
    private Sprite backButton, currentCoinsIcon, coinIcon, heartIcon, plusIcon, background;

    private boolean maxHealthReached;

    public HealthShopScreen(FingerGun game) {
        this.game = game;

        background = new Sprite(game.assets.manager.get("background.png", Texture.class));
        background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        background.setPosition(0, 0);

        Color totalCoinsFontColor = new Color();
        totalCoinsFontColor.set(247f/255, 239f/255, 202f/255, 1f);
        titleFont = game.createBitmapFont((int) SCREEN_WIDTH / 15);
        totalCoinsFont = game.createBitmapFont((int) SCREEN_WIDTH / 25, totalCoinsFontColor);
        buyFont = game.createBitmapFont((int) SCREEN_WIDTH / 12, totalCoinsFontColor);
        healthFont = game.createBitmapFont((int) SCREEN_WIDTH / 12, Color.WHITE);

        titleText = "Health Shop";
        shopGlupLayout = new GlyphLayout();
        shopGlupLayout.setText(titleFont, titleText);
        //--
        coinCountGlupLayout = new GlyphLayout();
        //--
        int current_health = game.prefs.getInteger("current_health", 100);

        //finding index
        int index = 0;
        for(int i=0; i<Constants.HEART_HEALTH.length-1;i++){
            if(Constants.HEART_HEALTH[i]==current_health)
                index = i;
        }

        priceText = String.valueOf(Constants.HEART_PRICE[index]);
        priceTextGlupLayout = new GlyphLayout();
        priceTextGlupLayout.setText(buyFont, priceText);
        //--
        currentHealth = String.valueOf(game.prefs.getInteger("current_health", 100));
        currentHealthGlupLayout = new GlyphLayout();
        currentHealthGlupLayout.setText(healthFont, currentHealth);

        backButton = new Sprite(game.assets.manager.get("back_button.png", Texture.class));
        currentCoinsIcon = new Sprite(game.assets.manager.get("coins_collective.png", Texture.class));
        heartIcon = new Sprite(game.assets.manager.get("heart_icon2.png", Texture.class));
        plusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        coinIcon = new Sprite(game.assets.manager.get("coin_icon.png", Texture.class));

        backButton.setSize(BACK_BUTTON_WIDTH, BACK_BUTTON_WIDTH);
        backButton.setPosition(BACK_BUTTON_X, BACK_BUTTON_Y);
        backButton.setRegion(new Texture(Gdx.files.internal("back_button.png")));

        currentCoinsIcon.setSize(COINS_COLLECTIVE_WIDTH, COINS_COLLECTIVE_HEIGHT);
        currentCoinsIcon.setPosition(SCREEN_WIDTH-SCREEN_WIDTH/50-currentCoinsIcon.getWidth(), BACK_BUTTON_Y+coinCountGlupLayout.height/2);
//        currentCoinsIcon.setRegion(new Texture(Gdx.files.internal("coins_collective.png")));


        heartIcon.setSize(SCREEN_WIDTH*0.8f, SCREEN_WIDTH*0.7f);
        heartIcon.setPosition((SCREEN_WIDTH-heartIcon.getWidth())/2, backButton.getY()-SCREEN_HEIGHT/15-heartIcon.getHeight() );
//        heartIcon.setRegion(new Texture(Gdx.files.internal("heart_icon2.png")));

        plusIcon.setSize(SCREEN_WIDTH/8, SCREEN_WIDTH/8);
        plusIcon.setPosition((SCREEN_WIDTH-plusIcon.getWidth())/2, heartIcon.getY()-SCREEN_HEIGHT/10) ;
//        plusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));

        coinIcon.setSize(SCREEN_WIDTH/12, SCREEN_WIDTH/12);
        coinIcon.setPosition((SCREEN_WIDTH-priceTextGlupLayout.width)/2+priceTextGlupLayout.width+SCREEN_WIDTH/30,plusIcon.getY()-SCREEN_HEIGHT/15-coinIcon.getHeight()+(coinIcon.getHeight()-priceTextGlupLayout.height)/2);
//        coinIcon.setRegion(new Texture(Gdx.files.internal("coin_icon.png")));


        if (Integer.valueOf(currentHealth) >= Constants.HEART_HEALTH[Constants.HEART_HEALTH.length-1] ) {
            maxHealthReached = true;
        }else{
            maxHealthReached = false;
        }

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


        //sprite batch
        game.batch.begin();
            background.draw(game.batch);
            backButton.draw(game.batch);
            titleFont.draw(game.batch, titleText, MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, BACK_BUTTON_Y+shopGlupLayout.height*3/2);
            totalCoinsFont.draw(game.batch, totalCoinCountText, SCREEN_WIDTH-coinCountGlupLayout.width-currentCoinsIcon.getWidth()-SCREEN_WIDTH/40, BACK_BUTTON_Y+coinCountGlupLayout.height*2);
            currentCoinsIcon.draw(game.batch);
            heartIcon.draw(game.batch);
            if (!maxHealthReached) { // if upgrade still available
                plusIcon.draw(game.batch);
                coinIcon.draw(game.batch);
                buyFont.draw(game.batch, priceText, (SCREEN_WIDTH - priceTextGlupLayout.width) / 2, plusIcon.getY() - SCREEN_HEIGHT / 15);
            }
            healthFont.draw(game.batch, currentHealth, (SCREEN_WIDTH-currentHealthGlupLayout.width)/2, heartIcon.getY()+heartIcon.getHeight()-(heartIcon.getHeight()-currentHealthGlupLayout.height)/2);

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
        titleFont.dispose();
        totalCoinsFont.dispose();
        buyFont.dispose();
        healthFont.dispose();
        background.getTexture().dispose();
        backButton.getTexture().dispose();
        currentCoinsIcon.getTexture().dispose();
        heartIcon.getTexture().dispose();
        plusIcon.getTexture().dispose();
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
            game.playsound("audio/click.wav");
            game.setScreen(game.shopScreen);
        }

        //increase health
        if (plusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !maxHealthReached){

            //there is enough money to purchase
            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(priceText) ) {

                game.playsound("audio/buy_item.wav");
                //update coins
                currentCoins = currentCoins-Integer.valueOf(priceText);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                int current_health = game.prefs.getInteger("current_health", 100);

                //finding index
                int index = 0;
                for (int i = 0; i < Constants.HEART_HEALTH.length - 1; i++) {
                    if (Constants.HEART_HEALTH[i] == current_health)
                        index = i;
                }

                if (current_health == Constants.HEART_HEALTH[Constants.HEART_HEALTH.length - 2]) {
                    maxHealthReached = true;
                }

                //finding price
                int newPrice = Constants.HEART_PRICE[index + 1];

                currentHealth = String.valueOf(Constants.HEART_HEALTH[index + 1]);
                priceText = String.valueOf(newPrice);


                game.prefs.putInteger("current_health", Constants.HEART_HEALTH[index + 1]);
                game.prefs.flush();


            }else{
                game.playsound("audio/not_enough_coins.wav");
            }



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

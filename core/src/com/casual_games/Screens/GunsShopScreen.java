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
import com.casual_games.Additional.Constants;
import com.casual_games.FingerGun;
import static com.casual_games.Additional.Constants.*;

public class GunsShopScreen implements Screen, InputProcessor {

    private FingerGun game;
    private BitmapFont font, smallFont, xsFont, buyFont;
    private String titleText, currentGun;
    private Sprite coinIcon;
    private Sprite backButton,  bgRect1, bgRect2, bgRect3, currentCoinsIcon, background;
    private GlyphLayout shopGlupLayout, coinCountGlupLayout, shootingTimeoutGlupLayout, damageGlupLayout, buyGlupLayout;
    private String shootingTimeoutText, damageText, buyText;

    //put current gosterici strings here
    private String totalCoinCountText;

    //pistol stuff
    private  Sprite pistolIcon, pistolTimeoutPlusIcon, pistolDamagePlusIcon;
    private String currentPistolTimeout,currentPistolDamage;
    private GlyphLayout currentPistolTimeoutGlupLayout, currentPistolDamageGlupLayout;
        //price strings
    private String pistolTimeoutUpgradePrice, pistolDamageUpgradePrice;
    private GlyphLayout pistolTimeoutUpgradeGlyphLayout, pistolDamageUpgradeGlyphLayout;

    //sniper stuff
    private boolean isSniperPurchased;
    private Sprite sniperIcon, sniperTimeoutPlusIcon, sniperDamagePlusIcon, sniperLockIcon, sniperBuyPlusIcon;
    private String currentSniperTimeout,currentSniperDamage;
    private GlyphLayout currentSniperTimeoutGlupLayout, currentSniperDamageGlupLayout;
        //price strings
    private String sniperTimeoutUpgradePrice, sniperDamageUpgradePrice, sniperBuyPrice;
    private GlyphLayout sniperTimeoutUpgradeGlyphLayout, sniperDamageUpgradeGlyphLayout, sniperBuyPriceGlyphLayout;

    //minigun stuff
    private boolean isMinigunPurchased;
    private Sprite minigunIcon, minigunTimeoutPlusIcon, minigunDamagePlusIcon, minigunLockIcon, minigunBuyPlusIcon;
    private String currentMinigunTimeout,currentMinigunDamage;
    private GlyphLayout currentMinigunTimeoutGlupLayout, currentMinigunDamageGlupLayout;
        //price strings
    private String minigunTimeoutUpgradePrice, minigunDamageUpgradePrice, minigunBuyPrice;
    private GlyphLayout minigunTimeoutUpgradeGlyphLayout, minigunDamageUpgradeGlyphLayout, minigunBuyPriceGlyphLayout;

    private boolean maxPistolTimeoutReached, maxPistolDamageReached;
    private boolean maxSniperTimeoutReached, maxSniperDamageReached;
    private boolean maxMinigunTimeoutReached, maxMinigunDamageReached;

    public GunsShopScreen(FingerGun game) {
        this.game = game;

        //functionality stuff
        currentGun = game.prefs.getString("currentGun", "pistol");

        isSniperPurchased = game.prefs.getBoolean("isSniperPurchased", false);
        isMinigunPurchased = game.prefs.getBoolean("isMinigunPurchased", false);

        //PISTOL
        //pistol timeout
        int current_pistol_timeout = game.prefs.getInteger("current_pistol_timeout", 1000);

        //finding index
        int index_pistol_timeout = 0;
        for(int i = 0; i< Constants.PISTOL_SHOOTING_TIMEOUT_VALUES.length-1; i++){
            if(Constants.PISTOL_SHOOTING_TIMEOUT_VALUES[i]==current_pistol_timeout)
                index_pistol_timeout = i;
        }

        if (Integer.valueOf(current_pistol_timeout) <=
                Constants.PISTOL_SHOOTING_TIMEOUT_VALUES[Constants.PISTOL_SHOOTING_TIMEOUT_VALUES.length-1] ) {
            maxPistolTimeoutReached = true;
        }else{
            maxPistolTimeoutReached = false;
        }

        //pistol damage
        int current_pistol_damage = game.prefs.getInteger("current_pistol_damage", 3);

        //finding index
        int index_pistol_damage = 0;
        for(int i = 0; i< Constants.PISTOL_DAMAGE_VALUES.length-1; i++){
            if(Constants.PISTOL_DAMAGE_VALUES[i]==current_pistol_timeout)
                index_pistol_damage = i;
        }

        if (Integer.valueOf(current_pistol_timeout) <=
                Constants.PISTOL_DAMAGE_VALUES[Constants.PISTOL_DAMAGE_VALUES.length-1] ) {
            maxPistolDamageReached = true;
        }else{
            maxPistolDamageReached = false;
        }

        //SNIPER
        //sniper timeout
        int current_sniper_timeout = game.prefs.getInteger("current_sniper_timeout", 1200);

        //finding index
        int index_sniper_timeout = 0;
        for(int i = 0; i< Constants.SNIPER_SHOOTING_TIMEOUT_VALUES.length-1; i++){
            if(Constants.SNIPER_SHOOTING_TIMEOUT_VALUES[i]==current_sniper_timeout)
                index_sniper_timeout = i;
        }

        if (Integer.valueOf(current_sniper_timeout) <=
                Constants.SNIPER_SHOOTING_TIMEOUT_VALUES[Constants.SNIPER_SHOOTING_TIMEOUT_VALUES.length-1] ) {
            maxSniperTimeoutReached = true;
        }else{
            maxSniperTimeoutReached = false;
        }

        //sniper damage
        int current_sniper_damage = game.prefs.getInteger("current_sniper_damage", 3);

        //finding index
        int index_sniper_damage = 0;
        for(int i = 0; i< Constants.SNIPER_DAMAGE_VALUES.length-1; i++){
            if(Constants.SNIPER_DAMAGE_VALUES[i]==current_sniper_timeout)
                index_sniper_damage = i;
        }

        if (Integer.valueOf(current_sniper_timeout) <=
                Constants.SNIPER_DAMAGE_VALUES[Constants.SNIPER_DAMAGE_VALUES.length-1] ) {
            maxSniperDamageReached = true;
        }else{
            maxSniperDamageReached = false;
        }

        //MINIGUN
        //minigun timeout
        int current_minigun_timeout = game.prefs.getInteger("current_minigun_timeout", 1200);

        //finding index
        int index_minigun_timeout = 0;
        for(int i = 0; i< Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES.length-1; i++){
            if(Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES[i]==current_minigun_timeout)
                index_minigun_timeout = i;
        }

        if (Integer.valueOf(current_minigun_timeout) <=
                Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES[Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES.length-1] ) {
            maxMinigunTimeoutReached = true;
        }else{
            maxMinigunTimeoutReached = false;
        }

        //minigun damage
        int current_minigun_damage = game.prefs.getInteger("current_minigun_damage", 3);

        //finding index
        int index_minigun_damage = 0;
        for(int i = 0; i< Constants.MINIGUN_DAMAGE_VALUES.length-1; i++){
            if(Constants.MINIGUN_DAMAGE_VALUES[i]==current_minigun_timeout)
                index_minigun_damage = i;
        }

        if (Integer.valueOf(current_minigun_timeout) <=
                Constants.MINIGUN_DAMAGE_VALUES[Constants.MINIGUN_DAMAGE_VALUES.length-1] ) {
            maxMinigunDamageReached = true;
        }else{
            maxMinigunDamageReached = false;
        }


        //----------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------
        background = new Sprite(game.assets.manager.get("background.png", Texture.class));
        background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        background.setPosition(0, 0);

        backButton = new Sprite(game.assets.manager.get("back_button.png", Texture.class));
        pistolTimeoutPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        sniperTimeoutPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        minigunTimeoutPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        pistolDamagePlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        sniperDamagePlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        minigunDamagePlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        sniperLockIcon = new Sprite(game.assets.manager.get("lock_icon.png", Texture.class));
        minigunLockIcon = new Sprite(game.assets.manager.get("lock_icon.png", Texture.class));
        sniperBuyPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        minigunBuyPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        bgRect1 = new Sprite(game.assets.manager.get("orange.png", Texture.class));
        bgRect2 = new Sprite(game.assets.manager.get("orange.png", Texture.class));
        bgRect3 = new Sprite(game.assets.manager.get("orange.png", Texture.class));
        pistolIcon = new Sprite(game.assets.manager.get("pistol_icon.png", Texture.class));
        sniperIcon = new Sprite(game.assets.manager.get("sniper_icon.png", Texture.class));
        minigunIcon = new Sprite(game.assets.manager.get("minigun_icon.png", Texture.class));
        currentCoinsIcon = new Sprite(game.assets.manager.get("coins_collective.png", Texture.class));
        coinIcon = new Sprite(game.assets.manager.get("coin_icon.png", Texture.class));

        font = game.createBitmapFont((int) SCREEN_WIDTH / 15);
        Color smallFontColor = new Color();
        smallFontColor.set(247f/255, 239f/255, 202f/255, 1f);
        smallFont = game.createBitmapFont((int) SCREEN_WIDTH / 25, smallFontColor);
        xsFont = game.createBitmapFont((int) SCREEN_WIDTH / 30, smallFontColor);
        buyFont = game.createBitmapFont((int) SCREEN_WIDTH / 15, smallFontColor);

        titleText = "Guns Shop";
        shopGlupLayout = new GlyphLayout();
        shopGlupLayout.setText(font, titleText);
        //--
        buyText = "Buy";
        buyGlupLayout = new GlyphLayout();
        buyGlupLayout.setText(buyFont, buyText);
        //--
        coinCountGlupLayout = new GlyphLayout();
        //--
        shootingTimeoutText = "Shooting \nTimeout: ";
        shootingTimeoutGlupLayout = new GlyphLayout();
        shootingTimeoutGlupLayout.setText(xsFont, shootingTimeoutText);
        //--
        currentPistolTimeout = String.valueOf(current_pistol_timeout);
        currentPistolTimeoutGlupLayout = new GlyphLayout();
        currentPistolTimeoutGlupLayout.setText(smallFont, currentPistolTimeout);
        //--
        currentSniperTimeout = String.valueOf(current_sniper_timeout);
        currentSniperTimeoutGlupLayout = new GlyphLayout();
        currentSniperTimeoutGlupLayout.setText(smallFont, currentSniperTimeout);
        //--
        currentMinigunTimeout = String.valueOf(current_minigun_timeout);
        currentMinigunTimeoutGlupLayout = new GlyphLayout();
        currentMinigunTimeoutGlupLayout.setText(smallFont, currentMinigunTimeout);
        //--
        pistolTimeoutUpgradePrice = String.valueOf(Constants.PISTOL_SHOOTING_TIMEOUT_PRICES[index_pistol_timeout]);
        pistolTimeoutUpgradeGlyphLayout = new GlyphLayout();
        pistolTimeoutUpgradeGlyphLayout.setText(smallFont, pistolTimeoutUpgradePrice);
        //--
        sniperTimeoutUpgradePrice = String.valueOf(Constants.SNIPER_SHOOTING_TIMEOUT_PRICES[index_sniper_timeout]);
        sniperTimeoutUpgradeGlyphLayout = new GlyphLayout();
        sniperTimeoutUpgradeGlyphLayout.setText(smallFont, sniperTimeoutUpgradePrice);
        //--
        minigunTimeoutUpgradePrice = String.valueOf(Constants.MINIGUN_SHOOTING_TIMEOUT_PRICES[index_minigun_timeout]);
        minigunTimeoutUpgradeGlyphLayout = new GlyphLayout();
        minigunTimeoutUpgradeGlyphLayout.setText(smallFont, minigunTimeoutUpgradePrice);
        //--
        damageText = "Damage: ";
        damageGlupLayout = new GlyphLayout();
        damageGlupLayout.setText(xsFont, damageText);
        //--
        currentPistolDamage = String.valueOf(current_pistol_damage);
        currentPistolDamageGlupLayout = new GlyphLayout();
        currentPistolDamageGlupLayout.setText(smallFont, currentPistolDamage);
        //--
        currentSniperDamage = String.valueOf(current_sniper_damage);
        currentSniperDamageGlupLayout = new GlyphLayout();
        currentSniperDamageGlupLayout.setText(smallFont, currentSniperDamage);
        //--
        currentMinigunDamage = String.valueOf(current_minigun_damage);
        currentMinigunDamageGlupLayout = new GlyphLayout();
        currentMinigunDamageGlupLayout.setText(smallFont, currentMinigunDamage);
        //--
        pistolDamageUpgradePrice = String.valueOf(Constants.PISTOL_DAMAGE_PRICES[index_pistol_damage]);
        pistolDamageUpgradeGlyphLayout = new GlyphLayout();
        pistolDamageUpgradeGlyphLayout.setText(smallFont, pistolDamageUpgradePrice);
        //--
        sniperDamageUpgradePrice = String.valueOf(Constants.SNIPER_DAMAGE_PRICES[index_sniper_damage]);
        sniperDamageUpgradeGlyphLayout = new GlyphLayout();
        sniperDamageUpgradeGlyphLayout.setText(smallFont, sniperDamageUpgradePrice);
        //--
        minigunDamageUpgradePrice = String.valueOf(Constants.MINIGUN_DAMAGE_PRICES[index_minigun_damage]);
        minigunDamageUpgradeGlyphLayout = new GlyphLayout();
        minigunDamageUpgradeGlyphLayout.setText(smallFont, minigunDamageUpgradePrice);
        //--
        sniperBuyPrice = "1000";
        sniperBuyPriceGlyphLayout = new GlyphLayout();
        sniperBuyPriceGlyphLayout.setText(smallFont, sniperBuyPrice);
        //--
        minigunBuyPrice = "2000";
        minigunBuyPriceGlyphLayout = new GlyphLayout();
        minigunBuyPriceGlyphLayout.setText(smallFont, minigunBuyPrice);



        //sizes
        backButton.setSize(BACK_BUTTON_WIDTH, BACK_BUTTON_WIDTH);
        pistolTimeoutPlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
        sniperTimeoutPlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
        minigunTimeoutPlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
        pistolDamagePlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
        sniperDamagePlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
        minigunDamagePlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
        sniperLockIcon.setSize(LOCK_ICON_WIDTH, LOCK_ICON_HEIGHT);
        minigunLockIcon.setSize(LOCK_ICON_WIDTH, LOCK_ICON_HEIGHT);
        sniperBuyPlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
        minigunBuyPlusIcon.setSize(PLUS_ICON_WIDTH, PLUS_ICON_WIDTH);
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
//        pistolPlusIcon.setPosition(SCREEN_WIDTH*0.65f, bgRect1.getY()+bgRect1.getHeight()-pistolPlusIcon.getHeight()*1.7f);
        pistolTimeoutPlusIcon.setPosition(bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width+currentPistolTimeoutGlupLayout.width+SCREEN_WIDTH/10, bgRect1.getY()+bgRect1.getHeight()-pistolTimeoutPlusIcon.getHeight()*1.7f);
        sniperTimeoutPlusIcon.setPosition(bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width+currentSniperTimeoutGlupLayout.width+SCREEN_WIDTH/10, bgRect2.getY()+bgRect2.getHeight()-sniperTimeoutPlusIcon.getHeight()*1.7f);
        minigunTimeoutPlusIcon.setPosition(bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width+currentMinigunTimeoutGlupLayout.width+SCREEN_WIDTH/10, bgRect3.getY()+bgRect3.getHeight()-minigunTimeoutPlusIcon.getHeight()*1.7f);
        pistolDamagePlusIcon.setPosition(bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width+currentPistolTimeoutGlupLayout.width+SCREEN_WIDTH/10, bgRect1.getY()+bgRect1.getHeight()-pistolTimeoutPlusIcon.getHeight()*3.3f);
        sniperDamagePlusIcon.setPosition(bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width+currentSniperTimeoutGlupLayout.width+SCREEN_WIDTH/10, bgRect2.getY()+bgRect2.getHeight()-sniperTimeoutPlusIcon.getHeight()*3.3f);
        minigunDamagePlusIcon.setPosition(bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width+currentMinigunTimeoutGlupLayout.width+SCREEN_WIDTH/10, bgRect3.getY()+bgRect3.getHeight()-minigunTimeoutPlusIcon.getHeight()*3.3f);
        sniperLockIcon.setPosition(bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/30, bgRect2.getY()+bgRect2.getHeight()-sniperLockIcon.getHeight()*1.5f);
        minigunLockIcon.setPosition(bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/30, bgRect3.getY()+bgRect3.getHeight()-minigunLockIcon.getHeight()*1.5f);
        sniperBuyPlusIcon.setPosition(sniperLockIcon.getX()+sniperLockIcon.getWidth()+buyGlupLayout.width+SCREEN_WIDTH/15, sniperLockIcon.getY()+sniperBuyPlusIcon.getHeight()*0.2f);
        minigunBuyPlusIcon.setPosition(minigunLockIcon.getX()+minigunLockIcon.getWidth()+buyGlupLayout.width+SCREEN_WIDTH/15, minigunLockIcon.getY()+minigunBuyPlusIcon.getHeight()*0.2f);
        pistolIcon.setPosition(bgRect1.getX() + (bgRect1.getWidth() - pistolIcon.getWidth()) / 2, bgRect1.getY() + (bgRect1.getHeight() - pistolIcon.getHeight()) / 2);
        sniperIcon.setPosition(bgRect2.getX() + (bgRect2.getWidth() - sniperIcon.getWidth()) / 2, bgRect2.getY() + (bgRect2.getHeight() - sniperIcon.getHeight()) / 2);
        minigunIcon.setPosition(bgRect3.getX() + (bgRect3.getWidth() - minigunIcon.getWidth()) / 2, bgRect3.getY() + (bgRect3.getHeight() - minigunIcon.getHeight()) / 2);
        currentCoinsIcon.setPosition(SCREEN_WIDTH-SCREEN_WIDTH/50-currentCoinsIcon.getWidth(), BACK_BUTTON_Y+coinCountGlupLayout.height/2);


    }


    @Override
    public void show() {

        game.prefs.putInteger("coinCoint", 30000);
        game.prefs.flush();
        //delete above

        totalCoinCountText = String.valueOf(game.prefs.getInteger("coinCoint", 0));
        coinCountGlupLayout.setText(smallFont, totalCoinCountText);


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
            background.draw(game.batch);
        game.batch.end();

        //shaperenderer
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            Gdx.gl.glEnable(GL20.GL_BLEND); //for transparency
            game.shapeRenderer.setColor(37f/255, 119f/255, 178f/255, 0.7f);

        if (currentGun.equals("pistol")){
            game.shapeRenderer.rect(0, bgRect1.getY()-SCREEN_HEIGHT/100, SCREEN_WIDTH, bgRect1.getHeight()+SCREEN_HEIGHT/50);
        }else if (currentGun.equals("sniper")){
            game.shapeRenderer.rect(0, bgRect2.getY()-SCREEN_HEIGHT/100, SCREEN_WIDTH, bgRect2.getHeight()+SCREEN_HEIGHT/50);
        }else if (currentGun.equals("minigun")){
            game.shapeRenderer.rect(0, bgRect3.getY()-SCREEN_HEIGHT/100, SCREEN_WIDTH, bgRect3.getHeight()+SCREEN_HEIGHT/50);
        }


//            game.shapeRenderer.rect(0, bgRect1.getY()-SCREEN_HEIGHT/100, SCREEN_WIDTH, bgRect1.getHeight()+SCREEN_HEIGHT/50);
        game.shapeRenderer.end();


        //sprite batch
        game.batch.begin();

        backButton.draw(game.batch);
        font.draw(game.batch, titleText, MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, BACK_BUTTON_Y+shopGlupLayout.height*3/2);
        smallFont.draw(game.batch, totalCoinCountText, SCREEN_WIDTH-coinCountGlupLayout.width-currentCoinsIcon.getWidth()-SCREEN_WIDTH/40, BACK_BUTTON_Y+coinCountGlupLayout.height*2);
        xsFont.draw(game.batch, shootingTimeoutText, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/40, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height*0.5f);

        smallFont.draw(game.batch, currentPistolTimeout, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height);

        if (!maxPistolTimeoutReached)
            smallFont.draw(game.batch, pistolTimeoutUpgradePrice, pistolTimeoutPlusIcon.getX()+pistolTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height);

        smallFont.draw(game.batch, damageText, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/40, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);

        smallFont.draw(game.batch, currentPistolDamage, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/15+damageGlupLayout.width, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);

        if (!maxPistolDamageReached)
        smallFont.draw(game.batch, pistolDamageUpgradePrice, pistolTimeoutPlusIcon.getX()+pistolTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40,pistolDamagePlusIcon.getY()+pistolDamageUpgradeGlyphLayout.height*1.2f);

        bgRect1.draw(game.batch);
        bgRect2.draw(game.batch);
        bgRect3.draw(game.batch);

        if (!maxPistolTimeoutReached)
            pistolTimeoutPlusIcon.draw(game.batch);

        if (!maxPistolDamageReached)
        pistolDamagePlusIcon.draw(game.batch);

        pistolIcon.draw(game.batch);
        sniperIcon.draw(game.batch);
        minigunIcon.draw(game.batch);
        currentCoinsIcon.draw(game.batch);

        //pistol timeout coin
        if (!maxPistolTimeoutReached) {
            game.batch.draw(coinIcon.getTexture(), pistolTimeoutPlusIcon.getX() + pistolTimeoutPlusIcon.getWidth() + SCREEN_WIDTH / 20 + pistolTimeoutUpgradeGlyphLayout.width,
                    bgRect1.getY() + bgRect1.getHeight() - shootingTimeoutGlupLayout.height - pistolTimeoutUpgradeGlyphLayout.height * 1.3f,
                    coinIcon.getWidth(), coinIcon.getHeight());
        }

        //pistol damage coin
        if (!maxPistolDamageReached) {
            game.batch.draw(coinIcon.getTexture(), pistolDamagePlusIcon.getX() + pistolDamagePlusIcon.getWidth() + SCREEN_WIDTH / 20 + pistolDamageUpgradeGlyphLayout.width,
                    pistolDamagePlusIcon.getY(),
                    coinIcon.getWidth(), coinIcon.getHeight());
        }



        //sniper stuff
        if (isSniperPurchased){
            xsFont.draw(game.batch, shootingTimeoutText, bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/40, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height*0.5f);
            smallFont.draw(game.batch, damageText, bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/40, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);

            smallFont.draw(game.batch, currentSniperTimeout, bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height);
            if(!maxSniperTimeoutReached)
                smallFont.draw(game.batch, sniperTimeoutUpgradePrice, sniperTimeoutPlusIcon.getX()+sniperTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height);
            smallFont.draw(game.batch, currentSniperDamage, bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/15+damageGlupLayout.width, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);
            if(!maxSniperDamageReached)
                smallFont.draw(game.batch, sniperDamageUpgradePrice, sniperTimeoutPlusIcon.getX()+sniperTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40,sniperDamagePlusIcon.getY()+sniperDamageUpgradeGlyphLayout.height*1.2f);

            if(!maxSniperTimeoutReached)
                sniperTimeoutPlusIcon.draw(game.batch);
            if(!maxSniperDamageReached)
                sniperDamagePlusIcon.draw(game.batch);

            //sniper timeout coin
            if(!maxSniperTimeoutReached) {
                game.batch.draw(coinIcon.getTexture(), sniperTimeoutPlusIcon.getX() + sniperTimeoutPlusIcon.getWidth() + SCREEN_WIDTH / 20 + sniperTimeoutUpgradeGlyphLayout.width,
                        bgRect2.getY() + bgRect2.getHeight() - shootingTimeoutGlupLayout.height - sniperTimeoutUpgradeGlyphLayout.height * 1.3f,
                        coinIcon.getWidth(), coinIcon.getHeight());
            }

            //sniper damage coin
            if(!maxSniperDamageReached) {
                game.batch.draw(coinIcon.getTexture(), sniperDamagePlusIcon.getX() + sniperDamagePlusIcon.getWidth() + SCREEN_WIDTH / 20 + sniperDamageUpgradeGlyphLayout.width,
                        sniperDamagePlusIcon.getY(),
                        coinIcon.getWidth(), coinIcon.getHeight());
            }
        }else{
            sniperLockIcon.draw(game.batch);
            buyFont.draw(game.batch, buyText,sniperLockIcon.getX()+sniperLockIcon.getWidth()+SCREEN_WIDTH/50, sniperLockIcon.getY()+buyGlupLayout.height*1.5f);
            sniperBuyPlusIcon.draw(game.batch);
            smallFont.draw(game.batch, sniperBuyPrice, sniperBuyPlusIcon.getX()+sniperBuyPlusIcon.getWidth()+SCREEN_WIDTH/30, sniperBuyPlusIcon.getY()+sniperBuyPriceGlyphLayout.height);
            game.batch.draw(coinIcon.getTexture(), sniperBuyPlusIcon.getX()+sniperBuyPlusIcon.getWidth()+sniperBuyPriceGlyphLayout.width+SCREEN_WIDTH/15,
                    sniperBuyPlusIcon.getY(),
                    coinIcon.getWidth(), coinIcon.getHeight());
        }

        //minigun stuff
        if (isMinigunPurchased){
            xsFont.draw(game.batch, shootingTimeoutText, bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/40, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height*0.5f);
            smallFont.draw(game.batch, damageText, bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/40, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);

            smallFont.draw(game.batch, currentMinigunTimeout, bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height);
            if(!maxMinigunTimeoutReached)
                smallFont.draw(game.batch, minigunTimeoutUpgradePrice, minigunTimeoutPlusIcon.getX()+minigunTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height);
            smallFont.draw(game.batch, currentMinigunDamage, bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/15+damageGlupLayout.width, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);
            if(!maxMinigunDamageReached)
                smallFont.draw(game.batch, minigunDamageUpgradePrice, minigunTimeoutPlusIcon.getX()+minigunTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40,minigunDamagePlusIcon.getY()+minigunDamageUpgradeGlyphLayout.height*1.2f);

            if(!maxMinigunTimeoutReached)
                minigunTimeoutPlusIcon.draw(game.batch);
            if(!maxMinigunDamageReached)
            minigunDamagePlusIcon.draw(game.batch);

            //minigun timeout coin
            if(!maxMinigunTimeoutReached) {
                game.batch.draw(coinIcon.getTexture(), minigunTimeoutPlusIcon.getX() + minigunTimeoutPlusIcon.getWidth() + SCREEN_WIDTH / 20 + minigunTimeoutUpgradeGlyphLayout.width,
                        bgRect3.getY() + bgRect3.getHeight() - shootingTimeoutGlupLayout.height - minigunTimeoutUpgradeGlyphLayout.height * 1.3f,
                        coinIcon.getWidth(), coinIcon.getHeight());
            }

            //minigun damage coin
            if(!maxMinigunDamageReached) {
                game.batch.draw(coinIcon.getTexture(), minigunDamagePlusIcon.getX() + minigunDamagePlusIcon.getWidth() + SCREEN_WIDTH / 20 + minigunDamageUpgradeGlyphLayout.width,
                        minigunDamagePlusIcon.getY(),
                        coinIcon.getWidth(), coinIcon.getHeight());
            }
        }else{
            minigunLockIcon.draw(game.batch);
            buyFont.draw(game.batch, buyText,minigunLockIcon.getX()+minigunLockIcon.getWidth()+SCREEN_WIDTH/50, minigunLockIcon.getY()+buyGlupLayout.height*1.5f);
            minigunBuyPlusIcon.draw(game.batch);
            smallFont.draw(game.batch, minigunBuyPrice, minigunBuyPlusIcon.getX()+minigunBuyPlusIcon.getWidth()+SCREEN_WIDTH/30, minigunBuyPlusIcon.getY()+minigunBuyPriceGlyphLayout.height);
            game.batch.draw(coinIcon.getTexture(), minigunBuyPlusIcon.getX()+minigunBuyPlusIcon.getWidth()+minigunBuyPriceGlyphLayout.width+SCREEN_WIDTH/15,
                    minigunBuyPlusIcon.getY(),
                    coinIcon.getWidth(), coinIcon.getHeight());
        }

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
        game.shapeRenderer.dispose();
        game.batch.dispose();
        game.arc.dispose();

        font.dispose();
        xsFont.dispose();
        buyFont.dispose();
        smallFont.dispose();
        background.getTexture().dispose();
        backButton.getTexture().dispose();
        bgRect1.getTexture().dispose();
        bgRect2.getTexture().dispose();
        bgRect3.getTexture().dispose();
        pistolTimeoutPlusIcon.getTexture().dispose();
        sniperTimeoutPlusIcon.getTexture().dispose();
        minigunTimeoutPlusIcon.getTexture().dispose();
        pistolDamagePlusIcon.getTexture().dispose();
        sniperDamagePlusIcon.getTexture().dispose();
        minigunDamagePlusIcon.getTexture().dispose();
        sniperLockIcon.getTexture().dispose();
        minigunLockIcon.getTexture().dispose();
        sniperBuyPlusIcon.getTexture().dispose();
        minigunBuyPlusIcon.getTexture().dispose();
        pistolIcon.getTexture().dispose();
        sniperIcon.getTexture().dispose();
        minigunIcon.getTexture().dispose();
        currentCoinsIcon.getTexture().dispose();
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

        //buy sniper
        if (sniperBuyPlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !isSniperPurchased ){

            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(sniperBuyPrice) ) {

                game.playsound("audio/click.wav");
                //update coins
                currentCoins = currentCoins - Integer.valueOf(sniperBuyPrice);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                isSniperPurchased = true;
                game.prefs.putString("currentGun", "sniper");
                currentGun = "sniper";

                game.prefs.putBoolean("isSniperPurchased", true);
                game.prefs.flush();
            }else{
                game.playsound("audio/not_enough_coins.wav");
            }
        }

        //buy minigun
        if (minigunBuyPlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !isMinigunPurchased ){

            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(minigunBuyPrice) ) {

                game.playsound("audio/click.wav");
                //update coins
                currentCoins = currentCoins - Integer.valueOf(minigunBuyPrice);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                isMinigunPurchased = true;
                game.prefs.putString("currentGun", "minigun");
                currentGun = "minigun";

                game.prefs.putBoolean("isMinigunPurchased", true);
                game.prefs.flush();
            }else{
                game.playsound("audio/not_enough_coins.wav");
            }
        }

        //increase pistol shooting timeout
        if (pistolTimeoutPlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !maxPistolTimeoutReached){

            //there is enough money to purchase
            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(pistolTimeoutUpgradePrice) ) {

                game.playsound("audio/click.wav");
                //update coins
                currentCoins = currentCoins-Integer.valueOf(pistolTimeoutUpgradePrice);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                int current_pistol_timeout = game.prefs.getInteger("current_pistol_timeout", 1000);

                //finding index
                int index_pistol_timeout = 0;
                for(int i = 0; i< Constants.PISTOL_SHOOTING_TIMEOUT_VALUES.length-1; i++){
                    if(Constants.PISTOL_SHOOTING_TIMEOUT_VALUES[i]==current_pistol_timeout)
                        index_pistol_timeout = i;
                }

                if (current_pistol_timeout == Constants.PISTOL_SHOOTING_TIMEOUT_VALUES[Constants.PISTOL_SHOOTING_TIMEOUT_VALUES.length - 2]) {
                    maxPistolTimeoutReached = true;
                }

                //finding price
                int newPrice = Constants.PISTOL_SHOOTING_TIMEOUT_PRICES[index_pistol_timeout + 1];

                currentPistolTimeout= String.valueOf(Constants.PISTOL_SHOOTING_TIMEOUT_VALUES[index_pistol_timeout + 1]);
                pistolTimeoutUpgradePrice = String.valueOf(newPrice);


                game.prefs.putInteger("current_pistol_timeout", Constants.PISTOL_SHOOTING_TIMEOUT_VALUES[index_pistol_timeout + 1]);
                game.prefs.flush();


            }else{
                game.playsound("audio/not_enough_coins.wav");
            }
        }


        //increase pistol damage
        if (pistolDamagePlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !maxPistolDamageReached){

            //there is enough money to purchase
            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(pistolDamageUpgradePrice) ) {

                game.playsound("audio/click.wav");
                //update coins
                currentCoins = currentCoins-Integer.valueOf(pistolDamageUpgradePrice);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                int current_pistol_damage = game.prefs.getInteger("current_pistol_damage", 3);

                //finding index
                int index_pistol_damage = 0;
                for(int i = 0; i< Constants.PISTOL_DAMAGE_VALUES.length-1; i++){
                    if(Constants.PISTOL_DAMAGE_VALUES[i]==current_pistol_damage)
                        index_pistol_damage = i;
                }

                if (current_pistol_damage == Constants.PISTOL_DAMAGE_VALUES[Constants.PISTOL_DAMAGE_VALUES.length - 2]) {
                    maxPistolDamageReached = true;
                }

                //finding price
                int newPrice = Constants.PISTOL_DAMAGE_PRICES[index_pistol_damage + 1];

                currentPistolDamage = String.valueOf(Constants.PISTOL_DAMAGE_VALUES[index_pistol_damage + 1]);
                pistolDamageUpgradePrice = String.valueOf(newPrice);


                game.prefs.putInteger("current_pistol_damage", Constants.PISTOL_DAMAGE_VALUES[index_pistol_damage + 1]);
                game.prefs.flush();


            }else{
                game.playsound("audio/not_enough_coins.wav");
            }
        }


        //increase sniper shooting timeout
        if (sniperTimeoutPlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !maxSniperTimeoutReached){

            //there is enough money to purchase
            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(sniperTimeoutUpgradePrice) ) {

                game.playsound("audio/click.wav");
                //update coins
                currentCoins = currentCoins-Integer.valueOf(sniperTimeoutUpgradePrice);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                int current_sniper_timeout = game.prefs.getInteger("current_sniper_timeout", 1000);

                //finding index
                int index_sniper_timeout = 0;
                for(int i = 0; i< Constants.SNIPER_SHOOTING_TIMEOUT_VALUES.length-1; i++){
                    if(Constants.SNIPER_SHOOTING_TIMEOUT_VALUES[i]==current_sniper_timeout)
                        index_sniper_timeout = i;
                }

                if (current_sniper_timeout == Constants.SNIPER_SHOOTING_TIMEOUT_VALUES[Constants.SNIPER_SHOOTING_TIMEOUT_VALUES.length - 2]) {
                    maxSniperTimeoutReached = true;
                }

                //finding price
                int newPrice = Constants.SNIPER_SHOOTING_TIMEOUT_PRICES[index_sniper_timeout + 1];

                currentSniperTimeout= String.valueOf(Constants.SNIPER_SHOOTING_TIMEOUT_VALUES[index_sniper_timeout + 1]);
                sniperTimeoutUpgradePrice = String.valueOf(newPrice);


                game.prefs.putInteger("current_sniper_timeout", Constants.SNIPER_SHOOTING_TIMEOUT_VALUES[index_sniper_timeout + 1]);
                game.prefs.flush();


            }else{
                game.playsound("audio/not_enough_coins.wav");
            }
        }


        //increase sniper damage
        if (sniperDamagePlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !maxSniperDamageReached){

            //there is enough money to purchase
            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(sniperDamageUpgradePrice) ) {

                game.playsound("audio/click.wav");
                //update coins
                currentCoins = currentCoins-Integer.valueOf(sniperDamageUpgradePrice);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                int current_sniper_damage = game.prefs.getInteger("current_sniper_damage", 3);

                //finding index
                int index_sniper_damage = 0;
                for(int i = 0; i< Constants.SNIPER_DAMAGE_VALUES.length-1; i++){
                    if(Constants.SNIPER_DAMAGE_VALUES[i]==current_sniper_damage)
                        index_sniper_damage = i;
                }

                if (current_sniper_damage == Constants.SNIPER_DAMAGE_VALUES[Constants.SNIPER_DAMAGE_VALUES.length - 2]) {
                    maxSniperDamageReached = true;
                }

                //finding price
                int newPrice = Constants.SNIPER_DAMAGE_PRICES[index_sniper_damage + 1];

                currentSniperDamage = String.valueOf(Constants.SNIPER_DAMAGE_VALUES[index_sniper_damage + 1]);
                sniperDamageUpgradePrice = String.valueOf(newPrice);


                game.prefs.putInteger("current_sniper_damage", Constants.SNIPER_DAMAGE_VALUES[index_sniper_damage + 1]);
                game.prefs.flush();


            }else{
                game.playsound("audio/not_enough_coins.wav");
            }
        }

        //increase minigun shooting timeout
        if (minigunTimeoutPlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !maxMinigunTimeoutReached){

            //there is enough money to purchase
            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(minigunTimeoutUpgradePrice) ) {

                game.playsound("audio/click.wav");
                //update coins
                currentCoins = currentCoins-Integer.valueOf(minigunTimeoutUpgradePrice);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                int current_minigun_timeout = game.prefs.getInteger("current_minigun_timeout", 200);

                //finding index
                int index_minigun_timeout = 0;
                for(int i = 0; i< Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES.length-1; i++){
                    if(Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES[i]==current_minigun_timeout)
                        index_minigun_timeout = i;
                }

                if (current_minigun_timeout == Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES[Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES.length - 2]) {
                    maxMinigunTimeoutReached = true;
                }

                //finding price
                int newPrice = Constants.MINIGUN_SHOOTING_TIMEOUT_PRICES[index_minigun_timeout + 1];

                currentMinigunTimeout= String.valueOf(Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES[index_minigun_timeout + 1]);
                minigunTimeoutUpgradePrice = String.valueOf(newPrice);


                game.prefs.putInteger("current_minigun_timeout", Constants.MINIGUN_SHOOTING_TIMEOUT_VALUES[index_minigun_timeout + 1]);
                game.prefs.flush();


            }else{
                game.playsound("audio/not_enough_coins.wav");
            }
        }


        //increase minigun damage
        if (minigunDamagePlusIcon.getBoundingRectangle().contains(screenX, SCREEN_HEIGHT-screenY) && !maxMinigunDamageReached){

            //there is enough money to purchase
            int currentCoins = game.prefs.getInteger("coinCoint", 0);
            if ( currentCoins >= Integer.valueOf(minigunDamageUpgradePrice) ) {

                game.playsound("audio/click.wav");
                //update coins
                currentCoins = currentCoins-Integer.valueOf(minigunDamageUpgradePrice);
                game.prefs.putInteger("coinCoint", currentCoins);
                totalCoinCountText = String.valueOf(currentCoins);

                int current_minigun_damage = game.prefs.getInteger("current_minigun_damage", 3);

                //finding index
                int index_minigun_damage = 0;
                for(int i = 0; i< Constants.MINIGUN_DAMAGE_VALUES.length-1; i++){
                    if(Constants.MINIGUN_DAMAGE_VALUES[i]==current_minigun_damage)
                        index_minigun_damage = i;
                }

                if (current_minigun_damage == Constants.MINIGUN_DAMAGE_VALUES[Constants.MINIGUN_DAMAGE_VALUES.length - 2]) {
                    maxMinigunDamageReached = true;
                }

                //finding price
                int newPrice = Constants.MINIGUN_DAMAGE_PRICES[index_minigun_damage + 1];

                currentMinigunDamage = String.valueOf(Constants.MINIGUN_DAMAGE_VALUES[index_minigun_damage + 1]);
                minigunDamageUpgradePrice = String.valueOf(newPrice);


                game.prefs.putInteger("current_minigun_damage", Constants.MINIGUN_DAMAGE_VALUES[index_minigun_damage + 1]);
                game.prefs.flush();


            }else{
                game.playsound("audio/not_enough_coins.wav");
            }
        }



        //choose gun to use
        if ((SCREEN_HEIGHT-screenY) >= pistolIcon.getY()
                && (SCREEN_HEIGHT-screenY) <= pistolIcon.getY() + pistolIcon.getWidth()
                 ){
            currentGun = "pistol";
            game.prefs.putString("currentGun", "pistol");
            game.prefs.flush();
            game.playsound("audio/click.wav");
        }else if ((SCREEN_HEIGHT-screenY) >= sniperIcon.getY()
                && (SCREEN_HEIGHT-screenY) <= sniperIcon.getY() + sniperIcon.getWidth()
                && isSniperPurchased ){
            currentGun = "sniper";
            game.prefs.putString("currentGun", "sniper");
            game.prefs.flush();
            game.playsound("audio/click.wav");
        }else if ((SCREEN_HEIGHT-screenY) >= minigunIcon.getY()
                && (SCREEN_HEIGHT-screenY) <= minigunIcon.getY() + minigunIcon.getWidth()
                && isMinigunPurchased ){
            currentGun = "minigun";
            game.prefs.putString("currentGun", "minigun");
            game.prefs.flush();
            game.playsound("audio/click.wav");
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

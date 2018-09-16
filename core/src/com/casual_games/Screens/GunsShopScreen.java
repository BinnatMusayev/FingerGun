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

public class GunsShopScreen implements Screen, InputProcessor {

    private FingerGun game;
    private BitmapFont font, smallFont, xsFont, buyFont;
    private String titleText;
    private Sprite coinIcon;
    private Sprite backButton,  bgRect1, bgRect2, bgRect3, currentCoinsIcon;
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
    private boolean sniperPurchased;
    private Sprite sniperIcon, sniperTimeoutPlusIcon, sniperDamagePlusIcon, sniperLockIcon, sniperBuyPlusIcon;
    private String currentSniperTimeout,currentSniperDamage;
    private GlyphLayout currentSniperTimeoutGlupLayout, currentSniperDamageGlupLayout;
        //price strings
    private String sniperTimeoutUpgradePrice, sniperDamageUpgradePrice, sniperBuyPrice;
    private GlyphLayout sniperTimeoutUpgradeGlyphLayout, sniperDamageUpgradeGlyphLayout, sniperBuyPriceGlyphLayout;

    //minigun stuff
    private boolean minigunPurchased;
    private Sprite minigunIcon, minigunTimeoutPlusIcon, minigunDamagePlusIcon, minigunLockIcon, minigunBuyPlusIcon;
    private String currentMinigunTimeout,currentMinigunDamage;
    private GlyphLayout currentMinigunTimeoutGlupLayout, currentMinigunDamageGlupLayout;
        //price strings
    private String minigunTimeoutUpgradePrice, minigunDamageUpgradePrice, minigunBuyPrice;
    private GlyphLayout minigunTimeoutUpgradeGlyphLayout, minigunDamageUpgradeGlyphLayout, minigunBuyPriceGlyphLayout;


    public GunsShopScreen(FingerGun game) {
        this.game = game;

        backButton = new Sprite(game.assets.manager.get("back_button.png", Texture.class));
        pistolTimeoutPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        sniperTimeoutPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        minigunTimeoutPlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        pistolDamagePlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        sniperDamagePlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        minigunDamagePlusIcon = new Sprite(game.assets.manager.get("+_icon.png", Texture.class));
        sniperLockIcon = new Sprite(game.assets.manager.get("lock_icon2.png", Texture.class));
        minigunLockIcon = new Sprite(game.assets.manager.get("lock_icon2.png", Texture.class));
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

        sniperPurchased = false;
        minigunPurchased = false;


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
        totalCoinCountText = "24531";
        coinCountGlupLayout = new GlyphLayout();
        coinCountGlupLayout.setText(smallFont, totalCoinCountText);
        //--
        shootingTimeoutText = "Shooting \nTimeout: ";
        shootingTimeoutGlupLayout = new GlyphLayout();
        shootingTimeoutGlupLayout.setText(xsFont, shootingTimeoutText);
        //--
        currentPistolTimeout = "3500";
        currentPistolTimeoutGlupLayout = new GlyphLayout();
        currentPistolTimeoutGlupLayout.setText(smallFont, currentPistolTimeout);
        //--
        currentSniperTimeout = "4528";
        currentSniperTimeoutGlupLayout = new GlyphLayout();
        currentSniperTimeoutGlupLayout.setText(smallFont, currentSniperTimeout);
        //--
        currentMinigunTimeout = "4418";
        currentMinigunTimeoutGlupLayout = new GlyphLayout();
        currentMinigunTimeoutGlupLayout.setText(smallFont, currentMinigunTimeout);
        //--
        pistolTimeoutUpgradePrice = "200";
        pistolTimeoutUpgradeGlyphLayout = new GlyphLayout();
        pistolTimeoutUpgradeGlyphLayout.setText(smallFont, pistolTimeoutUpgradePrice);
        //--
        sniperTimeoutUpgradePrice = "222";
        sniperTimeoutUpgradeGlyphLayout = new GlyphLayout();
        sniperTimeoutUpgradeGlyphLayout.setText(smallFont, sniperTimeoutUpgradePrice);
        //--
        minigunTimeoutUpgradePrice = "333";
        minigunTimeoutUpgradeGlyphLayout = new GlyphLayout();
        minigunTimeoutUpgradeGlyphLayout.setText(smallFont, minigunTimeoutUpgradePrice);
        //--
        damageText = "Damage: ";
        damageGlupLayout = new GlyphLayout();
        damageGlupLayout.setText(xsFont, damageText);
        //--
        currentPistolDamage = "1000";
        currentPistolDamageGlupLayout = new GlyphLayout();
        currentPistolDamageGlupLayout.setText(smallFont, currentPistolDamage);
        //--
        currentSniperDamage = "6666";
        currentSniperDamageGlupLayout = new GlyphLayout();
        currentSniperDamageGlupLayout.setText(smallFont, currentSniperDamage);
        //--
        currentMinigunDamage = "6969";
        currentMinigunDamageGlupLayout = new GlyphLayout();
        currentMinigunDamageGlupLayout.setText(smallFont, currentMinigunDamage);
        //--
        pistolDamageUpgradePrice = "2483";
        pistolDamageUpgradeGlyphLayout = new GlyphLayout();
        pistolDamageUpgradeGlyphLayout.setText(smallFont, pistolDamageUpgradePrice);
        //--
        sniperDamageUpgradePrice = "2555";
        sniperDamageUpgradeGlyphLayout = new GlyphLayout();
        sniperDamageUpgradeGlyphLayout.setText(smallFont, sniperDamageUpgradePrice);
        //--
        minigunDamageUpgradePrice = "2332";
        minigunDamageUpgradeGlyphLayout = new GlyphLayout();
        minigunDamageUpgradeGlyphLayout.setText(smallFont, minigunDamageUpgradePrice);
        //--
        sniperBuyPrice = "5555";
        sniperBuyPriceGlyphLayout = new GlyphLayout();
        sniperBuyPriceGlyphLayout.setText(smallFont, sniperBuyPrice);
        //--
        minigunBuyPrice = "5225";
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

        //files
//        backButton.setRegion(new Texture(Gdx.files.internal("back_button.png")));
//        pistolTimeoutPlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
//        sniperTimeoutPlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
//        minigunTimeoutPlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
//        pistolDamagePlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
//        sniperDamagePlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
//        minigunDamagePlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
//        sniperLockIcon.setRegion(new Texture(Gdx.files.internal("lock_icon2.png")));
//        minigunLockIcon.setRegion(new Texture(Gdx.files.internal("lock_icon2.png")));
//        sniperBuyPlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
//        minigunBuyPlusIcon.setRegion(new Texture(Gdx.files.internal("+_icon.png")));
//        bgRect1.setRegion(new Texture(Gdx.files.internal("orange.png")));
//        bgRect2.setRegion(new Texture(Gdx.files.internal("orange.png")));
//        bgRect3.setRegion(new Texture(Gdx.files.internal("orange.png")));
//        pistolIcon.setRegion(new Texture(Gdx.files.internal("pistol_icon.png")));
//        sniperIcon.setRegion(new Texture(Gdx.files.internal("sniper_icon.png")));
//        minigunIcon.setRegion(new Texture(Gdx.files.internal("minigun_icon.png")));
//        currentCoinsIcon.setRegion(new Texture(Gdx.files.internal("coins_collective.png")));
//        coinIcon.setRegion(new Texture(Gdx.files.internal("coin_icon.png")));


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

        //shaperenderer
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            Gdx.gl.glEnable(GL20.GL_BLEND); //for transparency
            game.shapeRenderer.setColor(37f/255, 119f/255, 178f/255, 0.7f);
            game.shapeRenderer.rect(0, bgRect1.getY()-SCREEN_HEIGHT/100, SCREEN_WIDTH, bgRect1.getHeight()+SCREEN_HEIGHT/50);
        game.shapeRenderer.end();


        //sprite batch
        game.batch.begin();

        backButton.draw(game.batch);
        font.draw(game.batch, titleText, MAIN_MENU_SHOP_BUTTON_X-shopGlupLayout.width/2, BACK_BUTTON_Y+shopGlupLayout.height*3/2);
        smallFont.draw(game.batch, totalCoinCountText, SCREEN_WIDTH-coinCountGlupLayout.width-currentCoinsIcon.getWidth()-SCREEN_WIDTH/40, BACK_BUTTON_Y+coinCountGlupLayout.height*2);
        xsFont.draw(game.batch, shootingTimeoutText, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/40, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height*0.5f);

        smallFont.draw(game.batch, currentPistolTimeout, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height);

        smallFont.draw(game.batch, pistolTimeoutUpgradePrice, pistolTimeoutPlusIcon.getX()+pistolTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height);

        smallFont.draw(game.batch, damageText, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/40, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);

        smallFont.draw(game.batch, currentPistolDamage, bgRect1.getX()+bgRect1.getWidth()+SCREEN_WIDTH/15+damageGlupLayout.width, bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);

        smallFont.draw(game.batch, pistolDamageUpgradePrice, pistolTimeoutPlusIcon.getX()+pistolTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40,pistolDamagePlusIcon.getY()+pistolDamageUpgradeGlyphLayout.height*1.2f);

        bgRect1.draw(game.batch);
        bgRect2.draw(game.batch);
        bgRect3.draw(game.batch);
        pistolTimeoutPlusIcon.draw(game.batch);

        pistolDamagePlusIcon.draw(game.batch);

        pistolIcon.draw(game.batch);
        sniperIcon.draw(game.batch);
        minigunIcon.draw(game.batch);
        currentCoinsIcon.draw(game.batch);

        //pistol timeout coin
        game.batch.draw(coinIcon.getTexture(), pistolTimeoutPlusIcon.getX()+pistolTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/20+pistolTimeoutUpgradeGlyphLayout.width,
                bgRect1.getY()+bgRect1.getHeight()-shootingTimeoutGlupLayout.height-pistolTimeoutUpgradeGlyphLayout.height*1.3f,
                coinIcon.getWidth(), coinIcon.getHeight());

        //pistol damage coin
        game.batch.draw(coinIcon.getTexture(), pistolDamagePlusIcon.getX()+pistolDamagePlusIcon.getWidth()+SCREEN_WIDTH/20+pistolDamageUpgradeGlyphLayout.width,
                pistolDamagePlusIcon.getY(),
                coinIcon.getWidth(), coinIcon.getHeight());



        //sniper stuff
        if (sniperPurchased){
            xsFont.draw(game.batch, shootingTimeoutText, bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/40, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height*0.5f);
            smallFont.draw(game.batch, damageText, bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/40, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);

            smallFont.draw(game.batch, currentSniperTimeout, bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height);
            smallFont.draw(game.batch, sniperTimeoutUpgradePrice, sniperTimeoutPlusIcon.getX()+sniperTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height);
            smallFont.draw(game.batch, currentSniperDamage, bgRect2.getX()+bgRect2.getWidth()+SCREEN_WIDTH/15+damageGlupLayout.width, bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);
            smallFont.draw(game.batch, sniperDamageUpgradePrice, sniperTimeoutPlusIcon.getX()+sniperTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40,sniperDamagePlusIcon.getY()+sniperDamageUpgradeGlyphLayout.height*1.2f);
            sniperTimeoutPlusIcon.draw(game.batch);
            sniperDamagePlusIcon.draw(game.batch);

            //sniper timeout coin
            game.batch.draw(coinIcon.getTexture(), sniperTimeoutPlusIcon.getX()+sniperTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/20+sniperTimeoutUpgradeGlyphLayout.width,
                    bgRect2.getY()+bgRect2.getHeight()-shootingTimeoutGlupLayout.height-sniperTimeoutUpgradeGlyphLayout.height*1.3f,
                    coinIcon.getWidth(), coinIcon.getHeight());

            //sniper damage coin
            game.batch.draw(coinIcon.getTexture(), sniperDamagePlusIcon.getX()+sniperDamagePlusIcon.getWidth()+SCREEN_WIDTH/20+sniperDamageUpgradeGlyphLayout.width,
                    sniperDamagePlusIcon.getY(),
                    coinIcon.getWidth(), coinIcon.getHeight());
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
        if (minigunPurchased){
            xsFont.draw(game.batch, shootingTimeoutText, bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/40, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height*0.5f);
            smallFont.draw(game.batch, damageText, bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/40, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);

            smallFont.draw(game.batch, currentMinigunTimeout, bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/20+shootingTimeoutGlupLayout.width, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height);
            smallFont.draw(game.batch, minigunTimeoutUpgradePrice, minigunTimeoutPlusIcon.getX()+minigunTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height);
            smallFont.draw(game.batch, currentMinigunDamage, bgRect3.getX()+bgRect3.getWidth()+SCREEN_WIDTH/15+damageGlupLayout.width, bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height*0.5f - shootingTimeoutGlupLayout.height*2.0f);
            smallFont.draw(game.batch, minigunDamageUpgradePrice, minigunTimeoutPlusIcon.getX()+minigunTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/40,minigunDamagePlusIcon.getY()+minigunDamageUpgradeGlyphLayout.height*1.2f);
            minigunTimeoutPlusIcon.draw(game.batch);
            minigunDamagePlusIcon.draw(game.batch);

            //minigun timeout coin
            game.batch.draw(coinIcon.getTexture(), minigunTimeoutPlusIcon.getX()+minigunTimeoutPlusIcon.getWidth()+SCREEN_WIDTH/20+minigunTimeoutUpgradeGlyphLayout.width,
                    bgRect3.getY()+bgRect3.getHeight()-shootingTimeoutGlupLayout.height-minigunTimeoutUpgradeGlyphLayout.height*1.3f,
                    coinIcon.getWidth(), coinIcon.getHeight());

            //minigun damage coin
            game.batch.draw(coinIcon.getTexture(), minigunDamagePlusIcon.getX()+minigunDamagePlusIcon.getWidth()+SCREEN_WIDTH/20+minigunDamageUpgradeGlyphLayout.width,
                    minigunDamagePlusIcon.getY(),
                    coinIcon.getWidth(), coinIcon.getHeight());
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
        game.shapeRenderer.dispose();
        game.batch.dispose();
        game.arc.dispose();

        font.dispose();
        xsFont.dispose();
        buyFont.dispose();
        smallFont.dispose();
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
            game.setScreen(new ShopScreen(game));
            System.gc();
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
            System.gc();
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

package com.casual_games.Additional;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.casual_games.FingerGun;

public class Assets {

    FingerGun game;
    public final AssetManager manager;


    public Assets(FingerGun game) {
        this.game = game;

        manager = new AssetManager();
        loadAssets();
    }

    public void loadAssets(){
        //picture
        manager.load("+_icon.png", Texture.class);
        manager.load("back_button.png", Texture.class);
        manager.load("bullet1.png", Texture.class);
        manager.load("bullet2.png", Texture.class);
        manager.load("bullet3.png", Texture.class);
        manager.load("Coin.png", Texture.class);
        manager.load("coin_icon.png", Texture.class);
        manager.load("coins_collective.png", Texture.class);
        manager.load("dead.png", Texture.class);
        manager.load("heart_icon.png", Texture.class);
        manager.load("heart_icon2.png", Texture.class);
        manager.load("home.png", Texture.class);
        manager.load("hud_coins.png", Texture.class);
        manager.load("lock_icon2.png", Texture.class);
        manager.load("locked_icon.png", Texture.class);
        manager.load("minigun_icon.png", Texture.class);
        manager.load("orange.png", Texture.class);
        manager.load("pause.png", Texture.class);
        manager.load("pistol_icon.png", Texture.class);
        manager.load("play.png", Texture.class);
        manager.load("play_button.png", Texture.class);
        manager.load("pointer_icon.png", Texture.class);
        manager.load("retry.png", Texture.class);
        manager.load("sniper_icon.png", Texture.class);
        manager.load("splashLogo.png", Texture.class);
        manager.load("zombies.png", Texture.class);

        //fonts
//        FileHandleResolver resolver = new InternalFileHandleResolver();
//        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
//        manager.setLoader();

        //sound/auido



        manager.finishLoading();
    }
}

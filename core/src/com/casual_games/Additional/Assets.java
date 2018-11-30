package com.casual_games.Additional;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
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
        manager.load("bullet_1.png", Texture.class);
        manager.load("bullet_2.png", Texture.class);
        manager.load("bullet_3.png", Texture.class);
        manager.load("Coin.png", Texture.class);
        manager.load("coin_icon.png", Texture.class);
        manager.load("coins_collective.png", Texture.class);
        manager.load("dead.png", Texture.class);
        manager.load("heart_icon.png", Texture.class);
        manager.load("heart_icon2.png", Texture.class);
        manager.load("home.png", Texture.class);
        manager.load("hud_coins.png", Texture.class);
        manager.load("lock_icon.png", Texture.class);
        manager.load("lock_icon2.png", Texture.class);
        manager.load("locked_icon.png", Texture.class);
        manager.load("minigun_icon.png", Texture.class);
        manager.load("music_off.png", Texture.class);
        manager.load("music_on.png", Texture.class);
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
        manager.load("zombies_new.png", Texture.class);
        manager.load("fingerGunLogoText.png", Texture.class);
        manager.load("play2.png", Texture.class);
        manager.load("shop.png", Texture.class);
        manager.load("background.png", Texture.class);

        //fonts
//        FileHandleResolver resolver = new InternalFileHandleResolver();
//        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
//        manager.setLoader();

        //sound/auido
        manager.load("audio/buy_item.wav", Sound.class);
        manager.load("audio/click.wav", Sound.class);
        manager.load("audio/minigun.wav", Sound.class);
        manager.load("audio/not_enough_coins.wav", Sound.class);
        manager.load("audio/pistol1.wav", Sound.class);
        manager.load("audio/pistol2.wav", Sound.class);
        manager.load("audio/sniper1.wav", Sound.class);
        manager.load("audio/sniper2.wav", Sound.class);
        //zombiesounds
        manager.load("audio/zombies/zombie-1.wav", Sound.class);
        manager.load("audio/zombies/zombie-2.wav", Sound.class);
        manager.load("audio/zombies/zombie-3.wav", Sound.class);
        manager.load("audio/zombies/zombie-4.wav", Sound.class);
        manager.load("audio/zombies/zombie-5.wav", Sound.class);
        manager.load("audio/zombies/zombie-6.wav", Sound.class);
        manager.load("audio/zombies/zombie-7.wav", Sound.class);
        manager.load("audio/zombies/zombie-8.wav", Sound.class);
        manager.load("audio/zombies/zombie-9.wav", Sound.class);
        manager.load("audio/zombies/zombie-10.wav", Sound.class);
        manager.load("audio/zombies/zombie-11.wav", Sound.class);
        manager.load("audio/zombies/zombie-12.wav", Sound.class);
        manager.load("audio/zombies/zombie-13.wav", Sound.class);
        manager.load("audio/zombies/zombie-14.wav", Sound.class);
        manager.load("audio/zombies/zombie-15.wav", Sound.class);
        manager.load("audio/zombies/zombie-16.wav", Sound.class);
        manager.load("audio/zombies/zombie-17.wav", Sound.class);
        manager.load("audio/zombies/zombie-18.wav", Sound.class);
        manager.load("audio/zombies/zombie-19.wav", Sound.class);
        manager.load("audio/zombies/zombie-20.wav", Sound.class);
        manager.load("audio/zombies/zombie-21.wav", Sound.class);
        manager.load("audio/zombies/zombie-22.wav", Sound.class);
        manager.load("audio/zombies/zombie-23.wav", Sound.class);
        manager.load("audio/zombies/zombie-24.wav", Sound.class);



        manager.finishLoading();
    }
}

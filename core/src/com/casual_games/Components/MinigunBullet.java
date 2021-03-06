package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.casual_games.Additional.Constants;
import com.casual_games.Screens.PlayScreen;

public class MinigunBullet extends Bullet{

    public MinigunBullet(PlayScreen playScreen, float x, float y) {
        super(playScreen, x, y);
//        setRegion(playScreen.getMinigunBulletTexture());
        setRegion(playScreen.getGame().assets.manager.get("bullet_2.png", Texture.class));

//        setRegionWidth(Gdx.graphics.getWidth()/3);
//        setRegionHeight(getRegionWidth()*2);
//        setSize(getRegionWidth(), getRegionHeight());
        setSize(Constants.SCREEN_WIDTH/55, Constants.SCREEN_HEIGHT/30);
//        setScale(1f/3);

        //older version
//        setScale(getWidth()*2f/(3*Gdx.graphics.getWidth()) );
        //in new version i replace getWidth with something constant (get it from Constants class)
//        setScale((Gdx.graphics.getWidth()/5)*1f/(3*Gdx.graphics.getWidth()) );

        setX(x-getRegionWidth()*getScaleX()/2);
        speed = Constants.MINIGUN_SPEED;

        shootingTimeout = playScreen.getGame().prefs.getInteger("current_minigun_timeout", 1200);

        damage = playScreen.getGame().prefs.getInteger("current_minigun_damage", 3);
    }

    @Override
    public void move() {
        setY(getY()+speed);
    }

}

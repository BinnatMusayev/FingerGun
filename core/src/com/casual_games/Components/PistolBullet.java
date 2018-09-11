package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.casual_games.Additional.Constants;
import com.casual_games.Screens.PlayScreen;

public class PistolBullet extends Bullet{

    public PistolBullet(PlayScreen playScreen, float x, float y) {
        super(playScreen, x, y);
        setRegion(new Texture(Gdx.files.internal("bullet1.png")));

//        setRegionWidth(Gdx.graphics.getWidth()/3);
//        setRegionHeight(getRegionWidth()*2);
        setSize(getRegionWidth(), getRegionHeight());
//        setScale(1f/3);

        //older version
//        setScale(getWidth()*2f/(3*Gdx.graphics.getWidth()) );
        //in new version i replace getWidth with something constant (get it from Constants class)
        setScale((Gdx.graphics.getWidth()/5)*1f/(3*Gdx.graphics.getWidth()) );

        setX(x-getRegionWidth()*getScaleX()/2);
        speed = Constants.PISTOL_SPEED;

        shootingTimeout = Constants.PISTOL_SHOOTING_TIMEOUT;

        damage = Constants.PISTOL_DAMAGE;

    }

    @Override
    public void move() {
        setY(getY()+speed);
    }

}

package com.casual_games.Components;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.casual_games.Additional.Constants;
import com.casual_games.Screens.PlayScreen;

public class Coin extends Sprite {

    private Animation<TextureRegion> coinRotatingAnimation;
    private float stateTimer;
    private PlayScreen playScreen;

    public Coin(PlayScreen playScreen){
        super(playScreen.getCoin().findRegion("coin_sprite"));
        this.playScreen = playScreen;

        stateTimer = 0;

        //ilk ikisi bashlangic
        Array<TextureRegion> coinRotating = new Array<TextureRegion>();
        for(int i =0; i<6; i++){
//            if (i==6){
//                coinRotating.add(new TextureRegion(getTexture(), 0, 0, 115, 96));
//            }else {
                coinRotating.add(new TextureRegion(getTexture(), i * 120, 0, 120, 96));
//            }
        }
        //if u uncomment if statement abouve inside for loop then comment below line for better animation
//        coinRotating.add(new TextureRegion(getTexture(), 32, 0, 32, 32));

        coinRotatingAnimation = new Animation<TextureRegion>(0.08f, coinRotating);

        setSize(Constants.SCREEN_WIDTH/16,Constants.SCREEN_WIDTH/16);

    }

    public void update(float dt){
        setRegion(getFrame(dt));
        destroy();
    }

    public TextureRegion getFrame(float dt){
        stateTimer =  stateTimer +dt ;
        return coinRotatingAnimation.getKeyFrame(stateTimer, true);
    }



    public void destroy(){

    }



//    public boolean isVisible() {
//        return visible;
//    }

//    public void setVisible(boolean visible) {
//        this.visible = visible;
//    }

    public void dispose(){
        this.dispose();
    }

}

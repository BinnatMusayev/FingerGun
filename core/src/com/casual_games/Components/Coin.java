package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.casual_games.Additional.Constants;
import com.casual_games.Screens.PlayScreen;

import static com.casual_games.Additional.Constants.*;

public class Coin extends Sprite {

    private Animation<TextureRegion> coinRotatingAnimation;
    private float stateTimer;
    private PlayScreen playScreen;
    private float directionX, directionY;
    private float movingSpeed;

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

        coinRotatingAnimation = new Animation<TextureRegion>(0.1f, coinRotating);

        setSize(Constants.SCREEN_WIDTH/20,Constants.SCREEN_WIDTH/20);

        directionX = HUD_COINS_ICON_X +HUD_BUTTON_WIDTH/2;
        directionY = HUD_COINS_ICON_Y + HUD_BUTTON_WIDTH;
        movingSpeed = SCREEN_HEIGHT/150;
    }

    public void update(float dt){
        setRegion(getFrame(dt));
        move();

    }

    public TextureRegion getFrame(float dt){
        stateTimer =  stateTimer +dt ;
        return coinRotatingAnimation.getKeyFrame(stateTimer, true);
    }

    public void move(){
        float currentX = getX();
        float currentY = getY();

        float destX = directionX - getX();
        float destY = directionY - getY();

        float dist = (float)Math.sqrt(destX * destX + destY * destY);
        destX = destX / dist;
        destY = destY / dist;

        float travelX = destX * movingSpeed;
        float travelY = destY * movingSpeed;

//        distTravel = Math.sqrt(travelX * travelX + travelY * travelY);
//
//        if ( distTravel > dist )
//        {
//            posX = destX;
//            posY = destY;
//        }
//        else
//        {
            currentX += travelX;
            currentY += travelY;
            setX(currentX);
            setY(currentY);
//        }
    }


    public boolean isOffScreen(){
        if ( getY() >= Constants.SCREEN_HEIGHT-Constants.HUD_HEIGHT){
            return true;
        }else{
            return false;
        }
    }

    public void dispose(){
        this.dispose();
    }

}

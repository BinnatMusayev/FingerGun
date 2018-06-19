package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.casual_games.Screens.PlayScreen;

public class EnemyOne extends Sprite {


	private Animation<TextureRegion> zombieWalkAnimation;
	private float stateTimer;
	private int orderIndex;
	private boolean visible, destroyed;
	private float damage = 5;
	private PlayScreen playScreen;

	public EnemyOne(PlayScreen playScreen){
		super(playScreen.getZombie().findRegion("ZombieSheet"));
        this.playScreen = playScreen;

		stateTimer = 0;
        visible = false;
        destroyed = false;

		//ilk ikisi bashlangic
		Array<TextureRegion> zombieWalking = new Array<TextureRegion>();
		for(int i =0; i<3; i++){
//			if(i!=1)
			zombieWalking.add(new TextureRegion(getTexture(), i*32, 0, 32, 32));
		}
		//if u uncomment if statement abouve inside for loop then comment below line for better animation
		zombieWalking.add(new TextureRegion(getTexture(), 32, 0, 32, 32));

		zombieWalkAnimation = new Animation<TextureRegion>(0.2f, zombieWalking);

		setSize(Gdx.graphics.getWidth()/10,Gdx.graphics.getWidth()/10);
	}

	public void update(float dt){
	    setRegion(getFrame(dt));
	    move();
	    destroy();
	}

	public TextureRegion getFrame(float dt){

		stateTimer =  stateTimer +dt ;
		return zombieWalkAnimation.getKeyFrame(stateTimer, true);


	}

	public void move(){
	    //0.5 slow
		setY(getY()-1.5f);
	}

	public void destroy(){
	    if (getY()<-getWidth()){
//	        destroyed = true;
            if (visible) {
                playScreen.getHealthBar().setHealth(playScreen.getHealthBar().getHealth() - damage);
            }
            visible = false;
	    }
    }

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void dispose(){
	    this.dispose();
    }

}

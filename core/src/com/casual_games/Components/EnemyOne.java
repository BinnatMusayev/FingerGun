package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.casual_games.Screens.PlayScreen;

public class EnemyOne extends Sprite {


	private Animation<TextureRegion> zombieWalkAnimation;
	private float stateTimer;
	private int orderIndex;
	private boolean visible;

	public EnemyOne(PlayScreen playScreen){
		super(playScreen.getZombie().findRegion("ZombieSheet"));

		stateTimer = 0;
        visible = false;

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
	}

	public TextureRegion getFrame(float dt){

		stateTimer =  stateTimer +dt ;
		return zombieWalkAnimation.getKeyFrame(stateTimer, true);


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
}

package com.casual_games.Components;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.casual_games.Screens.PlayScreen;

public class Enemy extends Sprite {


	private Animation<TextureRegion> zombieWalkAnimation;
	private float stateTimer;

	public Enemy(PlayScreen playScreen){
		super(playScreen.getZombie().findRegion("ZombieSheet"));

		stateTimer = 0;

		//ilk ikisi bashlangic
		Array<TextureRegion> zombieWalking = new Array<TextureRegion>();
		for(int i =0; i<3; i++){
//			if(i!=1)
			zombieWalking.add(new TextureRegion(getTexture(), i*32, 0, 32, 32));
		}
		zombieWalking.add(new TextureRegion(getTexture(), 32, 0, 32, 32));

		zombieWalkAnimation = new Animation<TextureRegion>(0.2f, zombieWalking);

		setSize(64,64);

	}

	public void update(float dt){
		setRegion(getFrame(dt));
	}

	public TextureRegion getFrame(float dt){

		stateTimer =  stateTimer +dt ;
		return zombieWalkAnimation.getKeyFrame(stateTimer, true);


	}


}

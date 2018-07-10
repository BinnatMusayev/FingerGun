package com.casual_games.Components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.casual_games.Additional.Constants;
import com.casual_games.Screens.PlayScreen;

import java.util.Random;

public class EnemyOne extends Sprite {


	private Animation<TextureRegion> zombieWalkAnimation;
	private float stateTimer;
	private int orderIndex;
	private boolean visible, destroyed;
	private float damage = 5;
	private float speed;
	private PlayScreen playScreen;

	private enum State {walking, standing}
	private State stateOfEnemy;
	private TextureRegion standingZombie;
	private Random random;
	private int randomViewOfZombieX, randomViewOfZombieY;
	private int health;

	public EnemyOne(PlayScreen playScreen){
		super(playScreen.getZombie().findRegion("ZombieSheet"));
        this.playScreen = playScreen;

		stateTimer = 0;
        visible = false;
        destroyed = false;

        speed = Constants.ENEMY_SPEED;

        stateOfEnemy = State.walking;
        //Random view of zombie
        random = new Random();
        randomViewOfZombieX = random.nextInt(4);
        randomViewOfZombieX = randomViewOfZombieX*3*32;//sliding to right
        randomViewOfZombieY = random.nextInt(2);
        if (randomViewOfZombieY == 1) randomViewOfZombieY = 4*32;
        //end of random stuff

        standingZombie = new TextureRegion(getTexture(), randomViewOfZombieX, randomViewOfZombieY, 32, 32);

		//ilk ikisi bashlangic
		Array<TextureRegion> zombieWalking = new Array<TextureRegion>();
		for(int i =0; i<3; i++){
//			if(i!=1)
			zombieWalking.add(new TextureRegion(getTexture(), i*32+randomViewOfZombieX, 0+randomViewOfZombieY, 32, 32));
		}
		//if u uncomment if statement abouve inside for loop then comment below line for better animation
		zombieWalking.add(new TextureRegion(getTexture(), 32+randomViewOfZombieX, randomViewOfZombieY, 32, 32));

		zombieWalkAnimation = new Animation<TextureRegion>(0.2f, zombieWalking);

		setSize(Constants.SCREEN_WIDTH/10,Constants.SCREEN_WIDTH/10);

		health = Constants.ENEMY_HEALTH;
	}

	public void update(float dt){
		if (stateOfEnemy == State.walking) {
			setRegion(getFrame(dt));
		}else if(stateOfEnemy == State.standing){
			setRegion(standingZombie);
		}
        move();
        destroy();
    }

	public TextureRegion getFrame(float dt){
		stateTimer =  stateTimer +dt ;
		return zombieWalkAnimation.getKeyFrame(stateTimer, true);
	}

	public void move(){
	    //0.5 slow
        if (playScreen.isPaused()) {
            speed=0;
        }else{
            speed = Constants.ENEMY_SPEED;
        }
		setY(getY()-speed);
	}


	public void destroy(){
		//fix this with -getWidth()
	    if (getY() <= (-50 ) ){
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

    public void makeEnemyStand(){
		stateOfEnemy = State.standing;
	}

	public void makeEnemyWalk(){
		stateOfEnemy = State.walking;
	}

    public void dispose(){
	    this.dispose();
    }

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}

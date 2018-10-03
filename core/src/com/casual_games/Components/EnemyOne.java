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
//        super(playScreen.getZombie().findRegion("zombie_sprite"));
        this.playScreen = playScreen;

		stateTimer = 0;
        visible = false;
        destroyed = false;

        stateOfEnemy = State.walking;
//        //Random view of zombie
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

        //Other Option

        //Random view of zombie
//        random = new Random();
//        randomViewOfZombieX = 0;
//        randomViewOfZombieY = random.nextInt(6)*64;
//
//        standingZombie = new TextureRegion(getTexture(), randomViewOfZombieX+2*64, randomViewOfZombieY, 64, 64);
//
//        //ilk ikisi bashlangic
//        Array<TextureRegion> zombieWalking = new Array<TextureRegion>();
////        for(int i =0; i<3; i++){
//////			if(i!=1)
////            zombieWalking.add(new TextureRegion(getTexture(), i*32+randomViewOfZombieX, 0+randomViewOfZombieY, 32, 32));
////        }
////        //if u uncomment if statement abouve inside for loop then comment below line for better animation
////        zombieWalking.add(new TextureRegion(getTexture(), 32+randomViewOfZombieX, randomViewOfZombieY, 32, 32));
//
//        //new version
//        zombieWalking.add(new TextureRegion(getTexture(), 0, randomViewOfZombieY, 64, 64));
//        zombieWalking.add(new TextureRegion(getTexture(), 2*64, randomViewOfZombieY, 64, 64));
//        zombieWalking.add(new TextureRegion(getTexture(), 64, randomViewOfZombieY, 64, 64));
//        zombieWalking.add(new TextureRegion(getTexture(), 2*64, randomViewOfZombieY, 64, 64));
//
//        zombieWalkAnimation = new Animation<TextureRegion>(0.2f, zombieWalking);

		setSize(Constants.SCREEN_WIDTH/10,Constants.SCREEN_WIDTH/10);

		speed = 0;

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
            if (playScreen.getDeathCount() > 1400){
                speed = Constants.ENEMY_SPEED_FAST;
            }else if (playScreen.getDeathCount()>1390){
                speed = Constants.ENEMY_SPEED_NORMAL;
            }else if (playScreen.getDeathCount() > 1200){
                speed = Constants.ENEMY_SPEED_SLOW;
            }else if (playScreen.getDeathCount() > 1100){
                speed = Constants.ENEMY_SPEED_FAST;
            }else if (playScreen.getDeathCount()>1000){
                speed = Constants.ENEMY_SPEED_NORMAL;
            }else if (playScreen.getDeathCount() > 900){
                speed = Constants.ENEMY_SPEED_SLOW;
            }else if (playScreen.getDeathCount() > 800){
                speed = Constants.ENEMY_SPEED_FAST;
            }else if (playScreen.getDeathCount()>700){
                speed = Constants.ENEMY_SPEED_NORMAL;
            }else if (playScreen.getDeathCount() > 600){
                speed = Constants.ENEMY_SPEED_SLOW;
            }else if (playScreen.getDeathCount() > 500){
                speed = Constants.ENEMY_SPEED_FAST;
            }else if (playScreen.getDeathCount()>400){
                speed = Constants.ENEMY_SPEED_NORMAL;
            }else if (playScreen.getDeathCount() > 350){
                speed = Constants.ENEMY_SPEED_SLOW;
            }else if (playScreen.getDeathCount() > 300){
                speed = Constants.ENEMY_SPEED_FAST;
            }else if (playScreen.getDeathCount()>250){
                speed = Constants.ENEMY_SPEED_NORMAL;
            }else if (playScreen.getDeathCount() > 200){
                speed = Constants.ENEMY_SPEED_SLOW;
            }else if (playScreen.getDeathCount() > 150){
                speed = Constants.ENEMY_SPEED_FAST;
            }else if (playScreen.getDeathCount()>120){
                speed = Constants.ENEMY_SPEED_NORMAL;
            }else if (playScreen.getDeathCount() > 90){
                speed = Constants.ENEMY_SPEED_SLOW;
            }else if (playScreen.getDeathCount() > 60){
                speed = Constants.ENEMY_SPEED_FAST;
            }else if (playScreen.getDeathCount()>30){
                speed = Constants.ENEMY_SPEED_NORMAL;
            }else{
                speed = Constants.ENEMY_SPEED_SLOW;
            }
        }
		setY(getY()-speed);
	}


	public void destroy(){
		//fix this with -getWidth()
	    if (getY() <= (-getHeight()) ){
//	        destroyed = true;
            if (visible) {
//                playScreen.getHealthBar().setHealth(playScreen.getHealthBar().getHealth() - damage);
                playScreen.getHealthBar().setCurrentHealth(playScreen.getHealthBar().getCurrentHealth() - damage);
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

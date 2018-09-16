package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.casual_games.Additional.Constants;
import com.casual_games.Additional.GameOverWidget;
import com.casual_games.Additional.Hud;
import com.casual_games.Additional.PauseWidget;
import com.casual_games.Components.Bullet;
import com.casual_games.Components.Bullets;
import com.casual_games.Components.Coin;
import com.casual_games.Components.Coins;
import com.casual_games.Components.Enemies;
import com.casual_games.Components.EnemyLine;
import com.casual_games.Components.EnemyOne;
import com.casual_games.Components.HealthBar;
import com.casual_games.Components.MinigunBullet;
import com.casual_games.Components.PistolBullet;
import com.casual_games.Components.Pointer;
import com.casual_games.Components.PointerOne;
import com.casual_games.Components.PointerTwo;
import com.casual_games.Components.SniperBullet;
import com.casual_games.FingerGun;

import java.util.Random;


public class PlayScreen implements Screen, InputProcessor{
	private FingerGun game;

	private Enemies enemies;
	private Pointer pointer;
	private TextureAtlas zombie, coin;
//	private Bullet bullet;
    private Bullets bullets;
    private Bullet bullet;
    private Coins coins;
    private HealthBar healthBar;
    private Hud hud;
    private PauseWidget pauseWidget;
    private GameOverWidget gameOverWidget;
    public BitmapFont font;
    private int coinCount;
    private int deathCount;
    private Constants.Gun gunType;

    Preferences prefs;

    private long shootingTimeout, currentGunShootingTimeout;
    private boolean canShoot;
    private boolean paused, gameover;

    private Random random;
	public PlayScreen(FingerGun game) {
		this.game = game;


		this.startGame();
	}

	@Override
	public void show() {

	}

	public void update(float delta){
        bulletAndEnemyCollision();
        bullets.update(delta);
        healthBar.update(delta);


        enemies.update(delta);
        pointer.update(delta);

        coins.update(delta);

        if (canShoot) {
            if (TimeUtils.millis() - shootingTimeout > currentGunShootingTimeout) {
//              bullets.addBullet(new PistolBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()));
//              bullets.addBullet(new SniperBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()));
//              bullets.addBullet(new MinigunBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()));
                shoot();
                shootingTimeout = TimeUtils.millis();
            }
        }

	}

	@Override
	public void render(float delta) {
	    this.update(delta);


	    //clear game screen with black
		Gdx.gl.glClearColor(0,0,0,1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //for antialiasing
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

        Gdx.gl.glLineWidth(Gdx.graphics.getWidth()/100);

		game.batch.begin();

        //SpriteBatch
        coins.draw(game.batch);
        enemies.draw(game.batch);
//		bullet.draw(game.batch);
		bullets.draw(game.batch);
        font.draw(game.batch, "Paused: "+paused, 200, 800);
        font.draw(game.batch, "Health: "+healthBar.getHealth(), 200, 850);
        font.draw(game.batch, "All Lines count: "+enemies.getNumberOfEnemyLines(), 200, 900);
        font.draw(game.batch, "Empty Lines: "+enemies.getNumberOfEmptyEnemyLines(), 200, 950);
//        font.draw(game.batch, "Line index: "+enemies.getLineIndex(), 200, 1000);
        font.draw(game.batch, coins.getCoinsCount(), 200, 1000);
//        font.draw(game.batch, "Removable: "+enemies.getRemovableLines(), 200, 1150);
        font.draw(game.batch, bullets.getCountOfBullets(), 200, 1200);
//		font.draw(game.batch, "Last Y coord: "+enemies.getEnemyLines().get(enemies.getEnemyLines().size()-1).getLineIndex()*(Gdx.graphics.getWidth() / 10), 200, 1100);

        game.batch.end();

        //Arc
        game.arc.begin(ShapeRenderer.ShapeType.Line);
        pointer.draw(game.arc);
        game.arc.end();

        //ShapeRenderer
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        healthBar.draw(game.shapeRenderer);
        hud.draw(game.shapeRenderer);
        pauseWidget.draw(game.shapeRenderer);
        gameOverWidget.draw(game.shapeRenderer);

        game.shapeRenderer.end();


        //for being on the upside of shaperenderer
        game.batch.begin();
        hud.draw(game.batch);
        pauseWidget.draw(game.batch);
        gameOverWidget.draw(game.batch);
        game.batch.end();

	}

	public void startGame(){
        zombie = new TextureAtlas("zombies.pack");
        coin = new TextureAtlas("Coin.pack");

        random = new Random();
        int r = random.nextInt(2);

        //initialize objects
        enemies = new Enemies(this);
        bullets = new Bullets(this);
//		bullet = new PistolBullet(this, 0, 0);
        healthBar = new HealthBar(this);
        hud = new Hud(this);
        pauseWidget = new PauseWidget(this);
        gameOverWidget = new GameOverWidget(this);
        font = new BitmapFont();
        coins = new Coins(this);

        switch (r){
            case 0:
                pointer = new PointerOne();
                break;
            case 1:
                pointer = new PointerTwo();
                break;
        }

        prefs = Gdx.app.getPreferences("My Preferences");
        coinCount = prefs.getInteger("coinCoint", 0);
        deathCount = 0;

        Gdx.input.setInputProcessor(this);

        shootingTimeout = 0;
        canShoot = false;

        paused = false;
        gameover = false;

        gunType = Constants.Gun.minigun;

        currentGunShootingTimeout = Constants.MINIGUN_SHOOTING_TIMEOUT;
    }

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
        if (!gameover) {
            paused = true;
            enemies.makeEnemiesStand();
        }
	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
	    enemies.dispose();
	    bullets.dispose();
	    coins.dispose();
	}

	public TextureAtlas getZombie() {
		return zombie;
	}


    public TextureAtlas getCoin() {
        return coin;
    }


	// input processor

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!gameover) {
            if (!paused) {
                this.pointer.setX(screenX);
                this.pointer.setY(Gdx.graphics.getHeight() - screenY - Gdx.graphics.getWidth() / 40);
                this.pointer.setVisible(true);

                canShoot = true;
                shootingTimeout = TimeUtils.millis();
                if (screenX >= Constants.HUD_BUTTON_X - Constants.HUD_BUTTON_WIDTH
                        && screenX <= Constants.HUD_BUTTON_X + 2 * Constants.HUD_BUTTON_WIDTH
                        && screenY >= Constants.SCREEN_HEIGHT - Constants.HUD_BUTTON_Y - Constants.HUD_BUTTON_WIDTH
                        && screenY <= Constants.SCREEN_HEIGHT - Constants.HUD_BUTTON_Y + 2 * Constants.HUD_BUTTON_WIDTH) {
                    paused = true;
                    enemies.makeEnemiesStand();
                }
            } else {
                if (pauseWidget.getPlayButtonBounds().contains(screenX, screenY)){
                    paused = false;
                    enemies.makeEnemiesWalk();
                }else if(pauseWidget.getHomeButtonBounds().contains(screenX, screenY)){
                    game.setScreen(new MainMenu(game));
                    System.gc();
                }
            }
        }else{
            if (gameOverWidget.getRetryButtonBounds().contains(screenX, screenY)){
                startGame();
            }else if(gameOverWidget.getHomeButtonBounds().contains(screenX, screenY)){
                game.setScreen(new MainMenu(game));
                System.gc();
            }
//            gameover = false;
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		this.pointer.setVisible(false);

		canShoot = false;

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
	    if (!gameover) {
            this.pointer.setX(screenX);
            this.pointer.setY(Gdx.graphics.getHeight() - screenY - Gdx.graphics.getWidth() / 40);
        }
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    //end of input processor


    public void bulletAndEnemyCollision(){
	    for(Bullet b: bullets.getBullets()){
	        for (int i=0; i<enemies.getEnemyLines().size(); i++){
	            EnemyLine enemyLine = enemies.getEnemyLines().get(i);
	            for (EnemyOne e: enemyLine.getEnemies()){
	                if(e.isVisible() && !b.isDestroyed()) {
                        if (b.getBoundingRectangle().overlaps(e.getBoundingRectangle())) {
                            if (b.getDamage() >= e.getHealth()) {


                                // in the case of pistol bullet or plumyot not in sniper
//                            if (!(b instanceof SniperBullet) ){
//                                b.setDestroyed(true);
//                            }

                                b.setDamage(b.getDamage()-e.getHealth());
                                e.setVisible(false);

                                //only if enemy died/destroyed
                                coins.addCoin(b.getX(), b.getY());
//                            increase coint count
                                coinCount++;
                                deathCount++;
                            }else{
                                b.setDestroyed(true);
                                e.setHealth(e.getHealth()-b.getDamage());

                            }


                        }

                    }
                }
            }

        }
    }

    private void shoot(){
//	    switch (gunType){
//            case pistol:
//              bullet =   new PistolBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
//              bullets.addBullet(bullet);
//              break;
//            case sniper:
//              bullet = new SniperBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
//              bullets.addBullet(bullet);
//              break;
//            case minigun:
//                bullet = new MinigunBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
//                bullets.addBullet(bullet);
//                break;
//            default:
//                bullet =   new PistolBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
//                bullets.addBullet(bullet);
//              break;
//        }
        bullets.shoot(gunType, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }

    public void saveCoins(int tempCoins){
	    prefs.putInteger("coinCoint", tempCoins);
	    prefs.flush();
    }

    public void updateScore(){
	    int bestScore = prefs.getInteger("highScore", 0);
	    if (deathCount>bestScore){
            prefs.putInteger("highScore", deathCount);
            prefs.flush();
        }
    }


    public HealthBar getHealthBar() {
        return healthBar;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public BitmapFont getFont() {
        return font;
    }

    public FingerGun getGame() {
        return game;
    }
}

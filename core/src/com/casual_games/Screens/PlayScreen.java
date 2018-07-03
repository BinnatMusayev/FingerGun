package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.casual_games.Additional.Constants;
import com.casual_games.Additional.Hud;
import com.casual_games.Additional.PauseWidget;
import com.casual_games.Components.Bullet;
import com.casual_games.Components.Bullets;
import com.casual_games.Components.Enemies;
import com.casual_games.Components.EnemyLine;
import com.casual_games.Components.EnemyOne;
import com.casual_games.Components.HealthBar;
import com.casual_games.Components.MinigunBullet;
import com.casual_games.Components.PistolBullet;
import com.casual_games.Components.PointerOne;
import com.casual_games.Components.PointerTwo;
import com.casual_games.Components.SniperBullet;
import com.casual_games.FingerGun;


public class PlayScreen implements Screen, InputProcessor{
	private FingerGun game;

	private Enemies enemies;
	private PointerOne pointerOne;
	private TextureAtlas zombie;
//	private Bullet bullet;
    private Bullets bullets;
    private HealthBar healthBar;
    private Hud hud;
    private PauseWidget pauseWidget;
    public BitmapFont font;

    private long shootingTimeout;
    private boolean canShoot;
    private boolean paused, gameover;

	public PlayScreen(FingerGun game) {
		this.game = game;
		zombie = new TextureAtlas("zombies.pack");

		//initialize objects
		enemies = new Enemies(this);
		pointerOne = new PointerOne();
		bullets = new Bullets(this);
//		bullet = new PistolBullet(this, 0, 0);
        healthBar = new HealthBar(this);
        hud = new Hud(this);
        pauseWidget = new PauseWidget(this);
        font = new BitmapFont();

        Gdx.input.setInputProcessor(this);

        shootingTimeout = 0;
        canShoot = false;

        paused = false;
        gameover = false;
	}

	@Override
	public void show() {

	}

	public void update(float delta){
        bulletAndEnemyCollision();
        bullets.update(delta);
        healthBar.update(delta);


        enemies.update(delta);
        pointerOne.update(delta);


        if (canShoot) {
            if (TimeUtils.millis() - shootingTimeout > Constants.MINIGUN_SHOOTING_TIMEOUT) {
//              bullets.addBullet(new PistolBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()));
//              bullets.addBullet(new SniperBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()));
                bullets.addBullet(new MinigunBullet(this, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()));
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

//        Gdx.gl.glLineWidth(Gdx.graphics.getWidth()/30);

		game.batch.begin();


        //SpriteBatch
		enemies.draw(game.batch);
//		bullet.draw(game.batch);
		bullets.draw(game.batch);
        font.draw(game.batch, "Paused: "+paused, 200, 800);
        font.draw(game.batch, "Health: "+healthBar.getHealth(), 200, 850);
        font.draw(game.batch, "All Lines count: "+enemies.getNumberOfEnemyLines(), 200, 900);
        font.draw(game.batch, "Empty Lines: "+enemies.getNumberOfEmptyEnemyLines(), 200, 950);
        font.draw(game.batch, "Line index: "+enemies.getLineIndex(), 200, 1000);
        font.draw(game.batch, "Removable: "+enemies.getRemovableLines(), 200, 1150);
        font.draw(game.batch, bullets.getCountOfBullets(), 200, 1200);
//		font.draw(game.batch, "Last Y coord: "+enemies.getEnemyLines().get(enemies.getEnemyLines().size()-1).getLineIndex()*(Gdx.graphics.getWidth() / 10), 200, 1100);

        game.batch.end();


        //ShapeRenderer
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        pointerOne.draw(game.shapeRenderer);
        healthBar.draw(game.shapeRenderer);
        hud.draw(game.shapeRenderer);
        pauseWidget.draw(game.shapeRenderer);

        game.shapeRenderer.end();


        //for being on the upside of shaperenderer
        game.batch.begin();
        hud.draw(game.batch);
        pauseWidget.draw(game.batch);
        game.batch.end();

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
        paused = true;
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
//	    bullet.dispose();
	    bullets.dispose();
	}

	public TextureAtlas getZombie() {
		return zombie;
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

	    if (!paused) {
            pointerOne.setX(screenX);
            pointerOne.setY(Gdx.graphics.getHeight() - screenY - Gdx.graphics.getWidth() / 40);
            pointerOne.setVisible(true);

            canShoot = true;
            shootingTimeout = TimeUtils.millis();
            if (screenX >= Constants.HUD_BUTTON_X - Constants.HUD_BUTTON_WIDTH
                    && screenX <= Constants.HUD_BUTTON_X+2*Constants.HUD_BUTTON_WIDTH
                    && screenY >= Constants.SCREEN_HEIGHT - Constants.HUD_BUTTON_Y-Constants.HUD_BUTTON_WIDTH
                    && screenY <= Constants.SCREEN_HEIGHT - Constants.HUD_BUTTON_Y + 2*Constants.HUD_BUTTON_WIDTH){
                paused = true;
            }
        }else{
            paused = false;
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		pointerOne.setVisible(false);

		canShoot = false;

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        pointerOne.setX(screenX);
        pointerOne.setY(Gdx.graphics.getHeight()-screenY-Gdx.graphics.getWidth()/40);
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
                        // in the case of pistol bullet or plumyot not in sniper
                            if (!(b instanceof SniperBullet) ){
                                b.setDestroyed(true);
                            }

                            e.setVisible(false);
                        }
                    }
                }
            }

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

    public BitmapFont getFont() {
        return font;
    }
}

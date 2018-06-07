package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.casual_games.Components.Enemies;
import com.casual_games.Components.PointerOne;
import com.casual_games.FingerGun;


public class PlayScreen implements Screen, InputProcessor{
	private FingerGun game;

	private Enemies enemies;
	private PointerOne pointerOne;
	private TextureAtlas zombie;
    BitmapFont font = new BitmapFont();

	public PlayScreen(FingerGun game) {
		this.game = game;
		zombie = new TextureAtlas("zombies.pack");

		enemies = new Enemies(this);
		pointerOne = new PointerOne();
        Gdx.input.setInputProcessor(this);
	}

	@Override
	public void show() {

	}

	public void update(float delta){
		enemies.update(delta);
	}

	@Override
	public void render(float delta) {
		this.update(delta);
		//clear game screen with black
		Gdx.gl.glClearColor(0,0,0,1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //for antialiasing
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

        Gdx.gl.glLineWidth(Gdx.graphics.getWidth()/30);

		game.batch.begin();
		enemies.draw(game.batch);
        font.draw(game.batch, "All Lines count: "+enemies.getNumberOfEnemyLines(), 200, 900);
        font.draw(game.batch, "Empty Lines: "+enemies.getNumberOfEmptyEnemyLines(), 200, 1000);
        font.draw(game.batch, "Line index: "+enemies.getLineIndex(), 200, 1100);
//		font.draw(game.batch, "Last Y coord: "+enemies.getEnemyLines().get(enemies.getEnemyLines().size()-1).getLineIndex()*(Gdx.graphics.getWidth() / 10), 200, 1100);
		game.batch.end();

		game.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        pointerOne.draw(game.shapeRenderer);
		game.shapeRenderer.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

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
        pointerOne.setX(screenX);
        pointerOne.setY(Gdx.graphics.getHeight()-screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
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
}

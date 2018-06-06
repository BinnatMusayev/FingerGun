package com.casual_games.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.casual_games.Components.Enemies;
import com.casual_games.Components.EnemyOne;
import com.casual_games.FingerGun;


public class PlayScreen implements Screen{
	private FingerGun game;

	private Enemies enemies;

	private Texture img;
	private TextureAtlas zombie;
    BitmapFont font = new BitmapFont();

	public PlayScreen(FingerGun game) {
		this.game = game;
		img = new Texture(Gdx.files.internal("badlogic.jpg"));
		zombie = new TextureAtlas("zombies.pack");

		enemies = new Enemies(this);
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
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		game.batch.begin();
//		game.batch.draw(img, 50, 50, Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/3);
		enemies.draw(game.batch);
        font.draw(game.batch, "Enemies count: "+enemies.getSize(), 200, 200);
		game.batch.end();
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
		img.dispose();
	}

	public TextureAtlas getZombie() {
		return zombie;
	}
}

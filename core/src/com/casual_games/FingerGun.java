package com.casual_games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.casual_games.Additional.Arc;
import com.casual_games.Screens.MainMenu;
import com.casual_games.Screens.PlayScreen;
import com.casual_games.Screens.SplashScreen;

public class FingerGun extends Game {
	public SpriteBatch batch;
	public ShapeRenderer shapeRenderer;
	public Arc arc;

	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		arc = new Arc();
		setScreen(new SplashScreen(this));


	}

	@Override
	public void render () {
		super.render();

	}

	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
		arc.dispose();
	}
}

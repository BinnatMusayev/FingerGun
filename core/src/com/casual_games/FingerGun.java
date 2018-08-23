package com.casual_games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.casual_games.Additional.Arc;
import com.casual_games.Additional.Constants;
import com.casual_games.Screens.MainMenu;
import com.casual_games.Screens.PlayScreen;
import com.casual_games.Screens.SplashScreen;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FingerGun extends Game {
	public SpriteBatch batch;
	public ShapeRenderer shapeRenderer;
	public Arc arc;
	public BitmapFont font24;

	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		arc = new Arc();
        initFonts();
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
        font24.dispose();
	}

    private void initFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Lato-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

        Color fontColor = new Color();
        fontColor.set(111f/255, 199f/255, 247f/255, 1f);

        params.size = (int)Constants.SCREEN_WIDTH/15;
        params.color = fontColor;
        font24 = generator.generateFont(params);
    }

    public BitmapFont createBitmapFont(int size){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Lato-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

        Color fontColor = new Color();
        fontColor.set(111f/255, 199f/255, 247f/255, 1f);

        params.size = size;
        params.color = fontColor;
        return generator.generateFont(params);
    }
}

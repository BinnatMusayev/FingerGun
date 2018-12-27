package com.casual_games.Additional;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;
import com.casual_games.Screens.PlayScreen;

public class PauseWidget implements Disposable {

    private PlayScreen playScreen;
    private Rectangle rectangle;
    private Sprite homeButton, playButton;
    private BitmapFont font;
    private GlyphLayout pausedGlyphLayout;
    private String pausedTitle;

    public PauseWidget(PlayScreen playScreen) {
        this.playScreen = playScreen;

        rectangle = new Rectangle();
        rectangle.setWidth(Constants.PAUSE_WIDGET_RECTANGLE_WIDTH);
        rectangle.setHeight(Constants.PAUSE_WIDGET_RECTANGLE_HEIGHT);
        rectangle.setX(Constants.PAUSE_WIDGET_RECTANGLE_X);
        rectangle.setY(Constants.PAUSE_WIDGET_RECTANGLE_Y);

        homeButton = new Sprite(playScreen.getGame().assets.manager.get("home.png", Texture.class));
        playButton = new Sprite(playScreen.getGame().assets.manager.get("play_button.png", Texture.class));

        homeButton.setPosition(Constants.PAUSE_WIDGET_HOME_BUTTON_X, Constants.PAUSE_WIDGET_HOME_BUTTON_Y);
        homeButton.setSize(Constants.PAUSE_WIDGET_HOME_BUTTON_WIDHT, Constants.PAUSE_WIDGET_HOME_BUTTON_HEIGHT);

        playButton.setPosition(Constants.PAUSE_WIDGET_PLAY_BUTTON_X, Constants.PAUSE_WIDGET_PLAY_BUTTON_Y);
        playButton.setSize(Constants.PAUSE_WIDGET_PLAY_BUTTON_WIDHT, Constants.PAUSE_WIDGET_PLAY_BUTTON_HEIGHT);

        //font
        pausedTitle = "Paused";
        font = new BitmapFont(Gdx.files.internal("fonts/favorite.fnt"));
        pausedGlyphLayout = new GlyphLayout();
        pausedGlyphLayout.setText(font, pausedTitle);

    }

    @Override
    public void dispose() {
        font.dispose();
    }

    public void draw(ShapeRenderer shapeRenderer){
        if (playScreen.isPaused()){
            Gdx.gl.glEnable(GL20.GL_BLEND); //for transparency
            shapeRenderer.setColor(37f/255, 119f/255, 178f/255, 0.7f);
            shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }

    public void draw(SpriteBatch spriteBatch){
        if (playScreen.isPaused()){
            homeButton.draw(spriteBatch);
            playButton.draw(spriteBatch);
            font.draw(spriteBatch, pausedGlyphLayout,
                    Constants.SCREEN_WIDTH/2-pausedGlyphLayout.width/2,
                        Constants.PAUSE_WIDGET_RECTANGLE_Y+Constants.PAUSE_WIDGET_RECTANGLE_HEIGHT-pausedGlyphLayout.height/2);
        }
    }

    public Rectangle getPlayButtonBounds(){
        Rectangle r = new Rectangle();
        r.setWidth(playButton.getWidth() + playButton.getWidth()/3);
        r.setHeight(playButton.getHeight()+playButton.getHeight()/2);
        r.setX(playButton.getX()-playButton.getWidth()/6);
        r.setY(playButton.getY());
        return r;
    }

    public Rectangle getHomeButtonBounds(){
        Rectangle r = new Rectangle();
        r.setWidth(homeButton.getWidth() + homeButton.getWidth()/3);
        r.setHeight(homeButton.getHeight() + homeButton.getHeight()/2);
        r.setX(homeButton.getX() -homeButton.getWidth()/6);
        r.setY(homeButton.getY());
        return r;
    }

}

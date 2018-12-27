package com.casual_games.Additional;

import com.badlogic.gdx.Gdx;
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

public class GameOverWidget implements Disposable{

    private PlayScreen playScreen;
    private Rectangle rectangle;
    private Sprite homeButton, retryButton;
    private BitmapFont font;
    private GlyphLayout gameOverGlyphLayout;
    private String gameOverTitle;

    public GameOverWidget(PlayScreen playScreen) {
        this.playScreen = playScreen;

        rectangle = new Rectangle();
        rectangle.setWidth(Constants.PAUSE_WIDGET_RECTANGLE_WIDTH);
        rectangle.setHeight(Constants.PAUSE_WIDGET_RECTANGLE_HEIGHT);
        rectangle.setX(Constants.PAUSE_WIDGET_RECTANGLE_X);
        rectangle.setY(Constants.PAUSE_WIDGET_RECTANGLE_Y);

        homeButton = new Sprite(playScreen.getGame().assets.manager.get("home.png", Texture.class));
        retryButton = new Sprite(playScreen.getGame().assets.manager.get("retry.png", Texture.class));

        homeButton.setPosition(Constants.PAUSE_WIDGET_HOME_BUTTON_X, Constants.PAUSE_WIDGET_HOME_BUTTON_Y);
        homeButton.setSize(Constants.PAUSE_WIDGET_HOME_BUTTON_WIDHT, Constants.PAUSE_WIDGET_HOME_BUTTON_HEIGHT);

        retryButton.setPosition(Constants.PAUSE_WIDGET_PLAY_BUTTON_X, Constants.PAUSE_WIDGET_PLAY_BUTTON_Y);
        retryButton.setSize(Constants.PAUSE_WIDGET_PLAY_BUTTON_WIDHT, Constants.PAUSE_WIDGET_PLAY_BUTTON_HEIGHT);

        //font
        gameOverTitle = "Game Over";
        font = new BitmapFont(Gdx.files.internal("fonts/favorite.fnt"));
        gameOverGlyphLayout = new GlyphLayout();
        gameOverGlyphLayout.setText(font, gameOverTitle);

    }

    @Override
    public void dispose() {
        font.dispose();
    }

    public void draw(ShapeRenderer shapeRenderer){
        if (playScreen.isGameover()){
            Gdx.gl.glEnable(GL20.GL_BLEND); //for transparency
            shapeRenderer.setColor(37f/255, 119f/255, 178f/255, 0.7f);
            shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }

    public void draw(SpriteBatch spriteBatch){
        if (playScreen.isGameover()){
            homeButton.draw(spriteBatch);
            retryButton.draw(spriteBatch);
            font.draw(spriteBatch, gameOverGlyphLayout,
                    Constants.SCREEN_WIDTH/2-gameOverGlyphLayout.width/2,
                    Constants.PAUSE_WIDGET_RECTANGLE_Y+Constants.PAUSE_WIDGET_RECTANGLE_HEIGHT-gameOverGlyphLayout.height/2);
        }
    }

    public Rectangle getRetryButtonBounds(){
        Rectangle r = new Rectangle();
        r.setWidth(retryButton.getWidth()+retryButton.getWidth()/3);
        r.setHeight(retryButton.getHeight()+retryButton.getHeight()/2);
        r.setX(retryButton.getX()-retryButton.getWidth()/6);
        r.setY(retryButton.getY());
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

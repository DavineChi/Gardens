package com.farsight.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.farsight.GameFont;
import com.farsight.GardenGame;

public class SplashScreen implements Screen {
	
	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	private final GardenGame game;
	private SpriteBatch spriteBatch;
	
	public SplashScreen(final GardenGame game) {
		
		this.game = game;
	}
	
	@Override
	public void show() {
		
		// TODO Auto-generated method stub
	}
	
	@Override
	public void render(float delta) {
		
		spriteBatch = game.getSpriteBatch();
		
		ScreenUtils.clear(0, 0, 0, 1);
		spriteBatch.begin();
		gameFont.draw(spriteBatch, "Gardens!", 100, 350);
		gameFont.draw(spriteBatch, "Press [Enter] or [mouse click] to continue...", 100, 300);
		spriteBatch.end();
		
		update();
	}
	
	public void update() {
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) ||
			Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
			
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}
	
	@Override
	public void resize(int width, int height) {
		
		// TODO Auto-generated method stub
	}
	
	@Override
	public void pause() {
		
		// TODO Auto-generated method stub
	}
	
	@Override
	public void resume() {
		
		// TODO Auto-generated method stub
	}
	
	@Override
	public void hide() {
		
		// TODO Auto-generated method stub
	}
	
	@Override
	public void dispose() {
		
		// TODO Auto-generated method stub
	}
}

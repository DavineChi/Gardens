package com.farsight.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.farsight.GameFont;
import com.farsight.GardenGame;
import com.farsight.input.TitleInputProcessor;

public class TitleScreen extends ScreenAdapter {

	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	private final GardenGame game;
	private SpriteBatch spriteBatch;

	public TitleScreen(final GardenGame game) {

		this.game = game;
	}
	
	@Override
	public void show() {

		Gdx.input.setInputProcessor(new TitleInputProcessor(game));
	}

	@Override
	public void render(float delta) {

		spriteBatch = game.getSpriteBatch();

		ScreenUtils.clear(0, 0, 0, 1);
		spriteBatch.begin();
		gameFont.draw(spriteBatch, "Gardens!", 100, 350);
		gameFont.draw(spriteBatch, "Press [Enter] or [left mouse click] to continue...", 100, 300);
		spriteBatch.end();
	}
	
	@Override
	public void hide() {
		
		Gdx.input.setInputProcessor(null);
		dispose();
	}
}

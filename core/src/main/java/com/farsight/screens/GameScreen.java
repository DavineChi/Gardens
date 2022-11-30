package com.farsight.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.farsight.Constants;
import com.farsight.GardenGame;
import com.farsight.components.World;
import com.farsight.input.GameInputProcessor;
import com.farsight.ui.UserInterface;

public class GameScreen extends ScreenAdapter {
	
	private final GardenGame game;
	
	private GameInputProcessor gameInputProcessor;
	
	private static SpriteBatch spriteBatch;
	private static OrthographicCamera camera;
	private static UserInterface userInterface;
	
	private World world;
	
	public GameScreen(final GardenGame game) {
		
		this.game = game;
		
		gameInputProcessor = GameInputProcessor.instance();
		camera = new OrthographicCamera();
		userInterface = UserInterface.instance();
		world = World.instance();
		
		camera.setToOrtho(false, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
	}
	
	public static SpriteBatch getSpriteBatch() { return spriteBatch; }
	public static OrthographicCamera getCamera() { return camera; }
	
	@Override
	public void show() {
		
		Gdx.input.setInputProcessor(gameInputProcessor);
	}
	
	@Override
	public void render(float delta) {
		
		spriteBatch = game.getSpriteBatch();
		
		ScreenUtils.clear(0, 0, 0, 1);
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		world.render(spriteBatch);
		userInterface.render(spriteBatch);
		spriteBatch.end();
		
		update();
	}
	
	public void update() {
		
		camera.update();
		world.update();
		userInterface.update();
	}
	
	@Override
	public void hide() {
		
		Gdx.input.setInputProcessor(null);
	}
}

package com.farsight.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.farsight.Constants;
import com.farsight.GardenGame;
import com.farsight.components.World;
import com.farsight.ui.UserInterface;

public class GameScreen implements Screen {
	
	private final GardenGame game;
	
	private static SpriteBatch spriteBatch;
	private static OrthographicCamera camera;
	private static UserInterface userInterface;
	
	private World world;
	
	public GameScreen(final GardenGame game) {
		
		this.game = game;
		
		camera = new OrthographicCamera();
		userInterface = UserInterface.instance();
		world = World.instance();
		
		camera.setToOrtho(false, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
	}
	
	public static SpriteBatch getSpriteBatch() { return spriteBatch; }
	public static OrthographicCamera getCamera() { return camera; }
	
	@Override
	public void show() {
		
		// TODO Auto-generated method stub
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
	public void dispose() {  }
}

package com.farsight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.components.World;
import com.farsight.screens.SplashScreen;

public class GardenGame extends Game {
	
	private InputHandler inputHandler;
	private SpriteBatch spriteBatch;
	
	@Override
	public void create() {
		
		inputHandler = InputHandler.instance();
		spriteBatch = new SpriteBatch();
		
		Gdx.input.setInputProcessor(inputHandler);
		this.setScreen(new SplashScreen(this));
	}
	
	@Override
	public void render() {
		
		super.render();
	}
	
	public InputHandler getInputHandler() {
		
		return inputHandler;
	}
	
	public SpriteBatch getSpriteBatch() {
		
		return spriteBatch;
	}
	
	@Override
	public void dispose() {
		
		spriteBatch.dispose();
		World.instance().dispose();
		GameFont.instance().dispose();
	}
}

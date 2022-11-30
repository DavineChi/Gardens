package com.farsight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.components.World;
import com.farsight.screens.TitleScreen;

public class GardenGame extends Game {
	
	private SpriteBatch spriteBatch;
	
	@Override
	public void create() {
		
		spriteBatch = new SpriteBatch();
		
		this.setScreen(new TitleScreen(this));
	}
	
	@Override
	public void render() {
		
		super.render();
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

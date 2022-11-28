package com.farsight.plants;

public class Cucumber extends Vegetable {
	
	private static final int SPRITE_X = 0;
	private static final int SPRITE_Y = 0;
	
	public Cucumber() {
		
		// TODO: finalize implementation
		super("cucumber", SPRITE_X, SPRITE_Y);
	}
	
	@Override
	public void update() {
		
		if (turns > 10) {
			
			growthState = GrowthState.DEAD;
		}
	}
}

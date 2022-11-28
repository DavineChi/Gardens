package com.farsight.plants;

public class Tomato extends Fruit {
	
	private static final int SPRITE_X = 0;
	private static final int SPRITE_Y = 0;
	
	public Tomato() {
		
		// TODO: finalize implementation
		super("tomato", SPRITE_X, SPRITE_Y);
	}
	
	@Override
	public void update() {
		
		if (turns > 10) {
			
			growthState = GrowthState.DEAD;
		}
	}
}

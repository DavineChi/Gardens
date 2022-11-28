package com.farsight.plants;

public class BellPepper extends Vegetable {
	
	private static final int SPRITE_X = 0;
	private static final int SPRITE_Y = 0;
	
	public BellPepper() {
		
		// TODO: finalize implementation
		super("bell_pepper", SPRITE_X, SPRITE_Y);
	}
	
	@Override
	public void update() {
		
		if (turns > 10) {
			
			growthState = GrowthState.DEAD;
		}
	}
}

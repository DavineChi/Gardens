package com.farsight.plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.farsight.components.SunDial;
import com.farsight.entities.Item;

public abstract class Plant extends Item implements IGrowable {
	
	public static final Texture TEXTURE_CROPS = new Texture(Gdx.files.internal("crops.png"));
	
	protected int turns;
	protected GrowthState growthState;
	
	public Plant(String name, int spriteX, int spriteY) {
		
		this.turns = 0;
		this.name = name;
		this.growthState = GrowthState.SEEDLING;
	}
	
	public GrowthState getGrowthState() { return growthState; }
	
	public String getAge() {
		
		String result = SunDial.parseTurns(turns);
		
		return result;
	}
	
	public int getTurns() { return turns; }
	
	public void addTurn() {
		
		addTurns(1);
	}
	
	public void addTurns(int nTurns) {
		
		if (growthState != GrowthState.DEAD) {
			
			turns = turns + nTurns;
		}
	}
	
	protected void nextState() {
		
		switch (growthState) {
			
			case SEEDLING:
				growthState = GrowthState.VEGETATIVE;
				break;
				
			case VEGETATIVE:
				growthState = GrowthState.BUDDING;
				break;
				
			case BUDDING:
				growthState = GrowthState.FLOWERING;
				break;
				
			case FLOWERING:
				growthState = GrowthState.RIPENING;
				break;
				
			case RIPENING:
				growthState = GrowthState.DECAYING;
				break;
				
			case DECAYING:
				growthState = GrowthState.DEAD;
				break;
				
			default:
				break;
		}
	}
}

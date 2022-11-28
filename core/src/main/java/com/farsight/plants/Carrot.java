package com.farsight.plants;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.farsight.Constants;

public class Carrot extends Vegetable {
	
	private static final int SPRITE_X = 192;
	private static final int SPRITE_Y = 32;
	private static final int GS_TURNS_DEAD = 100;
	
	private TextureRegion[] textureList;
	
	public Carrot() {
		
		super("carrot", SPRITE_X, SPRITE_Y);
		this.textureList = new  TextureRegion[5];
		
		this.textureList[0] = new TextureRegion(Plant.TEXTURE_CROPS, 192, 32,  (int)Constants.TILE_WIDTH, (int)Constants.TILE_HEIGHT);
		this.textureList[1] = new TextureRegion(Plant.TEXTURE_CROPS, 192, 96,  (int)Constants.TILE_WIDTH, (int)Constants.TILE_HEIGHT);
		this.textureList[2] = new TextureRegion(Plant.TEXTURE_CROPS, 192, 160, (int)Constants.TILE_WIDTH, (int)Constants.TILE_HEIGHT);
		this.textureList[3] = new TextureRegion(Plant.TEXTURE_CROPS, 192, 224, (int)Constants.TILE_WIDTH, (int)Constants.TILE_HEIGHT);
		this.textureList[4] = new TextureRegion(Plant.TEXTURE_CROPS, 192, 288, (int)Constants.TILE_WIDTH, (int)Constants.TILE_HEIGHT);
		
		this.currentTexture = textureList[0];
	}
	
	@Override
	public void update() {
		
		if (turns >= 0 && turns < 10) {
			
			growthState = GrowthState.SEEDLING;
			currentTexture = textureList[0];
			return;
		}
		
		if (turns >= 10 && turns < 20) {
			
			growthState = GrowthState.VEGETATIVE;
			currentTexture = textureList[0];
			return;
		}
		
		if (turns >= 20 && turns < 30) {
			
			growthState = GrowthState.BUDDING;
			currentTexture = textureList[1];
			return;
		}
		
		if (turns >= 30 && turns < 40) {
			
			growthState = GrowthState.FLOWERING;
			currentTexture = textureList[2];
			return;
		}
		
		if (turns >= 40 && turns < 85) {
			
			growthState = GrowthState.RIPENING;
			currentTexture = textureList[3];
			return;
		}
		
		if (turns >= 85 && turns < GS_TURNS_DEAD) {
			
			growthState = GrowthState.DECAYING;
			currentTexture = textureList[3];
			return;
		}
		
		if (turns >= GS_TURNS_DEAD) {
			
			growthState = GrowthState.DEAD;
			currentTexture = textureList[4];
			return;
		}
	}
}
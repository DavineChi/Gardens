package com.farsight.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.farsight.Constants;
import com.farsight.plants.Plant;
import com.farsight.screens.GameScreen;

public final class Garden {
	
	private int width;
	private int height;
	
	private Ground[][] groundGrid;
	private Ground currentGround;
	
	private Texture spriteSheetSoil;
	private TextureRegion plowedSoil;
	
	private TextureRegion grassTopLeft;
	private TextureRegion grassTopRight;
	private TextureRegion grassBottomRight;
	private TextureRegion grassBottomLeft;
	
	private TextureRegion grassTop;
	private TextureRegion grassBottom;
	private TextureRegion grassLeft;
	private TextureRegion grassRight;
	
	public Garden() {
		
		this.width = 10 + 2;
		this.height = 6 + 2;
		this.groundGrid = new Ground[this.height][this.width];
		this.currentGround = null;
		
		spriteSheetSoil = new Texture(Gdx.files.internal("plowed_soil.png"));
		plowedSoil = new TextureRegion(spriteSheetSoil, 32, 96, 32, 32);
		
		grassTopLeft     = new TextureRegion(spriteSheetSoil,  0,  64, 32, 32);
		grassTopRight    = new TextureRegion(spriteSheetSoil, 64,  64, 32, 32);
		grassBottomRight = new TextureRegion(spriteSheetSoil, 64, 128, 32, 32);
		grassBottomLeft  = new TextureRegion(spriteSheetSoil,  0, 128, 32, 32);
		
		grassTop    = new TextureRegion(spriteSheetSoil, 32,  64, 32, 32);
		grassBottom = new TextureRegion(spriteSheetSoil, 32, 128, 32, 32);
		grassLeft   = new TextureRegion(spriteSheetSoil,  0,  96, 32, 32);
		grassRight  = new TextureRegion(spriteSheetSoil, 64,  96, 32, 32);
		
		init();
	}
	
	private void init() {
		
		int gridWidth = groundGrid[0].length;
		int gridHeight = groundGrid.length;
		int gardenWidthPixels  = (int)(width  * Constants.TILE_WIDTH);
		int gardenHeightPixels = (int)(height * Constants.TILE_HEIGHT);
		int halfGardenWidth  = (int)(Math.floor(gardenWidthPixels  / 2));
		int halfGardenHeight = (int)(Math.floor(gardenHeightPixels / 2));
		int halfScreenWidth  = (int)(Gdx.graphics.getWidth()  / 2);
		float offsetY = Gdx.graphics.getHeight() - halfGardenHeight;
		int index = 0;
		
		for (int i = 0; i < height; i++) {
			
			float offsetX = halfScreenWidth - halfGardenWidth;
			
			for (int j = 0; j < width; j++) {
				
				Ground groundCell = null;
				float x = offsetX;
				float y = offsetY;
				
				// Top row
				if (i == 0) {
					
					if (j == 0) {
						
						groundCell = new Ground(x, y, grassTopLeft, GroundType.GRASS);
					}
					
					else if (j > 0 && j < (gridWidth - 1)) {
						
						groundCell = new Ground(x, y, grassTop, GroundType.GRASS);
					}
					
					else {
						
						groundCell = new Ground(x, y, grassTopRight, GroundType.GRASS);
					}
				}
				
				// Middle rows
				else if (i > 0 && i < (gridHeight - 1)) {
					
					if (j == 0) {
						
						groundCell = new Ground(x, y, grassLeft, GroundType.GRASS);
					}
					
					else if (j > 0 && j < (gridWidth - 1)) {
						
						groundCell = new Ground(index++, x, y, plowedSoil, GroundType.SOIL);
					}
					
					else {
						
						groundCell = new Ground(x, y, grassRight, GroundType.GRASS);
					}
				}
				
				// Bottom row
				else if (i == (gridHeight - 1)) {
					
					if (j == 0) {
						
						groundCell = new Ground(x, y, grassBottomLeft, GroundType.GRASS);
					}
					
					else if (j > 0 && j < (gridWidth - 1)) {
						
						groundCell = new Ground(x, y, grassBottom, GroundType.GRASS);
					}
					
					else {
						
						groundCell = new Ground(x, y, grassBottomRight, GroundType.GRASS);
					}
				}
				
				groundGrid[i][j] = groundCell;
				offsetX = offsetX + Constants.TILE_WIDTH;
			}
			
			offsetY = offsetY - Constants.TILE_HEIGHT;
		}
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public int getHeight() {
		
		return height;
	}
	
	public Ground[][] getGroundGrid() {
		
		return groundGrid;
	}
	
	public void plantSeed() {
		
		// TODO: implementation
		Vector3 cursor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		OrthographicCamera camera = GameScreen.getCamera();
		
		camera.unproject(cursor);
	}
	
	/*
	public void hydrate(int gallons) {
		
		// TODO: implementation
	}
	
	public void destroy(int x, int y) {
		
		// TODO: implementation
	}
	
	public Plant harvest(int x, int y) {
		
		// TODO: implementation
		return null;
	}
	*/
	
	public Ground getCurrentGround() {
		
		return currentGround;
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
				
				Ground ground = groundGrid[i][j];
				GroundType type = ground.getGroundType();
				
				if (type.equals(GroundType.SOIL)) {
					
					ground.update();
					
					if (ground.hovered()) {
						
						currentGround = ground;
					}
				}
				
				ground.render(spriteBatch);
			}
		}
	}
	
	public void update() {
		
		int lastTurns = World.instance().getSunDial().getLastNTurnsAndReset();
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
				
				Ground ground = groundGrid[i][j];
				GroundType type = ground.getGroundType();
				
				if (type.equals(GroundType.SOIL)) {
					
					Plant plant = ground.getPlant();
					
					if (plant != null) {
						
						plant.addTurns(lastTurns);
					}
				}
			}
		}
	}
	
	public void dispose() {
		
		spriteSheetSoil.dispose();
	}
}

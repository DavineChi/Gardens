package com.farsight.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.farsight.Constants;
import com.farsight.GameFont;
import com.farsight.plants.Carrot;
import com.farsight.plants.GrowthState;
import com.farsight.plants.Plant;
import com.farsight.screens.GameScreen;
import com.farsight.ui.ActivityLog;

public class Ground {
	
	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	
	private int index;
	private float x;
	private float y;
	
	private TextureRegion[] textureRegion = new TextureRegion[2];
	//private TextureRegion plowedSoilHovered;
	private GroundType groundType;
	private Rectangle boundingBox;
	private boolean hovered;
	private boolean clicked;
	private Plant plant;
	
	public Ground(float x, float y, TextureRegion textureRegion, GroundType groundType) {
		
		this(-1, x, y, textureRegion, groundType);
	}
	
	public Ground(int index, float x, float y, TextureRegion textureRegion, GroundType groundType) {
		
		this.index = index;
		this.x = x;
		this.y = y;
		this.textureRegion[0] = textureRegion;
		this.groundType = groundType;
		this.boundingBox = new Rectangle(this.x, this.y, Constants.TILE_WIDTH, Constants.TILE_HEIGHT);
		this.hovered = false;
		this.clicked = false;
		
		//Texture spriteSheetSoil = new Texture(Gdx.files.internal("plowed_soil_highlight.png"));
		//plowedSoilHovered = new TextureRegion(spriteSheetSoil, 32, 96, 32, 32);
	}
	
	public int getIndex() { return index; }
	public float getX() { return x; }
	public float getY() { return y; }
	
	public void setX(float x) { this.x = x; };
	public void setY(float y) { this.y = y; };
	
	public TextureRegion getTextureRegion(int layer) { return textureRegion[layer]; }
	public GroundType getGroundType() { return groundType; }
	public Rectangle getBoundingBox() { return boundingBox; }
	
	public boolean hovered() { return hovered; }
	public boolean clicked() { return clicked; }
	
	public Plant getPlant() { return plant; }
	
	public void addPlant(Plant plant) {
		
		this.plant = plant;
		this.textureRegion[1] = this.plant.getCurrentTexture();
	}
	
	public void removePlant() {
		
		this.textureRegion[1] = null;
		this.plant = null;
	}
	
	private void handleOnClick() {
		
		if (plant != null) {
			
			if (plant.getGrowthState() == GrowthState.DEAD) {
				
				String plantRemoved = plant.getName();
				
				removePlant();
				ActivityLog.addMessage("Removed: " + plantRemoved + " [index=" + index + "]");
			}
			
			return;
		}
		
		else {
			
			addPlant(new Carrot());
			ActivityLog.addMessage("Added: " + plant.getName() + " [index=" + index + "]");
		}
	}
	
	private void checkIfHovered() {
		
		Vector3 cursor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		OrthographicCamera camera = GameScreen.getCamera();
		
		camera.unproject(cursor);
		
		if (cursor.x > x && cursor.y > y && cursor.x < (x + Constants.TILE_WIDTH) && cursor.y < (y + Constants.TILE_HEIGHT)) {
			
			hovered = true;
		}
		
		else {
			
			hovered = false;
		}
	}
	
	public void setClicked(boolean value) {
		
		clicked = value;
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		Color tint = null;
		
		if (hovered) {
			
			tint = new Color(0.5f, 0.5f, 0.5f, 1.0f);
			//spriteBatch.draw(plowedSoilHovered, x, y);
			
			// Show 'status' info
			//gameFont.draw(spriteBatch, "Index: " + String.valueOf(index), 5.0f, 90.0f);
			gameFont.draw(spriteBatch, this.toString(), 5.0f, 72.0f);
		}
		
		else {
			
			tint = new Color(1.0f, 1.0f, 1.0f, 1.0f);
			//spriteBatch.draw(textureRegion, x, y);
		}
		
		spriteBatch.setColor(tint);
		spriteBatch.draw(textureRegion[0], x, y);
		
		// Draw the underlying Plant object
		if (textureRegion[1] != null) {
			
			spriteBatch.draw(textureRegion[1], x, y);
		}
	}
	
	public void update() {
		
		checkIfHovered();
		
		if (hovered) {
			
			if (clicked) {
				
				clicked = false;
				handleOnClick();
			}
		}
		
		if (plant != null) {
			
			plant.update();
			textureRegion[1] = plant.getCurrentTexture();
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		if (plant != null) {
			
			sb.append("Plant: " + plant.getName() + "\n");
			sb.append("Turns: " + plant.getTurns() + "\n");
			sb.append("  Age: " + plant.getAge() + "\n");
			sb.append("State: " + plant.getGrowthState().toString());
		}
		
		return sb.toString();
	}
}

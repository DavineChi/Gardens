package com.farsight.components;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.GameFont;
import com.farsight.entities.Item;
import com.farsight.plants.Carrot;

public class Market {
	
	private static final float X_POS = 200.0f;
	private static final float Y_POS = 200.0f;
	
	private static BitmapFont gameFont = GameFont.instance().getFont10();
	
	private String name;
	private Map<Item, Integer> inventory;
	
	private Texture texture;
	
	private float textureHeight;
	
	public Market(String name) {
		
		this.name = name;
		this.inventory = new HashMap<Item, Integer>();
		this.texture = new Texture(Gdx.files.internal("market.png"));
		
		Item item = new Carrot();
		
		inventory.put(item, 17);
	}
	
	public void addItem() {
		
		
	}
	
	public Item getAndRemoveItem(Item item) {
		
		return null;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		spriteBatch.draw(texture, X_POS, Y_POS);
		
		float x = X_POS + 5;
		float y = Y_POS + 107.0f;
		
		for (Entry<Item, Integer> entry : inventory.entrySet()) {
			
			Item item = entry.getKey();
			int quantity = entry.getValue();
			
			if (item != null) {
				
				// TODO: make Market (x,y) Item positions drawable by simple x,y index values
				spriteBatch.draw(item.getCurrentTexture(), x, y);
				gameFont.draw(spriteBatch, String.valueOf(quantity), x + 4, y + 30);
			}
		}
	}
	
	public void update() {
		
		
	}
	
	public void dispose() {
		
		texture.dispose();
	}
}

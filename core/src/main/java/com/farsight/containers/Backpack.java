package com.farsight.containers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.entities.Item;

public class Backpack extends Container {
	
	private static final int MAX_SIZE = 16;
	private static Backpack backpack = null;
	private Texture backpackTexture;
	private Item[] items;
	
	private Backpack() {
		
		this.backpackTexture = new Texture(Gdx.files.internal("backpack.png"));
		this.items = new Item[MAX_SIZE];
	}
	
	public static Backpack instance() {
		
		if (backpack == null) {
			
			backpack = new Backpack();
		}
		
		return backpack;
	}
	
	public void addItem(Item item) {
		
		// TODO: implementation
	}
	
	public Item removeItem(int index) {
		
		Item result = null;
		
		// TODO: implementation
		
		return result;
	}
	
	public void destroyItem(int index) {
		
		if (index < 0 || index > (MAX_SIZE - 1)) {
			
			return;
		}
		
		if (items[index] != null) {
			
			items[index] = null;
		}
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		spriteBatch.draw(backpackTexture, 646, 10);
		
		for (int i = 0; i < items.length; i++) {
			
			
		}
	}
	
	public void update() {
		
		
	}
}

package com.farsight;

import java.util.Arrays;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu {
	
	private static final int INITIAL_CAPACITY = 5;
	
	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	
	private int id;
	private String name;
	private MenuItem[] items;
	private int capacity;
	private int size;
	
	/**************************************************************************************************
	 * Creates a new Menu with the specified id and name.
	 * 
	 * @param id - simple identifier
	 * @param name - the name of this Menu
	 * 
	 */
	public Menu(int id, String name) {
		
		this.id = id;
		this.name = name;
		this.capacity = INITIAL_CAPACITY;
		this.size = 0;
		this.items = new MenuItem[INITIAL_CAPACITY];
	}
	
	private class MenuItem {
		
		private String symbol;
		private String text;
		
		public MenuItem(String symbol, String text) {
			
			this.symbol = symbol;
			this.text = text;
		}
		
		public String toString() {
			
			return " [" + symbol + "] " + text;
		}
	}
	
	public int getId() {
		
		return id;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void addItem(String symbol, String text) {
		
		MenuItem menuItem = new MenuItem(symbol, text);
		MenuItem[] itemsCopy;
		
		if ((size + 1) > capacity) {
			
			capacity = items.length + 5;
			itemsCopy = Arrays.copyOfRange(items, 0, capacity);
			items = itemsCopy;
		}
		
		items[size] = menuItem;
		
		size++;
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		String message;
		
		if (size == 1) {
			
			message = " Not much to do here:";
		}
		
		else {
			
			message = " Please choose:";
		}
		
		float xPos = 20.0f;
		float yPos = 240.0f;
		
		gameFont.draw(spriteBatch, message, xPos, yPos);
		
		yPos = 260.0f;
		
		for (int i = 0; i < size; i++) {
			
			String item = items[i].toString();
			
			gameFont.draw(spriteBatch, item, xPos, yPos);
			
			yPos = yPos + 20.0f;
		}
	}
}

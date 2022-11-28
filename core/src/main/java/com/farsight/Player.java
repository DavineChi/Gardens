package com.farsight;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.containers.SeedBag;
import com.farsight.entities.Item;

public class Player {
	
	private static Player player;
	
	private String name;
	private int currency;
	private SeedBag bag;
	
	@SuppressWarnings("unused")
	private Item equippedItem;
	
	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	
	public Player() {
		
		this.name = "";
		this.currency = 0;
		this.bag = new SeedBag();
		
		// TODO: fixme
		//this.bag.addPacket(new Packet(new Cucumber(), 1200, 449));
		
		this.equippedItem = null;
	}
	
	public static Player instance() {
		
		if (player == null) {
			
			player = new Player();
		}
		
		return player;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public int getCurrency() {
		
		return currency;
	}
	
	public void addCurrency(int amount) {
		
		currency = currency + amount;
	}
	
	public SeedBag getBag() {
		
		return bag;
	}
	
	public void equipItem(Item item) {
		
		equippedItem = item;
	}
	
	public void update() {
		
		// TODO: implementation
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		gameFont.draw(spriteBatch, " Name: " + name, 500.0f, 10.0f);
		gameFont.draw(spriteBatch, "Money: " + currency, 500.0f, 30.0f);
	}
}

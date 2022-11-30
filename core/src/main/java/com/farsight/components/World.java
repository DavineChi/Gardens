package com.farsight.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.Player;

public class World {
	
	private static World world = null;
	
	private SunDial sunDial;
	private Player player;
	private Garden garden;
	private Market market;
	private boolean keyTDown;
	
	private boolean displayGarden;
	private boolean displayMarket;
	
	private World() {
		
		this.sunDial = new SunDial();
		this.player = new Player();
		this.garden = new Garden();
		this.market = new Market("Happy Hops");
		this.keyTDown = false;
		this.displayGarden = true;
		this.displayMarket = false;
	}
	
	public static World instance() {
		
		if (world == null) {
			
			world = new World();
		}
		
		return world;
	}
	
	public SunDial getSunDial() {
		
		return sunDial;
	}
	
	public Player getPlayer() {
		
		return player;
	}
	
	public void setPlayer(Player player) {
		
		this.player = player;
	}
	
	public Garden getGarden() {
		
		return garden;
	}
	
	public Market getMarket() {
		
		return market;
	}
	
	public void setKeyTDown(boolean value) {
		
		keyTDown = value;
	}
	
	public void addTurns(int turns) {
		
		sunDial.addTurns(turns);
	}
	
	
	public void toggleShowMarket() {
		
		if (displayMarket) {
			
			displayGarden = true;
			displayMarket = false;
		}
		
		else {
			
			displayGarden = false;
			displayMarket = true;
		}
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		if (displayMarket) {
			
			market.render(spriteBatch);
		}
		
		if (displayGarden) {
			
			sunDial.render(spriteBatch);
			garden.render(spriteBatch);
		}
	}
	
	public void update() {
		
		if (keyTDown) {
			
			keyTDown = false;
			sunDial.addTurns(1);
		}
		
		sunDial.update();
		player.update();
		garden.update();
	}
	
	public void dispose() {
		
		garden.dispose();
		market.dispose();
	}
}

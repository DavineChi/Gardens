package com.farsight.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InfoPanel extends Panel {
	
	private String text;
	
	public InfoPanel(float x, float y) {
		
		this.text = "";
		this.x = x;
		this.y = y;
	}
	
	public String getText() {
		
		return text;
	}
	
	public void setText(String text) {
		
		this.text = text;
	}
	
	@Override
	public void render(SpriteBatch spriteBatch) {
		
		Panel.font.draw(spriteBatch, "HIHIHIHI!", x, y);
		update();
	}
	
	private void update() {
		
		
	}
}

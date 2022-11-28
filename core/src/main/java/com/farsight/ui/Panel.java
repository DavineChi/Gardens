package com.farsight.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.GameFont;

public abstract class Panel {
	
	public static final BitmapFont font = GameFont.instance().getFont12();
	
	protected String id = "";
	protected float x;
	protected float y;
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public float getX() { return x; }
	public float getY() { return y; }
	
	public void setX(float x) { this.x = x; }
	public void setY(float y) { this.y = y; }
	
	public abstract void render(SpriteBatch spriteBatch);
}

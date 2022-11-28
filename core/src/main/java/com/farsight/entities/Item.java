package com.farsight.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Item extends GameObject {
	
	protected String name;
	protected TextureRegion currentTexture;
	
	public String getName() { return name; }
	public TextureRegion getCurrentTexture() { return currentTexture; }
}

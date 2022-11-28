package com.farsight.util;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.GameFont;

public class ScreenLog {

	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	
	public static void printMessage(SpriteBatch batch, String message, float x, float y) {
		
		gameFont.draw(batch, message, x, y);
	}
}

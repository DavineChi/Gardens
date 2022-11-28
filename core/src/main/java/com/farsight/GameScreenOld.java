package com.farsight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreenOld {
	
	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	
	private static List<String> splashOutput = new ArrayList<String>();
	
	private static float xPos = 10.0f;
	private static float yPos = 0.0f;
	
	public static void init() {
		
		ClassLoader classLoader = GameScreenOld.class.getClassLoader();
		InputStream stream = classLoader.getResourceAsStream(Constants.SPLASH_SCREEN);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));	
		
		try {
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				
				splashOutput.add(line);
			}
		}
		
		catch (IOException ex) {
			
			ex.printStackTrace();
		}
	}
	
	public static void renderSplashScreen(SpriteBatch spriteBatch) {
		
		for (int i = 0; i < splashOutput.size(); i++) {
			
			String line = splashOutput.get(i);
			
			gameFont.draw(spriteBatch, line, xPos, yPos);
			
			incrementYPos();
		}
		
		incrementYPos(40.0f);
		
		String message = "Press [Enter] to proceed...";
		
		gameFont.draw(spriteBatch, message, xPos, yPos);
		
		yPos = 0.0f;
	}
	
	private static void incrementYPos() {
		
		yPos = yPos + 13;
	}
	
	private static void incrementYPos(float value) {
		
		yPos = yPos + value;
	}
}

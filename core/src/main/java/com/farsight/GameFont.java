package com.farsight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameFont {
	
	private static GameFont gameFont = null;
	
	private FreeTypeFontGenerator generatorFont9;
	private FreeTypeFontGenerator generatorFont10;
	private FreeTypeFontGenerator generatorFont12;
	private FreeTypeFontGenerator generatorFont14;
	private FreeTypeFontGenerator generatorFont16;
	
	private BitmapFont font9;
	private BitmapFont font10;
	private BitmapFont font12;
	private BitmapFont font14;
	private BitmapFont font16;
	
	private GameFont() {
		
		FreeTypeFontParameter paramFont9 = new FreeTypeFontParameter();
		FreeTypeFontParameter paramFont10 = new FreeTypeFontParameter();
		FreeTypeFontParameter paramFont12 = new FreeTypeFontParameter();
		FreeTypeFontParameter paramFont14 = new FreeTypeFontParameter();
		FreeTypeFontParameter paramFont16 = new FreeTypeFontParameter();
		
		generatorFont9 = new FreeTypeFontGenerator(Gdx.files.internal("fonts/DejaVuSans-ExtraLight.ttf"));
		generatorFont10 = new FreeTypeFontGenerator(Gdx.files.internal("fonts/DejaVuSans-ExtraLight.ttf"));
		generatorFont12 = new FreeTypeFontGenerator(Gdx.files.internal("fonts/DejaVuSansMono.ttf"));
		generatorFont14 = new FreeTypeFontGenerator(Gdx.files.internal("fonts/DejaVuSansMono.ttf"));
		generatorFont16 = new FreeTypeFontGenerator(Gdx.files.internal("fonts/DejaVuSansMono.ttf"));
		
		paramFont9.size = 9;
		paramFont10.size = 10;
		paramFont12.size = 12;
		paramFont14.size = 14;
		paramFont16.size = 16;
		
		font9 = generatorFont9.generateFont(paramFont9);
		font10 = generatorFont10.generateFont(paramFont10);
		font12 = generatorFont12.generateFont(paramFont12);
		font14 = generatorFont14.generateFont(paramFont14);
		font16 = generatorFont16.generateFont(paramFont16);
	}
	
	public static GameFont instance() {
		
		if (gameFont == null) {
			
			gameFont = new GameFont();
		}
		
		return gameFont;
	}
	
	public BitmapFont getFont9() {
		
		return font9;
	}
	
	public BitmapFont getFont10() {
		
		return font10;
	}
	
	public BitmapFont getFont12() {
		
		return font12;
	}
	
	public BitmapFont getDefaultFont() {
		
		return font14;
	}
	
	public BitmapFont getFont16() {
		
		return font16;
	}
	
	public void dispose() {
		
		generatorFont9.dispose();
		generatorFont12.dispose();
	}
}

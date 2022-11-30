package com.farsight.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.farsight.GardenGame;
import com.farsight.screens.GameScreen;

public class TitleInputProcessor implements InputProcessor {
	
	private GardenGame game;
	
	public TitleInputProcessor(final GardenGame game) {
		
		this.game = game;
	}
	
	private void setGameScreen() {
		
		game.setScreen(new GameScreen(game));
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		if (keycode == Input.Keys.ENTER) {
			
			setGameScreen();
		}
		
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean keyTyped(char character) {
		
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (button == Buttons.LEFT) {
			
			setGameScreen();
		}
		
		return true;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean scrolled(float amountX, float amountY) {
		
		// TODO Auto-generated method stub
		return false;
	}
}

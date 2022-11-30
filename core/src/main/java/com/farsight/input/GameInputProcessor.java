package com.farsight.input;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.farsight.components.Ground;
import com.farsight.components.World;
import com.farsight.ui.UserInterface;

public class GameInputProcessor implements InputProcessor {
	
	private static GameInputProcessor gameInputProcessor;
	private static World world = World.instance();
	private static UserInterface ui = UserInterface.instance();
	
	private GameInputProcessor() {
		
		
	}
	
	public static GameInputProcessor instance() {
		
		if (gameInputProcessor == null) {
			
			gameInputProcessor = new GameInputProcessor();
		}
		
		return gameInputProcessor;
	}
	
	private void processGroundClick(int button) {
		
		Ground currentGround = world.getGarden().getCurrentGround();
		
		if (currentGround != null) {
			
			switch (button) {
				
				case Buttons.LEFT:
					currentGround.setLeftClicked(true);
					break;
					
				case Buttons.RIGHT:
					currentGround.setRightClicked(true);
					break;
			}
		}
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		switch (keycode) {
			
			case Keys.T:
				world.setKeyTDown(true);
				break;
				
			case Keys.B:
				ui.toggleShowBackpack();
				break;
				
			case Keys.M:
				world.toggleShowMarket();
				break;
		}
		
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		
		switch (keycode) {
			
			case Keys.T:
				world.setKeyTDown(false);
				break;
		}
		
		return true;
	}
	
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		switch (button) {
			
			case Keys.T:
				world.setKeyTDown(true);
				break;
				
			case Buttons.LEFT:
				processGroundClick(button);
				break;
				
			case Buttons.RIGHT:
				processGroundClick(button);
				break;
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

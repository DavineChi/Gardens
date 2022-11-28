package com.farsight.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.containers.Backpack;

public class UserInterface {
	
	private static UserInterface userInterface = null;
	
	private ActivityLog activityLog;
	private InfoPanel cursorInfoPanel;
	private Backpack backpack;
	
	private boolean displayBackpack;
	
	private UserInterface() {
		
		this.activityLog = ActivityLog.instance();
		this.cursorInfoPanel = new InfoPanel(500, 10);
		this.backpack = Backpack.instance();
		
		this.displayBackpack = false;
	}
	
	public static UserInterface instance() {
		
		if (userInterface == null) {
			
			userInterface = new UserInterface();
		}
		
		return userInterface;
	}
	
	public InfoPanel getCursorInfoPanel() {
		
		return cursorInfoPanel;
	}
	
	public void toggleShowBackpack() {
		
		if (displayBackpack) {
			
			displayBackpack = false;
		}
		
		else {
			
			displayBackpack = true;
		}
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		activityLog.render(spriteBatch);
		//cursorInfoPanel.render(spriteBatch);
		
		if (displayBackpack) {
			
			backpack.render(spriteBatch);
		}
	}
	
	public void update() {
		
		
	}
}

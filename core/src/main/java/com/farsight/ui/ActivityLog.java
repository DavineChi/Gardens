package com.farsight.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.Constants;
import com.farsight.GameFont;

public class ActivityLog {
	
	private static final int BUFFER = 5;
	private static ActivityLog activityLog;
	private static List<String> log = new ArrayList<String>();
	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	
	private float messageX;
	private float messageY;
	
	private ActivityLog() {
		
		this.messageX = 5.0f;
		this.messageY = (float)(Constants.WINDOW_HEIGHT - 80);
	}
	
	public static ActivityLog instance() {
		
		if (activityLog == null) {
			
			activityLog = new ActivityLog();
		}
		
		return activityLog;
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		Iterator<String> iterator = log.iterator();
		this.messageY = (float)(Constants.WINDOW_HEIGHT - 80);
		
		for (int i = 0; i < BUFFER; i++) {
			
			if (iterator.hasNext()) {
				
				String next = iterator.next();
				
				gameFont.draw(spriteBatch, next, messageX, messageY);
				update();
			}
		}
	}
	
	private void update() {
		
		messageY = messageY + 18.0f;
	}
	
	public static void addMessage(String message) {
		
		log.add(0, message);
	}
}

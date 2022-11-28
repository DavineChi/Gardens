package com.farsight.components;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.GameFont;

public class SunDial {
	
	private static final int MINUTES_PER_TURN = 5;
	private static final float COORD_X = 650.0f;
	
	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	
	private int turns;
	private int lastNTurns;
	private String[] clock;
	private int day;
	private int hour;
	private int minute;
	private Meridiem meridiem;
	private String time;
	private int meridiemAccumulator;
	
	private enum Meridiem {
		
		AM, PM
	}
	
	public SunDial() {
		
		this.turns = 0;
		this.lastNTurns = 0;
		this.clock = new String[3];
		this.day = 1;
		this.meridiem = Meridiem.AM;
		this.meridiemAccumulator = 0;
		
		refresh();
	}
	
	public static String parseTurns(int turns) {
		
		String result = "";
		String[] parts = new String[3];
		double quotient = (double)(turns * MINUTES_PER_TURN) / (double)(60.0);
		
		int day = (int)(Math.floor((turns * MINUTES_PER_TURN) / 1440));
		int hour = (int)(Math.floor(quotient)) % 12;
		int minute = (int)((turns * MINUTES_PER_TURN) % 60);
		
		if (hour == 24) {
			
			hour = 0;
			day = day + 1;
		}
		
		String suffixDay = (day == 1 ? "day" : "days");
		String suffixHour = (hour == 1 ? "hour" : "hours");
		String suffixMinute = (minute == 1 ? "minute" : "minutes");
		
		parts[0] = String.valueOf(day);
		parts[1] = String.valueOf(hour);
		parts[2] = String.valueOf(minute);
		
		result = parts[0] + " " + suffixDay + ", " + parts[1] + " " + suffixHour + ", " + parts[2] + " " + suffixMinute;
		
		return result;
	}
	
	private void refresh() {
		
		boolean meridiemChange = (double)((meridiemAccumulator * MINUTES_PER_TURN) / 720) >= (double)(1.0);
		double quotient = (double)(turns * MINUTES_PER_TURN) / (double)(60.0);
		
		hour = (int)(Math.floor(quotient)) % 12;
		minute = (int)((turns * MINUTES_PER_TURN) % 60);
		day = (int)(Math.floor((turns * MINUTES_PER_TURN) / 1440) + 1);
		
		if (hour == 0) {
			
			hour = 12;
		}
		
		if (meridiemChange) {
			
			flipMeridiem();
		}
		
		clock[0] = String.format("%1$2s", String.valueOf(hour)).replace(' ', '0');
		clock[1] = String.format("%1$2s", String.valueOf(minute)).replace(' ', '0');
		clock[2] = meridiem.toString().toLowerCase();
		
		time = clock[0] + ":" + clock[1] + " " + clock[2];
	}
	
	private void flipMeridiem() {
		
		if (meridiem == Meridiem.AM) {
			
			meridiem = Meridiem.PM;
		}
		
		else {
			
			meridiem = Meridiem.AM;
		}
		
		meridiemAccumulator = 0;
	}
	
	public void addTurns(int nTurns) {
		
		lastNTurns = nTurns;
		turns = turns + nTurns;
		meridiemAccumulator = meridiemAccumulator + nTurns;
	}
	
	public int getTurns() {
		
		return turns;
	}
	
	public int getLastNTurnsAndReset() {
		
		int result = lastNTurns;
		lastNTurns = 0;
		
		return result;
	}
	
	public int getDay() {
		
		return day;
	}
	
	public String getTime() {
		
		String result = clock[0] + ":" + clock[1] + " " + clock[2];
		
		return result;
	}
	
	public void update() {
		
		refresh();
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		gameFont.draw(spriteBatch, " Time: " + time, COORD_X, 470.0f);
		gameFont.draw(spriteBatch, "Turns: " + turns, COORD_X,  450.0f);
		gameFont.draw(spriteBatch, "  Day: " + day, COORD_X,  430.0f);
	}
}

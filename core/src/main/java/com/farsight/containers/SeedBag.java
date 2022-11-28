package com.farsight.containers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farsight.GameFont;
import com.farsight.Packet;

public class SeedBag extends Container {
	
	private static final int INITIAL_CAPACITY = 5;
	
	private static BitmapFont gameFont = GameFont.instance().getDefaultFont();
	
	private Packet[] packets;
	private int capacity;
	private int size;
	
	public SeedBag() {
		
		this.id = "Seed Bag";
		this.capacity = INITIAL_CAPACITY;
		this.size = 0;
		this.packets = new Packet[INITIAL_CAPACITY];
	}
	
	/**************************************************************************************************
	 * Returns the capacity of this Bag object.
	 * 
	 * @return
	 *   The capacity of this Bag.
	 */
	public int getCapacity() {
		
		return capacity;
	}
	
	/**************************************************************************************************
	 * Returns the size of this Bag object.
	 * 
	 * @return
	 *   The size of this Bag.
	 */
	public int size() {
		
		return size;
	}
	
	/**************************************************************************************************
	 * Checks if this Bag object is full.
	 * 
	 * @return
	 *   True if this Bag is full, false otherwise.
	 */
	public boolean isFull() {
		
		boolean result = size == capacity;
		
		return result;
	}
	
	public Packet getPacket(int index) {
		
		Packet result = null;
		
		index--;
		
		if (index < size) {
			
			result = packets[index];
		}
		
		return result;
	}
	
	public boolean addPacket(Packet packet) {
		
		if ((size + 1) > capacity) {
			
			return false;
		}
		
		else {
			
			packets[size] = packet;
			
			size++;
			
			return true;
		}
	}
	
	public boolean removePacket(int index) {
		
		if (index < 0 || index >= size) {
			
			return false;
		}
		
		else {
			
			index--;
			packets[index] = null;
			
			sort();
			
			size--;
			
			return true;
		}
	}
	
	private void sort() {
		
		for (int i = 0; i < packets.length; i++) {
			
			int next = i + 1;
			
			if (packets[i] == null) {
				
				if (next < packets.length && packets[next] != null) {
					
					packets[i] = packets[next];
					packets[next] = null;
				}
			}
		}
	}
	
	public void update() {
		
		
	}
	
	public void render(SpriteBatch spriteBatch) {
		
		float xPos = 500.0f;
		float yPos = 210.0f;
		
		gameFont.draw(spriteBatch, id, xPos, yPos);
		
		yPos = 230.0f;
		
		for (int i = 0; i < size; i++) {
			
			String item = "[" + (i + 1) + "] " + packets[i].toString();
			
			gameFont.draw(spriteBatch, item, xPos, yPos);
			
			yPos = yPos + 20.0f;
		}
	}
}

package com.farsight;

import com.farsight.plants.Plant;

public class Packet {
	
	private Plant plant;
	private int milligrams;
	private int numberOfSeeds;
	private int sellPrice;
	
	/*************************************************************************
	 * Constructor for a new Packet of the specified plant and seed quantity.
	 * 
	 * @param plant - the specified plant
	 * @param milligrams - quantity of seeds in this packet
	 * @param sellPrice - the current sell price of this packet
	 */
	public Packet(Plant plant, int milligrams, int sellPrice) {
		
		this.plant = plant;
		this.milligrams = milligrams;
		this.numberOfSeeds = Util.getNumberOfSeedsByPlantAndWeight(plant, milligrams);
		this.sellPrice = sellPrice;
	}
	
	public Plant getPlant() {
		
		return plant;
	}
	
	public int getMilligrams() {
		
		return milligrams;
	}
	
	public int getNumberOfSeeds() {
		
		return numberOfSeeds;
	}
	
	public int getSellPrice() {
		
		return sellPrice;
	}
	
	@Override
	public String toString() {
		
		return plant.getName() + ", " + milligrams + " mg - $ " + sellPrice;
	}
}

package com.farsight;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.farsight.plants.Plant;

public class Util {
	
	public static int getNumberOfSeedsByPlantAndWeight(Plant plant, int milligrams) {
		
		int[] range = Util.getSeedsPerGramRangeByPlant(plant);
		int nRandomSeedsPerGram = ThreadLocalRandom.current().nextInt(range[0], range[1] + 1);
		double grams = (double)(milligrams) / 1000;
		
		int result = (int)(Math.floor(nRandomSeedsPerGram * grams));
		
		return result;
	}
	
	public static int getNumberOfSeedsByPacket(Packet packet) {
		
		Plant plant = packet.getPlant();
		int milligrams = packet.getMilligrams();
		int result = Util.getNumberOfSeedsByPlantAndWeight(plant, milligrams);
		
		return result;
	}
	
	public static int[] getSeedsPerGramRangeByPlant(Plant plant) {
		
		Map<String, int[]> map = new HashMap<String, int[]>();
		
		map.put("cucumber",    new int[] { 30,  45   });
		map.put("tomato",      new int[] { 250, 380  });
		map.put("onion",       new int[] { 250, 400  });
		map.put("bell_pepper", new int[] { 150, 200  });
		map.put("carrot",      new int[] { 400, 1200 });
		
		int[] result = map.get(plant.getName());
		
		return result;
	}
}

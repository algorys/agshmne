package io.github.algorys.agshmne.tools;

import java.util.Random;

public class RandomCoordinated {
	private int coordinated;
	
	public RandomCoordinated(int max, int min) {
		int range = max - min + 1;
		Random rand = new Random();
		coordinated = rand.nextInt(range) + min;
	}

	public int getCoordinated() {
		return coordinated;
	}
	
	
}

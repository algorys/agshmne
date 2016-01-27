package io.github.algorys.agshmne.movement;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.tools.RandomCoordinated;

public class RandomCoordonnateTest {

	@Test
	public void test() {
		int min = -10;
		int max = 10;
		boolean hasMin = false;
		boolean hasMax = false;
		
		for(int i = 0; i < 500; i++) {
			RandomCoordinated underTest = new RandomCoordinated(max, min);
			assertTrue("Erreur, la coordonnée est trop haute", underTest.getCoordinated() <= max);
			assertTrue("Erreur, la coordonnée est trop basse", underTest.getCoordinated() >= min);
			if(underTest.getCoordinated() == min) {hasMin = true;}
			if(underTest.getCoordinated() == max) {hasMax = true;}
		}
		assertTrue("Pas vu min", hasMin);
		assertTrue("Pas vu max", hasMax);
			

	}

}

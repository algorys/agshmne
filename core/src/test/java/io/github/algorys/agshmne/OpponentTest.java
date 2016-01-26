package io.github.algorys.agshmne;

import io.github.algorys.agshmne.opponent.beast.Beast;
import io.github.algorys.agshmne.opponent.beast.BeastFactory;

public class OpponentTest {

	public static void main(String[] args) {
		// Test Factory
		BeastFactory beastFact = new BeastFactory();
		Beast wolf = beastFact.createBeast();
		System.out.println(wolf.toString());
	}

}

package io.github.algorys.agshmne.character.opponent.beast;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BeastFactoryTest {

	@Test
	public void oneBeastShouldHaveAttributes() {
		BeastFactory beastFact = new BeastFactory();
		Beast wolf = beastFact.createBeast();
		assertTrue(wolf.getCurrentAttributes()!= null);
	}
	
	@Test
	public void oneBeastShouldHaveALevel() {
		BeastFactory beastFact = new BeastFactory();
		Beast wolf = beastFact.createBeast();
		assertTrue(wolf.getLevel() > 0);
	}
	
	@Test
	public void beastFactShouldCreateABeast() {
		BeastFactory beastFact = new BeastFactory();
		assertTrue(beastFact.createBeast() instanceof Beast);
	}

}

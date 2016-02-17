package io.github.algorys.agshmne.events.locality;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;

public class LocalityFactoryTest {

	@Test
	public void testLocalityFactory() {
		LocalityFactory underTest = new LocalityFactory();
		Locality locality = underTest.createAdventure(new PlayerBuilder().create());
		assertNotNull(locality);
	}
	
	@Test
	public void test() {
		LocalityFactory underTest = new LocalityFactory();
		Player pj = new PlayerBuilder().create();
		Locality locality = underTest.createAdventure(pj);
		Locality second = underTest.createAdventure(pj);
		assertNotNull(locality);
		assertNotSame(locality, second);
	}

}

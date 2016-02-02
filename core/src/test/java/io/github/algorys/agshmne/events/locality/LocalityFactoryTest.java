package io.github.algorys.agshmne.events.locality;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;

public class LocalityFactoryTest {

	@Test
	public void testLocalityFactory() {
		LocalityFactory underTest = new LocalityFactory();
		Region region = new RandomRegionFactory().create();
		Locality locality = underTest.createAdventure(new Player(region));
		assertNotNull(locality);
	}
	
	@Test
	public void test() {
		LocalityFactory underTest = new LocalityFactory();
		Region region = new RandomRegionFactory().create();
		Locality locality = underTest.createAdventure(new Player(region));
		Locality second = underTest.createAdventure(new Player(region));
		assertNotNull(locality);
		assertNotSame(locality, second);
	}

}

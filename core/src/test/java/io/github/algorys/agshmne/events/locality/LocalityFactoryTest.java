package io.github.algorys.agshmne.events.locality;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import io.github.algorys.agshmne.adventure.locality.Locality;
import io.github.algorys.agshmne.adventure.locality.LocalityFactory;

public class LocalityFactoryTest {

	@Test
	public void testLocalityFactory() {
		LocalityFactory underTest = new LocalityFactory();
		Locality locality = underTest.createAdventure(null);
		assertNotNull(locality);
	}
	
	@Test
	public void test() {
		LocalityFactory underTest = new LocalityFactory();
		Locality locality = underTest.createAdventure(null);
		Locality second = underTest.createAdventure(null);
		assertNotNull(locality);
		assertNotSame(locality, second);
	}

}

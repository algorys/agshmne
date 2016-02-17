package io.github.algorys.agshmne.events.locality;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

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

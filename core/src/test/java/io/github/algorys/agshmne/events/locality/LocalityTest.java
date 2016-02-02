package io.github.algorys.agshmne.events.locality;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;

public class LocalityTest {

	@Test
	public void testLocalityNotNull() {
		String locality = "Fontaine:PDV10:"+
				"Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Region region = new RandomRegionFactory().create();
		Locality underTest = new Locality(locality, new Player(region));
		assertNotNull(underTest);
	}
	
	@Test
	public void testLocalityGetGoodName() {
		String locality = "Fontaine:PDV10:"+
				"Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Region region = new RandomRegionFactory().create();
		Locality underTest = new Locality(locality, new Player(region));
		assertEquals(underTest.getName(), "Fontaine");
	}
	
	@Test
	public void testLocalityGetGoodDesc() {
		String locality = "Statue:PDV5:"+
				"Une statue représentant un ange déversant des flots sur un corps inanimé.";
		Region region = new RandomRegionFactory().create();
		Locality underTest = new Locality(locality, new Player(region));
		assertEquals(underTest.getDesc(), "Une statue représentant un ange déversant des flots sur un corps inanimé.");
	}

}

package io.github.algorys.agshmne.events.locality;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;

public class LocalityTest {

	@Test
	public void testLocalityNotNull() {
		String locality = "Fontaine:PDV10:"
				+ "Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Region region = new RandomRegionFactory().create();
		Locality underTest = new Locality(locality, new Player(region));
		assertNotNull(underTest);
	}

	@Test
	public void testLocalityGetGoodName() {
		String locality = "Fontaine:PDV10:"
				+ "Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Region region = new RandomRegionFactory().create();
		Locality underTest = new Locality(locality, new Player(region));
		assertEquals(underTest.getName(), "Fontaine");
	}

	@Test
	public void testLocalityGetGoodDesc() {
		String locality = "Statue:PDV5:" + "Une statue représentant un ange déversant des flots sur un corps inanimé.";
		Region region = new RandomRegionFactory().create();
		Locality underTest = new Locality(locality, new Player(region));
		assertEquals(underTest.getDesc(), "Une statue représentant un ange déversant des flots sur un corps inanimé.");
	}

	@Test
	public void testLocalityShouldHaveTheGoodEffectWhenApply() {
		String locality = "Statue:PDV10:" + "Une statue représentant un ange déversant des flots sur un corps inanimé.";
		Region region = new RandomRegionFactory().create();
		Player pj = new Player(region);
		pj.initVital();
		pj.getVital().setVie(10);
		Locality underTest = new Locality(locality, pj);
		assertEquals(underTest.getDesc(), "Une statue représentant un ange déversant des flots sur un corps inanimé.");
		assertEquals(pj.getVital().getVie(), 10);
		underTest.interact(pj);
		assertTrue(pj.getVital().getVie() == 0 || pj.getVital().getVie() == 20);
	}

	// TODO test mana et competences.
}

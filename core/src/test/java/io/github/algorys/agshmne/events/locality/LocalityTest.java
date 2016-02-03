package io.github.algorys.agshmne.events.locality;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;

public class LocalityTest {

	@Test
	public void testLocalityNotNull() {
		String locality = "Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Locality underTest = new Locality("Fontaine", "PDV10", locality);
		assertNotNull(underTest);
	}

	@Test
	public void testLocalityGetGoodName() {
		String locality = "Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Locality underTest = new Locality("Fontaine", "PDV10", locality);
		assertEquals(underTest.getName(), "Fontaine");
	}

	@Test
	public void testLocalityGetGoodDesc() {
		String locality = "Une statue représentant un ange déversant des flots sur un corps inanimé.";
		Locality underTest = new Locality("Statue", "PDV5", locality);
		assertEquals(underTest.getDesc(), "Une statue représentant un ange déversant des flots sur un corps inanimé.");
	}

	@Test
	public void testLocalityShouldChangeLifeWhenInteract() {
		String locality = "Une statue représentant un ange déversant des flots sur un corps inanimé.";
		Player pj = new Player(null);
		pj.initVital();
		pj.getVital().setVie(10);
		Locality underTest = new Locality("Statue", "PDV10", locality);
		assertEquals(underTest.getDesc(), "Une statue représentant un ange déversant des flots sur un corps inanimé.");
		assertEquals(pj.getVital().getVie(), 10);
		underTest.interact(pj);
		assertTrue(pj.getVital().getVie() == 0 || pj.getVital().getVie() == 20);
	}
	
	@Test
	public void testLocalityShouldChangeManaWhenInteract() {
		String locality = "Un verger luxurieux qui semblent vous acceuillir à bras ouvert.";
		Player pj = new Player(null);
		pj.initVital();
		pj.getVital().setMana(10);
		Locality underTest = new Locality("Verger", "MAN10", locality);
		
		assertEquals(underTest.getName(), "Verger");
		assertEquals(underTest.getDesc(), "Un verger luxurieux qui semblent vous acceuillir à bras ouvert.");
		assertEquals(pj.getVital().getMana(), 10);
		underTest.interact(pj);
		assertTrue(pj.getVital().getMana() == 0 || pj.getVital().getMana() == 20);
	}

	// TODO test mana et competences.
}

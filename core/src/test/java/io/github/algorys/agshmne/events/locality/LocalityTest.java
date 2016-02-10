package io.github.algorys.agshmne.events.locality;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.effect.LifeEffect;
import io.github.algorys.agshmne.effect.ManaEffect;

public class LocalityTest {

	@Test
	public void testLocalityNotNull() {
		String locality = "Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Locality underTest = new Locality("Fontaine", null, locality, "Affecte votre vie !");
		assertNotNull(underTest);
	}

	@Test
	public void testLocalityGetGoodName() {
		String locality = "Une fontaine représentant un ange déversant des flots sur un corps inanimé.";
		Locality underTest = new Locality("Fontaine", null, locality, "Affecte votre vie !");
		assertEquals(underTest.getName(), "Fontaine");
	}

	@Test
	public void testLocalityGetGoodDesc() {
		String locality = "Une statue représentant un ange déversant des flots sur un corps inanimé.";
		Locality underTest = new Locality("Statue", null, locality, "Affecte votre vie !");
		assertEquals(underTest.getDesc(), "Une statue représentant un ange déversant des flots sur un corps inanimé.");
	}

	@Test
	public void testLocalityShouldChangeLifeWhenInteract() {
		String locality = "Une statue représentant un ange déversant des flots sur un corps inanimé.";
		Player pj = new Player(null);
		pj.initVital();
		pj.getVital().setVie(10);
		Locality underTest = new Locality("Statue", new LifeEffect(10), locality, "Affecte votre vie !");
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
		Locality underTest = new Locality("Verger", new ManaEffect(10), locality, "Affecte votre vie !");
		
		assertEquals(underTest.getName(), "Verger");
		assertEquals(underTest.getDesc(), "Un verger luxurieux qui semblent vous acceuillir à bras ouvert.");
		assertEquals(pj.getVital().getMana(), 10);
		underTest.interact(pj);
		assertTrue(pj.getVital().getMana() == 0 || pj.getVital().getMana() == 20);
	}

	// TODO test mana et competences.
}

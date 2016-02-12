package io.github.algorys.agshmne.character;

import static org.junit.Assert.*;

import org.junit.Test;

public class VitalTest {

	/*
	 * Vital => Vie, Mana, Faim, Fatigue
	 */
	@Test
	public void vitalShouldHaveMaxLifeEqualsInitialisation() {
		Vital underTest = new Vital(15, 15, 10, 10);
		assertEquals(Vital.MAX_LIFE, underTest.getLife());
		underTest.setLife(underTest.getLife() - 4);
		assertNotEquals(Vital.MAX_LIFE, underTest.getLife());
	}
	
	@Test
	public void vitalShouldHaveMaxManaEqualsInitialisation() {
		Vital underTest = new Vital(15, 15, 10, 10);
		assertEquals(Vital.MAX_MANA, underTest.getMana());
		underTest.setMana(underTest.getMana() - 4);
		assertNotEquals(Vital.MAX_MANA, underTest.getMana());
	}

	@Test
	public void lifeCantDropBelowZero() {
		Vital underTest = new Vital(15, 15, 10, 10);
		underTest.setLife(underTest.getLife() - 16);
		assertEquals(0, underTest.getLife());
	}
	
	@Test
	public void manaCantDropBelowZero() {
		Vital underTest = new Vital(15, 15, 10, 10);
		underTest.setMana(underTest.getMana() - 16);
		assertEquals(0, underTest.getMana());
	}
}

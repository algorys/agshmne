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
		assertEquals(underTest.getMaxLife(), underTest.getLife());
		underTest.setLife(underTest.getLife() - 4);
		assertNotEquals(underTest.getMaxLife(), underTest.getLife());
	}

	@Test
	public void vitalShouldHaveMaxManaEqualsInitialisation() {
		Vital underTest = new Vital(15, 15, 10, 10);
		assertEquals(underTest.getMaxMana(), underTest.getMana());
		underTest.setMana(underTest.getMana() - 4);
		assertNotEquals(underTest.getMaxMana(), underTest.getMana());
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

	@Test
	public void hungerCantDropBelowZero() {
		Vital underTest = new Vital(15, 15, 10, 10);
		underTest.setHunger(underTest.getHunger() - 12);
		assertEquals(0, underTest.getHunger());
	}

	@Test
	public void fatigueCantDropBelowZero() {
		Vital underTest = new Vital(15, 15, 10, 10);
		underTest.setFatigue(underTest.getFatigue() - 12);
		assertEquals(0, underTest.getFatigue());
	}

	@Test
	public void whenHungerExceedsHisMax_LifeDecreases() {
		Vital underTest = new Vital(15, 15, 10, 10);
		int oldLife = underTest.getLife();

		underTest.setHunger(12);
		underTest.checkVital();

		assertNotEquals(oldLife, underTest.getLife());
	}

	@Test
	public void whenFatigueExceedsHisMax_LifeDecreases() {
		Vital underTest = new Vital(15, 15, 10, 10);
		int oldLife = underTest.getLife();

		underTest.setFatigue(12);
		underTest.checkVital();

		assertNotEquals(oldLife, underTest.getLife());
	}
}

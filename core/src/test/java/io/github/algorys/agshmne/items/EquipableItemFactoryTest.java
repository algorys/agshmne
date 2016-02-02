package io.github.algorys.agshmne.items;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;

public class EquipableItemFactoryTest {

	@Test
	public void testHead() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.getHeadFactory().createRandom();

		assertTrue(underTest.getPart() == BodyPart.HEAD);
	}

	@Test
	public void testChest() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.getChestFactory().createRandom();

		assertTrue(underTest.getPart() == BodyPart.CHEST);
	}

	@Test
	public void testLegs() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.getLegsFactory().createRandom();

		assertTrue(underTest.getPart() == BodyPart.LEGS);
	}

	@Test
	public void testArms() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.getArmsFactory().createRandom();

		assertTrue(underTest.getPart() == BodyPart.ARMS);
	}

	@Test
	public void testRightHand() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.getCloseWeaponFactory().createRandom();

		assertTrue(underTest.getPart() == BodyPart.RIGHT_HAND);
	}
}

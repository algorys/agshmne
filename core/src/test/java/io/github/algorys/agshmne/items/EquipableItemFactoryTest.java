package io.github.algorys.agshmne.items;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EquipableItemFactoryTest {

	@Test
	public void testHead() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.createHeadArmor();

		assertTrue(underTest.getPart() == BodyPart.HEAD);
	}

	@Test
	public void testChest() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.createChestArmor();

		assertTrue(underTest.getPart() == BodyPart.CHEST);
	}

	@Test
	public void testLegs() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.createLegsArmor();

		assertTrue(underTest.getPart() == BodyPart.LEGS);
	}

	@Test
	public void testArms() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.createArmsArmor();

		assertTrue(underTest.getPart() == BodyPart.ARMS);
	}

	@Test
	public void testRightHand() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.createCloseWeapon();

		assertTrue(underTest.getPart() == BodyPart.RIGHT_HAND);
	}
}

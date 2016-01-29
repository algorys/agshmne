package io.github.algorys.agshmne.items;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EquipableItemFactoryTest {
	
	@Test
	public void testCasque() {
		EquipableItemFactory equipFact = new EquipableItemFactory();
		IEquipableItem underTest = equipFact.createHeadArmor();
		
		assertTrue(underTest.getPart() == BodyPart.HEAD);
	}
}

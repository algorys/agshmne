package io.github.algorys.agshmne.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EquipableItemTest {

	@Test
	public void testCasque() {
		String name = "Casque";
		BodyPart part = BodyPart.HEAD;
		IEquipableItem underTest = new EquipableItem(name, part, 1);
		assertEquals(name, underTest.getName());
		assertFalse(underTest.isEquipped());
		assertSame(part, underTest.getPart());
	}

	@Test
	public void testChapeau() {
		String name = "Chapeau";
		BodyPart part = BodyPart.HEAD;
		IEquipableItem underTest = new EquipableItem(name, part, 1);
		assertEquals(name, underTest.getName());
		assertFalse(underTest.isEquipped());
		assertSame(part, underTest.getPart());
	}

	@Test
	public void testBottes() {
		String name = "bottes";
		BodyPart part = BodyPart.LEGS;
		IEquipableItem underTest = new EquipableItem(name, part, 1);
		assertEquals(name, underTest.getName());
		assertFalse(underTest.isEquipped());
		assertSame(part, underTest.getPart());
	}

	@Test
	public void testBottesEquipées() {
		String name = "bottes";
		BodyPart part = BodyPart.LEGS;
		IEquipableItem underTest = new EquipableItem(name, part, 1);
		underTest.equip();
		assertEquals(name, underTest.getName());
		assertTrue(underTest.isEquipped());
		assertSame(part, underTest.getPart());
	}
	
	@Test
	public void equipableItem_shouldHaveAttributes() {
		IEquipableItem underTest = new EquipableItem("name",BodyPart.HEAD, 1);
		assertNotNull(underTest.getAttribute());
	}
}

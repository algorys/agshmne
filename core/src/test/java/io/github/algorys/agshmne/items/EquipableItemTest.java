package io.github.algorys.agshmne.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.character.AttributeTest;
import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
import io.github.algorys.agshmne.items.equipable.IEquipableItem;

public class EquipableItemTest {

	@Test
	public void testCasque() {
		String name = "Casque";
		BodyPart part = BodyPart.HEAD;
		IEquipableItem underTest = new EquipableItem(name, part);
		assertEquals(name, underTest.getName());
		assertFalse(underTest.isEquipped());
		assertSame(part, underTest.getPart());
	}

	@Test
	public void testChapeau() {
		String name = "Chapeau";
		BodyPart part = BodyPart.HEAD;
		IEquipableItem underTest = new EquipableItem(name, part);
		assertEquals(name, underTest.getName());
		assertFalse(underTest.isEquipped());
		assertSame(part, underTest.getPart());
	}

	@Test
	public void testBottes() {
		String name = "bottes";
		BodyPart part = BodyPart.LEGS;
		IEquipableItem underTest = new EquipableItem(name, part);
		assertEquals(name, underTest.getName());
		assertFalse(underTest.isEquipped());
		assertSame(part, underTest.getPart());
	}

	@Test
	public void testBottesEquipées() {
		String name = "bottes";
		BodyPart part = BodyPart.LEGS;
		IEquipableItem underTest = new EquipableItem(name, part);
		underTest.equip();
		assertEquals(name, underTest.getName());
		assertTrue(underTest.isEquipped());
		assertSame(part, underTest.getPart());
	}

	@Test
	public void equipableItem_shouldHaveAttributes() {
		IEquipableItem underTest = new EquipableItem("name", BodyPart.HEAD);
		assertNotNull(underTest.getAttribute());
	}

	@Test
	public void equipableItem_shouldHaveSpecifiAttributes() {
		IEquipableItem underTest = new EquipableItem("name", BodyPart.HEAD);
		AttributeTest.setBaseValues(underTest.getAttribute());

		Attribute original = AttributeTest.createBaseAttribute();

		assertEquals(original, underTest.getAttribute());
	}
}

package io.github.algorys.agshmne.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
import io.github.algorys.agshmne.items.stackable.StackableItem;

public class InventoryTest {

	@Test
	public void newInventory_should_NOT_contains_Apple() {
		Inventory underTest = new Inventory();
		assertFalse(underTest.contains(new StackableItem("Pomme", 1, 2)));
	}

	@Test
	public void inventoryWithApple_should_contains_Apple() {
		Inventory underTest = new Inventory();
		Item apple = new StackableItem("Pomme", 1, 2);
		underTest.addItem(apple);
		assertTrue(underTest.contains(apple));
	}

	@Test
	public void inventoryWithApple_should_NOT_contains_Nails() {
		Inventory underTest = new Inventory();
		Item apple = new StackableItem("Pomme", 1, 2);
		underTest.addItem(apple);
		assertFalse(underTest.contains(new StackableItem("Clou", 1, 2)));
	}

	@Test
	public void inventoryWithNail_should_contains_Nails() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItem("Clou", 1, 2));
		assertTrue(underTest.contains(new StackableItem("Clou", 1, 2)));
	}

	@Test
	public void inventoryWithOrange_should_contains_Orange_but_NOT_Apple_NOR_Nails() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItem("Orange", 1, 2));
		assertTrue(underTest.contains(new StackableItem("Orange", 1, 2)));
		assertFalse(underTest.contains(new StackableItem("Pomme", 1, 2)));
		assertFalse(underTest.contains(new StackableItem("Clou", 1, 2)));
	}

	@Test
	public void inventoryWithApple_should_NOT_contains_Apple_when_Apple_is_removed() {
		Inventory underTest = new Inventory();
		Item apple = new StackableItem("Pomme", 1, 2);
		underTest.addItem(apple);
		underTest.removeItem(apple);
		assertFalse(underTest.contains(new StackableItem("Pomme", 1, 2)));
	}

	@Test
	public void inventoryWithTwoAxe_should_contains_Axe_when_one_is_removed() {
		Inventory underTest = new Inventory();
		Item axe = new EquipableItem("Hache", BodyPart.RIGHT_HAND, 10);
		underTest.addItem(axe);
		underTest.addItem(new EquipableItem("Hache", BodyPart.RIGHT_HAND, 10));
		assertEquals(2, underTest.count(new EquipableItem("Hache", BodyPart.RIGHT_HAND, 10)));
		underTest.removeItem(axe);
		assertTrue(underTest.contains(new EquipableItem("Hache", BodyPart.RIGHT_HAND, 10)));
	}

	@Test
	public void inventoryWith2Apple_should_have_2_apple() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItem("Pomme", 1, 2));
		underTest.addItem(new StackableItem("Pomme", 1, 2));
		assertEquals(2, underTest.count(new StackableItem("Pomme", 1, 2)));
	}

	@Test
	public void inventoryWith3Apple_should_have_3_apple() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItem("Pomme", 1, 2));
		underTest.addItem(new StackableItem("Pomme", 1, 2));
		underTest.addItem(new StackableItem("Pomme", 1, 2));
		assertEquals(3, underTest.count(new StackableItem("Pomme", 1, 2)));
	}

	@Test
	public void inventoryWith2Orange_and_Remove2Orange_should_have_0_orange() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItem("Orange", 2, 2));
		underTest.removeItem(new StackableItem("Orange", 2, 2));
		assertFalse(underTest.contains(new StackableItem("Orange", 1, 2)));
	}

	@Test
	public void inventoryCanGiveAllEquippedItem() {
		Player pj = new PlayerBuilder().create();
		Inventory underTest = pj.getInventory();
		EquipableItem axe = new EquipableItem("Hache", BodyPart.RIGHT_HAND, 10);
		EquipableItem leatherArmor = new EquipableItem("Armure en cuir", BodyPart.CHEST, 20);
		EquipableItem helmet = new EquipableItem("Casque", BodyPart.HEAD, 10);

		underTest.addItem(axe);
		underTest.addItem(leatherArmor);
		underTest.addItem(helmet);

		pj.equip(leatherArmor);
		assertTrue(underTest.getEquipment().contains(leatherArmor));

		pj.equip(helmet);
		assertTrue(underTest.getEquipment().contains(helmet));

	}

	@Test
	public void inventoryCanKnowAllItemUnequip() {
		Player pj = new PlayerBuilder().create();
		Inventory underTest = pj.getInventory();
		EquipableItem leatherArmor = new EquipableItem("Armure en cuir", BodyPart.CHEST, 15);
		EquipableItem helmet = new EquipableItem("Casque", BodyPart.HEAD, 10);

		underTest.addItem(leatherArmor);
		underTest.addItem(helmet);

		pj.equip(leatherArmor);
		assertTrue(underTest.getEquipment().contains(leatherArmor));

		pj.equip(helmet);
		assertTrue(underTest.getEquipment().contains(helmet));
		pj.unequip(leatherArmor);
		assertFalse(underTest.getEquipment().contains(leatherArmor));

	}
}

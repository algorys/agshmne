package io.github.algorys.agshmne.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InventoryTest {

	@Test
	public void newInventory_should_NOT_contains_Apple() {
		Inventory underTest = new Inventory();
		assertFalse(underTest.contains(new StackableItemDirectFactory().createApple()));
	}

	@Test
	public void inventoryWithApple_should_contains_Apple() {
		Inventory underTest = new Inventory();
		Item apple = new StackableItemDirectFactory().createApple();
		underTest.addItem(apple);
		assertTrue(underTest.contains(apple));
	}

	@Test
	public void inventoryWithApple_should_NOT_contains_Nails() {
		Inventory underTest = new Inventory();
		Item apple = new StackableItemDirectFactory().createApple();
		underTest.addItem(apple);
		assertFalse(underTest.contains(new StackableItemDirectFactory().createNail()));
	}

	@Test
	public void inventoryWithNail_should_contains_Nails() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItemDirectFactory().createNail());
		assertTrue(underTest.contains(new StackableItemDirectFactory().createNail()));
	}

	@Test
	public void inventoryWithOrange_should_contains_Orange_but_NOT_Apple_NOR_Nails() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItemDirectFactory().createOrange());
		assertTrue(underTest.contains(new StackableItemDirectFactory().createOrange()));
		assertFalse(underTest.contains(new StackableItemDirectFactory().createApple()));
		assertFalse(underTest.contains(new StackableItemDirectFactory().createNail()));
	}

	@Test
	public void inventoryWithApple_should_NOT_contains_Apple_when_Apple_is_removed() {
		Inventory underTest = new Inventory();
		Item apple = new StackableItemDirectFactory().createApple();
		underTest.addItem(apple);
		underTest.removeItem(apple);
		assertFalse(underTest.contains(new StackableItemDirectFactory().createApple()));
	}

	@Test
	public void inventoryWithTwoAxe_should_contains_Axe_when_one_is_removed() {
		Inventory underTest = new Inventory();
		Item axe = new ItemDirectFactory().createAxe();
		underTest.addItem(axe);
		underTest.addItem(new ItemDirectFactory().createAxe());
		assertEquals(2, underTest.count(new ItemDirectFactory().createAxe()));
		underTest.removeItem(axe);
		assertTrue(underTest.contains(new ItemDirectFactory().createAxe()));
	}

	@Test
	public void inventoryWith2Apple_should_have_2_apple() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItemDirectFactory().createApple());
		underTest.addItem(new StackableItemDirectFactory().createApple());
		assertEquals(2, underTest.count(new StackableItemDirectFactory().createApple()));
	}

	@Test
	public void inventoryWith3Apple_should_have_3_apple() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItemDirectFactory().createApple());
		underTest.addItem(new StackableItemDirectFactory().createApple());
		underTest.addItem(new StackableItemDirectFactory().createApple());
		assertEquals(3, underTest.count(new StackableItemDirectFactory().createApple()));
	}
	
	@Test
	public void inventoryWith2Orange_and_Remove2Orange_should_have_0_orange() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StackableItemDirectFactory().createOrange());
		underTest.addItem(new StackableItemDirectFactory().createOrange());
		underTest.removeItem(new StackableItemDirectFactory().createOrange());
		underTest.removeItem(new StackableItemDirectFactory().createOrange());
		assertFalse(underTest.contains(new StackableItemDirectFactory().createOrange()));
	}
}

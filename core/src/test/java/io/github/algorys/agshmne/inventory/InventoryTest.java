package io.github.algorys.agshmne.inventory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.objets.Apple;
import io.github.algorys.agshmne.objets.Axe;
import io.github.algorys.agshmne.objets.Nail;
import io.github.algorys.agshmne.objets.Orange;
import io.github.algorys.agshmne.objets.StrongAxe;
import io.github.algorys.agshmne.objets.WeakAxe;

public class InventoryTest {

	@Test
	public void newInventory_should_NOT_contains_Apple() {
		Inventory underTest = new Inventory();
		assertFalse(underTest.contains(Apple.class));
	}

	@Test
	public void inventoryWithApple_should_contains_Apple() {
		Inventory underTest = new Inventory();
		underTest.addItem(new Apple());
		assertTrue(underTest.contains(Apple.class));
	}

	@Test
	public void inventoryWithApple_should_NOT_contains_Nails() {
		Inventory underTest = new Inventory();
		underTest.addItem(new Apple());
		assertFalse(underTest.contains(Nail.class));
	}

	@Test
	public void inventoryWithNail_should_contains_Nails() {
		Inventory underTest = new Inventory();
		underTest.addItem(new Nail());
		assertTrue(underTest.contains(Nail.class));
	}

	@Test
	public void inventoryWithOrange_should_contains_Orange_but_NOT_Apple_NOR_Nails() {
		Inventory underTest = new Inventory();
		underTest.addItem(new Orange());
		assertTrue(underTest.contains(Orange.class));
		assertFalse(underTest.contains(Apple.class));
		assertFalse(underTest.contains(Nail.class));
	}

	@Test
	public void inventoryWithApple_should_NOT_contains_Apple_when_Apple_is_removed() {
		Inventory underTest = new Inventory();
		Apple myApple = new Apple();
		underTest.addItem(myApple);
		underTest.removeItem(myApple);
		assertFalse(underTest.contains(Apple.class));
	}

	@Test
	public void inventoryWithTwoApple_should_contains_Apple_when_one_is_removed() {
		Inventory underTest = new Inventory();
		WeakAxe myAxe = new WeakAxe();
		underTest.addItem(myAxe);
		underTest.addItem(new StrongAxe());
		assertEquals(2, underTest.count(Axe.class));
		underTest.removeItem(myAxe);
		assertTrue(underTest.contains(Axe.class));
	}

	@Test
	public void newInventory_should_addApple_at_specificIndex_and_containsApple() {
		Inventory underTest = new Inventory();
		Apple myApple = new Apple();
		underTest.addItem(myApple, 5);
		assertTrue(underTest.contains(Apple.class));
	}

	@Test(expected = IllegalArgumentException.class)
	public void inventoryWithAppleAtSpecificIndex_should_throw_exception_when_Nail_is_added_at_same_index() {
		Inventory underTest = new Inventory();
		underTest.addItem(new Apple(), 5);
		underTest.addItem(new Nail(), 5);
	}

	@Test
	public void inventoryWithStrongAxe_should_contains_Axe() {
		Inventory underTest = new Inventory();
		underTest.addItem(new StrongAxe());
		assertTrue(underTest.contains(Axe.class));
	}

	@Test
	public void inventoryWith2Apple_should_have_2_apple() {
		Inventory underTest = new Inventory();
		underTest.addItem(new Apple());
		underTest.addItem(new Apple());
		assertEquals(2, underTest.count(Apple.class));
	}

	@Test
	public void inventoryWith3Apple_should_have_3_apple() {
		Inventory underTest = new Inventory();
		underTest.addItem(new Apple());
		underTest.addItem(new Apple());
		underTest.addItem(new Apple());
		assertEquals(3, underTest.count(Apple.class));
	}

	@Test
	public void inventoryMayHave_ANY_numbersOfApple_and_One_Nail() {
		Inventory underTest = new Inventory();
		for (int i = 0; i < Inventory.MAX_INVENTORY; i++) {
			underTest.addItem(new Apple());
		}
		underTest.addItem(new Nail());
		assertEquals(Inventory.MAX_INVENTORY, underTest.count(Apple.class));
		assertTrue(underTest.contains(Nail.class));
	}
	
	@Test
	public void inventoryWith2Orange_and_Remove2Orange_should_have_0_orange() {
		Inventory underTest = new Inventory();
		underTest.addItem(new Orange());
		underTest.addItem(new Orange());
		Orange orange = new Orange();
		underTest.removeItem(orange);
		Orange orange2 = new Orange();
		underTest.removeItem(orange2);
		assertFalse(underTest.contains(Orange.class));
	}
}

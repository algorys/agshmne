package io.github.algorys.agshmne.map.city.shop;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ShopTest {

	@Test
	public void newShopInventoryShouldNotBeNull() {
		Shop underTest = new Shop(1);
		assertNotNull(underTest.getInventory());
	}

	@Test
	public void newShouldHaveMoney() {
		Shop underTest = new Shop(1);
		assertTrue(underTest.getGold() > 0);
	}
}

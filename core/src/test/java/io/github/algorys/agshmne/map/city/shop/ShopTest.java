package io.github.algorys.agshmne.map.city.shop;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.Item;

public class ShopTest {

	@Test
	public void newShopInventoryShouldNotBeNull() {
		Shop underTest = new Shop(1);
		assertNotNull(underTest.getInventory());
	}

	@Test
	public void newShopShouldHaveMoney() {
		Shop underTest = new Shop(1);
		assertTrue(underTest.getGold() > 0);
	}
	
	@Test
	public void newShopCouldSellAnItem() {
		Shop underTest = new Shop(1);
		underTest.getInventory().addItem(new GeneralItem("Pomme"));
		Inventory old = underTest.getInventory();
		Player pj = new Player(null);
		Item item = new GeneralItem("Pomme");
		underTest.sellItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
	}
}

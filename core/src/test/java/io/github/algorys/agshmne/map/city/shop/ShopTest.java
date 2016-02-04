package io.github.algorys.agshmne.map.city.shop;

import static org.junit.Assert.assertFalse;
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
		Item item = new GeneralItem("Pomme");
		underTest.getInventory().addItem(item);
		Player pj = new Player(null);
		Inventory old = underTest.getInventory();
	
		underTest.sellItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
		assertFalse(underTest.getInventory().contains(item));
		assertTrue(pj.getInventory().contains(item));
	}
	
	@Test
	public void newShopCanBuyAnItem() {
		Shop underTest = new Shop(1);
		Item item = new GeneralItem("Pomme");
		Player pj = new Player(null);
		pj.getInventory().addItem(item);
		Inventory old = underTest.getInventory();
	
		underTest.buyItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
		assertTrue(underTest.getInventory().contains(item));
		assertFalse(pj.getInventory().contains(item));
	}
	
}

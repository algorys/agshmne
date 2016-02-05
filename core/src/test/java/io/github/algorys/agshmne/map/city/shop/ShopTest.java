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
import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
import io.github.algorys.agshmne.items.stackable.StackableItem;

public class ShopTest {

	@Test
	public void newShopInventoryShouldNotBeNull() {
		Shop underTest = new Shop(1);
		assertNotNull(underTest.getInventory());
	}
	
	@Test
	public void newShopCouldSellAnyItem() {
		Shop underTest = new Shop(1);
		Item item = new StackableItem("Pomme", 1, 2);
		underTest.getInventory().addItem(item);
		Player pj = new Player(null);
		Inventory old = underTest.getInventory();
	
		underTest.sellItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
		assertFalse(underTest.getInventory().contains(item));
		assertTrue(pj.getInventory().contains(item));
	}
	
	@Test
	public void newShopCouldSellStackableItem() {
		Shop underTest = new Shop(1);
		StackableItem item = new StackableItem("Pomme", 1, 2);
		underTest.getInventory().addItem(item);
		Player pj = new Player(null);
		Inventory old = underTest.getInventory();
	
		underTest.sellItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
		assertFalse(underTest.getInventory().contains(item));
		assertTrue(pj.getInventory().contains(item));
	}
	
	@Test
	public void shopCanSellEquipableItem() {
		Shop underTest = new Shop(1);
		EquipableItem item = new EquipableItem("Chapeau", BodyPart.HEAD, 15);
		underTest.getInventory().addItem(item);
		Player pj = new Player(null);
		Inventory old = underTest.getInventory();
	
		underTest.sellItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
		assertFalse(underTest.getInventory().contains(item));
		assertTrue(pj.getInventory().contains(item));
	}
	
	@Test
	public void shopCanSellGeneralItem() {
		Shop underTest = new Shop(1);
		GeneralItem item = new GeneralItem("Bouteille", 3);
		underTest.getInventory().addItem(item);
		Player pj = new Player(null);
		Inventory old = underTest.getInventory();
	
		underTest.sellItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
		assertTrue(pj.getInventory().contains(item));
	}
	
	@Test
	public void newShopCanBuyStackableItem() {
		Shop underTest = new Shop(1);
		StackableItem item = new StackableItem("Pomme", 1, 2);
		Player pj = new Player(null);
		pj.getInventory().addItem(item);
		Inventory old = underTest.getInventory();
	
		underTest.buyItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
		assertTrue(underTest.getInventory().contains(item));
		assertFalse(pj.getInventory().contains(item));
	}
	
	@Test
	public void newShopCanBuyEquipableItem() {
		Shop underTest = new Shop(1);
		EquipableItem item = new EquipableItem("Armure de cuir", BodyPart.CHEST, 2);
		Player pj = new Player(null);
		pj.getInventory().addItem(item);
		Inventory old = underTest.getInventory();
	
		underTest.buyItem(pj, item);
		assertNotSame(old.getListBackpack(), underTest.getInventory().getListBackpack());
		assertTrue(underTest.getInventory().contains(item));
		assertFalse(pj.getInventory().contains(item));
	}
	
	@Test 
	public void shopShouldRemovePjGoldWhenPjBuyItem() {
		Shop underTest = new Shop(1);
		Item item = new GeneralItem("Pomme", 2);
		underTest.getInventory().addItem(item);
		Player pj = new Player(null);
		pj.getInventory().setGold(10);
		
		int old = pj.getInventory().getGold();
	
		underTest.sellItem(pj, item);
		assertNotSame(old, pj.getInventory().getGold());
		assertFalse(underTest.getInventory().contains(item));
		assertTrue(pj.getInventory().contains(item));
	}
	
	@Test
	public void shopShouldAddGoldWhenPjSellItem() {
		Shop underTest = new Shop(1);
		Item item = new GeneralItem("Pomme", 2);
		Player pj = new Player(null);
		pj.getInventory().addItem(item);
		int old = pj.getInventory().getGold();
	
		underTest.buyItem(pj, item);
		assertNotSame(old, pj.getInventory().getGold());
		assertTrue(underTest.getInventory().contains(item));
		assertFalse(pj.getInventory().contains(item));
	}
	
}

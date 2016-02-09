package io.github.algorys.agshmne.map.city.shop;

import io.github.algorys.agshmne.items.IItemFactory;
import io.github.algorys.agshmne.items.Inventory;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.tools.Tools;

public class ShopStockFactory {
	private IItemFactory[] itemFactories;
	
	public ShopStockFactory() {
		EquipableItemFactory equipableItemFactory = new EquipableItemFactory();
		ItemFactory itemFactory = new ItemFactory();
		
		itemFactories = new IItemFactory[] {
		equipableItemFactory.getCloseWeaponFactory(),
		equipableItemFactory.getArmsFactory(),
		equipableItemFactory.getChestFactory(),
		equipableItemFactory.getChestFactory(),
		equipableItemFactory.getHeadFactory(),
		equipableItemFactory.getLegsFactory(),
		equipableItemFactory.getRingFactory(),
		equipableItemFactory.getNecklaceFactory(),
		
		itemFactory,
		itemFactory,
		itemFactory,
		itemFactory,
		itemFactory,
		
		};
	}
	
	public Inventory createStock(int level) {
		Inventory inv = new Inventory();
		int nbItem = Tools.dice(level * 5) +5;
		for(int i = 0; i < nbItem; i++) {
			inv.addItem(Tools.random(itemFactories).createRandom());
		}
		return inv;
	}
}

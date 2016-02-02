package io.github.algorys.agshmne.map.tile;

import io.github.algorys.agshmne.items.IItemFactory;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.map.city.factory.CityFactory;
import io.github.algorys.agshmne.map.region.DescFactory;
import io.github.algorys.agshmne.tools.Tools;

public class RandomTileFactory implements TileFactory {
	private DescFactory descFactory = new DescFactory();
	private CityFactory cityFactory = new CityFactory();
	private IItemFactory[] itemFactories;

	public RandomTileFactory() {
		EquipableItemFactory equipableItemFactory = new EquipableItemFactory();
		ItemFactory itemFactory = new ItemFactory();
		itemFactories = new IItemFactory[] {

		equipableItemFactory.getCloseWeaponFactory(),
		equipableItemFactory.getArmsFactory(),
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
		itemFactory,
		};
	}
	/* (non-Javadoc)
	 * @see io.github.algorys.agshmne.map.tile.TileFactory#createTile()
	 */
	@Override
	public Tile createTile() {
		Tile currentTile;
		TileType type = Tools.random(TileType.values());
		String desc = descFactory.randomDesc(type);
		if (Math.random() < .25) {
			currentTile = new Tile(type, desc, cityFactory.createCity(type));
		} else {
			currentTile = new Tile(type, desc);
		}
		
		
		while (Math.random() < .4) {
			currentTile.addItem(Tools.random(itemFactories).createRandom());
		}
		
		if (Math.random() <.15) {
			currentTile.setDanger(true);
		}
		return currentTile;
	}
}

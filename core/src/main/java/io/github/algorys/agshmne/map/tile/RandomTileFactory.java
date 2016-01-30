package io.github.algorys.agshmne.map.tile;

import io.github.algorys.agshmne.items.EquipableItemFactory;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.map.city.factory.CityFactory;
import io.github.algorys.agshmne.map.region.DescFactory;
import io.github.algorys.agshmne.tools.Tools;

public class RandomTileFactory implements TileFactory {
	private DescFactory descFactory = new DescFactory();
	private CityFactory cityFactory = new CityFactory();

	/* (non-Javadoc)
	 * @see io.github.algorys.agshmne.map.tile.TileFactory#createTile()
	 */
	@Override
	public Tile createTile() {
		Tile currentTile;
		TileType type = TileType.values()[Tools.dice(TileType.values().length)];
		String desc = descFactory.randomDesc(type);
		if (Math.random() < .25) {
			currentTile = new Tile(type, desc, cityFactory.createCity(type));
		} else {
			currentTile = new Tile(type, desc);
		}
		
		
		while (Math.random() < .4) {
			Item[] itemTile = {
					
			new EquipableItemFactory().createCloseWeapon(),
			new EquipableItemFactory().createArmsArmor(),
			new EquipableItemFactory().createChestArmor(),
			new EquipableItemFactory().createHeadArmor(),
			new EquipableItemFactory().createLegsArmor(),
			
			new ItemFactory().createItem(),
			new ItemFactory().createItem(),
			new ItemFactory().createItem(),
			new ItemFactory().createStackableItem(),
			new ItemFactory().createStackableItem(),
			new ItemFactory().createStackableItem(),
			
					};
			currentTile.addItem(itemTile[Tools.dice(itemTile.length)]);
			}
		
		if (Math.random() <.15) {
			currentTile.setDanger(true);
		}
		return currentTile;
	}
}

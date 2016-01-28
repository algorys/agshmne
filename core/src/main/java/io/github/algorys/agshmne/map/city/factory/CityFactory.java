package io.github.algorys.agshmne.map.city.factory;

import java.util.HashMap;
import java.util.Map;

import io.github.algorys.agshmne.map.city.City;
import io.github.algorys.agshmne.map.city.ICityFactory;
import io.github.algorys.agshmne.map.tile.TileType;

public class CityFactory {
	private Map<TileType, ICityFactory> factories = new HashMap<>();

	public CityFactory() {
		ICityFactory hamletFactory = new GeneralCityFactory(2, 0);
		ICityFactory townFactory = new GeneralCityFactory(2, 2);
		ICityFactory cityFactory = new GeneralCityFactory(3, 4);
		ICityFactory citadelFactory = new GeneralCityFactory(3, 7);

		factories.put(TileType.Desert, hamletFactory);
		factories.put(TileType.Sea, hamletFactory);
		factories.put(TileType.Swamp, hamletFactory);
		factories.put(TileType.Mountain, townFactory);
		factories.put(TileType.Lake, townFactory);
		factories.put(TileType.Forest, cityFactory);
		factories.put(TileType.Wood, cityFactory);
		factories.put(TileType.Hill, citadelFactory);
		factories.put(TileType.Plain, citadelFactory);
		factories.put(TileType.River, citadelFactory);
		factories.put(TileType.Valley, citadelFactory);
	}

	public City createCity(TileType type) {
		return factories.get(type).createCity();
	}
}

package io.github.algorys.agshmne.map.city.factory;

import io.github.algorys.agshmne.map.city.City;
import io.github.algorys.agshmne.map.city.ICityFactory;
import io.github.algorys.agshmne.tools.Tools;

public class CityTownFactory implements ICityFactory {

	@Override
	public City createCity() {
		return new City(Tools.dice(2) + 2);
	}

}

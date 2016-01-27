package io.github.algorys.agshmne.map.city.factory;

import io.github.algorys.agshmne.map.city.City;
import io.github.algorys.agshmne.map.city.ICityFactory;
import io.github.algorys.agshmne.tools.Tools;

public class CityCityFactory implements ICityFactory {

	@Override
	public City createCity() {
		return new City(Tools.dice(3) + 5);
	}

}

package io.github.algorys.agshmne.city.factory;

import io.github.algorys.agshmne.city.City;
import io.github.algorys.agshmne.city.ICityFactory;
import io.github.algorys.agshmne.city.CityType;
import io.github.algorys.agshmne.tools.Outils;

public class CityTownFactory implements ICityFactory {

	@Override
	public City createCity() {
		return new City(Outils.dice(3) + 2);
	}

}

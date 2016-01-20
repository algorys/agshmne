package io.github.algorys.agshmne.city.factory;

import io.github.algorys.agshmne.city.City;
import io.github.algorys.agshmne.city.ICityFactory;
import io.github.algorys.agshmne.tools.Tools;

public class CityCitadelFactory implements ICityFactory {

	@Override
	public City createCity() {
		return new City(Tools.dice(3) + 7);
	}

}

package io.github.algorys.agshmne.map.city.factory;

import io.github.algorys.agshmne.map.city.City;
import io.github.algorys.agshmne.map.city.ICityFactory;
import io.github.algorys.agshmne.tools.Tools;

public class GeneralCityFactory  implements ICityFactory {
	private int dieFaces;
	private int modifier;
	private final CityDescFactory cityDescFactory = new CityDescFactory();

	public GeneralCityFactory(int dieFaces, int modifier) {
		super();
		this.dieFaces = dieFaces;
		this.modifier = modifier;
	}
	
	public City createCity() {
		int level = Tools.dice(dieFaces) + modifier;
		String name = cityDescFactory.randomDesc(City.getTypeFromLevel(level));
		return new City(name, level);
	}
}

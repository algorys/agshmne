package io.github.algorys.agshmne.map.city.factory;

import io.github.algorys.agshmne.map.city.City;
import io.github.algorys.agshmne.map.city.ICityFactory;
import io.github.algorys.agshmne.tools.Tools;

public class GeneralCityFactory  implements ICityFactory {
	private int dieFaces;
	private int modifier;

	public GeneralCityFactory(int dieFaces, int modifier) {
		super();
		this.dieFaces = dieFaces;
		this.modifier = modifier;
	}
	
	public City createCity() {
		return new City(Tools.dice(dieFaces) + modifier);
	}
}

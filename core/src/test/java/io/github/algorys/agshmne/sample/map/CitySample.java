package io.github.algorys.agshmne.sample.map;

import io.github.algorys.agshmne.map.city.City;
import io.github.algorys.agshmne.map.city.factory.CityFactory;
import io.github.algorys.agshmne.map.tile.TileType;

public class CitySample {

	public static void main(String[] args) {
		CityFactory cityFact = new CityFactory();
		City city = cityFact.createCity(TileType.Plain);
		
		System.out.println("Nom " + city.getName());

	}

}

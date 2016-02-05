package io.github.algorys.agshmne.map.city;

import io.github.algorys.agshmne.map.city.factory.CityDescFactory;
import io.github.algorys.agshmne.map.city.shop.Shop;

public class City {
	private String name = new CityDescFactory().randomDesc(getType());
	private int level;
	private Shop shop;
			

	public City(int level) {
		this.level = level;
		this.shop = new Shop(level);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CityType getType() {
		if(level < 2) {
			return CityType.Hamlet;
		} else if (level < 4)  {
			return CityType.Town;
		} else if (level < 7)  {
			return CityType.City;
		} else {
			return CityType.Citadel;
		}
	}

	public String getName() {
		return name;
	}

	public Shop getShop() {
		return shop;
	}

}

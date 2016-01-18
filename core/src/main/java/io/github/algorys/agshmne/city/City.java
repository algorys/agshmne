package io.github.algorys.agshmne.city;

import io.github.algorys.agshmne.tile.TileType;
import io.github.algorys.agshmne.tools.Outils;

public class City {
	private CityType cityType;
	private int level;
	
	public City(TileType type) {
		this.defineLvl(type);
	}
	
	private void defineLvl(TileType type){
		switch (type) {
			case Desert:
			case Sea:
			case Swamp:
				this.setLevel(Outils.dice(3));
				this.cityType = CityType.Hamlet;
				break;
			case Mountain:
			case Lake:
				this.setLevel(Outils.dice(3) + 2);
				this.cityType = CityType.Town;
				break;
			case Forest:
			case Wood:
				this.setLevel(Outils.dice(3) + 5);
				this.cityType = CityType.City;
				break;
			case Hill:
			case Plain:
			case River:
			case Valley:
			default:
				this.setLevel(Outils.dice(3) + 7);
				this.cityType = CityType.Citadel;
		}
		System.out.println("Type ville = " + this.cityType);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CityType getType() {
		return cityType;
	}

}

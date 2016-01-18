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
		if(type == TileType.Desert || type == TileType.Sea || type == TileType.Swamp) {
			this.setLevel(Outils.dice(3));
			CityType cityType = CityType.Hamlet;
			System.out.println("Type ville = " + cityType);
			this.cityType = cityType;
		}
		if(type == TileType.Mountain || type == TileType.Lake){
			this.setLevel(Outils.dice(3)+2);
			CityType cityType = CityType.Town;
			System.out.println("Type ville = " + cityType);
			this.cityType = cityType;
		}
		if(type == TileType.Forest || type == TileType.Wood){
			this.setLevel(Outils.dice(3)+5);
			CityType cityType = CityType.City;
			System.out.println("Type ville = " + cityType);
			this.cityType = cityType;
		}
		if(type == TileType.Hill || type == TileType.Plain ||
				type == TileType.River || type == TileType.Valley) {
			this.setLevel(Outils.dice(3)+7);
			CityType cityType = CityType.Citadel;
			System.out.println("Type ville = " + cityType);
			this.cityType = cityType;
		}
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

package io.github.algorys.agshmne.city;

import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;
import io.github.algorys.agshmne.tools.Outils;

public class City {
	private CityType type;
	private int level;
	
	public City(Tile tile) {
		this.defineLvl(tile);
	}
	
	private void defineLvl(Tile tile){
		if(tile.getType() == TileType.Desert || tile.getType() == TileType.Sea || tile.getType() == TileType.Swamp) {
			this.setLevel(Outils.dice(3));
			CityType type = CityType.values()[0];
			System.out.println("Type ville = " + type);
			this.type = type;
		}
		if(tile.getType() == TileType.Mountain || tile.getType() == TileType.Lake){
			this.setLevel(Outils.dice(3)+2);
			CityType type = CityType.values()[1];
			System.out.println("Type ville = " + type);
			this.type = type;
		}
		if(tile.getType() == TileType.Forest || tile.getType() == TileType.Wood){
			this.setLevel(Outils.dice(3)+5);
			CityType type = CityType.values()[2];
			System.out.println("Type ville = " + type);
			this.type = type;
		}
		if(tile.getType() == TileType.Hill || tile.getType() == TileType.Plain ||
				tile.getType() == TileType.River || tile.getType() == TileType.Valley) {
			this.setLevel(Outils.dice(3)+7);
			CityType type = CityType.values()[3];
			System.out.println("Type ville = " + type);
			this.type = type;
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CityType getType() {
		return type;
	}
	
}

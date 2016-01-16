package io.github.algorys.agshmne.city;

import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;

public class City {
	private CityType type;
	private int level;
	
	public City(Tile tile) {
		CityType type = CityType.values()[io.github.algorys.agshmne.tools.Outils.dice(CityType.values().length)];
		this.type = type;
		this.defineLvl(tile);
	}
	
	private void defineLvl(Tile tile){
		if(tile.getType() == TileType.Desert || tile.getType() == TileType.Sea || tile.getType() == TileType.Swamp) {
			this.setLevel(3);
		}
		if(tile.getType() == TileType.Mountain || tile.getType() == TileType.Lake){
			this.setLevel(5);
		}
		if(tile.getType() == TileType.Forest || tile.getType() == TileType.Wood){
			this.setLevel(8);
		}
		if(tile.getType() == TileType.Hill || tile.getType() == TileType.Plain ||
				tile.getType() == TileType.River || tile.getType() == TileType.Valley) {
			this.setLevel(10);
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

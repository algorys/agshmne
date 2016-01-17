package io.github.algorys.agshmne.history;

import io.github.algorys.agshmne.desctile.DescLake;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;

public class HistoryTile {
	String desc;
	
	public HistoryTile(Tile tile) {
		if(tile.getType().equals(TileType.Lake)) {
			DescLake descLake = DescLake.values()[io.github.algorys.agshmne.tools.Outils.dice(TileType.values().length)];
			this.desc = descLake.toString();
		}
		if(tile.getType().equals(TileType.Lake)) {
			DescLake descLake = DescLake.values()[io.github.algorys.agshmne.tools.Outils.dice(TileType.values().length)];
			this.desc = descLake.toString();
		}
	}

	public String getDesc() {
		return desc;
	}

}

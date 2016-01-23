package io.github.algorys.agshmne.history;

import io.github.algorys.agshmne.desctile.DescDesert;
import io.github.algorys.agshmne.desctile.DescHill;
import io.github.algorys.agshmne.desctile.DescLake;
import io.github.algorys.agshmne.desctile.DescMountain;
import io.github.algorys.agshmne.desctile.DescPlain;
import io.github.algorys.agshmne.desctile.DescRiver;
import io.github.algorys.agshmne.desctile.DescSea;
import io.github.algorys.agshmne.desctile.DescSwamp;
import io.github.algorys.agshmne.desctile.DescWood;
import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tile.TileType;
import io.github.algorys.agshmne.tools.Tools;

public class HistoryTile {
	String desc;
	
	public HistoryTile(Tile tile) {
		
		if(tile.getType().equals(TileType.Wood) || tile.getType().equals(TileType.Forest)) {
			DescWood descWood = DescWood.values()[Tools.dice(DescWood.values().length)];
			this.desc = descWood.toString();
		}
		if(tile.getType().equals(TileType.Hill)) {
			DescHill descHill = DescHill.values()[Tools.dice(DescHill.values().length)];
			this.desc = descHill.toString();
		}
		if(tile.getType().equals(TileType.Desert)) {
			DescDesert descDesert = DescDesert.values()[Tools.dice(DescDesert.values().length)];
			this.desc = descDesert.toString();
		}
		if(tile.getType().equals(TileType.Sea)) {
			DescSea descSea = DescSea.values()[Tools.dice(DescSea.values().length)];
			this.desc = descSea.toString();
		}
		if(tile.getType().equals(TileType.Mountain)) {
			DescMountain descMountain = DescMountain.values()[Tools.dice(DescMountain.values().length)];
			this.desc = descMountain.toString();
		}
		if(tile.getType().equals(TileType.Plain) || tile.getType().equals(TileType.Valley)) {
			DescPlain descPlain = DescPlain.values()[Tools.dice(DescPlain.values().length)];
			this.desc = descPlain.toString();
		}
		if(tile.getType().equals(TileType.River)) {
			DescRiver descRiver = DescRiver.values()[Tools.dice(DescRiver.values().length)];
			this.desc = descRiver.toString();
		}
		if(tile.getType().equals(TileType.Swamp)) {
			DescSwamp descSwamp = DescSwamp.values()[Tools.dice(DescSwamp.values().length)];
			this.desc = descSwamp.toString();
		}
		if(tile.getType().equals(TileType.Lake)) {
			DescLake descLake = DescLake.values()[Tools.dice(DescLake.values().length)];
			this.desc = descLake.toString();
		}
		//System.out.println("Desc Tile : " + desc);
		
	}

	public String getDesc() {
		return desc;
	}

}

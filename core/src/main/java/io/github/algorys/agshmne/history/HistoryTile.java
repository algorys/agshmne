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
		switch (tile.getType()) {
		case Wood:
		case Forest:
			DescWood descWood = DescWood.values()[Tools.dice(DescWood.values().length)];
			this.desc = descWood.toString();
			break;
		case Hill:
			DescHill descHill = DescHill.values()[Tools.dice(DescHill.values().length)];
			this.desc = descHill.toString();
			break;
		case Desert:
			DescDesert descDesert = DescDesert.values()[Tools.dice(DescDesert.values().length)];
			this.desc = descDesert.toString();
			break;
		case Sea:
			DescSea descSea = DescSea.values()[Tools.dice(DescSea.values().length)];
			this.desc = descSea.toString();
			break;
		case Mountain:
			DescMountain descMountain = DescMountain.values()[Tools.dice(DescMountain.values().length)];
			this.desc = descMountain.toString();
			break;
		case Plain:
		case Valley:
			DescPlain descPlain = DescPlain.values()[Tools.dice(DescPlain.values().length)];
			this.desc = descPlain.toString();
			break;
		case River:
			DescRiver descRiver = DescRiver.values()[Tools.dice(DescRiver.values().length)];
			this.desc = descRiver.toString();
			break;
		case Swamp:
			DescSwamp descSwamp = DescSwamp.values()[Tools.dice(DescSwamp.values().length)];
			this.desc = descSwamp.toString();
			break;
		case Lake:
			DescLake descLake = DescLake.values()[Tools.dice(DescLake.values().length)];
			this.desc = descLake.toString();
			break;
		default:
			this.desc = "No TileType found";
		}
		//System.out.println("Desc Tile : " + desc);
		
	}

	public String getDesc() {
		return desc;
	}

}

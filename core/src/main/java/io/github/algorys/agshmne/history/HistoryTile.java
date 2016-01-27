package io.github.algorys.agshmne.history;

import java.util.Arrays;
import java.util.List;

import io.github.algorys.agshmne.tile.Tile;
import io.github.algorys.agshmne.tools.Tools;

public class HistoryTile {
	String desc;

	public HistoryTile(Tile tile) {
		List<String> descWood = Arrays.asList("Bois", "Forêt", "Jardins", "Jungle", "Sylve");
		List<String> descHill = Arrays.asList("Collines", "Plateau", "Grand Tertre", "Buttes");
		List<String> descDesert = Arrays.asList("Désert", "Désert de Sel", "Steppe", "Toundra");
		List<String> descSea = Arrays.asList("Mer", "Océan");
		List<String> descMountain = Arrays.asList("Monts", "Montagnes", "Falaises", "Crevasses", "Canyons");
		List<String> descPlain = Arrays.asList("Plaines", "Savane", "Terres", "Contrées", "Comté");
		List<String> descRiver = Arrays.asList("Rivière", "Fleuve", "Côte", "Rivages");
		List<String> descSwamp = Arrays.asList("Marécage", "Marais", "Tourbière", "Bourbier");
		List<String> descLake = Arrays.asList("Lacs", "Etangs", "Fontaines", "Cascades", "Chutes");
		switch (tile.getType()) {
		case Wood:
		case Forest:
			this.desc = descWood.get(Tools.dice(descWood.size()));
			break;
		case Hill:
			this.desc = descHill.get(Tools.dice(descHill.size()));
			break;
		case Desert:
			this.desc = descDesert.get(Tools.dice(descDesert.size()));
			break;
		case Sea:
			this.desc = descSea.get(Tools.dice(descSea.size()));
			break;
		case Mountain:
			this.desc = descMountain.get(Tools.dice(descMountain.size()));
			break;
		case Plain:
		case Valley:
			this.desc = descPlain.get(Tools.dice(descPlain.size()));
			break;
		case River:
			this.desc = descRiver.get(Tools.dice(descRiver.size()));
			break;
		case Swamp:
			this.desc = descSwamp.get(Tools.dice(descSwamp.size()));
			break;
		case Lake:
			this.desc = descLake.get(Tools.dice(descLake.size()));
			break;
		default:
			this.desc = "No TileType found";
		}
	}

	public String getDesc() {
		return desc;
	}

}

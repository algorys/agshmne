package io.github.algorys.agshmne.map.region;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.algorys.agshmne.map.tile.TileType;
import io.github.algorys.agshmne.tools.Tools;

public class DescFactory {
	private Map<TileType, List<String>> descs = new HashMap<>();;

	public DescFactory() {
		List<String> descWood = Arrays.asList("Bois", "Forêt", "Jardins", "Jungle", "Sylve", "Bosquet");
		List<String> descHill = Arrays.asList("Collines", "Plateau", "Grand Tertre", "Buttes");
		List<String> descDesert = Arrays.asList("Désert", "Désert de Sel", "Steppe", "Toundra");
		List<String> descSea = Arrays.asList("Mer", "Océan");
		List<String> descMountain = Arrays.asList("Monts", "Montagnes", "Falaises", "Crevasses", "Canyons");
		List<String> descPlain = Arrays.asList("Plaines", "Savane", "Terres", "Contrées", "Comté", "Vallée");
		List<String> descRiver = Arrays.asList("Rivière", "Fleuve", "Côte", "Rivages");
		List<String> descSwamp = Arrays.asList("Marécage", "Marais", "Tourbière", "Bourbier");
		List<String> descLake = Arrays.asList("Lacs", "Etangs", "Fontaines", "Cascades", "Chutes");
		descs.put(TileType.Wood, descWood);
		descs.put(TileType.Forest, descWood);
		descs.put(TileType.Hill, descHill);
		descs.put(TileType.Desert, descDesert);
		descs.put(TileType.Sea, descSea);
		descs.put(TileType.Mountain, descMountain);
		descs.put(TileType.Plain, descPlain);
		descs.put(TileType.Valley, descPlain);
		descs.put(TileType.River, descRiver);
		descs.put(TileType.Swamp, descSwamp);
		descs.put(TileType.Lake, descLake);
	}

	public String randomDesc(TileType tileType) {

		List<String> possibleDesc = descs.get(tileType);
		final String title;
		if (possibleDesc == null) {
			title = "No TileType found";
		} else {
			title = Tools.random(possibleDesc);
		}
		String name = namePlace();
		return title + name;
	}
	
	private String namePlace() {
		String[] namePlace = {
				" des Nuits Noires",
				" de Sombre-Nuit",
				" des Ombres",
				" d'Agshmne",
				" de l'Ogre"
		};
		return Tools.random(namePlace);
	}
}

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
		List<String> descWood = Arrays.asList("Le Bois", "La Forêt", "Les Jardins", "La Jungle", "La Sylve", " Le Bosquet");
		List<String> descHill = Arrays.asList("Les Collines", "Le Plateau", "Le Grand Tertre", "Les Buttes");
		List<String> descDesert = Arrays.asList("Le Désert", "Le Désert de Sel", "La Steppe", "La Toundra");
		List<String> descSea = Arrays.asList("La Mer", "L'Océan", "Les Îles");
		List<String> descMountain = Arrays.asList("Les Monts", "Les Bandes Rocheuses", "Les Falaises", "La Crevasse", "Le Canyon");
		List<String> descPlain = Arrays.asList("Les Plaines", "La Savane", "Les Terres", "Les Contrées", "Le Comté", "La Vallée");
		List<String> descRiver = Arrays.asList("Les Rivières", "Le Fleuve", "Les Côtes", "Le Rivage");
		List<String> descSwamp = Arrays.asList("Les Marécages", "Les Marais", "La Tourbière", "Le Bourbier");
		List<String> descLake = Arrays.asList("Les Lacs", "Les Étendues", "Les Sources", "Les Cascades", "Les Chutes");
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
				" de l'Ogre",
				" de Blanc-Rivage",
				" de Sarleth",
				" de la Tarasque",
				" des Seigneurs Noirs",
				" du Vieux Sage",
				" du Dragon Noir",
				" du Dragon Rouge",
				" du Serpent Géant",
				" de l'Or Maudit",
				" des Sans Voix",
				" de Gerrie la Maudite",
		};
		return Tools.random(namePlace);
	}
}

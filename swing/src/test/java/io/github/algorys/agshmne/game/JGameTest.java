package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.BodyPart;
import io.github.algorys.agshmne.items.EquipableItem;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;;

public class JGameTest {
	
	public static void main(String[] args) {
		Region region = new RandomRegionFactory().create();
		Player pj = new Player(region);
		pj.getSocial().setName("Player");
		EquipableItem item = new EquipableItem("Casque", BodyPart.HEAD);
		pj.getInventory().addItem(item);
		pj.getInventory().addItem(new EquipableItem("Casque", BodyPart.HEAD));
		pj.equip(item);
		pj.initVital();
		JGame game = new JGame(pj);
		game.setVisible(true);
	}

}

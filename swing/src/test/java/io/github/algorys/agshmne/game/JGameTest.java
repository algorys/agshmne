package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.BodyPart;
import io.github.algorys.agshmne.items.EquipableItem;
import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;;

public class JGameTest {

	public static void main(String[] args) {
		Region region = new RandomRegionFactory().create();
		Player pj = new Player(region);
		pj.getSocial().setName("Player");
		EquipableItem item = new EquipableItem("Casque", BodyPart.HEAD, 1);
		pj.getInventory().addItem(item);
		pj.getInventory().addItem(new EquipableItem("Épée", BodyPart.RIGHT_HAND, 1));
		pj.equip(item);
		pj.getInventory().addItem(new GeneralItem("Clou"));
		pj.initVital();
		JGame game = new JGame(pj);
		game.setVisible(true);
	}

}

package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.BodyPart;
import io.github.algorys.agshmne.items.EquipableItem;
import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.items.StackableItem;
import io.github.algorys.agshmne.map.region.RandomRegionFactory;
import io.github.algorys.agshmne.map.region.Region;;

public class JGameTest {

	public static void main(String[] args) {
		Region region = new RandomRegionFactory().create();
		Player pj = new Player(region);
		pj.getSocial().setName("Player");
		
		EquipableItem helmet = new EquipableItem("Casque", BodyPart.HEAD);
		helmet.getAttribute().setINT(5);
		pj.getInventory().addItem(helmet);
		EquipableItem sword = new EquipableItem("Épée", BodyPart.RIGHT_HAND);
		sword.getAttribute().setFOR(10);
		pj.getInventory().addItem(sword);
		EquipableItem leatherArmor = new EquipableItem("Armure en cuir", BodyPart.CHEST);
		leatherArmor.getAttribute().setFOR(15);
		pj.getInventory().addItem(leatherArmor);
		GeneralItem barrel = new GeneralItem("Tonneau");
		pj.getInventory().addItem(barrel);
		
		pj.equip(helmet);
		pj.equip(sword);
		pj.getInventory().addItem(new StackableItem("Clou", 1));
		pj.initVital();
		JGame game = new JGame(pj);
		game.setVisible(true);
	}

}

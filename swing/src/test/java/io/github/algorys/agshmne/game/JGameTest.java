package io.github.algorys.agshmne.game;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.items.stackable.StackableItem;;

public class JGameTest {

	public static void main(String[] args) {
		PlayerBuilder playerBuilder = new PlayerBuilder();
		Player pj = playerBuilder.create();
		Game game = playerBuilder.getGame();
		pj.getSocial().setName("Player Playing");
		pj.getXp().setXp(125);
		System.out.println(pj.getXp().getProgress());

		EquipableItem helmet = new EquipableItem("Casque", BodyPart.HEAD, 10);
		helmet.getAttribute().setINT(5);
		pj.getInventory().addItem(helmet);
		EquipableItem sword = new EquipableItem("Épée", BodyPart.RIGHT_HAND, 15);
		sword.getAttribute().setFOR(10);
		pj.getInventory().addItem(sword);
		EquipableItem leatherArmor = new EquipableItem("Armure en cuir", BodyPart.CHEST, 20);
		leatherArmor.getAttribute().setFOR(15);
		pj.getInventory().addItem(leatherArmor);
		GeneralItem barrel = new GeneralItem("Tonneau", 5);
		pj.getInventory().addItem(barrel);
		pj.getInventory().addItem(new EquipableItemFactory().createRandom());
		pj.getInventory().addItem(new EquipableItemFactory().createRandom());

		pj.equip(helmet);
		pj.equip(sword);
		pj.getInventory().addItem(new StackableItem("Clou", 1, 2));
		pj.initVital();
		JGame jgame = new JGame(game);
		jgame.setVisible(true);
	}

}

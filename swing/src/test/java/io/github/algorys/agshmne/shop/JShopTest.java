package io.github.algorys.agshmne.shop;

import javax.swing.JFrame;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.PlayerBuilder;
import io.github.algorys.agshmne.items.GeneralItem;
import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
import io.github.algorys.agshmne.items.stackable.StackableItem;
import io.github.algorys.agshmne.map.city.shop.JShop;

public class JShopTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame("Inventory Ground...");
		
		Player pj = new PlayerBuilder().create();
		pj.getSocial().setName("Algorys");
		pj.getInventory().setGold(-10);
		pj.getInventory().addItem(new GeneralItem("Bouteille", 3));
		pj.getInventory().addItem(new StackableItem("Pomme", 15, 2));
		pj.getInventory().addItem(new EquipableItem("Armure en Cuir", BodyPart.HEAD, 20));
		pj.getInventory().addItem(new EquipableItem("Armure de Dragon", BodyPart.HEAD, 200));
		
		JShop shopDial = new JShop(pj);
		jf.add(shopDial);
		jf.setSize(900, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}

}

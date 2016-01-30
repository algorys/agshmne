package io.github.algorys.agshmne.items;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.tools.Tools;

public class EquipableItemFactory {
	private List<String> lowCloseWeapon = new ArrayList<>();;
	private List<String> lowHead = new ArrayList<>();;
	private List<String> lowArms = new ArrayList<>();;
	private List<String> lowLegs = new ArrayList<>();;
	private List<String> lowChest = new ArrayList<>();;

	public EquipableItemFactory() {
		lowCloseWeapon.add("Épée en fer:1");
		lowCloseWeapon.add("Hache en fer:1");
		lowCloseWeapon.add("Sabre en fer:1");
		lowCloseWeapon.add("Dague en fer:1");
		lowCloseWeapon.add("Baton en fer:1");

		lowHead.add("Casque en cuir:1");
		lowHead.add("Chapeau en tissu:1");

		lowArms.add("Brassieres en cuir:1");
		lowArms.add("Protège bras en tissu:1");

		lowLegs.add("Jambières en cuir:1");
		lowLegs.add("Protège-tibia:1");

		lowChest.add("Armure en cuir:2");
		lowChest.add("Plastron en cuir:1");
	}

	public EquipableItem createCloseWeapon() {
		String weapon = lowCloseWeapon.get(Tools.dice(lowCloseWeapon.size()));
		String[] values = weapon.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.RIGHT_HAND);
		equipableItem.getAttribute().setFOR(Integer.parseInt(values[1]));
		return equipableItem;
	}

	public EquipableItem createHeadArmor() {
		String head = lowHead.get(Tools.dice(lowHead.size()));
		String[] values = head.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.HEAD);
		equipableItem.getAttribute().setINT(Integer.parseInt(values[1]));
		return equipableItem;
	}

	public EquipableItem createArmsArmor() {
		String arms = lowArms.get(Tools.dice(lowArms.size()));
		String[] values = arms.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.ARMS);
		equipableItem.getAttribute().setCON(Integer.parseInt(values[1]));
		return equipableItem;
	}

	public EquipableItem createLegsArmor() {
		String legs = lowLegs.get(Tools.dice(lowLegs.size()));
		String[] values = legs.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.LEGS);
		equipableItem.getAttribute().setCON(Integer.parseInt(values[1]));
		return equipableItem;
	}

	public EquipableItem createChestArmor() {
		String chest = lowChest.get(Tools.dice(lowChest.size()));
		String[] values = chest.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.CHEST);
		equipableItem.getAttribute().setCON(Integer.parseInt(values[1]));
		return equipableItem;
	}
}

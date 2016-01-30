package io.github.algorys.agshmne.items;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.tools.Tools;

public class EquipableItemFactory {
	private List<String> lowCloseWeapon = new ArrayList<>();;
	private List<String> lowHead = new ArrayList<>();;
	private List<String> lowArms = new ArrayList<>();;
	private List<String> lowLegs = new ArrayList<>();;
	private List<String> lowChest = new ArrayList<>();;

	public EquipableItemFactory() {
		lowCloseWeapon.add("Épée en fer:FOR+1");
		lowCloseWeapon.add("Hache en fer:FOR+1");
		lowCloseWeapon.add("Sabre en fer:FOR+1");
		lowCloseWeapon.add("Dague en fer:FOR+1");
		lowCloseWeapon.add("Baton en fer:FOR+1");

		lowHead.add("Casque en cuir:INT+1");
		lowHead.add("Chapeau en tissu:INT+1");

		lowArms.add("Brassieres en cuir:CON+1");
		lowArms.add("Protège bras en tissu:CON+1");

		lowLegs.add("Jambières en cuir:CON+1");
		lowLegs.add("Protège-tibia:CON+1");

		lowChest.add("Armure en cuir:CON+2");
		lowChest.add("Plastron en cuir:CON+1");
	}

	private void manageAttribute(String input, Attribute attribute) {
		String carac = input.substring(0, 3);
		int modifier = Integer.parseInt(input.substring(3));
		if("FOR".equals(carac)) {
			attribute.setFOR(modifier);
		} else if ("INT".equals(carac)) {
			attribute.setINT(modifier);
		} else if ("CON".equals(carac)) {
			attribute.setCON(modifier);
		} else {
			throw new IllegalArgumentException(String.format("Le paramètre input [%s] n'est pas reconnu", input));
		}
	}

	public EquipableItem createCloseWeapon() {
		String weapon = lowCloseWeapon.get(Tools.dice(lowCloseWeapon.size()));
		String[] values = weapon.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.RIGHT_HAND);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	public EquipableItem createHeadArmor() {
		String head = lowHead.get(Tools.dice(lowHead.size()));
		String[] values = head.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.HEAD);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	public EquipableItem createArmsArmor() {
		String arms = lowArms.get(Tools.dice(lowArms.size()));
		String[] values = arms.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.ARMS);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	public EquipableItem createLegsArmor() {
		String legs = lowLegs.get(Tools.dice(lowLegs.size()));
		String[] values = legs.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.LEGS);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	public EquipableItem createChestArmor() {
		String chest = lowChest.get(Tools.dice(lowChest.size()));
		String[] values = chest.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.CHEST);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}
}

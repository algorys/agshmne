package io.github.algorys.agshmne.items.equipable;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.tools.Tools;

public class EquipableItemFactory {
	private List<String> lowCloseWeapon = new ArrayList<>();
	private List<String> lowHead = new ArrayList<>();
	private List<String> lowArms = new ArrayList<>();
	private List<String> lowLegs = new ArrayList<>();
	private List<String> lowChest = new ArrayList<>();
	private List<String> lowRing = new ArrayList<>();
	private List<String> lowNecklace = new ArrayList<>();

	public EquipableItemFactory() {
		lowCloseWeapon.add("Épée en fer:FOR+1");
		lowCloseWeapon.add("Hache en fer:FOR+1");
		lowCloseWeapon.add("Sabre en fer:FOR+1");
		lowCloseWeapon.add("Dague en fer:FOR+1");
		lowCloseWeapon.add("Baton en fer:FOR+1");
		lowCloseWeapon.add("Athamée:FOR-1,DEX+1,INT+1");

		lowHead.add("Casque en cuir:INT+1");
		lowHead.add("Chapeau en tissu:INT+1");
		lowHead.add("Chapeau coquet:INT-1,CHA+1");

		lowArms.add("Brassieres en cuir:CON+1");
		lowArms.add("Protège bras en tissu:CON+1");
		lowArms.add("Bracelet de force:CON+1,FOR+1");

		lowLegs.add("Jambières en cuir:CON+1");
		lowLegs.add("Protège-tibia:CON+1");

		lowChest.add("Armure en cuir:CON+2");
		lowChest.add("Plastron en cuir:CON+1");
		lowChest.add("Robe de prêtre:CON-1,INT+1,CHA-1");
		
		lowRing.add("Anneau de cuivre:CHA+1");
		lowRing.add("Anneau d'argent:DEX+1");
		lowRing.add("Anneau doré:INT+2");
		
		lowNecklace.add("Collier de Beauté:CHA+2");
		lowNecklace.add("Amulette de Savoir:INT+2");
		lowNecklace.add("Talisman de Courage:FOR+2");
		
	}

	private void manageAttribute(String manyCaracsInput, Attribute attribute) {
		String[] caracs = manyCaracsInput.split(",");
		for(String carac : caracs) {
			manageSingleAttribute(carac, attribute);
		}
	}

	private void manageSingleAttribute(String singleCaracInput, Attribute attribute) {
		String carac = singleCaracInput.substring(0, 3);
		int modifier = Integer.parseInt(singleCaracInput.substring(3));
		if("FOR".equals(carac)) {
			attribute.setFOR(modifier);
		} else if ("INT".equals(carac)) {
			attribute.setINT(modifier);
		} else if ("CON".equals(carac)) {
			attribute.setCON(modifier);
		} else if ("CHA".equals(carac)) {
			attribute.setCHA(modifier);
		} else if ("DEX".equals(carac)) {
			attribute.setDEX(modifier);
		} else {
			throw new IllegalArgumentException(String.format("Le paramètre input [%s] n'est pas reconnu", singleCaracInput));
		}
	}

	public EquipableItem createCloseWeapon() {
		String weapon = Tools.random(lowCloseWeapon);
		String[] values = weapon.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.RIGHT_HAND);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	public EquipableItem createHeadArmor() {
		String head = Tools.random(lowHead);
		String[] values = head.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.HEAD);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	public EquipableItem createArmsArmor() {
		String arms = Tools.random(lowArms);
		String[] values = arms.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.ARMS);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	public EquipableItem createLegsArmor() {
		String legs = Tools.random(lowLegs);
		String[] values = legs.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.LEGS);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	public EquipableItem createChestArmor() {
		String chest = Tools.random(lowChest);
		String[] values = chest.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.CHEST);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}
	
	public EquipableItem createRing() {
		String ring = Tools.random(lowRing);
		String[] values = ring.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.RING);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}
	
	public EquipableItem createNecklace() {
		String ring = Tools.random(lowNecklace);
		String[] values = ring.split(":");
		String name = values[0];
		EquipableItem equipableItem = new EquipableItem(name, BodyPart.NECKLACE);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}
}

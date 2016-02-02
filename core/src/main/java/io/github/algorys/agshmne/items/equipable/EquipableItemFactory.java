package io.github.algorys.agshmne.items.equipable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.algorys.agshmne.items.IItemFactory;
import io.github.algorys.agshmne.tools.Tools;

public class EquipableItemFactory implements IItemFactory {
	private BodyPartItemFactory necklaceFactory;
	private BodyPartItemFactory ringFactory;
	private BodyPartItemFactory chestFactory;
	private BodyPartItemFactory legsFactory;
	private BodyPartItemFactory armsFactory;
	private BodyPartItemFactory headFactory;
	private BodyPartItemFactory closeWeaponFactory;
	private Map<BodyPart, BodyPartItemFactory> bodyPartFactories;

	public EquipableItemFactory() {
		List<String> lowCloseWeapon = new ArrayList<>();
		lowCloseWeapon.add("Épée en fer:FOR+1");
		lowCloseWeapon.add("Hache en fer:FOR+1");
		lowCloseWeapon.add("Sabre en fer:FOR+1");
		lowCloseWeapon.add("Dague en fer:FOR+1");
		lowCloseWeapon.add("Baton en fer:FOR+1");
		lowCloseWeapon.add("Athamée:FOR-1,DEX+1,INT+1");
		closeWeaponFactory = new BodyPartItemFactory(lowCloseWeapon, BodyPart.RIGHT_HAND);

		List<String> lowHead = new ArrayList<>();
		lowHead.add("Casque en cuir:INT+1");
		lowHead.add("Chapeau en tissu:INT+1");
		lowHead.add("Chapeau coquet:INT-1,CHA+1");
		headFactory = new BodyPartItemFactory(lowHead, BodyPart.HEAD);

		List<String> lowArms = new ArrayList<>();
		lowArms.add("Brassieres en cuir:CON+1");
		lowArms.add("Protège bras en tissu:CON+1");
		lowArms.add("Bracelet de force:CON+1,FOR+1");
		armsFactory = new BodyPartItemFactory(lowArms, BodyPart.ARMS);
		
		List<String> lowLegs = new ArrayList<>();
		lowLegs.add("Jambières en cuir:CON+1");
		lowLegs.add("Protège-tibia:CON+1");
		legsFactory = new BodyPartItemFactory(lowLegs, BodyPart.LEGS);
		
		List<String> lowChest = new ArrayList<>();
		lowChest.add("Armure en cuir:CON+2");
		lowChest.add("Plastron en cuir:CON+1");
		lowChest.add("Robe de prêtre:CON-1,INT+1,CHA-1");
		chestFactory = new BodyPartItemFactory(lowChest, BodyPart.CHEST);

		List<String> lowRing = new ArrayList<>();
		lowRing.add("Anneau de cuivre:CHA+1");
		lowRing.add("Anneau d'argent:DEX+1");
		lowRing.add("Anneau doré:INT+2");
		ringFactory = new BodyPartItemFactory(lowRing, BodyPart.RING);

		List<String> lowNecklace = new ArrayList<>();
		lowNecklace.add("Collier de Beauté:CHA+2");
		lowNecklace.add("Amulette de Savoir:INT+2");
		lowNecklace.add("Talisman de Courage:FOR+2");
		necklaceFactory = new BodyPartItemFactory(lowNecklace, BodyPart.NECKLACE);

		bodyPartFactories = new HashMap<>();
		bodyPartFactories.put(BodyPart.ARMS, armsFactory);
		bodyPartFactories.put(BodyPart.CHEST, chestFactory);
		bodyPartFactories.put(BodyPart.HEAD, headFactory);
		bodyPartFactories.put(BodyPart.LEFT_HAND, closeWeaponFactory);
		bodyPartFactories.put(BodyPart.RIGHT_HAND, closeWeaponFactory);
		bodyPartFactories.put(BodyPart.LEGS, legsFactory);
		bodyPartFactories.put(BodyPart.NECKLACE, necklaceFactory);
		bodyPartFactories.put(BodyPart.RING, ringFactory);
	}

	@Override
	public EquipableItem createRandom() {
		return bodyPartFactories.get(Tools.random(BodyPart.values())).createRandom();
	}

	public BodyPartItemFactory getNecklaceFactory() {
		return necklaceFactory;
	}

	public BodyPartItemFactory getRingFactory() {
		return ringFactory;
	}

	public BodyPartItemFactory getChestFactory() {
		return chestFactory;
	}

	public BodyPartItemFactory getLegsFactory() {
		return legsFactory;
	}

	public BodyPartItemFactory getArmsFactory() {
		return armsFactory;
	}

	public BodyPartItemFactory getHeadFactory() {
		return headFactory;
	}

	public BodyPartItemFactory getCloseWeaponFactory() {
		return closeWeaponFactory;
	}
}

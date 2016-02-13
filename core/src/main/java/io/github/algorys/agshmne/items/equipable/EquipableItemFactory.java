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
		lowCloseWeapon.add("Épée en fer:FOR+1:30");
		lowCloseWeapon.add("Hache en fer:FOR+1:35");
		lowCloseWeapon.add("Sabre en fer:FOR+1:27");
		lowCloseWeapon.add("Dague en fer:FOR+1:20");
		lowCloseWeapon.add("Baton en fer:FOR+1:22");
		lowCloseWeapon.add("Athamée:FOR-1,DEX+1,INT+1:55");
		closeWeaponFactory = new BodyPartItemFactory(lowCloseWeapon, BodyPart.RIGHT_HAND);

		List<String> lowHead = new ArrayList<>();
		lowHead.add("Casque en cuir:INT+1:15");
		lowHead.add("Chapeau en tissu:INT+1:12");
		lowHead.add("Chapeau coquet:INT-1,CHA+1:14");
		lowHead.add("Couronne des Rois:DEX-2,CHA+4,FOR+4:1100");
		headFactory = new BodyPartItemFactory(lowHead, BodyPart.HEAD);

		List<String> lowArms = new ArrayList<>();
		lowArms.add("Brassieres en cuir:CON+2:25");
		lowArms.add("Protège bras en tissu:CON+1:17");
		lowArms.add("Bracelet de force:FOR+2:34");
		lowArms.add("Bracelet de puissance:CON+1,FOR+3:34");
		armsFactory = new BodyPartItemFactory(lowArms, BodyPart.ARMS);
		
		List<String> lowLegs = new ArrayList<>();
		lowLegs.add("Jambières de Morath:CON+4,DEX-1:150");
		lowLegs.add("Jambières en cuir:CON+2:32");
		lowLegs.add("Protège-tibia:CON+1:17");
		legsFactory = new BodyPartItemFactory(lowLegs, BodyPart.LEGS);
		
		List<String> lowChest = new ArrayList<>();
		lowChest.add("Armure en cuir:CON+2:45");
		lowChest.add("Plastron en cuir:CON+1:35");
		lowChest.add("Robe de prêtre:CON-2,INT+2,CHA-1:120");
		chestFactory = new BodyPartItemFactory(lowChest, BodyPart.CHEST);

		List<String> lowRing = new ArrayList<>();
		lowRing.add("Anneau de cuivre:CHA+1:100");
		lowRing.add("Anneau d'argent:DEX+1:130");
		lowRing.add("Anneau doré:INT+2:355");
		lowRing.add("Sceau d'Archimagie:INT+5,CHA+2,FOR-3:3314");
		ringFactory = new BodyPartItemFactory(lowRing, BodyPart.RING);

		List<String> lowNecklace = new ArrayList<>();
		lowNecklace.add("Collier de Beauté:CHA+2:660");
		lowNecklace.add("Amulette de Savoir:INT+2:880");
		lowNecklace.add("Talisman de Courage:FOR+2:750");
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

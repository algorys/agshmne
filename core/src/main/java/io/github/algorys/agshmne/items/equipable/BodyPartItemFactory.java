package io.github.algorys.agshmne.items.equipable;

import java.util.List;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.items.IItemFactory;
import io.github.algorys.agshmne.tools.Tools;

public class BodyPartItemFactory implements IItemFactory {
	private List<String> descriptions;
	private BodyPart part;

	public BodyPartItemFactory(List<String> descriptions, BodyPart part) {
		super();
		this.descriptions = descriptions;
		this.part = part;
	}

	@Override
	public EquipableItem createRandom() {
		String weapon = Tools.random(descriptions);
		String[] values = weapon.split(":");
		String name = values[0];
		int price = Integer.parseInt(values[2]);
		EquipableItem equipableItem = new EquipableItem(name, part, price);
		manageAttribute(values[1], equipableItem.getAttribute());
		return equipableItem;
	}

	private void manageAttribute(String manyCaracsInput, Attribute attribute) {
		String[] caracs = manyCaracsInput.split(",");
		for (String carac : caracs) {
			manageSingleAttribute(carac, attribute);
		}
	}

	private void manageSingleAttribute(String singleCaracInput, Attribute attribute) {
		String carac = singleCaracInput.substring(0, 3);
		int modifier = Integer.parseInt(singleCaracInput.substring(3));
		if ("FOR".equals(carac)) {
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
			throw new IllegalArgumentException(
					String.format("Le paramètre input [%s] n'est pas reconnu", singleCaracInput));
		}
	}
}

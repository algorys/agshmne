package io.github.algorys.agshmne.items.equipable;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.items.GeneralItem;

public class EquipableItem extends GeneralItem implements IEquipableItem {
	private BodyPart part;
	private boolean equipped;
	private Attribute attribute = new Attribute();

	public EquipableItem(String name, BodyPart part, int price) {
		super(name, price);
		this.part = part;
	}

	public void equip() {
		this.equipped = true;
	}
	
	@Override
	public int getPuissance() {
		int puissance = attribute.getFOR() + attribute.getDEX() + attribute.getCON() + attribute.getINT() + attribute.getCHA();
		return puissance;
	}

	@Override
	public void unequip() {
		this.equipped = false;
	}

	@Override
	public boolean isEquipped() {
		return equipped;
	}

	@Override
	public BodyPart getPart() {
		return part;
	}

	@Override
	public Attribute getAttribute() {
		return attribute;
	}
}

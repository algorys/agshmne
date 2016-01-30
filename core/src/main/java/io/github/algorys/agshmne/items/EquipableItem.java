package io.github.algorys.agshmne.items;

import io.github.algorys.agshmne.character.Attribute;

public class EquipableItem extends GeneralItem implements IEquipableItem {
	private BodyPart part;
	private boolean equipped;
	private Attribute attribute = new Attribute();

	public EquipableItem(String name, BodyPart part) {
		super(name);
		this.part = part;
	}

	public void equip() {
		this.equipped = true;
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

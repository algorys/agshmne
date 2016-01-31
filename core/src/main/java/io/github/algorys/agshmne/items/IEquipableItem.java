package io.github.algorys.agshmne.items;

import io.github.algorys.agshmne.character.Attribute;

public interface IEquipableItem extends Item {
	public boolean isEquipped();

	public BodyPart getPart();

	public void equip();

	public void unequip();

	public Attribute getAttribute();

	int getPuissance();

}

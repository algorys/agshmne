package io.github.algorys.agshmne.items.equipable;

import io.github.algorys.agshmne.character.Attribute;
import io.github.algorys.agshmne.items.Item;

public interface IEquipableItem extends Item {
	public boolean isEquipped();

	public BodyPart getPart();

	public void equip();

	public void unequip();

	public Attribute getAttribute();

	int getPuissance();

}

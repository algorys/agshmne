package io.github.algorys.agshmne.character.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.Test;

import io.github.algorys.agshmne.items.BodyPart;
import io.github.algorys.agshmne.items.EquipableItem;
import io.github.algorys.agshmne.map.Position;

public class PlayerTest {

	private final class MyObserver implements PropertyChangeListener {
		private int called = 0;

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			called++;
		}

		public boolean isCalled() {
			return called > 0;
		}
	}

	@Test
	public void whenCharacterIsCreated_positionShouldBe00() {
		Player underTest = new Player(null);
		assertEquals(new Position(0, 0), underTest.getPosition());
	}

	@Test
	public void whenCharacterChangePosition_observersShouldBeNotified() {
		Player underTest = new Player(null);
		MyObserver myObserver = new MyObserver();
		underTest.addPropertyChangeListener(myObserver);
		underTest.setPosition(new Position(1, 0));
		assertTrue(myObserver.isCalled());
	}

	@Test
	public void whenCharacterSetSamePosition_observersShouldNotBeNotified() {
		Player underTest = new Player(null);
		MyObserver myObserver = new MyObserver();
		underTest.addPropertyChangeListener(myObserver);
		underTest.setPosition(new Position(0, 0));
		assertFalse(myObserver.isCalled());
	}

	@Test
	public void whenCharacterEquipAnItem() {
		Player underTest = new Player(null);
		EquipableItem item = new EquipableItem("Casque", BodyPart.HEAD, 1);
		underTest.getInventory().addItem(item);
		assertTrue(underTest.getInventory().contains(item));
		assertFalse(item.isEquipped());
		underTest.equip(item);
		assertTrue(item.isEquipped());
	}

	@Test
	public void whenCharacterEquipAnItemHeDoesNotHave() {
		Player underTest = new Player(null);
		EquipableItem item = new EquipableItem("Casque", BodyPart.HEAD, 1);
		assertFalse(underTest.getInventory().contains(item));
		assertFalse(item.isEquipped());
		underTest.equip(item);
		assertFalse(item.isEquipped());
	}

	@Test
	public void whenCharacterEquipASecondItem() {
		Player underTest = new Player(null);
		EquipableItem first = new EquipableItem("Casque", BodyPart.HEAD, 1);
		EquipableItem second = new EquipableItem("Bottes", BodyPart.LEGS, 1);
		underTest.getInventory().addItem(first);
		underTest.getInventory().addItem(second);

		assertTrue(underTest.getInventory().contains(first));
		assertTrue(underTest.getInventory().contains(second));

		assertFalse(first.isEquipped());
		assertFalse(second.isEquipped());

		underTest.equip(first);

		assertTrue(first.isEquipped());
		assertFalse(second.isEquipped());

		underTest.equip(second);

		assertTrue(first.isEquipped());
		assertTrue(second.isEquipped());
	}

	@Test
	public void whenCharacterUnEquipAnItem() {
		Player underTest = new Player(null);
		EquipableItem item = new EquipableItem("Casque", BodyPart.HEAD, 1);
		underTest.getInventory().addItem(item);
		underTest.equip(item);
		assertTrue(item.isEquipped());
		underTest.unequip(item);
		assertFalse(item.isEquipped());
	}

	@Test
	public void whenCharacterEquipASecondItem_sameBodyPart() {
		Player underTest = new Player(null);
		EquipableItem first = new EquipableItem("Casque", BodyPart.HEAD, 1);
		EquipableItem second = new EquipableItem("Chapeau", BodyPart.HEAD, 1);
		underTest.getInventory().addItem(first);
		underTest.getInventory().addItem(second);

		assertTrue(underTest.getInventory().contains(first));
		assertTrue(underTest.getInventory().contains(second));

		assertFalse(first.isEquipped());
		assertFalse(second.isEquipped());

		underTest.equip(first);

		assertTrue(first.isEquipped());
		assertFalse(second.isEquipped());

		underTest.equip(second);

		assertFalse(first.isEquipped());
		assertTrue(second.isEquipped());
	}

	@Test
	public void whenCharacterEquipACloseWeapon_FORisModifed() {
		Player underTest = new Player(null);
		underTest.getAttributes().setFOR(12);
		assertTrue(underTest.getAttributes().getFOR() == 12);
		EquipableItem sword = new EquipableItem("Sword", BodyPart.RIGHT_HAND, 1);
		underTest.getInventory().addItem(sword);
		underTest.equip(sword);

		assertTrue(underTest.getInventory().contains(sword));
		assertTrue(underTest.getAttributes().getFOR() != underTest.getCurrentAttributes().getFOR());
	}

}

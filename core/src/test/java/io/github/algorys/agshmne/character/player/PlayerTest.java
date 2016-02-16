package io.github.algorys.agshmne.character.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.Test;

import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.items.equipable.BodyPart;
import io.github.algorys.agshmne.items.equipable.EquipableItem;
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
	public void whenCharacterVitalAreInit_VitalShouldNotBeNull() {
		Player underTest = new Player(null);
		underTest.initVital();
		assertNotNull(underTest.getVital());
	}

	@Test
	public void whenCharacterIsCreatedSkillsAreNotNull() {
		Player underTest = new Player(null);
		assertNotNull(underTest.getSkills());
		for (SkillType type : SkillType.values()) {
			assertNotNull(underTest.getSkills().getSkillName(type));
			assertNotNull(underTest.getSkills().getSkillLevel(type));
		}
	}

	@Test
	public void whenCharacterIsCreatedInventoryIsNotNull() {
		Player underTest = new Player(null);
		assertNotNull(underTest.getInventory());
	}

	@Test
	public void whenCharacterIsCreatedLevelShouldBeEqualToOne_AndXPToZero() {
		Player underTest = new Player(null);
		assertEquals(1, underTest.getXp().getLevel());
		assertEquals(0, underTest.getXp().getXp());
	}

	@Test
	public void whenCharacterIsCreated_positionShouldBe00() {
		Player underTest = new Player(null);
		assertEquals(new Position(0, 0), underTest.getPosition());
	}

	@Test
	public void whenCharacterChangePosition_observersShouldBeNotified() {
		Player underTest = new PlayerBuilder().create();
		MyObserver myObserver = new MyObserver();
		underTest.addPropertyChangeListener(Player.PROPERTY_POSITION, myObserver);
		underTest.setPosition(new Position(1, 0));
		assertTrue(myObserver.isCalled());
	}

	@Test
	public void whenCharacterSetSamePosition_observersShouldNotBeNotified() {
		Player underTest = new PlayerBuilder().create();
		MyObserver myObserver = new MyObserver();
		underTest.addPropertyChangeListener(myObserver);
		underTest.setPosition(new Position(0, 0));
		assertFalse(myObserver.isCalled());
	}

	@Test
	public void whenCharacterEquipAnItem() {
		Player underTest = new Player(null);
		EquipableItem item = new EquipableItem("Casque", BodyPart.HEAD, 10);
		underTest.getInventory().addItem(item);
		assertTrue(underTest.getInventory().contains(item));
		assertFalse(item.isEquipped());
		underTest.equip(item);
		assertTrue(item.isEquipped());
	}

	@Test
	public void whenCharacterEquipAnItemHeDoesNotHave() {
		Player underTest = new Player(null);
		EquipableItem item = new EquipableItem("Casque", BodyPart.HEAD, 10);
		assertFalse(underTest.getInventory().contains(item));
		assertFalse(item.isEquipped());
		underTest.equip(item);
		assertFalse(item.isEquipped());
	}

	@Test
	public void whenCharacterEquipASecondItem() {
		Player underTest = new Player(null);
		EquipableItem first = new EquipableItem("Casque", BodyPart.HEAD, 10);
		EquipableItem second = new EquipableItem("Bottes", BodyPart.LEGS, 15);
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
		EquipableItem item = new EquipableItem("Casque", BodyPart.HEAD, 10);
		underTest.getInventory().addItem(item);
		underTest.equip(item);
		assertTrue(item.isEquipped());
		underTest.unequip(item);
		assertFalse(item.isEquipped());
	}

	@Test
	public void whenCharacterEquipASecondItem_sameBodyPart() {
		Player underTest = new Player(null);
		EquipableItem first = new EquipableItem("Casque", BodyPart.HEAD, 10);
		EquipableItem second = new EquipableItem("Chapeau", BodyPart.HEAD, 7);
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
		EquipableItem sword = new EquipableItem("Sword", BodyPart.RIGHT_HAND, 15);
		sword.getAttribute().setFOR(1);
		underTest.getInventory().addItem(sword);
		underTest.equip(sword);

		assertTrue(underTest.getInventory().contains(sword));
		assertTrue(underTest.getAttributes().getFOR() != underTest.getCurrentAttributes().getFOR());
	}

	@Test
	public void whenCharacterEquipAChest_CONisModifed() {
		Player underTest = new Player(null);
		underTest.getAttributes().setCON(12);
		assertTrue(underTest.getAttributes().getCON() == 12);
		EquipableItem armor = new EquipableItem("Armor", BodyPart.CHEST, 20);
		armor.getAttribute().setCON(1);
		underTest.getInventory().addItem(armor);
		assertTrue(underTest.getInventory().contains(armor));

		underTest.equip(armor);

		assertEquals(12, underTest.getAttributes().getCON());
		assertEquals(13, underTest.getCurrentAttributes().getCON());
	}

	@Test
	public void whenCharacterEquipAChestALegsAndArms_CONisModifedWithThreeModifier() {
		Player underTest = new Player(null);
		underTest.getAttributes().setCON(12);
		EquipableItem armor = new EquipableItem("Armor", BodyPart.CHEST, 20);
		armor.getAttribute().setCON(1);
		EquipableItem legs = new EquipableItem("Legs", BodyPart.LEGS, 15);
		legs.getAttribute().setCON(1);
		EquipableItem arms = new EquipableItem("Arms", BodyPart.ARMS, 17);
		arms.getAttribute().setCON(1);
		underTest.getInventory().addItem(armor);
		underTest.getInventory().addItem(legs);
		underTest.getInventory().addItem(arms);
		assertTrue(underTest.getInventory().contains(armor));
		assertTrue(underTest.getInventory().contains(legs));
		assertTrue(underTest.getInventory().contains(arms));

		underTest.equip(armor);
		underTest.equip(legs);
		underTest.equip(arms);

		assertEquals(12, underTest.getAttributes().getCON());
		assertEquals(15, underTest.getCurrentAttributes().getCON());
	}

	@Test
	public void whenCharacterEquipAChestALegsAndArms_AndRemoveOne_CONisModifedWithTwoModifier() {
		Player underTest = new Player(null);
		underTest.getAttributes().setCON(12);
		EquipableItem armor = new EquipableItem("Armor", BodyPart.CHEST, 20);
		armor.getAttribute().setCON(1);
		EquipableItem legs = new EquipableItem("Legs", BodyPart.LEGS, 15);
		legs.getAttribute().setCON(1);
		EquipableItem arms = new EquipableItem("Arms", BodyPart.ARMS, 15);
		arms.getAttribute().setCON(2);
		underTest.getInventory().addItem(armor);
		underTest.getInventory().addItem(legs);
		underTest.getInventory().addItem(arms);
		assertTrue(underTest.getInventory().contains(armor));
		assertTrue(underTest.getInventory().contains(legs));
		assertTrue(underTest.getInventory().contains(arms));

		underTest.equip(armor);
		underTest.equip(legs);
		underTest.equip(arms);

		assertEquals(12, underTest.getAttributes().getCON());
		assertEquals(16, underTest.getCurrentAttributes().getCON());

		underTest.unequip(arms);
		assertEquals(12, underTest.getAttributes().getCON());
		assertEquals(14, underTest.getCurrentAttributes().getCON());
	}

}

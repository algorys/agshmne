package io.github.algorys.agshmne.events.quest;

import java.util.ArrayList;
import java.util.List;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.IAdventureFactory;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.tools.Tools;

public class QuestFactory implements IAdventureFactory {
	private IQuest fetch;
	private List<IQuest> listQuest = new ArrayList<>();

	public QuestFactory(Player pj) {
		fetch = new FetchStackQuest(pj, new ItemFactory().createStackableItem(), Tools.dice(6));

		IQuest bringMisc = new BringQuest(pj, new ItemFactory().createItem());
		IQuest bringChest = new BringQuest(pj, new EquipableItemFactory().createChestArmor());
		IQuest bringHead = new BringQuest(pj, new EquipableItemFactory().createHeadArmor());
		IQuest bringArms = new BringQuest(pj, new EquipableItemFactory().createArmsArmor());
		IQuest bringLegs = new BringQuest(pj, new EquipableItemFactory().createLegsArmor());
		IQuest bringRing = new BringQuest(pj, new EquipableItemFactory().createRing());
		IQuest bringNeck = new BringQuest(pj, new EquipableItemFactory().createNecklace());
		IQuest bringWeapon = new BringQuest(pj, new EquipableItemFactory().createCloseWeapon());

		listQuest.add(bringMisc);
		listQuest.add(bringHead);
		listQuest.add(bringChest);
		listQuest.add(bringArms);
		listQuest.add(bringLegs);
		listQuest.add(bringRing);
		listQuest.add(bringNeck);
		listQuest.add(bringWeapon);
	}

	public IQuest createFetchQuest() {
		return fetch;
	}

	public IQuest createBringQuest() {
		return Tools.random(listQuest);
	}

	public IQuest createRandomQuest() {
		listQuest.add(fetch); // XXX
		return Tools.random(listQuest);
	}

	@Override
	public IQuest createAdventure(Player pj) {
		return createRandomQuest();
	}
}

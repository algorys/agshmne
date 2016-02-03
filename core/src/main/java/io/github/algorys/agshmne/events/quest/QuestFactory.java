package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.events.IAdventureFactory;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.tools.Tools;

public class QuestFactory implements IAdventureFactory {
	/*
	 *  TODO Ajouter les Quêtes suivantes :
	 *  - Énigmes
	 *  - Production d'objets
	 *  - Aller tuer une créature à un lieu donné
	 */
	private EquipableItemFactory equipableItemFactory = new EquipableItemFactory();
	private ItemFactory itemFactory = new ItemFactory();

	public QuestFactory() {

	}

	public IQuest createFetchQuest(Player pj) {
		return new FetchQuest(pj, new ItemFactory().createStackableItem(), Tools.dice(6));
	}

	public IQuest createBringQuest(Player pj) {
		return new BringQuest(pj, Tools.random(itemFactory, equipableItemFactory).createRandom());
	}

	@Override
	public IQuest createAdventure(Player pj) {
		if(Tools.dice(2) == 1) {
			return this.createFetchQuest(pj);
		} else {
			return this.createBringQuest(pj);
		}
	}
}

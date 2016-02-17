package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.events.IAdventureFactory;
import io.github.algorys.agshmne.items.ItemFactory;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.tools.RandomCoordinated;
import io.github.algorys.agshmne.tools.Tools;

public class QuestFactory implements IAdventureFactory {
	private EquipableItemFactory equipableItemFactory = new EquipableItemFactory();
	private ItemFactory itemFactory = new ItemFactory();

	public QuestFactory() {

	}

	public IQuest createFetchQuest(Game game) {
		return new FetchQuest(new ItemFactory().createStackableItem(), Tools.dice(5)+1, game.getPlayer().getTile());
	}

	public BringQuest createBringQuest(Game game) {
		Position position = game.getPosition();
		int maxX = position.getX() + 10;
		int minX = position.getX() - 10;
		int maxY = position.getY() + 10;
		int minY = position.getY() - 10;
		RandomCoordinated newY = new RandomCoordinated(maxY, minY);
		RandomCoordinated newX = new RandomCoordinated(maxX, minX);
		Position questDestination = new Position(newX.getCoordinated(), newY.getCoordinated());
		return new BringQuest(Tools.random(itemFactory, equipableItemFactory).createRandom(), game.getRegion().getTileFromPosition(questDestination));
	}

	@Override
	public IQuest createAdventure(Game game) {
		if(Tools.dice(2) == 1) {
			return this.createFetchQuest(game);
		} else {
			return this.createBringQuest(game);
		}
	}
}

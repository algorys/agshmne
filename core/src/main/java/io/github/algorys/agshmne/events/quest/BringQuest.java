package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.equipable.EquipableItemFactory;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.tools.RandomCoordinated;
import io.github.algorys.agshmne.tools.Tools;

public class BringQuest implements IQuest {
	private Position questDestination;
	private Position initialPos;
	private Item item;
	private boolean finish = false;
	private Player pj;
	
	public BringQuest(Player pj, Item item) {
		this.pj = pj;
		this.initialPos = pj.getPosition();
		this.questDestination = this.defineDestination(initialPos);
		this.item = item;
		// TODO gérer les objets de quêtes différement des objets normaux.
		pj.getInventory().addItem(item);
	}
	
	private Position defineDestination(Position position) {
		int maxX = position.getX() + 10;
		int minX = position.getX() - 10;
		int maxY = position.getY() + 10;
		int minY = position.getY() - 10;
		RandomCoordinated newY = new RandomCoordinated(maxY, minY);
		RandomCoordinated newX = new RandomCoordinated(maxX, minX);	
		Position questDestination = new Position(newX.getCoordinated(), newY.getCoordinated());
		return questDestination;
	}
	
	

	public Position getQuestDestination() {
		return questDestination;
	}

	public Position getInitialPos() {
		return initialPos;
	}

	@Override
	public boolean isWin(Player pj) {
		return pj.getPosition() == questDestination && pj.getInventory().contains(item);
	}
	@Override
	public void reward(Player pj) {
		pj.getInventory().removeItem(item);
		finish = true;
		pj.getInventory().setGold(pj.getInventory().getGold() + Tools.dice(10));
		pj.getInventory().addItem(new EquipableItemFactory().createRandom());
		// TODO prévoir une récompense.
	}
	@Override
	public boolean isFinish() {
		return finish;
	}
	@Override
	public String getName() {
		Tile tile = pj.getRegion().getTileFromPosition(questDestination);
		return "Apporter des " + item.getName() + " dans la Région : " + tile.getDesc();
	}
	@Override
	public String getGoal() {
		Tile tile = pj.getRegion().getTileFromPosition(questDestination);
		StringBuffer sb = new StringBuffer();
		sb.append("Apporter des " + item.getName());
		sb.append("dans la Région : " + tile.getDesc());
		sb.append("(");
		sb.append(questDestination.getX() + ",");
		sb.append(questDestination.getY());
		sb.append(")");
		return sb.toString();
	}
	
}

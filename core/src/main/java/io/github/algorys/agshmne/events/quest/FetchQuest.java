package io.github.algorys.agshmne.events.quest;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.tile.Tile;
import io.github.algorys.agshmne.tools.Tools;

public class FetchQuest implements IQuest {
	private Position questPosition;
	private Tile tile;
	private Item item;
	private int count;
	private boolean finish = false;

	public FetchQuest(Player pj, Item item, int count) {
		this.questPosition = pj.getPosition();
		this.count = count;
		this.item = item;
		this.tile = pj.getTile();
	}
	
	@Override
	public boolean isWin(Player pj) {
		return (pj.getInventory().count(item) >= count) ;
	}
	@Override
	public void reward(Player pj) {
		for(int i = 0; i < count; i ++) {
			pj.getInventory().removeItem(item);
		}
		finish = true;
		pj.getInventory().setGold(pj.getInventory().getGold() + Tools.dice(10));
	}
	@Override
	public String getName() {
		return "Trouver des " + item.getName();
	}
	@Override
	public String getGoal() {
		StringBuffer sb = new StringBuffer();
		sb.append("Vous devez trouvez au moins ");
		sb.append(count + " ");
		sb.append(item.getName());
		sb.append(" et les rapporter dans la Région : ");
		sb.append(tile.getDesc());
		sb.append("(");
		sb.append(questPosition.getX() + ",");
		sb.append(questPosition.getY());
		sb.append(")");
		return sb.toString();
	}

	public Position getQuestPosition() {
		return questPosition;
	}

	@Override
	public boolean isFinish() {
		return finish;
	}

	@Override
	public void accept(Player pj) {
		pj.addQuest(this);
	}
}

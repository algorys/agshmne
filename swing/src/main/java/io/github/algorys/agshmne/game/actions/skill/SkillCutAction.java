package io.github.algorys.agshmne.game.actions.skill;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillTool;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.items.stackable.StackableItem;
import io.github.algorys.agshmne.map.tile.TileType;

@SuppressWarnings("serial")
public class SkillCutAction extends AbstractAction implements PropertyChangeListener {
	private final Player pj;

	public SkillCutAction(Player pj) {
		super("Couper du bois");
		this.pj = pj;
		pj.addPropertyChangeListener(this);
		this.update(pj.getTile().getType());
	}

	@Override
	public void actionPerformed(ActionEvent wood) {
		int mineLevel = pj.getSkills().getSkillLevel(SkillType.bucheron);
		if (SkillTool.Dice(mineLevel, 10)) {
			pj.getInventory().addItem(new StackableItem("Pin", 1, 5));
		} else {
			System.out.println("Rien d'exploitable");
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		TileType tileType = pj.getTile().getType();
		update(tileType);
	}

	private void update(TileType tileType) {
		switch (tileType) {
		case Wood:
		case Forest:
			this.setEnabled(true);
			break;
		default:
			this.setEnabled(false);
		}
	}
}
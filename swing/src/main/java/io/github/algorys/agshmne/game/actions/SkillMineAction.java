package io.github.algorys.agshmne.game.actions;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillTool;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.items.StackableItemDirectFactory;
import io.github.algorys.agshmne.map.tile.TileType;

@SuppressWarnings("serial")
public class SkillMineAction extends AbstractAction implements PropertyChangeListener {
	private final Player pj;

	public SkillMineAction(Player pj) {
		super("Récolter du minerai");
		this.pj = pj;
		pj.addPropertyChangeListener(this);
		this.update(pj.getTile().getType());
	}

	@Override
	public void actionPerformed(ActionEvent mine) {
		int mineLevel = pj.getSkills().getSkillLevel(SkillType.miner);
		if (SkillTool.Dice(mineLevel, 10)) {
			System.out.println("Minerai trouvé !");
			pj.getInventory().addItem(new StackableItemDirectFactory().createCopper());
		} else {
			System.out.println("Rien d'exploitable");
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		update(pj.getTile().getType());
	}

	private void update(TileType tileType) {
		switch (tileType) {
		case Mountain:
		case Hill:
			this.setEnabled(true);
			break;
		default:
			this.setEnabled(false);
		}
	}
}

package io.github.algorys.agshmne.game.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillTool;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.events.AdventureFactory;
import io.github.algorys.agshmne.events.IAdventure;
import io.github.algorys.agshmne.events.IAdventureFactory;
import io.github.algorys.agshmne.events.fight.Fight;
import io.github.algorys.agshmne.events.locality.Locality;
import io.github.algorys.agshmne.events.quest.IQuest;
import io.github.algorys.agshmne.game.fight.JFightDialog;
import io.github.algorys.agshmne.game.locality.JLocalityDialog;
import io.github.algorys.agshmne.game.quest.JQuestDialog;
import io.github.algorys.agshmne.map.tile.Tile;

@SuppressWarnings("serial")
public class SkillSearchRegionAction extends AbstractAction {
	private Player pj;
	private IAdventureFactory adventureFactory = new AdventureFactory();

	public SkillSearchRegionAction(Player pj) {
		super("Fouiller la Région");
		this.pj = pj;
		pj.addPropertyChangeListener(Player.PROPERTY_TILE, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getNewValue() instanceof Tile) {
					SkillSearchRegionAction.this.setEnabled(!((Tile)evt.getNewValue()).isSearched());
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (SkillTool.Dice(pj.getSkills().getSkillLevel(SkillType.fouiller), 5)) {
			this.pj.getTile().setSearched();
			this.setEnabled(false);
			JFrame topFrame = null;
			if (e.getSource() instanceof Component) {
				Component sourceComponent = (Component) e.getSource();
				topFrame = (JFrame) SwingUtilities.getWindowAncestor(sourceComponent);
			}
			IAdventure adventure = adventureFactory.createAdventure(pj);
			if (adventure instanceof Fight) {
				JFightDialog fightDialog = new JFightDialog(topFrame, (Fight) adventure);
				fightDialog.setVisible(true);
			}
			if(adventure instanceof IQuest) {
				JQuestDialog questDialog = new JQuestDialog(topFrame, (IQuest) adventure, pj);
				questDialog.setVisible(true);
			}
			if(adventure instanceof Locality) {
				JLocalityDialog localityDialog = new JLocalityDialog(topFrame, (Locality) adventure, pj);
				localityDialog.setVisible(true);
			}
		}
	}
}

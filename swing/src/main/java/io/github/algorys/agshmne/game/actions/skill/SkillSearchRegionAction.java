package io.github.algorys.agshmne.game.actions.skill;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.adventure.AdventureFactory;
import io.github.algorys.agshmne.adventure.IAdventure;
import io.github.algorys.agshmne.adventure.IAdventureFactory;
import io.github.algorys.agshmne.adventure.fight.Fight;
import io.github.algorys.agshmne.adventure.locality.Locality;
import io.github.algorys.agshmne.adventure.quest.IQuest;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillTool;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.game.fight.JFightDialog;
import io.github.algorys.agshmne.game.locality.JLocalityDialog;
import io.github.algorys.agshmne.game.quest.JQuestDialog;
import io.github.algorys.agshmne.map.tile.Tile;

@SuppressWarnings("serial")
public class SkillSearchRegionAction extends AbstractAction {
	private Game game;
	private IAdventureFactory adventureFactory = new AdventureFactory();

	public SkillSearchRegionAction(Game game) {
		super("Fouiller la Région");
		this.game = game;
		game.getPlayer().addPropertyChangeListener(Player.PROPERTY_TILE, new PropertyChangeListener() {
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
		if (SkillTool.Dice(this.game.getPlayer().getSkills().getSkillLevel(SkillType.fouiller), 5)) {
			this.game.getPlayer().getTile().setSearched();
			this.setEnabled(false);
			JFrame topFrame = null;
			if (e.getSource() instanceof Component) {
				Component sourceComponent = (Component) e.getSource();
				topFrame = (JFrame) SwingUtilities.getWindowAncestor(sourceComponent);
			}
			IAdventure adventure = adventureFactory.createAdventure(game);
			if (adventure instanceof Fight) {
				JFightDialog fightDialog = new JFightDialog(topFrame, (Fight) adventure);
				fightDialog.setVisible(true);
			} else if(adventure instanceof IQuest) {
				JQuestDialog questDialog = new JQuestDialog(topFrame, (IQuest) adventure, this.game.getPlayer());
				questDialog.setVisible(true);
			} else if(adventure instanceof Locality) {
				JLocalityDialog localityDialog = new JLocalityDialog(topFrame, (Locality) adventure, this.game.getPlayer());
				localityDialog.setVisible(true);
			}
		}
	}
}

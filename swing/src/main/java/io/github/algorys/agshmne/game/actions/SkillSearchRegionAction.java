package io.github.algorys.agshmne.game.actions;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class SkillSearchRegionAction extends AbstractAction implements PropertyChangeListener {

	public SkillSearchRegionAction(Player pj) {
		super("Fouiller la Région");
		pj.addPropertyChangeListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Vous fouillez la Région !");
		// TODO Générer un évènement
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Faire en sorte de savoir si la Tile a déjà été visitée ou pas.
	}

}

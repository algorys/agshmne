package io.github.algorys.agshmne.game.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import io.github.algorys.agshmne.character.player.Player;

@SuppressWarnings("serial")
public class SkillSearchRegionAction extends AbstractAction implements Observer {
	
	public SkillSearchRegionAction(Player pj) {
		super("Fouiller la Région");
		pj.addObserver(this);
		this.update(pj, null);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Vous fouillez la Région !");
		// TODO Générer un évènement
	}

	@Override
	public void update(Observable o, Object arg) {	
		// TODO Faire en sorte de savoir si la Tile a déjà été visitée ou pas.
	}

}

package io.github.algorys.agshmne.game.actions;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import io.github.algorys.agshmne.character.opponent.beast.BeastFactory;
import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillTool;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.events.fight.Fight;
import io.github.algorys.agshmne.game.east.JFightDialog;

@SuppressWarnings("serial")
public class SkillSearchRegionAction extends AbstractAction implements PropertyChangeListener {
	private Player pj;
	private JPanel jpan;
	
	public SkillSearchRegionAction(Player pj, JPanel jpan) {
		super("Fouiller la Région");
		this.jpan = jpan;
		this.pj = pj;
		pj.addPropertyChangeListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(SkillTool.Dice(pj.getSkills().getSkillLevel(SkillType.fouiller), 5)) {
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(jpan);
			JFightDialog fightDialog = new JFightDialog(topFrame, new Fight(pj, new BeastFactory().createBeast()));
			fightDialog.setVisible(true);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.setEnabled(false);
	}
}

package io.github.algorys.agshmne.game.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.character.player.skills.SkillTool;
import io.github.algorys.agshmne.character.player.skills.SkillType;
import io.github.algorys.agshmne.items.Item;
import io.github.algorys.agshmne.items.ItemFactory;

@SuppressWarnings("serial")
public class SkillSearchCityAction extends AbstractAction implements PropertyChangeListener {
	private final Player pj;

	public SkillSearchCityAction(Player pj) {
		super("Fouiller la Ville");
		this.pj = pj;
		pj.addPropertyChangeListener(this);
		this.setEnabled(pj.getTile().isCivilized());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Vous fouillez la Ville !");
		if (SkillTool.Dice(pj.getSkills().getSkillLevel(SkillType.fouiller), 10)) {
			Item item = new ItemFactory().createRandom();
			pj.getInventory().addItem(item);
			JFrame topFrame = null;
			if (e.getSource() instanceof Component) {
				Component sourceComponent = (Component) e.getSource();
				topFrame = (JFrame) SwingUtilities.getWindowAncestor(sourceComponent);
			}
			JOptionPane.showMessageDialog(topFrame, "Vous avez trouvé quelque chose : " + item.getName());
		}
		this.setEnabled(false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.setEnabled(pj.getTile().isCivilized());
	}

}

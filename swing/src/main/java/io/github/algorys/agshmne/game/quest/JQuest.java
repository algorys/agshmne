package io.github.algorys.agshmne.game.quest;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import io.github.algorys.agshmne.events.quest.IQuest;
import io.github.algorys.agshmne.tile.JTileLabel;

@SuppressWarnings("serial")
public class JQuest extends JPanel {
	private IQuest quest;
	private final JLabel jlName = new JLabel();
	private final JLabel jlDescription = new JLabel();
	private JTileLabel jDestination;

	public JQuest(IQuest quest) {
		super(new GridBagLayout());
		this.setBackground(Color.black);
		GridBagConstraints gbcQuest = new GridBagConstraints();
		gbcQuest.insets = new Insets(5, 5, 5, 5);

		gbcQuest.gridy = 0;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.CENTER;
		gbcQuest.fill = GridBagConstraints.NONE;
		jlName.setForeground(Color.cyan);
		this.add(jlName, gbcQuest);

		gbcQuest.gridy = 2;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.NONE;
		JLabel questDescTitle = new JLabel("Description :");
		questDescTitle.setOpaque(false);
		questDescTitle.setForeground(Color.white);
		this.add(questDescTitle, gbcQuest);

		gbcQuest.gridy = 3;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 4;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.BOTH;
		jlDescription.setOpaque(false);
		jlDescription.setForeground(Color.white);
		this.add(jlDescription, gbcQuest);
		
		gbcQuest.gridy = 4;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 0;
		gbcQuest.gridwidth = 1;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.BOTH;
		JLabel jlDestinationTitle = new JLabel("Destination :");
		jlDestinationTitle.setOpaque(false);
		jlDestinationTitle.setForeground(Color.white);
		this.add(jlDestinationTitle, gbcQuest);
		
		gbcQuest.gridy = 4;
		gbcQuest.gridheight = 1;
		gbcQuest.gridx = 1;
		gbcQuest.gridwidth = 1;
		gbcQuest.anchor = GridBagConstraints.WEST;
		gbcQuest.fill = GridBagConstraints.BOTH;
		jDestination = new JTileLabel(quest.getDestination());
		this.add(jDestination, gbcQuest);
		
		this.setQuest(quest);
	}

	public IQuest getQuest() {
		return quest;
	}

	public void setQuest(IQuest quest) {
		this.quest = quest;
		jlName.setText(quest.getName());
		jlDescription.setText(quest.getGoal());
		jDestination.setTile(quest.getDestination());
	}
}

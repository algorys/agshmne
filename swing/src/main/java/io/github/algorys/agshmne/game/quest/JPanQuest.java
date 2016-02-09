package io.github.algorys.agshmne.game.quest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JList;
import javax.swing.JPanel;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.design.QuestRenderer;
import io.github.algorys.agshmne.events.quest.IQuest;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JPanQuest extends JPanel {

	public JPanQuest(Player pj) {
		JList<IQuest> quests = new JList<IQuest>(new QuestListModel(pj.getQuest()));
		
		quests.setBackground(Color.BLACK);
		quests.setForeground(Color.cyan);
		quests.setCellRenderer(new QuestRenderer());
		quests.setFixedCellWidth(350);
		quests.setFixedCellHeight(15);
		quests.setVisibleRowCount(10);
		quests.setPreferredSize(new Dimension(400, 300));
		quests.setEnabled(true);

		this.add(quests);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			Image img = ImageIO.read(JTile.class.getClassLoader().getResource("parchemin.png"));
			Image imgBack = ImageIO.read(JTile.class.getClassLoader().getResource("table.png"));
			g.drawImage(imgBack, 0, 0, this.getWidth(), this.getHeight(), this);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

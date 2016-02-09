package io.github.algorys.agshmne.game.quest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.design.QuestRenderer;
import io.github.algorys.agshmne.events.quest.IQuest;
import io.github.algorys.agshmne.tile.JTile;

@SuppressWarnings("serial")
public class JPanQuest extends JPanel {
	private JList<IQuest> quests;
	
	public JPanQuest(final Player pj) {
		quests = new JList<IQuest>(new QuestListModel(pj.getQuest()));
		
		quests.setBackground(Color.BLACK);
		quests.setForeground(Color.cyan);
		quests.setCellRenderer(new QuestRenderer());
		quests.setFixedCellWidth(350);
		quests.setFixedCellHeight(15);
		quests.setVisibleRowCount(10);
		quests.setPreferredSize(new Dimension(400, 300));
		quests.setEnabled(true);

		this.add(quests);
		
		final JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		quests.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent me) {
				if (me.isPopupTrigger()) {
					final int index = quests.locationToIndex(me.getPoint());
					JPopupMenu menu = new JPopupMenu();

					JMenuItem see = new JMenuItem("Voir la quête");
					see.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							IQuest selectedQuest = quests.getModel().getElementAt(index);
							JQuestResume questDialog = new JQuestResume(topFrame, selectedQuest, pj);
							questDialog.setVisible(true);
							quests.invalidate();
							quests.repaint();
						}
					});
					
					menu.add(see);
					menu.show(quests, me.getX(), me.getY());
				}
				
			}
			
		});
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
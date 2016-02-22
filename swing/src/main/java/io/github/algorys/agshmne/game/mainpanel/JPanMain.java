package io.github.algorys.agshmne.game.mainpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import io.github.algorys.agshmne.Game;
import io.github.algorys.agshmne.map.JMapRegion;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MessageListModel;
import io.github.algorys.agshmne.renderer.MessageRenderer;

@SuppressWarnings("serial")
public class JPanMain extends JPanel {
	private JPanTabbed jpanTabbed;
	
	public JPanMain(Game game, JMapRegion jregion) {
		// JPanTabbed
		this.setLayout(new BorderLayout());
		jpanTabbed = new JPanTabbed(game, jregion);
		this.add(jpanTabbed, BorderLayout.NORTH);
		
		// Message
		MessageListModel messagesModel = new MessageListModel();
		game.getPlayer().getVital().setMessageReceiver(messagesModel);
		game.getPlayer().getInventory().setMessageReceiver(messagesModel);
		game.setMessageReceiver(messagesModel);
		final JList<Message> output = new JList<Message>(messagesModel);
		output.setCellRenderer(new MessageRenderer());
		output.setBackground(Color.BLACK);
		output.setForeground(Color.green);
		output.setFixedCellWidth(290);
		output.setFixedCellHeight(20);
		output.setVisibleRowCount(10);
		output.setEnabled(true);
		final JScrollPane outputScroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		messagesModel.addListDataListener(new ListDataListener() {

			@Override
			public void intervalRemoved(ListDataEvent e) {
			}

			@Override
			public void intervalAdded(ListDataEvent e) {
				output.invalidate();
				output.ensureIndexIsVisible(e.getIndex0());
			}

			@Override
			public void contentsChanged(ListDataEvent e) {
			}
		});

		outputScroll.setPreferredSize(new Dimension(300, 100));
		outputScroll.setMinimumSize(new Dimension(300, 100));
		this.add(outputScroll, BorderLayout.SOUTH);
		
	}

	public JPanTabbed getJPanTabbed() {
		return jpanTabbed;
	}
}

package io.github.algorys.agshmne.output;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;

import io.github.algorys.agshmne.renderer.OutputRenderer;

@SuppressWarnings("serial")
public class JOutput extends JPanel {
	private JList<String> output;
	
	public JOutput(OutputGame out) {
		output = new JList<String>(new OutputListModel(out));
		output.setCellRenderer(new OutputRenderer());
		output.setBackground(Color.BLACK);
		output.setForeground(Color.green);
		output.setFixedCellWidth(290);
		output.setFixedCellHeight(20);
		output.setVisibleRowCount(5);
		output.setPreferredSize(new Dimension(300, 300));
		output.setMinimumSize(new Dimension(300, 300));
		output.setEnabled(true);
		
		this.add(output);
	}
}

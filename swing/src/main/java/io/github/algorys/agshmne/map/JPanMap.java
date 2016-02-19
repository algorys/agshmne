package io.github.algorys.agshmne.map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanMap extends JPanel {

	public JPanMap(final JMapRegion jmapRegion) {
		this.setLayout(new GridBagLayout());
		this.setMinimumSize(jmapRegion.getPreferredSize());
		this.setBackground(Color.black);
		this.add(jmapRegion);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				resizePreview(jmapRegion, JPanMap.this);
			}
		});
	}

	private void resizePreview(JPanel innerPanel, JPanel container) {
		int w = container.getWidth();
		int h = container.getHeight();
		int size = Math.min(w, h);
		innerPanel.setPreferredSize(new Dimension(size, size));
		innerPanel.setMinimumSize(new Dimension(size, size));
		container.revalidate();
	}
}

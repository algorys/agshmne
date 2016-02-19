package io.github.algorys.agshmne.map;

import javax.swing.JLabel;

import io.github.algorys.agshmne.map.Position;

@SuppressWarnings("serial")
public class JPosition extends JLabel {
	private Position position;

	public JPosition() {
		this.setPosition(new Position(0, 0));
	}

	public JPosition(Position position) {
		this.setPosition(position);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
		this.setText("(" + position.getX() + ", " + position.getY() + ")");
	}
}

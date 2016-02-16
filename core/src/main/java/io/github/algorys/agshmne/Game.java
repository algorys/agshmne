package io.github.algorys.agshmne;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import io.github.algorys.agshmne.map.Position;

public class Game {
	public static final String PROPERTY_POSITION = "position";
	private Position position = new Position(0, 0);
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		Position old = this.position;
		this.position = position;
		pcs.firePropertyChange(PROPERTY_POSITION, old, position);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(propertyName, listener);
	}

}

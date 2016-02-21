package io.github.algorys.agshmne;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import io.github.algorys.agshmne.character.player.Player;
import io.github.algorys.agshmne.map.Position;
import io.github.algorys.agshmne.map.region.Region;
import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.IMessageSender;
import io.github.algorys.agshmne.message.Message;
import io.github.algorys.agshmne.message.MsgType;

public class Game implements IMessageSender, IMessageReceiver {
	public static final String PROPERTY_POSITION = "position";
	private Player player;
	private Position position = new Position(0, 0);
	private final Region region;
	private int turn = 1;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private IMessageReceiver messageReceiver;

	public Game(Region region) {
		super();
		this.region = region;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Region getRegion() {
		return region;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		Position old = this.position;
		this.position = position;
		String tileName = region.getTileFromPosition(position).getDesc();
		Message msg = new Message(MsgType.HISTORY, "Vous pénétrez dans " + tileName);
		this.sendMessage(msg);
		player.setTile(this.getRegion().getTileFromPosition(position));
		pcs.firePropertyChange(PROPERTY_POSITION, old, position);
	}

	public void newTurn() {
		if (turn != 1) {
			player.getVital().increaseHunger();
			player.getVital().increaseFatigue();
			player.getVital().checkVital();
		}
		turn += 1;
	}

	public int getTurn() {
		return turn;
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

	@Override
	public void setMessageReceiver(IMessageReceiver msgRcvr) {
		this.messageReceiver = msgRcvr;
	}

	public void sendMessage(Message message) {
		if (messageReceiver != null) {
			messageReceiver.sendMessage(message);
		}
	}
}

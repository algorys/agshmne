package io.github.algorys.agshmne.message;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import io.github.algorys.agshmne.message.IMessageReceiver;
import io.github.algorys.agshmne.message.Message;

@SuppressWarnings("serial")
public class MessageListModel extends AbstractListModel<Message> implements IMessageReceiver {
	private static final int MAXIMUM = 20;
	private List<Message> messages = new ArrayList<>();

	@Override
	public int getSize() {
		return messages.size();
	}

	@Override
	public Message getElementAt(int index) {
		return messages.get(index);
	}

	@Override
	public void sendMessage(Message message) {
		while (this.messages.size() >= MAXIMUM) {
			messages.remove(0);
			this.fireIntervalRemoved(this, 0, 0);
		}
		this.messages.add(message);
		this.fireIntervalAdded(this, getSize() - 1, getSize() - 1);
	}
}

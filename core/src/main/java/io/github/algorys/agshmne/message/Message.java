package io.github.algorys.agshmne.message;

public class Message {
	private final String message;
	private final MsgType type;

	public Message(MsgType type, String message) {
		super();
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public MsgType getType() {
		return type;
	}

}

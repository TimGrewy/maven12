package dk.tim.domain.message;

public class Message {
	private String message = "";

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return String.format("Message [message=%s]", message);
	}
}

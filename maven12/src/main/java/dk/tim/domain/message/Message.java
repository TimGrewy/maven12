package dk.tim.domain.message;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String message = "";
	private String createdTime;

	public Message(String message) {
		DateFormat fmt = new SimpleDateFormat("dd/MM HH:mm:ss");
		createdTime = fmt.format(new Date());
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	@Override
	public String toString() {
		return String.format("Message [message=%s, createdTime=%s]", message, createdTime);
	}
}

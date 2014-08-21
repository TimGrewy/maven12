package dk.tim.rest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dk.tim.domain.message.Message;

public class MessageLocalStorage {
	private static List<Message> messages = new ArrayList<Message>();

	private MessageLocalStorage() {
		//Force static use
	}

	public static void addMessage(Message message) {
		messages.add(message);
	}

	public static List<Message> getAllMessages() {
		if (messages.isEmpty()) {
			MessageLocalStorage.addMessage(new Message("Initial message"));
		}

		return Collections.unmodifiableList(messages);
	}
}

package dk.tim.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dk.tim.domain.message.Message;

@Path("/messages")
public class MessageService {
	private Gson gson = new Gson();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllMessages() {
		List<Message> allMessages = MessageLocalStorage.getAllMessages();
		System.out.println(allMessages);
		return gson.toJson(allMessages);
	}

	@PUT
	@Consumes
	@Path("/{message}")
	@Produces(MediaType.APPLICATION_JSON)
	public void createUser(@PathParam("message") String message) {
		System.out.println("creating: " + message);
		Message message2 = new Message(message);
		MessageLocalStorage.addMessage(message2);
	}
}
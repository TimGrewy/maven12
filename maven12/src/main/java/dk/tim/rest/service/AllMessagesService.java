package dk.tim.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dk.tim.domain.message.Message;

@Path("/messages")
public class AllMessagesService {
	private Gson gson = new Gson();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllMessages() {
		List<Message> allMessages = MessageLocalStorage.getAllMessages();
		String json = gson.toJson(allMessages);
		System.out.println(json);
		return json;
	}
}
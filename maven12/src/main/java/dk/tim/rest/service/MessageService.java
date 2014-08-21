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

@Path("/message")
public class MessageService {
	private Gson gson = new Gson();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//http://localhost:8080/maven12/rest/message
	public String getMessage() {
		System.out.println("getMessage:");
		List<Message> allMessages = MessageLocalStorage.getAllMessages();

		Message message = allMessages.get(0);
		String json = gson.toJson(message);

		System.out.println("returning: " + json);
		return json;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	//http://localhost:8080/maven12/rest/message/1
	public String getMessage(@PathParam("messageid") int messageId) {
		System.out.println("getMessage: " + messageId);
		//		if (messageId == 0) {
		//			throw new WebApplicationException(Response.Status.NOT_FOUND);
		//		}
		List<Message> allMessages = MessageLocalStorage.getAllMessages();

		Message message = allMessages.get(0);
		String json = gson.toJson(message);

		System.out.println("returning: " + json);
		return json;
	}

	@PUT
	@Consumes
	@Path("/create/{messagetext}")
	@Produces(MediaType.APPLICATION_JSON)
	//[PUT]http://localhost:8080/maven12/rest/message/create/hej
	public void createMessage(@PathParam("messagetext") String message) {
		System.out.println("creating: " + message);
		Message message2 = new Message(message);
		MessageLocalStorage.addMessage(message2);
	}
}
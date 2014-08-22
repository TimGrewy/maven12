package dk.tim.rest.service;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dk.tim.domain.message.Message;
import dk.tim.rest.response.ResponseFactory;

@Path("/message")
public class MessageService {
	private Gson gson = new Gson();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//http://localhost:8080/maven12/rest/message
	public Response getMessage() {
		List<Message> allMessages = MessageLocalStorage.getAllMessages();
		Message message = allMessages.get(0);
		String json = gson.toJson(message);

		return ResponseFactory.buildOKResponseWithCrossSiteCompatability(json);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	//http://localhost:8080/maven12/rest/message/1
	public Response getMessage(@PathParam("messageid") int messageId) {
		System.out.println("getMessage: " + messageId);
		//		if (messageId == 0) {
		//			throw new WebApplicationException(Response.Status.NOT_FOUND);
		//		}
		List<Message> allMessages = MessageLocalStorage.getAllMessages();

		Message message = allMessages.get(0);
		String json = gson.toJson(message);

		System.out.println("returning: " + json);
		return ResponseFactory.buildOKResponseWithCrossSiteCompatability(json);
	}

	@POST
	@Consumes
	@Path("/create/{messagetext}")
	@Produces(MediaType.APPLICATION_JSON)
	//[PUT]http://localhost:8080/maven12/rest/message/create/<message>
	public Response createMessage(@PathParam("messagetext") String message) throws URISyntaxException {
		System.out.println("creating: " + message);
		Message message2 = new Message(message);
		MessageLocalStorage.addMessage(message2);
		return ResponseFactory.buildCreatedResponseWithCrossSiteCompatability();
	}
}
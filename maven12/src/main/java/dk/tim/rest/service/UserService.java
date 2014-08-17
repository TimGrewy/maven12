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

import dk.tim.domain.user.User;
import dk.tim.integration.mongo.MongoDB;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/users")
public class UserService {
	private Gson gson = new Gson();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllMessages() {
		MongoDB mongoDB = new MongoDB();
		List<User> allUsers = mongoDB.getAllUsers();
		String result = "";
		for (User user : allUsers) {
			result += gson.toJson(user);
		}
		return result;
	}

	@PUT
	@Consumes
	@Path("/create/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String createUser(@PathParam("name") String name) {
		System.out.println("creating: " + name);
		//		MongoDB mongoDB = new MongoDB();
		return "User created: " + name;
	}
}

package dk.tim.integration.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

import dk.tim.domain.user.User;

public class MongoDB {
	public enum DeleteStatus {
		DELETED, NOT_DELETED
	}

	private DBCollection coll;
	private Gson gson = new Gson();

	public MongoDB() {
		try {
			MongoClientURI uri = new MongoClientURI("mongodb://flights:flights@ds053479.mongolab.com:53479/flights");
			MongoClient mongoClient = new MongoClient(uri);
			DB db = mongoClient.getDB("flights");
			coll = db.getCollection("flights");
		} catch (UnknownHostException e) {
			throw new RuntimeException("Error creting access to mongoDB: " + e.getMessage(), e);
		}
	}

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		DBCursor cursor = coll.find();
		while (cursor.hasNext()) {
			DBObject object = cursor.next();
			User user = (User) object;
			list.add(user);
		}
		list.add(new User("TGJ"));
		System.out.println("Found: " + list);
		return Collections.unmodifiableList(list);
	}

	public void saveUser(User user) {
		String json = gson.toJson(user);
		System.out.println("Inserting: " + json);
		DBObject dbObject = (DBObject) JSON.parse(json);
		coll.insert(dbObject);
	}
}

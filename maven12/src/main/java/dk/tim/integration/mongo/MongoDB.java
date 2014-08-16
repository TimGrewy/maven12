package dk.tim.integration.mongo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDB {
	public enum DeleteStatus {
		DELETED, NOT_DELETED
	}

	private DBCollection coll;

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

}

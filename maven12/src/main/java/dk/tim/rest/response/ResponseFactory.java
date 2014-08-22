package dk.tim.rest.response;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class ResponseFactory {

	public static Response buildOKResponseWithCrossSiteCompatability(String json) {
		ResponseBuilder status = Response.status(200);
		ResponseBuilder response = status.entity(json);
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
		response.header("Access-Control-Allow-Headers", "GET, PUT, OPTIONS, X-XSRF-TOKEN");
		return response.build();
	}

	public static Response buildCreatedResponseWithCrossSiteCompatability() {
		ResponseBuilder response = Response.created(null);
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
		response.header("Access-Control-Allow-Headers", "GET, PUT, OPTIONS, X-XSRF-TOKEN");
		return response.build();
	}
}

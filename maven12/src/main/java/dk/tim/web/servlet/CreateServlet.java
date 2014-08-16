package dk.tim.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//	private MongoDB mongoDB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateServlet() {
		//		mongoDB = new MongoDB();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getOutputStream().print("<a href=\"/userstatus/ListServlet\">To index</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post : " + request);
		response.getOutputStream().print("Flight " + "" + " created");
		response.getOutputStream().print("<br/>");
		response.getOutputStream().print("<a href=\"/userstatus/ListServlet\">To index</a>");
	}

}

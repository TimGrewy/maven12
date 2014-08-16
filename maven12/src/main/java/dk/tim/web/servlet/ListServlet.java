package dk.tim.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 * 
 * 
 * Created while reading http://devblog.virtage.com/2013/02/hello-world-with-jetty-maven-eclipse-wtp-tutorial/
 * 
 * 
 * Other tips:
 * * Stop the jetty server in the console tab by pressing the stop icon
 * * Run the full version of jetty using: "java -jar start.jar"
 * * Deploy a war file by copying it to the webapps folder
 * * Add dependencies using pom.xml
 * * Change Jetty port in http.ini in start.d
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Alternative sites:
 *  * https://dropwizard.github.io/dropwizard/getting-started.html <- All-in-one package
 * 
 * 
 * 
 * 
 * 
 */

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;

	//	private MongoDB mongoDB;

	/**
	 * Default constructor. 
	 */
	public ListServlet() {
		//		mongoDB = new MongoDB();
	}

	//		User user = new User();
	//		user.setUserId("user1");
	//		String json = gson.toJson(user);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.response = response;

		print("<!DOCTYPE html>");
		print("<html>");
		print("<head>");
		print("<meta charset=\"ISO-8859-1\">");
		print("<title>Insert title here</title>");
		print("</head>");
		print("<body>");
		print("<form>");
		print("<ul>");

		print("<li>");
		print("Stuff goes here");
		print("</li>");
		print("</ul>");
		print("</form>");
		print("</body>");
		print("</html>");
	}

	private void print(String text) throws IOException {
		response.getOutputStream().print(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

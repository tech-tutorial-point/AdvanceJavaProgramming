package ajp.servlet.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ch1Servlet extends HttpServlet{

	  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		      // Setting up the content type of webpage
		      response.setContentType("text/html");

		      // Writing message to the web page
		      PrintWriter out = response.getWriter();
		      java.util.Date today = new java.util.Date();
		      out.println("<html> " + "<body>" +"<h1 align=center>Welcome to Chapter1 Servlet </h1>" + 
		      "<br>"+today+"</body>"+"</html>");
		   }
}

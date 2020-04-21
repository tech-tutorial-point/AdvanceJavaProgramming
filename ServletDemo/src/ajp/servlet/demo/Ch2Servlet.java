package ajp.servlet.demo;

import javax.servlet.http.HttpServlet;

import java.io.*;

import javax.servlet.http.*;

public class Ch2Servlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		java.util.Date today = new java.util.Date();
		
		out.println("<html>"+ "<body>" + "<h1 style=text-align:center>" + " Chapter2 Servlet </h1>" + "<br>" + today +"</body>"+ "</html>");
		
	}

}

package ajp.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenFieldDemo
 */
@WebServlet("/HiddenFieldDemo")
public class HiddenFieldDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenFieldDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String ucity = request.getParameter("ucity");
		PrintWriter out = response.getWriter();
		//out.print("<h1> "+uname+" </h1>");
		
		out.print("<form method='post' action = 'SaveHiddenFields'");
		out.print("<br>");
		out.print("<input type='hidden' name= 'txtuname' value='"+uname+"'>");
		out.print("<input type='hidden' name= 'txtucity' value='"+ucity+"'>");
		//out.print("<input type='hidden' name= 'txtuname' value='"+uname+"'>");
		out.print("<input type='submit' value= 'Proceed'>");
		out.print("</form>");
	}

}

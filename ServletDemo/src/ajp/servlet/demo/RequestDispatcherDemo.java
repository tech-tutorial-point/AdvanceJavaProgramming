package ajp.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatcherDemo
 */
@WebServlet("/RequestDispatcherDemo")
public class RequestDispatcherDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDispatcherDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        if(uname.equals("Deepti") && pwd.equals("ajp111")){
        	RequestDispatcher rd = request.getRequestDispatcher("Success");
        	rd.forward(request, response);
        }
        else{
        	PrintWriter out = response.getWriter();
        	out.print("<h1> Wrong credentials entered....Retry!! <h1>" );
        	RequestDispatcher rd = request.getRequestDispatcher("RequestDispatcherDemo.html");
        	rd.include(request, response);
        }
	}

}

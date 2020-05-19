package com.xyz.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmployeeControllerServlet
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDbUtil employeeDbUtil;
	
	@Resource(name="jdbc/web_employee_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our employee db util ... and pass in the conn pool / datasource
		try {
			employeeDbUtil = new EmployeeDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing employees
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listEmployees(request, response);
				break;
				
			case "ADD":
				addEmployee(request, response);
				break;
				
			case "LOAD":
				loadEmployee(request, response);
				break;
				
			case "UPDATE":
				updateEmployee(request, response);
				break;
			
			case "DELETE":
				deleteEmployee(request, response);
				break;
				
			default:
				listEmployees(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read employee id from form data
		String theEmployeeId = request.getParameter("employeeId");
		
		// delete employee from database
		employeeDbUtil.deleteEmployee(theEmployeeId);
		
		// send them back to "list employees" page
		listEmployees(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read employee info from form data
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create a new employee object
		Employee theEmployee = new Employee(id, firstName, lastName, email);
		
		// perform update on database
		employeeDbUtil.updateEmployee(theEmployee);
		
		// send them back to the "list employees" page
		listEmployees(request, response);
		
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read employee id from form data
		String theEmployeeId = request.getParameter("employeeId");
		
		// get employee from database (db util)
		Employee theEmployee = employeeDbUtil.getEmployee(theEmployeeId);
		
		// place employee in the request attribute
		request.setAttribute("THE_EMPLOYEE", theEmployee);
		
		// send to jsp page: update-employee-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-employee-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read employee info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");		
		
		// create a new employee object
		Employee theEmployee = new Employee(firstName, lastName, email);
		
		// add the employee to the database
		employeeDbUtil.addEmployee(theEmployee);
				
		// send back to main page (the employee list)
		listEmployees(request, response);
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get employees from db util
		List<Employee> employees = employeeDbUtil.getEmployees();
		
		// add employees to the request
		request.setAttribute("EMPLOYEE_LIST", employees);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees.jsp");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees-with-scriptlets.jsp");
		dispatcher.forward(request, response);
	}

}














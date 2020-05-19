<%@ page import="java.util.*, com.xyz.web.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Employee Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
	// get the employees from the request object (sent by servlet)
	List<Employee> theEmployees = 
					(List<Employee>) request.getAttribute("EMPLOYEE_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>XYZ Firm</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<% for (Employee tempEmployee : theEmployees) { %>
				
					<tr>
						<td> <%= tempEmployee.getFirstName() %> </td>
						<td> <%= tempEmployee.getLastName() %> </td>
						<td> <%= tempEmployee.getEmail() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>









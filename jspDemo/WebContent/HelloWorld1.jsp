<html>
<body>
<h3> Welcome to JSP Demo</h3>
The time on the server is <%= new java.util.Date() %>
<br> <br>



JSP Expression example: <br>
Convert a string to uppercase: <%= new String("apple").toUpperCase()%> <br>
25 multiply by 5 equals: <%=25*5 %> <br>
Is 1 greater than 0?: <%=1>0 %> <br> <br>


<%//Allows java code  %> 


JSP Scriptlet example:   <br>
<% 
for(int i=1; i<=5; i++){
out.println("<br/>The count is:" + i);  
}%> 
<br>
</br>



JSP Declaration example:</br>
<%!
String makeItLower(String data){
return data.toLowerCase();
} %>
using JSP declaration: Lower case of APPLE is:<%= makeItLower("APPLE") %> 
</html>
</body>
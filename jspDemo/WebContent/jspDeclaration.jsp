<html>

<body>

<h3>JSP Declaration example</h3> <br></br>

<%!
    String makeItLower(String data){
         return data.toLowerCase();
    }
%>

<b>Using JSP declaration </b><br></br>

Lower case of APPLE is: 
 
 <%= makeItLower("APPLE") %> 

</body>

</html>
<%@ page import="java.sql.ResultSet,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
	String email=(String)session.getAttribute("email");
	if(email==null){
		response.sendRedirect("login.jsp");
	}
	ResultSet rs=(ResultSet)session.getAttribute("teststudent");
	String test=(String)session.getAttribute("test");
	ArrayList arr= new ArrayList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
form{
 	 background-color:#45B39D;
	 margin-left:30%;
	 margin-right:30%
}
body{
	background-color:  #F2F2F0;
}
h1{
	margin-left:27%;
}

</style>
</head>
<body>
<%@ include file="header.jsp" %>
	<br>
	<h1>List of Student of <%=test %> Test</h1>
	<form action="SaveTestScore" method="post">
	<%while(rs.next()){ arr.add(rs.getString(1));%>
		<pre> 
	<%=rs.getString(1)%>	<input type="text" name="<%=rs.getString(1) %>"/>
		<%} %>
			<input type="submit" value="Update"/>
        </pre>	
		</form>
		
	<%session.setAttribute("RegIDs", arr); %>
</body>
</html>
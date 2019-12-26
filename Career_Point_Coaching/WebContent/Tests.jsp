<%@ page import="java.sql.ResultSet" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String email=(String)session.getAttribute("email");
	if(email==null){
		response.sendRedirect("login.jsp");
	}
	ResultSet rs=(ResultSet)session.getAttribute("rs");
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a{
	margin-left:45%;
}
h1{
	margin-left:42%;
}
</style>
</head>
<body>
	<%@include file="header.jsp" %>
	<br>
	<h1>List of Test</h1>
	<%while(rs.next()){ %>
		<a href="ShowStudents?TName=<%=rs.getString(1)%>"><%=rs.getString(1) %></a>
	<%} %>
</body>
</html>
<%
	String email=(String)session.getAttribute("email");
	if(email==null){
		response.sendRedirect("login.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h3{
     text-align:center;
     color:Red;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
	<h3 ><a href="SetRegistrationNo.jsp">Set First Registration No.</a><h3>
	<br>
	<h3><a href="FetchTest">Update Test Score</a></h3>

</body>
</html>
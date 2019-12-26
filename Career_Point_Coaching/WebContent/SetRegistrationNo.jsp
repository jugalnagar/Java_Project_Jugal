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
</head>
<body>
<%@ include file="header.jsp" %>

	<form action="SetRegistration" method="post" style="background-color:#45B39D;width:400; height:200;margin-left:25%;margin-right:25%">
	<pre>
		Registraion No <input type="text" name="RegID"/><br>
		Password       <input type="password" name="psw"/><br>
			<input type="submit" value="SET"/>
	</pre>
	</form>
</body>
</html>
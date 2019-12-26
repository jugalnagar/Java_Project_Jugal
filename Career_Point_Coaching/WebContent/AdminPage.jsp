<%
	String email=(String)session.getAttribute("email");
	if(email==null){
		response.sendRedirect("login.jsp");
	}



%>
<html>
<head>
<style>
h3{
	text-align:center;
}
</style>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<%@ include file="header.jsp" %>
    <br>	
	<h3 ><a href="StudentRegistration.jsp">Student Registration</a> </h3>
	<br>
	<h3 > <a href="ResultUpdate.jsp">Update Result</a></h3>
	<br>
	<h3><a href="RecordSetting.jsp">Record Set</a></h3>
</body>
</html>
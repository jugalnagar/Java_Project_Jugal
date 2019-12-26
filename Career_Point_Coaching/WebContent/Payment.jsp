<%
	String email=(String)session.getAttribute("email");
	String name=(String)session.getAttribute("name");
	String id=(String)session.getAttribute("id");
	if(email==null){
		response.sendRedirect("login.jsp");
	}
	String Class=(String)session.getAttribute("class");
	int totalAmount=0;
	if(Class.equals("12th")) {
		totalAmount=8000;
	}else {
		totalAmount=6500;
	}
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4><%=name %></h4>
	<h4>you are registered successfully and your registration number is <%=id %></h4>
	<h3 style="text-align:center;">Payment-Process</h3>
	
	<form action="PymentManage">
		Total Amount <input type="text" name="total" value=<%=totalAmount %>/>
		Discount <input type="text" name="dis"/>
		Pay Amount <input type="text" name="paid"/>
		<input type="submit" value="paid"/>
	
	</form>
</body>
</html>
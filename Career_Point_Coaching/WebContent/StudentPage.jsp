<%@ page import="java.sql.*,java.util.*,com.app.StudentInfo.*" %>
<%	
	//ResultSet tests=(ResultSet)session.getAttribute("Tests");
	ArrayList tests=(ArrayList)session.getAttribute("Tests");
	ArrayList TestDetail=(ArrayList)session.getAttribute("testdetail");

%>
<jsp:useBean id="student" scope="session" type="com.app.StudentInfo.StudentBean"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Design.css">
<style type="text/css">
table{
	border-collapse:collapse;
}
table,tr,th{
	border:1px solid rgba(0, 0, 0, 0.5);
}
.test {
  background-color: lightgrey;
  width: 100px;
  border: 5px solid green;
  padding: 50px;
  margin: 20px;
}

</style>
</head>
<body>
<%@ include file="header.jsp" %>
	<br>
	<img alt="lodu" src="ImageRetrive" height="100" width="100" class="studentimg"/>
	<br>
	<div class="textshifting">
	<h1><jsp:getProperty property="NAME" name="student" /></h1>
	</div>
	<br>
	<table style="width:100%">
		<tr style="color: rgba(0, 0, 0, 0.5);">

    		<th >Batch</th>
    		<th>RegistrationID</th>
    		<th>Class</th>
    	
  		</tr>
  		<tr>
			<th><jsp:getProperty property="BATCH" name="student"/></th>
			<th><jsp:getProperty property="REGESTRATIONID" name="student"/></th>
			<th><jsp:getProperty property="CLASS" name="student"/></th>
		</tr>
	</table>
	<% for(int i=0;i<tests.size();i=i+2){ %>
	<div class="test">
		<% TestBean tb=(TestBean)TestDetail.get(i); %>
		<h4><%=tests.get(i) %></h4>
		<p><%=tests.get(i+1) %>/<%=tb.getTMark() %></p>
		<h5><%=tb.getSubject() %></h5>
		<%int tl=tb.getTMark();
		  int ob=tb.getOMark();
		  double d=ob*100/tl;%>
		<h3><%=d%>%</h3>
	</div>
	<br>
	<%} %>
</body>

</html>
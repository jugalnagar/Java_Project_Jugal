
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="backgroundloginpage">
	<h3 style="text-align:center;">Login Admin</h3>
	<form action="VerifyAdmin" method="post" style="text-align:center;">
	<pre>
	EmailId	    <input type="text" name="email"/>
	
	Password    <input type="password" name="pswd"/>
	
	        <input type="submit" value="Login"/>
	</pre>
	</form>
	<a href="verify.jsp"><h5 style="text-align:right;">Creat One more Admin</h5></a>
	</div>
</body>
</html>
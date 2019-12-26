<%
	String email=(String)session.getAttribute("email");
	if(email==null){
		response.sendRedirect("login.jsp");
	}
%>



<html>
<head>
<style>
.textfield{
	margin-left:43%;
}
form{
 	 background-color:#45B39D;
	 margin-left:20%;
	 margin-right:20%
}
body{
	background-color:  #F2F2F0;
}
</style>
<script type="text/javascript">
	function getBatch(){
		var c=document.getElementById("class").value;
		
		if(c==="12th"){
			var array=["TLR11H","TLR21H","TLR31H"];
			
		}
		else if(c==="11th"){
			var array=["ALR11H","ALR21H","ALR31H"];
		}
		var i;
		var string="";
		for(i=0;i<array.length;i++){
			string=string+"<option value="+array[i]+">"+array[i]+"</option>";
		}
		string="<select name='Batch'><option value='None'>None</option>"+string+"</select><br>";
		document.getElementById("batch").innerHTML=string;
	}
	

</script>
<title>Student Registration Form</title>
</head>


<body>
<%@include file="header.jsp" %>
	<div class="backgroundloginpage">
    <h3 style="text-align:center;">Registration Form</h3>
	<form action="SaveStudentData" method="post" enctype="multipart/form-data" >
	<pre>
	<br>
	RegistrationID*		<input type="text" name="RegistrationID"/><br>
	Name*			<input type="text" name="Name"/><br>
	Father's Name*		<input type="text" name="FatherName"/><br>
	Mother's Name*		<input type="text" name="MotherName"/><br>
	DOB*			<input type="text" name="DOB"/>
				<font face="arial" size="1" color="red">In Form of DDMMYYYY Like 10062000</font><br>
	Class*			<select id="class" name="Class" onchange="getBatch()">
				<option value="None">None</option>
  				<option value="11th">11th</option>
  				<option value="12th">12th</option>
			</select><br>
	Medium			<input  type="text" name="Medium"/><br>
	Batch <div class="textfield"><div id="batch"></div></div>
  				
			
	Subject*		<select name="Subject">
				<option value="None">None</option>
  				<option value="Maths">Mathematics</option>
  				<option value="Biology">Biology</option>
  				<option value="Other">Other</option>
			</select><br>
	Mobile No.*		<input type="text" name="MobileNo"/><br>
	Father's Mobile No.*	<input type="text" name="FatherMobileNo"/><br>
	Email ID		<input type="text" name="EmailID"/> <br>
	Address*		<input type="text" name="Address" style="height:50;width:350;"/><br>
	Upload Image*	<input type="file" name="Image"/><br>
					<input type="submit" value="Register" style="background-color:red;">
	
	
	</pre>
	</form>
	</div>
</body>
</html>
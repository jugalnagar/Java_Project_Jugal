
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Updation</title>
<style type="text/css">
.textfield{
	margin-left:25%;
}
body{
	background-color:  #F2F2F0;
}
form{
	margin-left:25%;
	margin-right:25%;
	background-color:#45B39D;
	
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
</head>
<body>
	<%@include file="header.jsp" %>
	
	<h2 style="text-align:center;color:blue">Test Update</h2>
	<form action="SaveResultInfo" method ="post"  >
		<pre>
		<br>
		Test Name  <input type="text" name="TName"/><br>
         <div class="textfield"> Class	   <select id="class" name="Class" onchange="getBatch()">
						   <option value="None">None</option>
  						   <option value="11th">11th</option>
  						   <option value="12th">12th</option>
  				   		</select><br></div>
		Subject    <input type="text" name="Subject"/><br>
        <div class="textfield">Batch	   <div id="batch"></div></div>
		Date 	   <input type="text" name="Date"/><br>
		Total Mark <input type="text" name="TMark"/><br>
				<input type="submit" value="Upload Test" style="color:Green"/>
		</pre>
	
	</form>
</body>
</html>
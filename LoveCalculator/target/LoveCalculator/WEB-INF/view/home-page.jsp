<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript">

	function validateUserName(){
		var userName=document.getElementById('yn').value;
		if(userName.length <2){
			alert("your name should have atleast 2 char")
			return false;	
		}
		else
			return true;
	}
	
</script>




</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr/>
	
	 <%-- onSubmit="return validateUserName()" --%>
	
	<form:form action="process-homepage" method="get" modelAttribute="user">
	
		<div align="center">
		<p>
			<label for="yourName">Your Name</label>
			<form:input  id="yn" path="userName"/>
		</p>
		
		<p>
		<label for="crushName">Crush Name</label>
		<form:input id="cn" path="crushName"/>
		</p>
		
		<input type="submit" value="Calculate">
		</div>
	
	</form:form>
	
</body>
</html>
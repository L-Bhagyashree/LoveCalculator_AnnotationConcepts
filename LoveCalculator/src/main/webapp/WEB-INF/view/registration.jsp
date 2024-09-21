<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.error{
		color:red;
		position:fixed;
		text-align:left;
		margin-left:30px;
	}
</style>

</head>
<body>
	<h1 align="center">Registration Page</h1>
	
	<form:form action="registration-success" method="GET" modelAttribute="user">
	
	<div align="center">
	
		<label>Name:</label>
		<form:input path="name"/>
		<form:errors path="name" cssClass="error"/>
			
		
		<br/>
		
		<label>User Name:</label>
		<form:input path="userName"/>
		
		<br/>
		
		<label>Password:</label>
		<form:password path="password"/>
		
		<br/>
		
		<label>Country:</label>
		<form:select path="countryName">
			<form:option value="Ind" label="India"></form:option>
			<form:option value="USA" label="United States"></form:option>
			<form:option value="UK" label="United Kingdom"></form:option>
			<form:option value="Aus" label="Australia"></form:option>	
		</form:select>
		
		<br/>
		
		<label>Hobby:</label>
		Travel: <form:checkbox path="hobbies" value="Travel"/>
		Writing: <form:checkbox path="hobbies" value="Writing"/>
		Reading: <form:checkbox path="hobbies" value="Reading"/>
		Drawing: <form:checkbox path="hobbies" value="Drawing"/>
		Singing: <form:checkbox path="hobbies" value="Singing"/>
		
		<br/>
		
		<label>Age:</label>
		<form:input path="age"/>
		<form:errors path="age" cssClass="error"/>
		
		<br/>
		
		<label>Gender:</label>
		Male:<form:radiobutton path="gender" value="male"/>
		Female:<form:radiobutton path="gender" value="female"/>
		<br/>
		
		</div>
		
		<div align="center">
			
			<h3>Communication:</h3>
			<label>Email:</label>
			<form:input path="communicationDTO.email"/>
			<br/>
			<br/>
			<label>Phone:</label>
			<form:input path="communicationDTO.phone"/>
			
		</div>
		
		<div align="center">
		</br>
		<input type="submit" value="Register">
		
		</div>
		
	</form:form>
	
</body>
</html>
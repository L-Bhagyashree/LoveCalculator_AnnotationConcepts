<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			
	<h1>Registration Successful</h1>	
	<h2>The data you have entered is:</h2>
	Name: ${user.name}	<br/>
	User Name: ${user.userName}	<br/>
	Password: ${user.password}	<br/>
	Country Name: ${user.countryName}	<br/>
	Age: ${user.age}	<br/>
	Gender: ${user.gender}	<br/>
	
	Hobbies: 
	
	<c:forEach var="temp" items="${user.hobbies}">
	
	${temp}	
	
	</c:forEach>
	
	<br/>
	Email:  ${user.communicationDTO.email}
	
	<br/>
	Phone:  ${user.communicationDTO.phone}
	
	
</body>
</html>
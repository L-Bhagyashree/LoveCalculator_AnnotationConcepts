<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- FOR SESSION AND COOKIES IMPLEMENTATION
	<h1>Hi ${userName}</h1> --%>
	
	<h1>Hi ${user.userName}</h1>
	<h2>Send result to your email</h2>
	
	<%-- <form:form action="${pageContext.request.contextPath}/process-email" method="GET" modelAttribute="email">
	in case you are using path Variable --%>

	<form:form action="process-email" method="GET" modelAttribute="email">

		<label>Enter your Email: </label>
		<form:input path="userEmail" />
		<input type="submit" value="send">

	</form:form>

</body>
</html>
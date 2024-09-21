<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>First Name: ${FirstName}</p>
	<p>Last Name: ${LastName}</p>
	<br/>
	FirstName value fetching from REQUEST SCOPE: ${requestScope.FirstName}
	<br/>
	FirstName value fetching from SESSION SCOPE: ${sessionScope.FirstName}
	<br/>
	Address: ${address}
	<br/>
	<a href="${pageContext.request.contextPath}${next}">Next${next}</a>
</body>
</html>	
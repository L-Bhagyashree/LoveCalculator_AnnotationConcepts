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
	<h2>Hi ${userName}	 </h2> --%>
	
	<h2>Hi ${user.userName}	 </h2>
	<label>Email successfully sent to ${email.userEmail }</label>

</body>
</html>
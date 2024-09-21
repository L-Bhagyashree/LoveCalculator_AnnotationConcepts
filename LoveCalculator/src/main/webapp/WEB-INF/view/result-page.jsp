<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1 align="center">Love Calculator</h1>
	<hr/>
	<h2> The Love Calculator predicts : </h2>
	${user.userName} and ${user.crushName} are
	<br/>
	${user.appResult} 
	<br/>
	<%-- ${result} --%>
	<br/>
	
	<%-- 
	<a href="${pageContext.request.contextPath}/sendEmail/${user.userName}">Send Result to Your Email</a>
	in case you are using pathvariable --%>
	
	<a href="${pageContext.request.contextPath}/sendEmail">Send Result to Your Email</a>
	
	
	<%-- <p>User Name is: ${userName}</p>
	<p>Crush Name is: ${userInfoDTO.getCrushName()}</p> --%>
	
</body>
</html>
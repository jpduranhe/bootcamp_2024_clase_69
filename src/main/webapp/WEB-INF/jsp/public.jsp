<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="sec"  uri="http://www.springframework.org/security/tags"  %>    
    
    
<!DOCTYPE html>
<html  xmlns:th="http://www.thymeleaf.org"
		xmlns:sec="http://www.springframework.org/extras/spring-security">
<head>
<meta charset="UTF-8">
<title>Public</title>
</head>
<body>
	<h1>Publico</h1>
	
	<sec:authorize access="isAuthenticated()">
		Solo Usuarios Logueados pueden verme
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated() and principal.username=='jtoro@mail.com'">
		<br/> Solo jtoro@mail.com puede verme
	</sec:authorize>
	
</body>
</html>
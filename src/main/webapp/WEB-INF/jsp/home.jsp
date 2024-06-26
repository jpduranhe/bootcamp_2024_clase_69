<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="sec"  uri="http://www.springframework.org/security/tags"  %>    
    
    
<!DOCTYPE html>
<html  xmlns:th="http://www.thymeleaf.org"
		xmlns:sec="http://www.springframework.org/extras/spring-security">
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Bienvenido</h1>
	
	
	<p>
		Nombre del Usuario:	<sec:authentication property="principal.username"/>
		<br/>
		<small> Roles:<sec:authentication property="principal.authorities"/></small>
	</p>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		Soy Administrador
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_USER')">
		Soy Usuario
	</sec:authorize>
	
</body>
</html>
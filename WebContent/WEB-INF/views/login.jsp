<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style type="text/css">
form {width:300px;}
#errMsg { background-color: rgb(255, 200,200);}
</style>
</head>
<body>
<p>
<h3>로그인</h3>
<c:if test="${not empty param.error}">
    <span id="errMsg">오류: ${SPRING_SECURITY_LAST_EXCEPTION.message}</span>
</c:if>
 
<form action="<c:url value='/user/login' />" method="post">
<div>아이디 <input type="text" name="id" value="JONES"></div>
<div>암 호 <input type="password" name="pwd" value="JONES"></div>
<div><button type="submit">로그인</button></div>
</form>
 
</body>
</html>
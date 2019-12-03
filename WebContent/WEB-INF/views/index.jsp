<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Hi INDEX</h3>
  
<%--로그인을 거친 이용자일 경우에는 이용자의 로그인 ID를 보여준다 --%>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="name"/>님 환영합니다
</sec:authorize>
  
<ul>
    <li><a href="<c:url value='/home/test' />">/home/main</a></li>
    <li><a href="<c:url value='/member/test' />">/member/main</a></li>
    <li><a href="<c:url value='/manager/test' />">/manager/main</a></li>
    <li><a href="<c:url value='/admin/usermanager/test' />">/admin/usermanager</a></li>
     
    <%--로그인을 거친 이용자일 경우에는 로그아웃 링크를 보여준다 --%>
    <sec:authorize access="isAuthenticated()">
        <li><a href="<c:url value='/logout' />"> 로그아웃</a></li>
    </sec:authorize>
     
</ul>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>managerMain</title>
</head>
<body>
  
<h3>managerMain !</h3>
  
managerMain: <sec:authentication property="name"/>메니저 화면
  
<a href="<c:url value='/index' />"> [index바로가기]</a>
  
</body>
</html>


출처: https://micropilot.tistory.com/2767 []
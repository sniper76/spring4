<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tlds/custom.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberMain</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-3.4.1.js" />"></script>
<script type="text/javascript">
      $(document).ready(function(){
            
            $("button#testJson").click(function() {
            	$.ajax({
            	    url:"/testJson", // 요청 할 주소
            	    async:true,// false 일 경우 동기 요청으로 변경
            	    type:"POST", // GET, PUT
            	    data: {
            	        Name:"ajax",
            	        Age:10
            	    },// 전송할 데이터
            	    dataType:"json",// xml, json, script, html
            	    beforeSend:function(jqXHR) {console.log('beforeSend', jqXHR);},// 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
            	    success:function(jqXHR) {console.log('success', jqXHR);},// 요청 완료 시
            	    error:function(jqXHR) {console.log('error', jqXHR);},// 요청 실패.
            	    complete:function(jqXHR) {console.log('complete', jqXHR);}// 요청의 실패, 성공과 상관 없이 완료 될 경우 호출
            	});
            });
      });
      
</script>
</head>
<body>
  
<h3><custom:messageTag msgId="11" langCd="KO" sysCd="NMI" empty="Hi member" /></h3>
  
memberMain: <sec:authentication property="name"/>멤버 화면

<button id="testJson">JsonTest</button>
  
<a href="<c:url value='/index' />"> [index바로가기]</a>
  
</body>
</html>


출처: https://micropilot.tistory.com/2767 []
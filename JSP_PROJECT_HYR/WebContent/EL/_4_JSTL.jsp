<!-- 
		[ jstl의 fmt 태그 ] : 숫자, 날짜의 포캣을 지정하는걸 도와주는 JSTL 태그
		- prefix : fmt
		- uri : @taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="price" value="1000"/>
	
	통화 : <fmt:formatNumber value="${price}" type="currency"  /><br/>
	퍼센트 : <fmt:formatNumber value="${price}" type="percent"/><br/>
	패턴 : <fmt:formatNumber value="${price}" pattern="0000.00"/><br/>
	
	<c:set var="now" value="<%= new java.util.Date() %>" /><br/>
	<fmt:formatDate value="${now}" type="date"/><br/>
	<fmt:formatDate value="${now}" type="time"/><br/>
	<fmt:formatDate value="${now}" pattern="YY년MM월dd일 hh:mm:ss"/>
	
</body>
</html>
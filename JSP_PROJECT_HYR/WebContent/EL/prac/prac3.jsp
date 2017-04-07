<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="VarName" value="VarValue"/>
	<c:set var="Str" value="VarValue" />
	<c:set var="VarName2" value="${10}"/>
	<c:set var="VarName2" value="${VarName2+10}"/> <!-- VarName2 = VarName2 + 10 -->
	<c:if test="${Str == VarName}">
		내용이 같습니다.
	</c:if>
	<c:if test="${Str != VarName }">
		다릅니다.
	</c:if>

	<c:set var="sum" value="${0}" />	
	<c:forEach var="i" begin="1" end="100">
		<c:set var="sum" value="${sum + i}"/>
	</c:forEach>
	1~100 sum : ${sum}<br/>
	
	<c:choose>
		<c:when test="${sum == 100 }">100</c:when>
		<c:when test="${sum == 300 }">300</c:when>
		<c:when test="${sum > 5000 }">5000보다 크다.</c:when>
		<c:otherwise>그 외임</c:otherwise>
	</c:choose>
	
	<c:remove var="sum"/>
	sum 변수 삭제 : ${sum}<br/>
	
	<c:redirect url="./prac2.jsp"/>
	
	<c:catch var="error">
		try catch문...
	</c:catch>
</body>
</html>
<%--
		[	JSTL	 ]
		: JSP Standard Tag Libary
		1) Core tag
			사용법)
				%@taglib prefix="c" uri="~~.core" 를 추가(taglib 디렉터리 추가)
			Core 태그 종류)
				1. 변수 설정 태그 : c:set var="변수명" value="값" scope="request/session/page/application"
								-> scope 미지정시 page가 default
				2. 반복문 : c:Foreach
				3. 변수 제거 : c:remove var="변수명" scope="범위"
				4. 조건문 : c:if test="${조건}" var="조건 처리 변수명" scope="범위">
				5. switch case default 문 : choose ~ when ~ otherwise 	
				6. redirect 태그 : response.sendRedirect() 역할
						c:redirect url="url"
		2) Format tag
		
		3) Functions
 --%>
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
	<c:set var="varName" value="varValue" />
	varName : ${varName}<br/>
	<c:remove var="varName" />
	varName : <c:out value="${varName}"/><br/>
	
	<c:set var="sessionName" value="sessionValue" scope="session" />
	${sessionScope.sessionName }<br/>
	
	<c:catch var="error">
		<%= 2/0 %>
	</c:catch>
	
	<c:if test="${1+2 == 3}">
		1+2 = 3
	</c:if>
	<br/>
	<c:if test="${1+2 != 3 }">
		1+2 != 3
	</c:if>
	
	<c:forEach var="fEach" begin="0" end="30" step="3">
		${fEach}
	</c:forEach>
	
	<!-- 
		0~100까지 합
	 -->
	 <c:set var="sum" value="0"/>
	 <c:forEach var="i" begin="0" end = "100">
	 	<c:set var="sum" value="${sum+i}" />
	 </c:forEach>
	 
	 0~100까지 합 : ${sum}<br/>
	 
	 <c:set var="num" value="10"/>
	 <c:choose>
	 	<c:when test="${num==20}">20입니다.</c:when>
	 	<c:when test="${num==10}">10입니다.</c:when>
	 	<c:when test="${num==30}">30입니다.</c:when>
	 	<c:otherwise>그 외 값</c:otherwise>
	 </c:choose>
	 
	 <!-- 
	 	response.sendRedirect() 를 대체하는 redirect JSTL
	  -->
	  <c:redirect url="./_2_JSTL.jsp" />
</body>
</html>
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
<%@page import="java.util.HashMap"%>
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
	
	<!-- 
		try catch문으로 여기서 발생된 Exception 종류를 변수에 저장함
	 -->
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
	 
	 
	 <!-- 
	 	value에 값을 넣을 때 표현식, 표현언어 다 올 수 있다.
	 	또한, varStatus 속성은 배열, 컬렉션 객체 등이 올 때 인덱스를 알기 위해 사용한다.
	 	index : 인덱스를 출력
	 	count : 루프 돈 횟수를 출력
	  -->
	 <c:set var="intArr" value="<%= new int[]{1,3,5,7,9} %>"/>
	 <c:forEach var="i" items="${intArr}" varStatus="status">
	 	${status.index + 1} 번째 값 : ${i}<br/>
	 	${status.count}번 실행함<br/>
	 </c:forEach>
	 
	 <%
	 	HashMap<String,Object> mapData = new HashMap<String,Object>();
	 	mapData.put("name", "황영롱");
	 	mapData.put("today",new java.util.Date());
	 %>
	 
	 <c:set var="map" value="${mapData}"/>
	 <c:forEach var="i" items="${map}" varStatus="status2">
	 	${status2.index + 1}번째 (key, value)값 : key=${i.key} , value=${i.value}<br/>
	 </c:forEach>
	 
	 
	 <!--    ---------------------------------------------    -->
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
	  <%-- <c:redirect url="./_2_JSTL.jsp" /> --%>
</body>
</html>
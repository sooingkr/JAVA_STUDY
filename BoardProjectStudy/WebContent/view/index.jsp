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
	로그인시 최초로 보여줄 게시판 화면입니다.
	<%
		System.out.println("여기는 실행되나요??????");
	%>
	<c:if test="${ !empty authUser }">
		 ${authUser.name}님, 안녕하세요.
		 <a href="<%=request.getContextPath()%>/logout.do">[로그아웃하기]</a>
		 <a href="<%=request.getContextPath() %>/changePwd.do">[암호 변경하기]</a>
		 <!-- 
		 	암호 변경은 로그인이 되어 있는 상태에만 수행될 수 있어야함 but 매 페이지마다 확인하는 걸 작성하면 코드 중복이 많아짐으로
		 	필터로 로그인 여부 확인하는 코드 작성해 놓고 필요시 해당 uri 요청 전에 필터를 거치도록 web.xml에 등록하는 방식으로 처리...
		  -->
	</c:if>
	<c:if test="${ empty authUser}">
		<a href="/BoardProjectStudy/join.do">[회원가입하기]</a>
		<a href="/BoardProjectStudy/login.do">[로그인하기]</a>
	</c:if>
	
</body>
</html>
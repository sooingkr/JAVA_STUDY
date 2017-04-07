<%--
		[	쿠키를 이용한 로그아웃 처리	]
		: 해당 페이지를 실행하면 쿠키를 삭제하고 쿠키가 없으면 로그인 해제되도록 한다.
		유효시간을 0으로 세팅하면 됨.
 --%>
<%@page import="cookiepackage.CookieHandling"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.addCookie(
					cookiepackage.CookieHandling.createCookie("AUTH", "", "/",  0)
					// 유효시간 maxAge를 0으로 세팅해서 쿠키에 반영
				);
	
	%>
	로그아웃되었습니다.
</body>
</html>
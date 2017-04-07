<%--
		[	로그인 여부 체크	]
 --%>
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
		cookiepackage.CookieHandling cookies = new cookiepackage.CookieHandling(request);
		// 만들어논 쿠키 클래스 객체화 : 생성자를 통해서 기존 쿠키 불러오도록 내부에 되어 있음
		
		// 쿠키가 존재한다면 로그인한걸로 인식
		if ( cookies.exits("AUTH") ){
			out.println(cookies.getValue("AUTH") + " 아이디로 로그인한 상태");
		} else {
			out.println("로그인하지 않은 상태");
		}
	%>
</body>
</html>
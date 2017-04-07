<%--
		[	쿠키의 도메인 설정/ 경로 설정 예제  &&  유효시간 설정	 ]
	: 설정하지 않으면 해당 쿠키를 생성한 서버에만 브라우저에서 저장하고 있는 쿠키를 전송함	
--%>
<%@page import="java.net.URLEncoder"%>
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
		//	[ 쿠키의 도메인 설정 ]
		Cookie cookie = new Cookie("id", "madviurs");
		cookie.setDomain(".somehost.com");
		// somehost.com 이 포함된 모든 도메인인 서버에 전송
		// cookie.setDomain("somehost.com"); 도메인이 somehost.com인 곳에만 전송
		// Domain 설정 생략시 쿠키를 생성한 서버에만 전송
		response.addCookie(cookie);
	%>
	
	<%
		// [ 쿠키의 경로 설정 ]
		// 쿠키 경로 설정 안하면, 해당 JSP 파일이 속한 폴더기준으로 공유 됨.
		Cookie cookie2 = new Cookie("path1", URLEncoder.encode("경로:/JSP_PROJECT_HYR","UTF-8"));
		cookie2.setPath("/JSP_PROJECT_HYR");
		response.addCookie(cookie2);
	%>
	
	<%
		// [ 쿠키의 유효시간]
		Cookie cookie3 = new Cookie("name2","ggg");
		cookie3.setMaxAge(5); // 유효시간 5초
		response.addCookie(cookie3); // 적용
		
	%>
</body>
</html>
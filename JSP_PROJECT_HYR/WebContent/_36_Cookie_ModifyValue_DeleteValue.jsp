<%--
			[	쿠키값 변경하기 / 쿠키값 삭제하기   ]
 --%>
<%@page import="java.net.URLDecoder"%>
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
		Cookie[] cookies = request.getCookies();
		
		Cookie cookie = null;
		
		// [ 기존 값 변경하기 ]
		if ( cookies != null && cookies.length > 0 ){
			cookie = new Cookie("name", URLEncoder.encode("값을 수정함"));
			response.addCookie(cookie);
		}
		
		out.println("변경후 값 : " + URLDecoder.decode(cookie.getValue()));
		
	%>
	
	<%
	// [ 기존 쿠키 삭제하기 ]
		if ( cookies != null && cookies.length > 0 ){
			for(int i=0; i<cookies.length; i++){
				if ( cookies[i].getName().equals("name") ){
					Cookie cookie2 = new Cookie("name", ""); // name변수값을 빈 문자열로 변경
					cookie2.setMaxAge(0); // 유효시간을 0초로 설정
					response.addCookie(cookie2);
				}
			}
		}
	%>
	
	
</body>
</html>
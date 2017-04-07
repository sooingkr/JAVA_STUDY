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
<%--
		[	response 내장 객체	]
		사용 용도)
		1. Cache 설정 
		2. sendRedirect로 페이지 이동 : 단, 이건 주소창에 주소 변화는 일어나지 X
			just 내부에서 페이지 이동만
			
 --%>
 <%
 	response.setHeader("Cache-Control", "no-chache");
 	response.addHeader("Cache-Control", "no-store");
 	response.setHeader("Pragma", "no-Cache");
 	// 캐시 사용의 장,단점 
 	/*
 		서버에서 가져오는게 아니라 요청한지 얼마안된 URI를 또 요청시
 		내부에 캐시에 저장해 두고 가져옴으로서 속도가 빨라짐
 		하지만, 게시판처럼 실시간으로 자주바끼는 경우 바낀 변화를 반영시키지 못할 수 있음
 		
 	*/
 	//response.sendRedirect("http://www.google.com"); // 웹페이지 이동도 가능
 
 	String name = "전달했찌롱";
 	name = URLEncoder.encode(name,"UTF-8");
 	response.sendRedirect("/webpractice/RequestObject.jsp?name=" + name); // name 값을 보낼 것임
 	
 %>
</body>
</html>
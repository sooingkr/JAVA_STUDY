<%--
		[	로그아웃 페이지	]
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
		session.invalidate();
		// 물론!!! 
		// session.removeAttribute("LOGINID") 처럼해서 세션에서 속성을 삭제해주는 방법도 있다.
		// 하지만, 이 경우 세션에 저장되어 있는 속성값이 많은 경우에는 일일이 로그아웃 페이지에서 다
		// 해당 코드를 처리를 해주어야 하기 때문에 번거롭다. 따라서
		// session.invalidate() 메서드를 활용해서 세션을 종료시키도록 하자.....
	%>
</body>
</html>
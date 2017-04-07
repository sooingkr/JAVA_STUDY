<%--
		[	작성한 cookiepackage.CookieHandling 클래스를 이용해서 
		    Login 설정 유지하는 JSP 페이지를 작성해 보자  ] 
 		
 		로그인 유지 mechanism)
 			1. 로그인 id와 password를 맞추면 특정이름을 갖는 쿠키를 생성한다.
 			2. 해당 특정 쿠키가 존재하면 로그인한 상태라고 판단한다.
 			3. 로그아웃하면 해당 쿠키를 삭제한다.
				
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
	<form action="<%= request.getContextPath() %>/_40_Cookie_Login.jsp">
		아이디 : <input type="text" name="id" size="10">
		암호 : <input type="password" name="password" size="10" >
		<input type="submit" value="로그인" />
	</form>
</body>
</html>
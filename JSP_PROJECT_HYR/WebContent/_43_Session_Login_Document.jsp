<%--
		[	적용한 세션에 따라 로그인 인증이 적용됐는지 확인하려는 페이지 	]
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
		String id = (String)session.getAttribute("LOGINID");
		String pwd = (String)session.getAttribute("LOGINPWD");
		
		if ( id == null && pwd == null ){
			out.println("로그인되어 있지 않습니다.");
		}else {
			out.println("ID : " + id + "(님) 환영합니다.");
		}
	%>
	<form action="<%= application.getContextPath() %>/_43_Session_Logout.jsp">
		로그아웃
		<input type="submit" value="로그아웃" />
	</form>
</body>
</html>
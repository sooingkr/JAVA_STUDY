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
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (id.equals(password)) { // id와 암호가 같으면 로그인에 성공한 것으로 판단
			// 로그인 성공시 쿠키 생성!
			response.addCookie(cookiepackage.CookieHandling.createCookie("AUTH", id, "/", -1));
			// 쿠키명을 AUTH로하고 value로 id를 넣음
			// 유효시간 -1넣었음으로 웹브라우저 종료시 쿠키 소멸하는걸로 되는 것!
			out.println("로그인 성공");
		} else { // 로그인 실패시
	%>
	<script>
		alert("로그인에 실패하였습니다.");
		history.go(-1);
	</script>
	<%
		}
	%>
</body>
</html>
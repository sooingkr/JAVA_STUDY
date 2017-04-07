<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
		class파일 실행시 경로는 프로젝트명을 넣어서 써줘야 하네....
 -->
	<form action="/JSP_PROJECT_HYR/loginServletTest.do" method="post">
		ID : <input type="text" name="id" /><br/>
		PW : <input type="password" name="pw" /><br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>